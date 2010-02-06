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

		SrcgenHandler handler = new SrcgenHandler(null, null);
		return new SourceGenerationData(handler.handle(topElement));
	}

	private static String getAttributeValue(Element e, String attribute)
	{
		return e.hasAttribute(attribute) ? e.getAttribute(attribute) : null;
	}

	static interface ElementHandler<T>
	{
		public T handle(Element e);
	}

	static class SrcgenHandler implements ElementHandler<Collection<TypeDefinition>>
	{
		/** The standing interface package name. */
		private String interfacePackageName;
		/** The standing class package name. */
		private String classPackageName;

		public SrcgenHandler(String interfacePackageName, String classPackageName)
		{
			super();
			this.interfacePackageName = interfacePackageName;
			this.classPackageName = classPackageName;
		}

		public Collection<TypeDefinition> handle(Element e)
		{
			Collection<TypeDefinition> types = new ArrayList<TypeDefinition>();

			if (e.hasAttribute("ipkg"))
			{
				this.interfacePackageName = e.getAttribute("ipkg");
			}
			if (e.hasAttribute("cpkg"))
			{
				this.classPackageName = e.getAttribute("cpkg");
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
						SrcgenHandler handler = new SrcgenHandler(interfacePackageName, classPackageName);
						types.addAll(handler.handle(childElement));
					} else if (childTag.equals("type"))
					{
						TypeHandler handler = new TypeHandler(interfacePackageName, classPackageName);
						types.add(handler.handle(childElement));
					} else
					{
						throw new IllegalStateException(childTag);
					}
				}
			}
			return types;
		}
	}

	static class TypeHandler implements ElementHandler<TypeDefinition>
	{
		/** The standing interface package name. */
		private String interfacePackageName;
		/** The standing class package name. */
		private String classPackageName;

		public TypeHandler(String interfacePackageName, String classPackageName)
		{
			super();
			this.interfacePackageName = interfacePackageName;
			this.classPackageName = classPackageName;
		}

		@Override
		public TypeDefinition handle(Element e)
		{
			String name = e.getAttribute("name");
			String typeParam = getAttributeValue(e, "typeParam");
			String superName = getAttributeValue(e, "super");
			String superTypeArg = getAttributeValue(e, "superTypeArg");
			TypeDefinition.Mode mode;
			if (e.hasAttribute("mode"))
			{
				String modeString = e.getAttribute("mode");
				if (modeString.equals("concrete"))
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
			} else
			{
				mode = TypeDefinition.Mode.CONCRETE;
			}

			List<String> tags = new ArrayList<String>();
			List<PropertyDefinition> props = new ArrayList<PropertyDefinition>();
			List<String> includes = new ArrayList<String>();
			String docString = null;
			List<String> toStringLines = new ArrayList<String>();
			Map<String, String> overrideMap = new HashMap<String, String>();
			boolean genConstructor = true;
			boolean genChildren = true;

			NodeList children = e.getChildNodes();
			for (int i = 0; i < children.getLength(); i++)
			{
				Node node = children.item(i);
				if (node instanceof Element)
				{
					Element childElement = (Element) node;
					String childTag = childElement.getTagName();
					if (childTag.equals("tag"))
					{
						tags.add(childElement.getAttribute("name"));
					} else if (childTag.equals("prop"))
					{
						PropertyHandler handler = new PropertyHandler();
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
					} else if (childTag.equals("override"))
					{
						overrideMap.put(childElement.getAttribute("prop"), childElement.getAttribute("expr"));
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
					} else
					{
						throw new IllegalStateException("Unknown subtag for type: " + childTag);
					}
				}
			}

			return new TypeDefinition(name, typeParam, superName, superTypeArg, interfacePackageName, classPackageName,
					tags, props, includes, docString, toStringLines, overrideMap, genConstructor, genChildren, mode);
		}

		private String unindent(String s)
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

		private List<String> splitAndTrim(String s)
		{
			List<String> strings = splitStrings(s);
			if (strings.size() == 0)
				return Collections.emptyList();
			int spaces = calculateMinimalWhitespace(strings);
			removePrefix(strings, spaces);
			return strings;
		}

		private List<String> splitStrings(String s)
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

		private int calculateMinimalWhitespace(List<String> strings)
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

		private void removePrefix(List<String> strings, int spaces)
		{
			for (int i = 0; i < strings.size(); i++)
			{
				strings.set(i, strings.get(i).substring(spaces));
			}
		}
	}

	static class PropertyHandler implements ElementHandler<PropertyDefinition>
	{
		@Override
		public PropertyDefinition handle(Element e)
		{
			String name = e.getAttribute("name");
			String baseType = getAttributeValue(e, "type");
			String typeArg = getAttributeValue(e, "typeArg");
			PropertyDefinition.Mode mode;
			String description = getAttributeValue(e, "desc");

			String modeString = getAttributeValue(e, "mode");
			if (modeString == null || modeString.equals("normal"))
			{
				mode = PropertyDefinition.Mode.NORMAL;
			} else if (modeString.equals("readOnly"))
			{
				mode = PropertyDefinition.Mode.READ_ONLY;
			} else if (modeString.equals("skip"))
			{
				mode = PropertyDefinition.Mode.SKIP;
			} else
			{
				throw new IllegalStateException("Unknown property mode: " + modeString);
			}

			return new PropertyDefinition(name, baseType, typeArg, mode, description);
		}
	}
}
