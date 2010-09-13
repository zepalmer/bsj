package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaFileObject.Kind;

import org.apache.bcel.classfile.AccessFlags;
import org.apache.bcel.classfile.Attribute;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.ExceptionTable;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.Signature;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.BasicType;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.ReferenceType;
import org.apache.bcel.generic.Type;
import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser.ClassDeclarationGenericData;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser.FieldDeclarationGenericData;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser.GatheredExecutableData;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser.JavaGenericSignatureParser;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser.MethodDeclarationGenericData;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser.ParseException;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser.StringInputSource;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * Dynamically loads binary class files along with their references and returns a read-only AST representing those
 * files.
 * 
 * @author Joseph Riley
 */
public class BsjBinaryNodeLoader
{
	// TODO: this module does not properly set BSJ source locations

	/**
	 * The logging for this class.
	 */
	@SuppressWarnings("unused")
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/**
	 * A constant describing the position of the access flag indicating a varargs function.
	 */
	private static final int ACC_VARARGS = 0x0080;

	/**
	 * Factory for creating nodes.
	 */
	private BsjNodeFactory factory;

	/**
	 * Constructor.
	 * 
	 * @param factory the BsjNodeFactory to use.
	 */
	public BsjBinaryNodeLoader(BsjNodeFactory factory)
	{
		this.factory = factory;
	}

	/**
	 * Load the binary class given from the given location and return a read-only AST representation.
	 * 
	 * @param className the name of the class to load.
	 * @param location the location of the class and its references.
	 * @return A read-only AST representation of the class.
	 * @throws IOException if an I/O error occurs.
	 */
	public CompilationUnitNode loadNodesFromBinary(String className, LocationManager location) throws IOException
	{
		BsjFileObject file = location.getJavaFile(className, Kind.CLASS, false);
		return loadNodesFromBinary(file);
	}

	/**
	 * Loads a binary compilation unit from the specified file object.
	 * 
	 * @param file The file from which to load the class.
	 * @return The loaded class.
	 * @throws IOException If an I/O error occurs.
	 */
	public CompilationUnitNode loadNodesFromBinary(BsjFileObject file) throws IOException
	{
		boolean binary = this.factory.getBinary();
		this.factory.setBinary(true);

		try
		{
			// locate the actual file we need to load
			InputStream inputStream = file.openInputStream();

			// TODO handle loading of referenced class files

			// load and parse the class file into a BCEL JavaClass
			ClassParser parser = new ClassParser(inputStream, file.getSimpleName());
			JavaClass clazz = parser.parse();

			CompilationUnitNode retNode = factory.makeCompilationUnitNode(
					StringUtilities.removeSuffix(file.getSimpleName(), '.'), buildPackageDeclarationNode(clazz),
					factory.makeImportListNode(), factory.makeTypeDeclarationListNode(buildTypeDeclarationNode(clazz)));

			return retNode;
		} finally
		{
			this.factory.setBinary(binary);
		}
	}

	// =========================================================================
	// Private methods for constructing AST nodes.
	// =========================================================================

	private PackageDeclarationNode buildPackageDeclarationNode(JavaClass clazz)
	{
		if (clazz.getPackageName() == null || clazz.getPackageName() == "")
		{
			return null;
		}

		return factory.makePackageDeclarationNode(buildNameNode(clazz.getPackageName()));
	}

	private TypeDeclarationNode buildTypeDeclarationNode(JavaClass clazz)
	{
		if (clazz.isInterface())
		{
			return buildInterfaceDeclarationNode(clazz);
		} else if (clazz.isEnum())
		{
			return buildEnumDeclarationNode(clazz);
		} else if (clazz.isClass())
		{
			return buildClassDeclarationNode(clazz);
		} else
		{
			throw new IllegalStateException("Java file " + clazz.getSourceFileName() + " is an invalid type");
		}
	}

	private ClassDeclarationNode buildClassDeclarationNode(JavaClass clazz)
	{
		Signature signature = extractSignatureAttribute(clazz.getAttributes());
		DeclaredTypeNode extendsNode;
		DeclaredTypeListNode implementsClause;
		TypeParameterListNode typeParameters;
		if (signature != null)
		{
			JavaGenericSignatureParser parser = new JavaGenericSignatureParser(new StringInputSource(
					signature.getSignature()), factory);
			ClassDeclarationGenericData data;
			try
			{
				data = parser.getGenericTypeSignature();
			} catch (ParseException e)
			{
				throw new IllegalStateException("Could not parse generic type signature in class", e);
			}
			extendsNode = data.getDirectSupertype();
			implementsClause = data.getSupertypes();
			typeParameters = data.getTypeParams();
		} else
		{
			extendsNode = buildExtendsNode(clazz);
			implementsClause = buildImplementsClause(clazz);
			typeParameters = factory.makeTypeParameterListNode();
		}

		ClassDeclarationNode retNode = factory.makeClassDeclarationNode(buildClassModifiersNode(clazz), extendsNode,
				implementsClause, buildClassBodyNode(clazz), typeParameters,
				factory.makeIdentifierNode(getUnqualifiedName(clazz.getClassName())), null);

		return retNode;
	}

	private String getUnqualifiedName(String className)
	{
		return className.substring(className.lastIndexOf('.') + 1);
	}

	private TypeDeclarationNode buildInterfaceDeclarationNode(JavaClass clazz)
	{
		Signature signature = extractSignatureAttribute(clazz.getAttributes());
		DeclaredTypeListNode extendsClause;
		TypeParameterListNode typeParameters;
		if (signature != null)
		{
			JavaGenericSignatureParser parser = new JavaGenericSignatureParser(new StringInputSource(
					signature.getSignature()), factory);
			ClassDeclarationGenericData data;
			try
			{
				data = parser.getGenericTypeSignature();
			} catch (ParseException e)
			{
				throw new IllegalStateException("Could not parse generic type signature in class", e);
			}
			extendsClause = data.getSupertypes();
			typeParameters = data.getTypeParams();
		} else
		{
			extendsClause = buildExtendsListNode(clazz);
			typeParameters = factory.makeTypeParameterListNode();
		}

		InterfaceDeclarationNode retNode = factory.makeInterfaceDeclarationNode(buildInterfaceModifiersNode(clazz),
				extendsClause, buildInterfaceBodyNode(clazz), typeParameters,
				factory.makeIdentifierNode(getUnqualifiedName(clazz.getClassName())), null);
		return retNode;
	}

	private TypeDeclarationNode buildEnumDeclarationNode(JavaClass clazz)
	{
		return factory.makeEnumDeclarationNode(buildEnumModifiersNode(clazz), buildImplementsClause(clazz),
				buildEnumBody(clazz), factory.makeIdentifierNode(getUnqualifiedName(clazz.getClassName())), null);
	}

	private EnumModifiersNode buildEnumModifiersNode(JavaClass clazz)
	{
		return factory.makeEnumModifiersNode(buildAccessModifier(clazz), clazz.isStrictfp(),
				factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode());
	}

	private EnumBodyNode buildEnumBody(JavaClass clazz)
	{
		return factory.makeEnumBodyNode(buildEnumConstants(clazz), buildEnumMembers(clazz));
	}

	private ClassMemberListNode buildEnumMembers(JavaClass clazz)
	{
		List<ClassMemberNode> list = new ArrayList<ClassMemberNode>();

		for (Method method : clazz.getMethods())
		{
			// enum constructors don't appear to be needed as they are always private
			if (!method.getName().startsWith("<"))
			{
				list.add(buildMethodDeclarationNode(method));
			}
		}

		for (Field field : clazz.getFields())
		{
			// we only care about non-enum fields here, and also want to avoid
			// synthetic (compiler-generated) fields
			if (!field.isEnum() && !field.isSynthetic())
			{
				list.add(buildFieldDeclarationNode(field));
			}
		}

		return factory.makeClassMemberListNode(list);
	}

	private EnumConstantDeclarationListNode buildEnumConstants(JavaClass clazz)
	{
		List<EnumConstantDeclarationNode> list = new ArrayList<EnumConstantDeclarationNode>();

		// enum constant bodies are not needed for the same reason method bodies are not needed,
		// but we have also left off enum constant arguments because they are not accessible
		// from outside the enum
		for (Field field : clazz.getFields())
		{
			// we only care about enum fields here, and also want to avoid
			// synthetic (compiler-generated) fields
			if (field.isEnum() && !field.isSynthetic())
			{
				list.add(factory.makeEnumConstantDeclarationNode(factory.makeEnumConstantModifiersNode(),
						factory.makeIdentifierNode(field.getName()), factory.makeExpressionListNode(), null, null));
			}
		}

		return factory.makeEnumConstantDeclarationListNode(list);
	}

	private DeclaredTypeListNode buildExtendsListNode(JavaClass clazz)
	{
		if (!clazz.isInterface())
		{
			throw new IllegalStateException("Multiple extends on a noninterface: " + clazz.toString());
		}

		// implements clauses for classes are the same as extends
		// clauses for interfaces, so just reuse that method
		return buildImplementsClause(clazz);
	}

	private InterfaceBodyNode buildInterfaceBodyNode(JavaClass clazz)
	{
		List<InterfaceMemberNode> list = new ArrayList<InterfaceMemberNode>();

		for (Method method : clazz.getMethods())
		{
			list.add(buildMethodDeclarationNode(method));
		}

		for (Field field : clazz.getFields())
		{
			list.add(buildConstantDeclarationNode(field));
		}

		return factory.makeInterfaceBodyNode(factory.makeInterfaceMemberListNode(list));
	}

	private InterfaceModifiersNode buildInterfaceModifiersNode(JavaClass clazz)
	{
		return factory.makeInterfaceModifiersNode(buildAccessModifier(clazz), clazz.isStatic(), clazz.isStrictfp(),
				factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode());
	}

	private DeclaredTypeListNode buildImplementsClause(JavaClass clazz)
	{
		List<DeclaredTypeNode> list = new ArrayList<DeclaredTypeNode>();

		for (String iface : clazz.getInterfaceNames())
		{
			list.add(factory.makeUnparameterizedTypeNode(buildNameNode(iface)));
		}

		return factory.makeDeclaredTypeListNode(list);
	}

	private DeclaredTypeNode buildExtendsNode(JavaClass clazz)
	{
		DeclaredTypeNode retNode = null;

		// ignore extending from Object, as it is implied
		if (clazz.getSuperclassName() != null && !clazz.getSuperclassName().equals("java.lang.Object"))
		{
			retNode = factory.makeUnparameterizedTypeNode(buildNameNode(clazz.getSuperclassName()));
		}
		return retNode;
	}

	private ClassBodyNode buildClassBodyNode(JavaClass clazz)
	{
		List<ClassMemberNode> list = new ArrayList<ClassMemberNode>();

		for (Method method : clazz.getMethods())
		{
			if (!method.isSynthetic())
			{
				if (method.getName().equals("<init>"))
				{
					list.add(buildConstructorDeclarationNode(method, getUnqualifiedName(clazz.getClassName())));
				} else
				{
					list.add(buildMethodDeclarationNode(method));
				}
			}
		}

		for (Field field : clazz.getFields())
		{
			list.add(buildFieldDeclarationNode(field));
		}

		return factory.makeClassBodyNode(factory.makeClassMemberListNode(list));
	}

	private ConstructorDeclarationNode buildConstructorDeclarationNode(Method method, String name)
	{
		GatheredExecutableData data = gatherFromMethod(method);

		ConstructorDeclarationNode retNode = factory.makeConstructorDeclarationNode(factory.makeIdentifierNode(name),
				null, buildConstructorModifiers(method), data.getVariables(), data.getVararg(), data.getThrowsClause(),
				data.getTypeParameters(), null);

		return retNode;
	}

	private ConstructorModifiersNode buildConstructorModifiers(Method method)
	{
		return factory.makeConstructorModifiersNode(buildAccessModifier(method));
	}

	private TypeNode gatherFieldData(Field field)
	{
		Signature signature = extractSignatureAttribute(field.getAttributes());
		TypeNode fieldType;
		if (signature != null)
		{
			JavaGenericSignatureParser parser = new JavaGenericSignatureParser(new StringInputSource(
					signature.getSignature()), factory);
			FieldDeclarationGenericData data;
			try
			{
				data = parser.getGenericVariableSignature();
			} catch (ParseException e)
			{
				throw new IllegalStateException("Could not parse generic type signature in class", e);
			}
			fieldType = data.getType();
		} else
		{
			fieldType = buildTypeNode(field.getType());
		}
		return fieldType;
	}

	private ConstantDeclarationNode buildConstantDeclarationNode(Field field)
	{
		TypeNode fieldType = gatherFieldData(field);

		ConstantDeclarationNode retNode = factory.makeConstantDeclarationNode(buildConstantModifiersNode(field),
				fieldType, buildVariableDeclarators(field), null);

		return retNode;
	}

	private FieldDeclarationNode buildFieldDeclarationNode(Field field)
	{
		TypeNode fieldType = gatherFieldData(field);

		FieldDeclarationNode retNode = factory.makeFieldDeclarationNode(buildFieldModifiersNode(field), fieldType,
				buildVariableDeclarators(field), null);

		return retNode;
	}

	private VariableDeclaratorListNode buildVariableDeclarators(Field field)
	{
		// TODO fix: initializer left as null
		VariableDeclaratorNode retNode = factory.makeVariableDeclaratorNode(
				factory.makeIdentifierNode(field.getName()), 0, null);

		return factory.makeVariableDeclaratorListNode(retNode);
	}

	private ConstantModifiersNode buildConstantModifiersNode(Field field)
	{
		return factory.makeConstantModifiersNode(factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode());
	}

	private FieldModifiersNode buildFieldModifiersNode(Field field)
	{
		return factory.makeFieldModifiersNode(buildAccessModifier(field), field.isStatic(), field.isFinal(),
				field.isTransient(), field.isVolatile(), factory.makeMetaAnnotationListNode(),
				factory.makeAnnotationListNode());
	}

	private GatheredExecutableData gatherFromMethod(Method method)
	{
		Signature signature = extractSignatureAttribute(method.getAttributes());
		List<VariableNode> variables;
		TypeNode returnType;
		UnparameterizedTypeListNode throwsClause;
		TypeParameterListNode typeParameters;
		if (signature != null)
		{
			JavaGenericSignatureParser parser = new JavaGenericSignatureParser(new StringInputSource(
					signature.getSignature()), factory);
			MethodDeclarationGenericData data;
			try
			{
				data = parser.getGenericExecutableSignature();
			} catch (ParseException e)
			{
				throw new IllegalStateException("Could not parse generic type signature in class", e);
			}
			variables = data.getVariables();
			returnType = data.getReturnType();
			throwsClause = data.getThrowsClause();
			typeParameters = data.getTypeParameters();
		} else
		{
			variables = buildVariableListNode(method);
			returnType = buildTypeNode(method.getReturnType());
			throwsClause = buildThrowTypes(method.getExceptionTable());
			typeParameters = factory.makeTypeParameterListNode();
		}

		VariableNode vararg = null;
		if ((method.getAccessFlags() & ACC_VARARGS) != 0 && variables.size() > 0)
		{
			vararg = variables.remove(variables.size() - 1);
			TypeNode type = vararg.getType();
			if (!(type instanceof ArrayTypeNode))
			{
				throw new IllegalStateException("Last argument of varargs method is not an array: "
						+ type.toSourceCode());
			}
			ArrayTypeNode arrayType = (ArrayTypeNode) type;
			type = arrayType.getType();
			vararg = factory.makeVariableNode(type.deepCopy(factory), vararg.getIdentifier().deepCopy(factory));
		}

		return new GatheredExecutableData(factory.makeVariableListNode(variables), vararg, returnType, throwsClause,
				typeParameters);
	}

	private MethodDeclarationNode buildMethodDeclarationNode(Method method)
	{
		GatheredExecutableData data = gatherFromMethod(method);

		MethodDeclarationNode retNode = factory.makeMethodDeclarationNode(null, buildMethodModifiersNode(method),
				factory.makeIdentifierNode(method.getName()), data.getVariables(), data.getVararg(),
				data.getReturnType(), data.getThrowsClause(), data.getTypeParameters(), null);

		return retNode;
	}

	private List<VariableNode> buildVariableListNode(Method method)
	{
		List<VariableNode> list = new ArrayList<VariableNode>();
		int argCount = 0;
		for (Type arg : method.getArgumentTypes())
		{
			list.add(factory.makeVariableNode(factory.makeVariableModifiersNode(), buildTypeNode(arg),
					factory.makeIdentifierNode("arg" + argCount)));
			argCount++;
		}
		return list;
	}

	private UnparameterizedTypeListNode buildThrowTypes(ExceptionTable exceptionTable)
	{
		List<UnparameterizedTypeNode> list = new ArrayList<UnparameterizedTypeNode>();

		if (exceptionTable != null)
		{
			for (String exception : exceptionTable.getExceptionNames())
			{
				list.add(factory.makeUnparameterizedTypeNode(buildNameNode(exception)));
			}
		}

		return factory.makeUnparameterizedTypeListNode(list);
	}

	private MethodModifiersNode buildMethodModifiersNode(Method method)
	{
		return factory.makeMethodModifiersNode(buildAccessModifier(method), method.isAbstract(), method.isStatic(),
				method.isFinal(), method.isSynchronized(), method.isNative(), method.isStrictfp(),
				factory.makeMetaAnnotationListNode(), factory.makeAnnotationListNode());
	}

	private AccessModifier buildAccessModifier(AccessFlags flags)
	{
		AccessModifier access = AccessModifier.PACKAGE;
		if (flags.isPublic())
		{
			access = AccessModifier.PUBLIC;
		} else if (flags.isProtected())
		{
			access = AccessModifier.PROTECTED;
		} else if (flags.isPrivate())
		{
			access = AccessModifier.PRIVATE;
		}
		return access;
	}

	private TypeNode buildTypeNode(Type type)
	{
		TypeNode retNode = null;

		if (type instanceof BasicType)
		{
			retNode = buildPrimitiveTypeNode(BasicType.getType(type.getType()));
		} else if (type instanceof ReferenceType)
		{
			retNode = buildReferenceTypeNode(type);
		} else
		{
			throw new IllegalStateException("Unknown type: " + type.toString());
		}

		return retNode;
	}

	private TypeNode buildReferenceTypeNode(Type type)
	{
		// TODO handle type arguments? (extract from fields, methods, parse signatures using regexes, etc )

		TypeNode retNode = null;

		if (type instanceof ArrayType)
		{
			// get the basic type then wrap it in the proper number of levels of array types
			retNode = buildTypeNode(((ArrayType) type).getBasicType());
			for (int i = 0; i < ((ArrayType) type).getDimensions(); i++)
			{
				retNode = factory.makeArrayTypeNode(retNode);
			}
		} else if (type instanceof ObjectType)
		{
			retNode = factory.makeUnparameterizedTypeNode(buildNameNode(((ObjectType) type).getClassName()));
		}

		return retNode;
	}

	private TypeNode buildPrimitiveTypeNode(BasicType type)
	{
		PrimitiveType primitiveType = null;

		if (type.equals(BasicType.BOOLEAN))
		{
			primitiveType = PrimitiveType.BOOLEAN;
		} else if (type.equals(BasicType.BYTE))
		{
			primitiveType = PrimitiveType.BYTE;
		} else if (type.equals(BasicType.CHAR))
		{
			primitiveType = PrimitiveType.CHAR;
		} else if (type.equals(BasicType.DOUBLE))
		{
			primitiveType = PrimitiveType.DOUBLE;
		} else if (type.equals(BasicType.FLOAT))
		{
			primitiveType = PrimitiveType.FLOAT;
		} else if (type.equals(BasicType.INT))
		{
			primitiveType = PrimitiveType.INT;
		} else if (type.equals(BasicType.LONG))
		{
			primitiveType = PrimitiveType.LONG;
		} else if (type.equals(BasicType.SHORT))
		{
			primitiveType = PrimitiveType.SHORT;
		} else if (type.equals(BasicType.VOID))
		{
			return factory.makeVoidTypeNode();
		} else
		{
			throw new IllegalStateException("Invalid type: " + type.toString());
		}

		return factory.makePrimitiveTypeNode(primitiveType);
	}

	private ClassModifiersNode buildClassModifiersNode(JavaClass clazz)
	{
		return factory.makeClassModifiersNode(buildAccessModifier(clazz), clazz.isAbstract(), clazz.isStatic(),
				clazz.isFinal(), clazz.isStrictfp(), factory.makeMetaAnnotationListNode(),
				factory.makeAnnotationListNode());
	}

	private NameNode buildNameNode(String name)
	{
		// if the name is not qualified, just return a simple name node
		if (!name.contains("."))
		{
			return factory.makeSimpleNameNode(factory.makeIdentifierNode(name));
		}

		// recursively build qualified names
		String[] tokens = name.split("\\.");
		NameNode retNode = factory.makeQualifiedNameNode(buildNameNode(name.substring(0, name.lastIndexOf('.'))),
				factory.makeIdentifierNode(tokens[tokens.length - 1]));

		return retNode;
	}

	private Signature extractSignatureAttribute(Attribute[] attributes)
	{
		for (Attribute a : attributes)
		{
			if (a instanceof Signature)
			{
				return (Signature) a;
			}
		}
		return null;
	}
}
