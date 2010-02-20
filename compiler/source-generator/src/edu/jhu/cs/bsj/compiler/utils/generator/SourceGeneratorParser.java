package edu.jhu.cs.bsj.compiler.utils.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.Utilities;

/**
 * This module is responsible for reading the contents of the XML files and producing source generation data structures.
 * 
 * @author Zachary Palmer
 */
public class SourceGeneratorParser
{
	public static File SRCGEN_SCHEMA_FILE = new File("data/srcgen/srcgen.xsd");

	/**
	 * Creates a new parser.
	 */
	public SourceGeneratorParser()
	{
	}

	/**
	 * Parses the provided XML, returning a collection of type definitions.
	 */
	public SourceGenerationData parse(File file) throws IOException, ParserConfigurationException, SAXException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(SRCGEN_SCHEMA_FILE);
		Validator validator = schema.newValidator();
		validator.validate(new DOMSource(document));

		Element topElement = document.getDocumentElement();

		if (!topElement.getTagName().equals("srcgen"))
		{
			throw new IllegalArgumentException("Top level node was not <srcgen ...>");
		}

		SrcgenHandler handler = new SrcgenHandler(file.getParentFile(), new GenerationProfile());
		SourceGenerationData data = handler.handle(topElement);

		establishHierarchy(data.getTypes(), true);
		establishHierarchy(data.getDiagnostics(), false);

		return data;
	}

	private <T extends HierarchyDefinition<T>> void establishHierarchy(Collection<T> definitions,
			boolean noParentIsError)
	{
		// Post processing
		Map<String, T> typeMapByName = new HashMap<String, T>();
		for (T definition : definitions)
		{
			typeMapByName.put(definition.getName(), definition);
		}
		for (T definition : definitions)
		{
			if (definition.getSuperName() != null)
			{
				T superDefinition = typeMapByName.get(definition.getSuperName());
				if (superDefinition == null)
				{
					if (noParentIsError)
					{
						throw new IllegalStateException("Type " + definition + " has supertype "
								+ definition.getSuperName() + " which was not declared.");
					}
				}
				definition.setParent(superDefinition);
				definition.setNamespaceMap(typeMapByName);
			}
		}

	}

	private static String getAttributeValue(Element e, String attribute)
	{
		return e.hasAttribute(attribute) ? e.getAttribute(attribute) : null;
	}

	private static String unindent(String s)
	{
		List<String> strings = splitAndTrim(s);
		StringBuilder sb = new StringBuilder();
		for (String string : strings)
		{
			if (sb.length() > 0)
				sb.append("\n");
			sb.append(string);
		}
		return sb.toString();
	}

	private static List<String> splitAndTrim(String s)
	{
		List<String> strings = splitStrings(s);
		if (strings.size() == 0)
			return Collections.emptyList();
		int spaces = calculateMinimalWhitespace(strings);
		removePrefix(strings, spaces);
		return strings;
	}

	private static List<String> splitStrings(String s)
	{
		List<String> strings = new LinkedList<String>(Arrays.asList(s.split("\n")));
		while (strings.size() > 0 && strings.get(0).trim().length() == 0)
			strings.remove(0);
		while (strings.size() > 0 && strings.get(strings.size() - 1).trim().length() == 0)
			strings.remove(strings.size() - 1);
		for (int i = 0; i < strings.size(); i++)
		{
			strings.set(i, strings.get(i).replaceAll("\t", "    "));
		}
		return strings;
	}

	private static int calculateMinimalWhitespace(List<String> strings)
	{
		if (strings.size() == 0)
			return 0;
		int space = Integer.MAX_VALUE;
		for (String string : strings)
		{
			int whitespaces = 0;
			while (string.length() > whitespaces && string.charAt(whitespaces) == ' ')
			{
				whitespaces++;
			}
			space = Math.min(space, whitespaces);
		}
		return space;
	}

	private static void removePrefix(List<String> strings, int spaces)
	{
		for (int i = 0; i < strings.size(); i++)
		{
			strings.set(i, strings.get(i).substring(spaces));
		}
	}

	private static TypeDefinition.Mode getTypeDefinitionModeFromString(GenerationProfile profile, String modeString)
	{
		TypeDefinition.Mode mode;
		if (modeString == null)
		{
			mode = profile.getProperty(GenerationProfile.DEFAULT_TYPE_MODE);
		} else if (modeString.equals("concrete"))
		{
			mode = TypeDefinition.Mode.CONCRETE;
		} else if (modeString.equals("abstract"))
		{
			mode = TypeDefinition.Mode.ABSTRACT;
		} else if (modeString.equals("tag"))
		{
			mode = TypeDefinition.Mode.INTERFACE;
		} else
		{
			throw new IllegalStateException("Unknown type mode string: " + modeString);
		}
		return mode;
	}
	
	static interface ElementHandler<T>
	{
		public T handle(Element e);
	}

	static class SrcgenHandler implements ElementHandler<SourceGenerationData>
	{
		/** The file to which pathnames in the XML are relative. */
		private File relativeFile;
		/** The standing factory interface name. */
		private GenerationProfile profile;

		public SrcgenHandler(File relativeFile, GenerationProfile profile)
		{
			super();
			this.relativeFile = relativeFile;
			this.profile = profile;
		}

		public SourceGenerationData handle(Element e)
		{
			Collection<TypeDefinition> types = new ArrayList<TypeDefinition>();
			Collection<DiagnosticDefinition> diagnostics = new ArrayList<DiagnosticDefinition>();

			if (e.hasAttribute("ipkg"))
			{
				profile = profile.derive(GenerationProfile.GENERATED_INTERFACE_PACKAGE_NAME, e.getAttribute("ipkg"));
			}
			if (e.hasAttribute("cpkg"))
			{
				profile = profile.derive(GenerationProfile.GENERATED_CLASS_PACKAGE_NAME, e.getAttribute("cpkg"));
			}

			NodeList children = e.getChildNodes();
			for (int i = 0; i < children.getLength(); i++)
			{
				Node node = children.item(i);
				if (node instanceof Element)
				{
					Element childElement = (Element) node;
					String childTag = childElement.getTagName();
					if (childTag.equals("srcgen"))
					{
						SrcgenHandler handler = new SrcgenHandler(relativeFile, profile);
						SourceGenerationData childData = handler.handle(childElement);
						types.addAll(childData.getTypes());
						diagnostics.addAll(childData.getDiagnostics());
					} else if (childTag.equals("type"))
					{
						TypeHandler handler = new TypeHandler(profile);
						types.add(handler.handle(childElement));
					} else if (childTag.equals("diagnostic"))
					{
						DiagnosticHandler handler = new DiagnosticHandler(profile);
						diagnostics.add(handler.handle(childElement));
					} else if (childTag.equals("import"))
					{
						SourceGeneratorParser parser = new SourceGeneratorParser();
						String path = childElement.getAttribute("path");
						path = this.relativeFile.getPath() + File.separator + path;
						SourceGenerationData childData;
						try
						{
							childData = parser.parse(new File(path));
						} catch (IOException e1)
						{
							throw new IllegalStateException("Failure while reading imported file " + path, e1);
						} catch (ParserConfigurationException e1)
						{
							throw new IllegalStateException("Failure while reading imported file " + path, e1);
						} catch (SAXException e1)
						{
							throw new IllegalStateException("Failure while reading imported file " + path, e1);
						}
						types.addAll(childData.getTypes());
						diagnostics.addAll(childData.getDiagnostics());
					} else if (childTag.equals("factory"))
					{
						String factoryInterfaceName = childElement.getAttribute("interface");
						String factoryClassName = childElement.getAttribute("class");
						String factoryDecoratorName = childElement.getAttribute("decorator");
						this.profile = this.profile.derive(GenerationProfile.FACTORY_INTERFACE_NAME,
								factoryInterfaceName).derive(GenerationProfile.FACTORY_CLASS_NAME, factoryClassName).derive(
								GenerationProfile.FACTORY_DECORATOR_CLASS_NAME, factoryDecoratorName);
					} else if (childTag.equals("defaults"))
					{
						if (childElement.hasAttribute("typeMode"))
						{
							String defaultTypeMode = childElement.getAttribute("typeMode");
							this.profile = this.profile.derive(GenerationProfile.DEFAULT_TYPE_MODE,
									getTypeDefinitionModeFromString(profile, defaultTypeMode));
						}
						if (childElement.hasAttribute("propertyMode"))
						{
							String defaultPropertyMode = childElement.getAttribute("propertyMode");
							this.profile = this.profile.derive(GenerationProfile.DEFAULT_PROPERTY_MODE,
									Utilities.getEnumByName(PropertyDefinition.Mode.values(),
											StringUtilities.convertCamelCaseToUpperCase(defaultPropertyMode)));
						}
					} else
					{
						throw new IllegalStateException(childTag);
					}
				}
			}

			return new SourceGenerationData(types, diagnostics);
		}
	}

	static class TypeHandler implements ElementHandler<TypeDefinition>
	{
		/** The standing factory profile. */
		private GenerationProfile profile;

		public TypeHandler(GenerationProfile profile)
		{
			super();
			this.profile = profile;
		}

		@Override
		public TypeDefinition handle(Element e)
		{
			String name = e.getAttribute("name");
			String typeParam = getAttributeValue(e, "typeParam");
			String superName = getAttributeValue(e, "super");
			String superTypeArg = getAttributeValue(e, "superTypeArg");
			TypeDefinition.Mode mode = getTypeDefinitionModeFromString(profile, getAttributeValue(e, "mode"));

			List<String> interfaces = new ArrayList<String>();
			List<String> tags = new ArrayList<String>();
			List<PropertyDefinition> props = new ArrayList<PropertyDefinition>();
			List<String> includes = new ArrayList<String>();
			String docString = null;
			List<String> toStringLines = new ArrayList<String>();
			Map<String, String> factoryOverrideMap = new HashMap<String, String>();
			Map<String, String> constructorOverrideMap = new HashMap<String, String>();
			boolean genConstructor = true;
			boolean genChildren = true;
			List<FactoryMethodDefinition> factoryMethodDefinitions = new ArrayList<FactoryMethodDefinition>();

			NodeList children = e.getChildNodes();
			for (int i = 0; i < children.getLength(); i++)
			{
				Node node = children.item(i);
				if (node instanceof Element)
				{
					Element childElement = (Element) node;
					String childTag = childElement.getTagName();
					if (childTag.equals("interface"))
					{
						interfaces.add(childElement.getAttribute("name"));
					} else if (childTag.equals("tag"))
					{
						tags.add(childElement.getAttribute("name"));
					} else if (childTag.equals("prop"))
					{
						PropertyHandler handler = new PropertyHandler(this.profile);
						props.add(handler.handle(childElement));
					} else if (childTag.equals("include"))
					{
						includes.add(childElement.getAttribute("file"));
					} else if (childTag.equals("doc"))
					{
						docString = unindent(childElement.getTextContent());
					} else if (childTag.equals("toString"))
					{
						toStringLines = splitAndTrim(childElement.getTextContent());
					} else if (childTag.equals("factory-override"))
					{
						factoryOverrideMap.put(childElement.getAttribute("prop"), childElement.getAttribute("expr"));
					} else if (childTag.equals("constructor-override"))
					{
						constructorOverrideMap.put(childElement.getAttribute("prop"), childElement.getAttribute("expr"));
					} else if (childTag.equals("nogen"))
					{
						String nogenString = childElement.getAttribute("id");
						if (nogenString.equals("cons"))
						{
							genConstructor = false;
						} else if (nogenString.equals("children"))
						{
							genChildren = false;
						} else
						{
							throw new IllegalStateException("Unknown nogen id: " + nogenString);
						}
					} else if (childTag.equals("factory-method"))
					{
						FactoryMethodHandler handler = new FactoryMethodHandler();
						factoryMethodDefinitions.add(handler.handle(childElement));
					} else
					{
						throw new IllegalStateException("Unknown subtag for type: " + childTag);
					}
				}
			}

			TypeDefinition typeDefinition = new TypeDefinition(name, typeParam, superName, superTypeArg, profile,
					interfaces, tags, props, includes, docString, toStringLines, factoryOverrideMap,
					constructorOverrideMap, genConstructor, genChildren, factoryMethodDefinitions, mode);
			for (FactoryMethodDefinition factoryMethodDefinition : factoryMethodDefinitions)
			{
				factoryMethodDefinition.setParent(typeDefinition);
			}
			return typeDefinition;
		}
	}

	static class PropertyHandler implements ElementHandler<PropertyDefinition>
	{
		private GenerationProfile profile;

		public PropertyHandler(GenerationProfile profile)
		{
			super();
			this.profile = profile;
		}

		@Override
		public PropertyDefinition handle(Element e)
		{
			String name = e.getAttribute("name");
			String baseType = getAttributeValue(e, "type");
			String typeArg = getAttributeValue(e, "typeArg");
			PropertyDefinition.Mode mode;
			String description = getAttributeValue(e, "desc");
			String defaultExpression = getAttributeValue(e, "default");

			String modeString = getAttributeValue(e, "mode");
			if (modeString == null)
			{
				mode = profile.getProperty(GenerationProfile.DEFAULT_PROPERTY_MODE);
			} else if (modeString.equals("normal"))
			{
				mode = PropertyDefinition.Mode.NORMAL;
			} else if (modeString.equals("readOnly"))
			{
				mode = PropertyDefinition.Mode.READ_ONLY;
			} else if (modeString.equals("skip"))
			{
				mode = PropertyDefinition.Mode.SKIP;
			} else if (modeString.equals("hide"))
			{
				mode = PropertyDefinition.Mode.HIDE;
			} else
			{
				throw new IllegalStateException("Unknown property mode: " + modeString);
			}

			return new PropertyDefinition(name, baseType, typeArg, mode, description, defaultExpression);
		}
	}

	static class FactoryMethodHandler implements ElementHandler<FactoryMethodDefinition>
	{
		public FactoryMethodHandler()
		{
			super();
		}

		@Override
		public FactoryMethodDefinition handle(Element e)
		{
			List<FactoryMethodPropertyDefinition> properties = new ArrayList<FactoryMethodPropertyDefinition>();

			NodeList children = e.getChildNodes();
			for (int i = 0; i < children.getLength(); i++)
			{
				Node node = children.item(i);
				if (node instanceof Element)
				{
					Element childElement = (Element) node;
					String childTag = childElement.getTagName();
					if (childTag.equals("prop"))
					{
						String propName = childElement.getAttribute("name");
						boolean propVisible = childElement.hasAttribute("visible") ? Boolean.parseBoolean(childElement.getAttribute("visible"))
								: true;
						properties.add(new FactoryMethodPropertyDefinition(propName, propVisible));
					} else if (childTag.equals("use-defaults"))
					{
						return new UseDefaultsFactoryMethodDefinition();
					} else
					{
						throw new IllegalStateException("Factory method tag does not understand child " + childTag);
					}
				}
			}
			return new EnumeratedFactoryMethodDefinition(properties);
		}
	}

	static class DiagnosticHandler implements ElementHandler<DiagnosticDefinition>
	{
		private GenerationProfile profile;

		public DiagnosticHandler(GenerationProfile profile)
		{
			super();
			this.profile = profile;
		}

		@Override
		public DiagnosticDefinition handle(Element e)
		{
			String name = e.getAttribute("name");
			String superName = getAttributeValue(e, "super");
			if (superName == null)
			{
				superName = "AbstractBsjDiagnostic";
			}
			List<PropertyDefinition> props = new ArrayList<PropertyDefinition>();
			String docString = null;
			String code = getAttributeValue(e, "code");

			NodeList children = e.getChildNodes();
			for (int i = 0; i < children.getLength(); i++)
			{
				Node node = children.item(i);
				if (node instanceof Element)
				{
					Element childElement = (Element) node;
					String childTag = childElement.getTagName();
					if (childTag.equals("prop"))
					{
						PropertyHandler handler = new PropertyHandler(this.profile);
						props.add(handler.handle(childElement));
					} else if (childTag.equals("doc"))
					{
						docString = unindent(childElement.getTextContent());
					} else
					{
						throw new IllegalStateException("Unknown subtag for type: " + childTag);
					}
				}
			}

			DiagnosticDefinition diagnosticDefinition = new DiagnosticDefinition(name, superName,
					profile.getProperty(GenerationProfile.GENERATED_CLASS_PACKAGE_NAME), props, docString, code);
			return diagnosticDefinition;
		}
	}
}
