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
		SourceGenerationData data = parseOnly(file);

		connectTypeDefinitionProperties(data.getTypes());
		connectParameterizedPropertyBasedHierarchyDefinitionProperties(data.getDiagnostics());
		connectParameterizedPropertyBasedHierarchyDefinitionProperties(data.getUserDiagnostics());

		establishHierarchy(data.getTypes(), true);
		establishHierarchy(data.getDiagnostics(), false);
		establishHierarchy(data.getUserDiagnostics(), false);

		connectParseRules(data.getParseRules(), data.getTypes());

		return data;
	}

	private SourceGenerationData parseOnly(File file) throws IOException, ParserConfigurationException, SAXException
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

		return data;
	}

	private void connectTypeDefinitionProperties(Collection<TypeDefinition> types)
	{
		connectParameterizedPropertyBasedHierarchyDefinitionProperties(types);
		for (TypeDefinition def : types)
		{
			for (ConstantDefinition constant : def.getConstants())
			{
				constant.setParentDef(def);
			}
		}
	}

	private <T extends ParameterizedPropertyBasedHierarchyDefinition<T, U>, U extends AbstractPropertyDefinition<U>> void connectParameterizedPropertyBasedHierarchyDefinitionProperties(
			Collection<T> definitions)
	{
		for (T def : definitions)
		{
			for (U prop : def.getProperties())
			{
				prop.setParentDef(def);
			}
		}
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
			}
			definition.setNamespaceMap(typeMapByName);
		}
	}

	private void connectParseRules(Collection<ParseRuleDefinition> parseRules, Collection<TypeDefinition> types)
	{
		for (ParseRuleDefinition parseRule : parseRules)
		{
			for (OutputTypeDefinition outputType : parseRule.getOutputTypes())
			{
				for (TypeDefinition type : types)
				{
					if (type.getBaseName().equals(outputType.getName()))
					{
						outputType.setType(type);
						break;
					}
				}
				if (outputType.getType() == null)
				{
					throw new IllegalStateException("Could not find type for output type " + outputType.getName()
							+ " in parse rule " + parseRule.getName());
				}
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

	private static ModalPropertyDefinition.Mode getPropertyModeFromString(GenerationProfile profile, String modeString)
	{
		ModalPropertyDefinition.Mode mode;
		if (modeString == null)
		{
			mode = profile.getProperty(GenerationProfile.DEFAULT_PROPERTY_MODE);
		} else if (modeString.equals("normal"))
		{
			mode = ModalPropertyDefinition.Mode.NORMAL;
		} else if (modeString.equals("readOnly"))
		{
			mode = ModalPropertyDefinition.Mode.READ_ONLY;
		} else if (modeString.equals("skip"))
		{
			mode = ModalPropertyDefinition.Mode.SKIP;
		} else if (modeString.equals("hide"))
		{
			mode = ModalPropertyDefinition.Mode.HIDE;
		} else
		{
			throw new IllegalStateException("Unknown property mode: " + modeString);
		}
		return mode;
	}

	private static Project parseProjectFromString(String project)
	{
		if (project.equals("api"))
		{
			return Project.API;
		} else if (project.equals("generator"))
		{
			return Project.GENERATOR;
		} else if (project.equals("parser"))
		{
			return Project.PARSER;
		} else if (project.equals("bsjutils"))
		{
			return Project.BSJ_UTILS;
		} else
		{
			throw new IllegalArgumentException("Unrecognized target project: " + project);
		}
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
			Collection<UserDiagnosticDefinition> userDiagnostics = new ArrayList<UserDiagnosticDefinition>();
			Collection<ParseRuleDefinition> parseRules = new ArrayList<ParseRuleDefinition>();

			if (e.hasAttribute("ipkg"))
			{
				profile = profile.derive(GenerationProfile.GENERATED_INTERFACE_PACKAGE_NAME, e.getAttribute("ipkg"));
			}
			if (e.hasAttribute("cpkg"))
			{
				profile = profile.derive(GenerationProfile.GENERATED_CLASS_PACKAGE_NAME, e.getAttribute("cpkg"));
			}
			if (e.hasAttribute("itgt"))
			{
				profile = profile.derive(GenerationProfile.INTERFACE_PROJECT,
						parseProjectFromString(e.getAttribute("itgt")));
			}
			if (e.hasAttribute("ctgt"))
			{
				profile = profile.derive(GenerationProfile.IMPLEMENTATION_PROJECT,
						parseProjectFromString(e.getAttribute("ctgt")));
			}
			if (e.hasAttribute("bsjSpecific"))
			{
				String bsjSpecificStr = e.getAttribute("bsjSpecific");
				boolean bsjSpecific;
				if (bsjSpecificStr.equalsIgnoreCase("true"))
				{
					bsjSpecific = true;
				} else if (bsjSpecificStr.equalsIgnoreCase("false"))
				{
					bsjSpecific = false;
				} else
				{
					throw new IllegalStateException("Incorrect boolean value: " + bsjSpecificStr);
				}
				profile = profile.derive(GenerationProfile.BSJ_SPECIFIC, bsjSpecific);
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
						userDiagnostics.addAll(childData.getUserDiagnostics());
						parseRules.addAll(childData.getParseRules());
					} else if (childTag.equals("type"))
					{
						TypeHandler handler = new TypeHandler(profile);
						types.add(handler.handle(childElement));
					} else if (childTag.equals("diagnostic"))
					{
						DiagnosticHandler handler = new DiagnosticHandler(profile);
						diagnostics.add(handler.handle(childElement));
					} else if (childTag.equals("userDiagnostic"))
					{
						UserDiagnosticHandler handler = new UserDiagnosticHandler(profile);
						userDiagnostics.add(handler.handle(childElement));
					} else if (childTag.equals("parserule"))
					{
						ParseRuleHandler handler = new ParseRuleHandler(profile);
						parseRules.add(handler.handle(childElement));
					} else if (childTag.equals("import"))
					{
						SourceGeneratorParser parser = new SourceGeneratorParser();
						String path = childElement.getAttribute("path");
						path = this.relativeFile.getPath() + File.separator + path;
						SourceGenerationData childData;
						try
						{
							childData = parser.parseOnly(new File(path));
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
						userDiagnostics.addAll(childData.getUserDiagnostics());
						parseRules.addAll(childData.getParseRules());
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
							this.profile = this.profile.derive(
									GenerationProfile.DEFAULT_PROPERTY_MODE,
									Utilities.getEnumByName(ModalPropertyDefinition.Mode.values(),
											StringUtilities.convertCamelCaseToUpperCase(defaultPropertyMode)));
						}
					} else
					{
						throw new IllegalStateException(childTag);
					}
				}
			}

			return new SourceGenerationData(types, diagnostics, userDiagnostics, parseRules);
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
			List<TagReferenceDefinition> tags = new ArrayList<TagReferenceDefinition>();
			List<ConstantDefinition> constants = new ArrayList<ConstantDefinition>();
			List<PropertyDefinition> props = new ArrayList<PropertyDefinition>();
			String docString = null;
			String constructorFooter = null;
			List<String> toStringLines = new ArrayList<String>();
			Map<String, String> factoryOverrideMap = new HashMap<String, String>();
			Map<String, String> constructorOverrideMap = new HashMap<String, String>();
			boolean genConstructor = true;
			boolean genChildren = true;
			boolean genReplace = true;
			List<FactoryMethodDefinition> factoryMethodDefinitions = new ArrayList<FactoryMethodDefinition>();
			boolean isBsjSpecific = this.profile.getProperty(GenerationProfile.BSJ_SPECIFIC);

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
						String tagName = childElement.getAttribute("name");
						String tagTypeArg = getAttributeValue(childElement, "typeArg");
						tags.add(new TagReferenceDefinition(tagName, tagTypeArg));
					} else if (childTag.equals("constant"))
					{
						ConstantHandler handler = new ConstantHandler(this.profile);
						constants.add(handler.handle(childElement));
					} else if (childTag.equals("prop"))
					{
						PropertyHandler handler = new PropertyHandler(this.profile);
						props.add(handler.handle(childElement));
					} else if (childTag.equals("doc"))
					{
						docString = unindent(childElement.getTextContent());
					} else if (childTag.equals("constructorFooter"))
					{
						constructorFooter = unindent(childElement.getTextContent());
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
						} else if (nogenString.equals("replace"))
						{
							genReplace = false;
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

			TypeDefinition typeDefinition = new TypeDefinition(name, typeParam, superName, superTypeArg,
					constructorFooter, profile, interfaces, tags, constants, props, docString, toStringLines, factoryOverrideMap,
					constructorOverrideMap, genConstructor, genChildren, genReplace, factoryMethodDefinitions,
					mode, isBsjSpecific);
			for (FactoryMethodDefinition factoryMethodDefinition : factoryMethodDefinitions)
			{
				factoryMethodDefinition.setParent(typeDefinition);
			}
			return typeDefinition;
		}
	}

	static abstract class AbstractPropertyHandler<T extends AbstractPropertyDefinition<T>> implements ElementHandler<T>
	{
		protected GenerationProfile profile;

		public AbstractPropertyHandler(GenerationProfile profile)
		{
			super();
			this.profile = profile;
		}

		protected abstract T create(Element e, String name, String baseType, String typeArg, String description,
				String defaultExpression, boolean allowUnion);

		@Override
		public T handle(Element e)
		{
			String name = e.getAttribute("name");
			String baseType = getAttributeValue(e, "type");
			String typeArg = getAttributeValue(e, "typeArg");
			String description = getAttributeValue(e, "desc");
			String defaultExpression = getAttributeValue(e, "default");
			String allowUnionString = getAttributeValue(e, "allowUnion");
			boolean allowUnion;
			if (allowUnionString == null || allowUnionString.equalsIgnoreCase("true"))
			{
				allowUnion = true;
			} else if (allowUnionString.equalsIgnoreCase("false"))
			{
				allowUnion = false;
			} else
			{
				throw new IllegalStateException("Unrecognized allowUnion string: " + allowUnionString);
			}

			return create(e, name, baseType, typeArg, description, defaultExpression, allowUnion);
		}
	}

	static class PropertyHandler extends AbstractPropertyHandler<PropertyDefinition>
	{
		public PropertyHandler(GenerationProfile profile)
		{
			super(profile);
		}

		@Override
		protected PropertyDefinition create(Element e, String name, String baseType, String typeArg,
				String description, String defaultExpression, boolean allowUnion)
		{
			ModalPropertyDefinition.Mode mode = getPropertyModeFromString(this.profile, getAttributeValue(e, "mode"));
			return new PropertyDefinition(name, baseType, typeArg, mode, description, defaultExpression, allowUnion);
		}
	}

	static class ConstantHandler extends AbstractPropertyHandler<ConstantDefinition>
	{
		public ConstantHandler(GenerationProfile profile)
		{
			super(profile);
		}

		@Override
		protected ConstantDefinition create(Element e, String name, String baseType, String typeArg,
				String description, String defaultExpression, boolean allowUnion)
		{
			return new ConstantDefinition(name, baseType, typeArg, description, defaultExpression, allowUnion);
		}
	}

	static class DiagnosticPropertyHandler extends AbstractPropertyHandler<DiagnosticPropertyDefinition>
	{
		public DiagnosticPropertyHandler(GenerationProfile profile)
		{
			super(profile);
		}

		@Override
		protected DiagnosticPropertyDefinition create(Element e, String name, String baseType, String typeArg,
				String description, String defaultExpression, boolean allowUnion)
		{
			ModalPropertyDefinition.Mode mode = getPropertyModeFromString(this.profile, getAttributeValue(e, "mode"));

			String messageExpression = getAttributeValue(e, "messageExpression");

			return new DiagnosticPropertyDefinition(name, baseType, typeArg, mode, description, defaultExpression,
					messageExpression);
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
			DiagnosticExceptionDefinition exception = null;
			String name = e.getAttribute("name");
			String typeParam = getAttributeValue(e, "typeParam");
			String superName = getAttributeValue(e, "super");
			String superArg = getAttributeValue(e, "superTypeArg");
			List<DiagnosticPropertyDefinition> props = new ArrayList<DiagnosticPropertyDefinition>();
			List<MessagePropertyExpressionDefinition> messagePropertyExpressions = new ArrayList<MessagePropertyExpressionDefinition>();
			String docString = null;
			String constructorFooter = null;
			String code = getAttributeValue(e, "code");

			NodeList children = e.getChildNodes();
			for (int i = 0; i < children.getLength(); i++)
			{
				Node node = children.item(i);
				if (node instanceof Element)
				{
					Element childElement = (Element) node;
					String childTag = childElement.getTagName();
					if (childTag.equals("exception"))
					{
						DiagnosticExceptionHandler handler = new DiagnosticExceptionHandler(this.profile);
						exception = handler.handle(childElement);
					} else if (childTag.equals("prop"))
					{
						DiagnosticPropertyHandler handler = new DiagnosticPropertyHandler(this.profile);
						props.add(handler.handle(childElement));
					} else if (childTag.equals("messageProp"))
					{
						String exprName = childElement.getAttribute("name");
						String expr = childElement.getAttribute("expression");
						messagePropertyExpressions.add(new MessagePropertyExpressionDefinition(exprName, expr));
					} else if (childTag.equals("doc"))
					{
						docString = unindent(childElement.getTextContent());
					} else if (childTag.equals("constructorFooter"))
					{
						constructorFooter = unindent(childElement.getTextContent());
					} else
					{
						throw new IllegalStateException("Unknown subtag for type: " + childTag);
					}
				}
			}

			DiagnosticDefinition diagnosticDefinition = new DiagnosticDefinition(name, typeParam, superName, superArg,
					constructorFooter, this.profile, exception, props, messagePropertyExpressions, docString, code);
			return diagnosticDefinition;
		}
	}

	static class DiagnosticExceptionHandler implements ElementHandler<DiagnosticExceptionDefinition>
	{
		public DiagnosticExceptionHandler(GenerationProfile profile)
		{
		}

		@Override
		public DiagnosticExceptionDefinition handle(Element e)
		{
			String docString = null;
			String property = getAttributeValue(e, "property");
			if (property == null)
			{
				property = "exception";
			}

			NodeList children = e.getChildNodes();
			for (int i = 0; i < children.getLength(); i++)
			{
				Node node = children.item(i);
				if (node instanceof Element)
				{
					Element childElement = (Element) node;
					String childTag = childElement.getTagName();
					if (childTag.equals("doc"))
					{
						docString = unindent(childElement.getTextContent());
					} else
					{
						throw new IllegalStateException("Unknown subtag for type: " + childTag);
					}
				}
			}

			return new DiagnosticExceptionDefinition(docString, property);
		}
	}

	static class UserDiagnosticHandler implements ElementHandler<UserDiagnosticDefinition>
	{
		private GenerationProfile profile;

		public UserDiagnosticHandler(GenerationProfile profile)
		{
			super();
			this.profile = profile;
		}

		@Override
		public UserDiagnosticDefinition handle(Element e)
		{
			String name = e.getAttribute("name");
			String typeParam = getAttributeValue(e, "typeParam");
			String superName = getAttributeValue(e, "super");
			String superArg = getAttributeValue(e, "superTypeArg");
			List<DiagnosticPropertyDefinition> props = new ArrayList<DiagnosticPropertyDefinition>();
			List<MessagePropertyExpressionDefinition> messagePropertyExpressions = new ArrayList<MessagePropertyExpressionDefinition>();
			String docString = null;
			String constructorFooter = null;
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
						DiagnosticPropertyHandler handler = new DiagnosticPropertyHandler(this.profile);
						props.add(handler.handle(childElement));
					} else if (childTag.equals("messageProp"))
					{
						String exprName = childElement.getAttribute("name");
						String expr = childElement.getAttribute("expression");
						messagePropertyExpressions.add(new MessagePropertyExpressionDefinition(exprName, expr));
					} else if (childTag.equals("doc"))
					{
						docString = unindent(childElement.getTextContent());
					} else if (childTag.equals("constructorFooter"))
					{
						constructorFooter = unindent(childElement.getTextContent());
					} else
					{
						throw new IllegalStateException("Unknown subtag for type: " + childTag);
					}
				}
			}

			UserDiagnosticDefinition def = new UserDiagnosticDefinition(name, typeParam, superName, superArg,
					constructorFooter, this.profile, props, messagePropertyExpressions, docString, code);
			return def;
		}
	}

	static class ParseRuleHandler implements ElementHandler<ParseRuleDefinition>
	{
		public ParseRuleHandler(GenerationProfile profile)
		{
		}

		@Override
		public ParseRuleDefinition handle(Element e)
		{
			String name = e.getAttribute("name");

			Collection<OutputTypeDefinition> outputTypes = new ArrayList<OutputTypeDefinition>();

			NodeList children = e.getChildNodes();
			for (int i = 0; i < children.getLength(); i++)
			{
				Node node = children.item(i);
				if (node instanceof Element)
				{
					Element childElement = (Element) node;
					String childTag = childElement.getTagName();
					if (childTag.equals("outputType"))
					{
						OutputTypeHandler handler = new OutputTypeHandler();
						outputTypes.add(handler.handle(childElement));
					} else
					{
						throw new IllegalStateException("Unknown subtag for type: " + childTag);
					}
				}
			}

			ParseRuleDefinition def = new ParseRuleDefinition(name, outputTypes);
			return def;
		}
	}

	static class OutputTypeHandler implements ElementHandler<OutputTypeDefinition>
	{
		@Override
		public OutputTypeDefinition handle(Element e)
		{
			String name = getAttributeValue(e, "name");

			OutputTypeDefinition def = new OutputTypeDefinition(name);
			return def;
		}
	}
}
