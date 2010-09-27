package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

/**
 * This class is designed to parse the generic signatures in Java class files according to the revised second edition of
 * the JVM specification (which includes support for generic types) in §4.4. This parser is hand-written due to the fact
 * that the lexical grammar specified in §4.4 is context-sensitive and extending ANTLR lexers to context sensitivity
 * involves considerable effort.
 * 
 * @author Zachary Palmer
 */
public class JavaGenericSignatureParser
{
	/** The input which is being processed. */
	private InputSource inputSource;
	/** The factory used to create nodes. */
	private BsjNodeFactory factory;

	/**
	 * Creates a parser for a generic signature. The provided input source must be ready to read from the signature
	 * contents.
	 * 
	 * @param inputSource The input source to parse.
	 */
	public JavaGenericSignatureParser(InputSource inputSource, BsjNodeFactory factory)
	{
		super();
		this.inputSource = inputSource;
		this.factory = factory;
	}

	/**
	 * Creates information for a class or interface generic signature by parsing the provided input source.
	 * 
	 * @throws IOException If an I/O error occurs.
	 * @throws EOFException If input is truncated.
	 * @throws ParseException If input is malformed.
	 */
	public ClassDeclarationGenericData getGenericTypeSignature() throws ParseException
	{
		ClassDeclarationGenericData ret = parseClassSignature();
		if (!this.inputSource.isExhausted())
		{
			throw new ParseException("Did not parse entire input source to obtain signature");
		}
		return ret;
	}

	/**
	 * Creates information for a method or constructor generic signature by parsing the provided input source.
	 * 
	 * @throws IOException If an I/O error occurs.
	 * @throws EOFException If input is truncated.
	 * @throws ParseException If input is malformed.
	 */
	public MethodDeclarationGenericData getGenericExecutableSignature() throws ParseException
	{
		MethodDeclarationGenericData ret = parseMethodTypeSignature();
		if (!this.inputSource.isExhausted())
		{
			throw new ParseException("Did not parse entire input source to obtain signature");
		}
		return ret;
	}

	/**
	 * Creates information for a method or constructor generic signature by parsing the provided input source.
	 * 
	 * @throws IOException If an I/O error occurs.
	 * @throws EOFException If input is truncated.
	 * @throws ParseException If input is malformed.
	 */
	public FieldDeclarationGenericData getGenericVariableSignature() throws ParseException
	{
		FieldDeclarationGenericData ret = new FieldDeclarationGenericData(parseFieldTypeSignature());
		if (!this.inputSource.isExhausted())
		{
			throw new ParseException("Did not parse entire input source to obtain signature");
		}
		return ret;
	}
	
	private ClassDeclarationGenericData parseClassSignature() throws ParseException
	{
		TypeParameterListNode typeParameters;
		inputSource.push();
		try
		{
			typeParameters = parseFormalTypeParameters();
			inputSource.erase();
		} catch (ParseException e)
		{
			inputSource.pop();
			typeParameters = factory.makeTypeParameterListNode();
		}
		DeclaredTypeNode superclass = parseSuperclassSignature();
		List<DeclaredTypeNode> list = new ArrayList<DeclaredTypeNode>();
		try
		{
			while (true)
			{
				inputSource.push();
				list.add(parseSuperinterfaceSignature());
				inputSource.erase();
			}
		} catch (ParseException e)
		{
			// That's fine.
			inputSource.pop();
		}
		return new ClassDeclarationGenericData(typeParameters, superclass, factory.makeDeclaredTypeListNode(list));
	}

	private TypeParameterListNode parseFormalTypeParameters() throws ParseException
	{
		inputSource.demand('<');
		List<TypeParameterNode> list = new ArrayList<TypeParameterNode>();
		try
		{
			while (true)
			{
				inputSource.push();
				list.add(parseFormalTypeParameter());
				inputSource.erase();
			}
		} catch (ParseException e)
		{
			// That's fine.
			inputSource.pop();
			if (list.size() == 0)
				throw e;
		}
		inputSource.demand('>');
		return factory.makeTypeParameterListNode(list);
	}

	private TypeParameterNode parseFormalTypeParameter() throws ParseException
	{
		IdentifierNode ident = parseIdentifier();
		List<DeclaredTypeNode> list = new ArrayList<DeclaredTypeNode>();
		DeclaredTypeNode classBound = parseClassBound(); // may be null
		if (classBound != null)
		{
			list.add(classBound);
		}
		try
		{
			while (true)
			{
				inputSource.push();
				list.add(parseInterfaceBound());
				inputSource.erase();
			}
		} catch (ParseException e)
		{
			// That's fine.
			inputSource.pop();
		}
		return factory.makeTypeParameterNode(ident, factory.makeDeclaredTypeListNode(list));
	}

	private IdentifierNode parseIdentifier() throws ParseException
	{
		StringBuilder sb = new StringBuilder();
		if (!Character.isJavaIdentifierStart(inputSource.peek()))
		{
			throw new ParseException("Invalid identifier character " + inputSource.peek());
		}
		sb.append(inputSource.consume());
		while (Character.isJavaIdentifierPart(inputSource.peek()))
		{
			sb.append(inputSource.consume());
		}
		return factory.makeIdentifierNode(sb.toString());
	}

	private DeclaredTypeNode parseClassBound() throws ParseException
	{
		inputSource.demand(':');
		inputSource.push();
		try
		{
			DeclaredTypeNode type = (DeclaredTypeNode) parseFieldTypeSignature();
			inputSource.erase();
			return type;
		} catch (ParseException e)
		{
			inputSource.pop();
			return null;
		}
	}

	private DeclaredTypeNode parseInterfaceBound() throws ParseException
	{
		inputSource.demand(':');
		return (DeclaredTypeNode) parseFieldTypeSignature();
	}

	private DeclaredTypeNode parseSuperclassSignature() throws ParseException
	{
		return parseClassTypeSignature();
	}

	private DeclaredTypeNode parseSuperinterfaceSignature() throws ParseException
	{
		return parseClassTypeSignature();
	}

	private ReferenceTypeNode parseFieldTypeSignature() throws ParseException
	{
		inputSource.push();
		try
		{
			ReferenceTypeNode ret = parseClassTypeSignature();
			inputSource.erase();
			return ret;
		} catch (ParseException e)
		{
			inputSource.pop();
		}

		inputSource.push();
		try
		{
			ReferenceTypeNode ret = parseArrayTypeSignature();
			inputSource.erase();
			return ret;
		} catch (ParseException e)
		{
			inputSource.pop();
		}

		return parseTypeVariableSignature();
	}

	private DeclaredTypeNode parseClassTypeSignature() throws ParseException
	{
		inputSource.demand('L');

		NameNode name = null;
		inputSource.push();
		try
		{
			name = parsePackageSpecifier(null);
			inputSource.erase();
		} catch (ParseException e)
		{
			inputSource.pop();
		}

		List<ParameterizedTypeNode> types = new ArrayList<ParameterizedTypeNode>();

		Pair<IdentifierNode, TypeArgumentListNode> pair = parseSimpleClassTypeSignature();

		boolean stop = false;
		do
		{
			name = addToName(name, pair.getFirst());
			if (pair.getSecond() != null)
			{
				types.add(factory.makeParameterizedTypeNode(factory.makeUnparameterizedTypeNode(name), pair.getSecond()));
				name = null;
			}

			try
			{
				pair = parseClassTypeSignatureSuffix();
			} catch (ParseException e)
			{
				stop = true;
			}
		} while (!stop);

		inputSource.demand(';');

		DeclaredTypeNode acc;
		if (name == null)
		{
			acc = types.remove(types.size() - 1);
		} else
		{
			acc = factory.makeUnparameterizedTypeNode(name);
		}
		while (types.size() > 0)
		{
			acc = factory.makeParameterizedTypeSelectNode(types.remove(types.size() - 1), acc);
		}
		return acc;
	}

	private NameNode parsePackageSpecifier(NameNode base) throws ParseException
	{
		IdentifierNode ident = parseIdentifier();
		inputSource.demand('/');
		NameNode ret;
		if (base == null)
		{
			ret = factory.makeSimpleNameNode(ident);
		} else
		{
			ret = factory.makeQualifiedNameNode(base, ident);
		}
		inputSource.push();
		try
		{
			ret = parsePackageSpecifier(ret);
			inputSource.erase();
		} catch (ParseException e)
		{
			inputSource.pop();
		}
		return ret;
	}

	private Pair<IdentifierNode, TypeArgumentListNode> parseSimpleClassTypeSignature() throws ParseException
	{
		IdentifierNode ident = parseIdentifier();

		inputSource.push();
		try
		{
			TypeArgumentListNode typeArguments = parseTypeArguments();
			inputSource.erase();
			return new Pair<IdentifierNode, TypeArgumentListNode>(ident, typeArguments);
		} catch (ParseException e)
		{
			inputSource.pop();
			return new Pair<IdentifierNode, TypeArgumentListNode>(ident, null);
		}
	}

	private Pair<IdentifierNode, TypeArgumentListNode> parseClassTypeSignatureSuffix() throws ParseException
	{
		inputSource.demand('.');
		return parseSimpleClassTypeSignature();
	}

	private UnparameterizedTypeNode parseTypeVariableSignature() throws ParseException
	{
		inputSource.demand('T');
		IdentifierNode ident = parseIdentifier();
		inputSource.demand(';');

		return factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(ident));
	}

	private TypeArgumentListNode parseTypeArguments() throws ParseException
	{
		inputSource.demand('<');

		List<TypeArgumentNode> list = new ArrayList<TypeArgumentNode>();
		try
		{
			while (true)
			{
				inputSource.push();
				list.add(parseTypeArgument());
				inputSource.erase();
			}
		} catch (ParseException e)
		{
			inputSource.pop();
			if (list.size() == 0)
				throw e;
		}

		inputSource.demand('>');

		return factory.makeTypeArgumentListNode(list);
	}

	private TypeArgumentNode parseTypeArgument() throws ParseException
	{
		if (inputSource.peek() == '*')
		{
			inputSource.consume();
			return factory.makeWildcardTypeNode((ReferenceTypeNode)null, true);
		} else
		{
			char c = inputSource.peek();
			Boolean upperBound;
			switch (c)
			{
				case '+':
					upperBound = true;
					inputSource.consume();
					break;
				case '-':
					upperBound = false;
					inputSource.consume();
					break;
				default:
					upperBound = null;
			}
			ReferenceTypeNode type = parseFieldTypeSignature();
			if (upperBound != null)
			{
				return factory.makeWildcardTypeNode(type, upperBound);
			} else
			{
				return type;
			}
		}
	}

	private ArrayTypeNode parseArrayTypeSignature() throws ParseException
	{
		inputSource.demand('[');
		return factory.makeArrayTypeNode(parseTypeSignature());
	}

	private TypeNode parseTypeSignature() throws ParseException
	{
		inputSource.push();
		try
		{
			TypeNode ret = parseFieldTypeSignature();
			inputSource.erase();
			return ret;
		} catch (ParseException e)
		{
			inputSource.pop();
		}

		return parseBaseType();
	}

	private PrimitiveTypeNode parseBaseType() throws ParseException
	{
		char c = inputSource.peek();
		PrimitiveType type;
		switch (c)
		{
			case 'B':
				type = PrimitiveType.BYTE;
				break;
			case 'C':
				type = PrimitiveType.CHAR;
				break;
			case 'D':
				type = PrimitiveType.DOUBLE;
				break;
			case 'F':
				type = PrimitiveType.FLOAT;
				break;
			case 'I':
				type = PrimitiveType.INT;
				break;
			case 'J':
				type = PrimitiveType.LONG;
				break;
			case 'S':
				type = PrimitiveType.SHORT;
				break;
			case 'Z':
				type = PrimitiveType.BOOLEAN;
				break;
			default:
				throw new ParseException("Unrecognized base type character " + c);
		}
		inputSource.consume();
		return factory.makePrimitiveTypeNode(type);
	}

	private NameNode addToName(NameNode name, IdentifierNode ident)
	{
		if (name == null)
		{
			return factory.makeSimpleNameNode(ident);
		} else
		{
			return factory.makeQualifiedNameNode(name, ident);
		}
	}

	private MethodDeclarationGenericData parseMethodTypeSignature() throws ParseException
	{
		TypeParameterListNode typeParameters;
		inputSource.push();
		try
		{
			typeParameters = parseFormalTypeParameters();
			inputSource.erase();
		} catch (ParseException e)
		{
			inputSource.pop();
			typeParameters = factory.makeTypeParameterListNode();
		}

		inputSource.demand('(');
		int argCount = 0;
		List<VariableNode> variableList = new ArrayList<VariableNode>();
		try
		{
			while (true)
			{
				inputSource.push();
				variableList.add(factory.makeVariableNode(parseTypeSignature(),
						factory.makeIdentifierNode("arg" + (argCount++))));
				inputSource.erase();
			}
		} catch (ParseException e)
		{
			inputSource.pop();
		}
		inputSource.demand(')');

		TypeNode returnType = parseReturnType();

		List<UnparameterizedTypeNode> throwsTypes = new ArrayList<UnparameterizedTypeNode>();
		try
		{
			while (true)
			{
				inputSource.push();
				throwsTypes.add(parseThrowsSignature());
				inputSource.erase();
			}
		} catch (ParseException e)
		{
			inputSource.pop();
		}

		return new MethodDeclarationGenericData(variableList, returnType,
				factory.makeUnparameterizedTypeListNode(throwsTypes), typeParameters);
	}
	
	private TypeNode parseReturnType() throws ParseException
	{
		inputSource.push();
		try
		{
			inputSource.demand('V');
			inputSource.erase();
			return factory.makeVoidTypeNode();
		} catch (ParseException e)
		{
			inputSource.pop();
		}
		
		return parseTypeSignature();
	}
	
	private UnparameterizedTypeNode parseThrowsSignature() throws ParseException
	{
		inputSource.demand('^');
		inputSource.push();
		try
		{
			UnparameterizedTypeNode type = (UnparameterizedTypeNode)parseClassTypeSignature();
			inputSource.erase();
			return type;
		} catch (ParseException e)
		{
			inputSource.pop();
		}
		
		return parseTypeVariableSignature();
	}
}
