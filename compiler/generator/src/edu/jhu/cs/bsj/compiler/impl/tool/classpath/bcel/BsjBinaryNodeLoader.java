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
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationListNode;
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
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * Dynamically loads binary class files along with their references and
 * returns a read-only AST representing those files.
 * 
 * @author Joseph Riley
 */
public class BsjBinaryNodeLoader
{
    /**
     * The logging for this class.
     */
    private Logger LOGGER = Logger.getLogger(this.getClass());
    
    /**
     * Factory for creating nodes.
     */
    private BsjNodeFactory factory;
    
    /**
     * Constructor.
     * @param factory the BsjNodeFactory to use.
     */
    public BsjBinaryNodeLoader(BsjNodeFactory factory)
    {
        this.factory = factory;
    }
    
    /**
     * Load the binary class given from the given location and return
     * a read-only AST representation.
     * @param className the name of the class to load.
     * @param location the location of the class and its references.
     * @return A read-only AST representation of the class.
     * @throws IOException if an I/O error occurs.
     */
    public CompilationUnitNode loadNodesFromBinary(
            String className, LocationManager location) 
            throws IOException
    {
        // locate the actual file we need to load
        BsjFileObject file = location.getJavaFile(className, Kind.CLASS, false);
        InputStream inputStream = file.openInputStream();
        
        //TODO handle loading of referenced class files

        // load and parse the class file into a BCEL JavaClass
        ClassParser parser = new ClassParser(inputStream, className + Kind.CLASS.extension);
        JavaClass clazz = parser.parse();

        // TODO add isBinary field to nodes
        
        CompilationUnitNode retNode = factory.makeCompilationUnitNode(
                className, 
                buildPackageDeclarationNode(clazz), 
                factory.makeImportListNode(), //TODO imports?
                factory.makeTypeDeclarationListNode(
                        buildTypeDeclarationNode(clazz)));

        return retNode;
    }
    
    //=========================================================================
    // Private methods for constructing AST nodes.
    //=========================================================================

    private PackageDeclarationNode buildPackageDeclarationNode(JavaClass clazz)
    {
        if (clazz.getPackageName() == null || clazz.getPackageName() == "")
        {
            return null;
        }
        
        return factory.makePackageDeclarationNode(
                buildNameNode(clazz.getPackageName()));
    }

    private TypeDeclarationNode buildTypeDeclarationNode(JavaClass clazz)
    {
        if (clazz.isInterface())
        {
            return buildInterfaceDeclarationNode(clazz);
        }
        else if (clazz.isEnum())
        {
            return buildEnumDeclarationNode(clazz);
        }
        else if (clazz.isClass())
        {
            return buildClassDeclarationNode(clazz);
        }
        else
        {
            throw new IllegalStateException(
                    "Java file " + clazz.getSourceFileName() 
                    + " is an invalid type");
        }
    }
    
    private ClassDeclarationNode buildClassDeclarationNode(JavaClass clazz)
    {
        ClassDeclarationNode retNode = factory.makeClassDeclarationNode(
                buildClassModifiersNode(clazz), 
                buildExtendsNode(clazz), 
                buildImplementsClause(clazz), 
                buildClassBodyNode(clazz), 
                buildTypeParamsListNode(clazz.getAttributes()), 
                factory.makeIdentifierNode(getUnqualifiedName(clazz.getClassName())), 
                null);
        
        return retNode;
    }
    
    private String getUnqualifiedName(String className)
    {
        return className.substring(className.lastIndexOf('.')+1);
    }

    private TypeDeclarationNode buildInterfaceDeclarationNode(JavaClass clazz)
    {
        InterfaceDeclarationNode retNode = 
            factory.makeInterfaceDeclarationNode(
                    buildInterfaceModifiersNode(clazz), 
                    buildExtendsListNode(clazz), 
                    buildInterfaceBodyNode(clazz), 
                    buildTypeParamsListNode(clazz.getAttributes()), 
                    factory.makeIdentifierNode(getUnqualifiedName(clazz.getClassName())),
                    null);
        return retNode;
    }
    
    private TypeDeclarationNode buildEnumDeclarationNode(JavaClass clazz)
    {
        return factory.makeEnumDeclarationNode(
                buildEnumModifiersNode(clazz), 
                buildImplementsClause(clazz), 
                buildEnumBody(clazz), 
                factory.makeIdentifierNode(getUnqualifiedName(clazz.getClassName())), 
                null);
    }

    private EnumModifiersNode buildEnumModifiersNode(JavaClass clazz)
    {
        return factory.makeEnumModifiersNode(
                buildAccessModifier(clazz), 
                clazz.isStrictfp(), 
                factory.makeAnnotationListNode());
    }

    private EnumBodyNode buildEnumBody(JavaClass clazz)
    {
        return factory.makeEnumBodyNode(
                buildEnumConstants(clazz), 
                buildEnumMembers(clazz));
    }

    private ClassMemberListNode buildEnumMembers(JavaClass clazz)
    {
        List<ClassMemberNode> list = new ArrayList<ClassMemberNode>();

        for (Method method : clazz.getMethods())
        {
            list.add(buildMethodDeclarationNode(method));//TODO finish
        }
        
        for (Field field : clazz.getFields())
        {
            // we only care about real fields, not synthetic ones (added by compiler),
            // and here we want fields which are NOT enum constants
            if (!field.isSynthetic()
                    && !(field.isPublic() && field.isStatic() && field.isFinal()))
            {
                list.add(buildFieldDeclarationNode(field));
            }
        }
        
        return factory.makeClassMemberListNode(list );
    }

    private EnumConstantDeclarationListNode buildEnumConstants(JavaClass clazz)
    {
        List<EnumConstantDeclarationNode> list = new ArrayList<EnumConstantDeclarationNode>();
        
        for (Field field : clazz.getFields())
        {
            // we only care about real fields, not synthetic ones (added by compiler),
            // and only 'public static final' fields are enum constants
            if (!field.isSynthetic()
                    && field.isPublic() && field.isStatic() && field.isFinal())
            {
                list.add(factory.makeEnumConstantDeclarationNode(
                        factory.makeAnnotationListNode(), 
                        factory.makeIdentifierNode(field.getName()), 
                        factory.makeExpressionListNode(),//TODO arguments 
                        factory.makeAnonymousClassBodyNode(
                                factory.makeAnonymousClassMemberListNode()), //TODO body if needed
                        null));
            }
        }
        
        
        
        return factory.makeEnumConstantDeclarationListNode(list);
    }

    private DeclaredTypeListNode buildExtendsListNode(JavaClass clazz)
    {
        if (!clazz.isInterface())
        {
            throw new IllegalStateException(
                    "Multiple extends on a noninterface: " + clazz.toString());
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
            list.add(buildFieldDeclarationNode(field));
        }
        
        return factory.makeInterfaceBodyNode(factory.makeInterfaceMemberListNode(list));
    }

    private InterfaceModifiersNode buildInterfaceModifiersNode(JavaClass clazz)
    {
        return factory.makeInterfaceModifiersNode(
                buildAccessModifier(clazz), 
                clazz.isStatic(), 
                clazz.isStrictfp(), 
                factory.makeAnnotationListNode());
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

    private TypeParameterListNode buildTypeParamsListNode(Attribute[] attributes)
    {
        if (attributes == null)
        {
            return factory.makeTypeParameterListNode();
        }
        
        // find the class signature in the attributes if present
        Signature signature = null;
        for (Attribute attribute : attributes)
        {
            if (attribute instanceof Signature)
            {
                signature = (Signature)attribute;
                break;
            }
        }        
        if (signature == null)
        {
            return factory.makeTypeParameterListNode();
        }
        
        List<TypeParameterNode> list = new ArrayList<TypeParameterNode>();
        
        // signatures are of the following form:
        // <T:Ljava/lang/Object;V:Ljava/lang/Object;>
        // this regex parses them into bit sized pieces
        String typeParams[] = signature.getSignature()
            .replaceAll(">.*", "")
            .replaceFirst(".*<", "")
            .split(";");
        
        for (String typeParam : typeParams)
        {
            String identifier = typeParam.split(":")[0];
            factory.makeTypeParameterNode(
                    factory.makeIdentifierNode(identifier), 
                    null); //TODO finish type bounds
        }
        
        return factory.makeTypeParameterListNode(list);
    }

    private DeclaredTypeNode buildExtendsNode(JavaClass clazz)
    {
        DeclaredTypeNode retNode = null;
        //TODO done?
        if (clazz.getSuperclassName() != null && !clazz.getSuperclassName().equals("java.lang.Object"))
        {
            retNode = factory.makeUnparameterizedTypeNode(
                    buildNameNode(clazz.getSuperclassName()));
        }
        return retNode;
    }

    private ClassBodyNode buildClassBodyNode(JavaClass clazz)
    {
        List<ClassMemberNode> list = new ArrayList<ClassMemberNode>();
        
        for (Method method : clazz.getMethods())
        {
            if (method.getName().equals("<init>"))
            {
                list.add(buildConstructorDeclarationNode(
                        method, getUnqualifiedName(clazz.getClassName())));
            }
            else
            {
                list.add(buildMethodDeclarationNode(method));
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
        ConstructorDeclarationNode retNode =
            factory.makeConstructorDeclarationNode(
                    factory.makeIdentifierNode(name), 
                    factory.makeConstructorBodyNode(
                            null, factory.makeBlockStatementListNode()), 
                    buildConstructorModifiers(method), 
                    buildVariableListNode(method), 
                    null, // varargs not needed because BCEL does not distinguish them from arrays
                    buildThrowTypes(method.getExceptionTable()), 
                    buildTypeParamsListNode(method.getAttributes()), 
                    null);
        
        return retNode;
    }

    private ConstructorModifiersNode buildConstructorModifiers(Method method)
    {
        return factory.makeConstructorModifiersNode(buildAccessModifier(method));
    }

    private FieldDeclarationNode buildFieldDeclarationNode(Field field)
    {
        FieldDeclarationNode retNode =
            factory.makeFieldDeclarationNode(
                    buildFieldModifiersNode(field), 
                    buildVariableDeclarators(field), 
                    null);

        return retNode;
    }

    private VariableDeclaratorListNode buildVariableDeclarators(Field field)
    {
        // TODO initializer - leave as null?
        VariableDeclaratorNode retNode = 
            factory.makeVariableDeclaratorNode(
                buildTypeNode(field.getType()), 
                factory.makeIdentifierNode(field.getName()), 
                null);
        
        return factory.makeVariableDeclaratorListNode(retNode);
    }

    private FieldModifiersNode buildFieldModifiersNode(Field field)
    {
        return factory.makeFieldModifiersNode(
                buildAccessModifier(field), 
                field.isStatic(), 
                field.isFinal(), 
                field.isTransient(), 
                field.isVolatile(), 
                factory.makeAnnotationListNode());
    }

    private MethodDeclarationNode buildMethodDeclarationNode(Method method)
    {
        MethodDeclarationNode retNode = 
            factory.makeMethodDeclarationNode(
                buildEmptyBlockNode(), 
                buildMethodModifiersNode(method), 
                factory.makeIdentifierNode(method.getName()), 
                buildVariableListNode(method), 
                null, // varargs not needed because BCEL does not distinguish them from arrays
                buildTypeNode(method.getReturnType()), 
                buildThrowTypes(method.getExceptionTable()), 
                buildTypeParamsListNode(method.getAttributes()), 
                null);
        
        return retNode;
    }

    private VariableListNode buildVariableListNode(Method method)
    {
        List<VariableNode> list = new ArrayList<VariableNode>();
        int argCount = 0;
        for (Type arg : method.getArgumentTypes())
        {
            list.add(factory.makeVariableNode(
                    factory.makeVariableModifiersNode(), 
                    buildTypeNode(arg), 
                    factory.makeIdentifierNode("arg" + argCount)));
            argCount++;
        }
        return factory.makeVariableListNode(list);
    }

    private UnparameterizedTypeListNode buildThrowTypes(
            ExceptionTable exceptionTable)
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
        return factory.makeMethodModifiersNode(
                buildAccessModifier(method), 
                method.isAbstract(), 
                method.isStatic(), 
                method.isFinal(), 
                method.isSynchronized(), 
                method.isNative(), 
                method.isStrictfp(), 
                factory.makeAnnotationListNode());
    }

    private AccessModifier buildAccessModifier(AccessFlags flags)
    {
        AccessModifier access = AccessModifier.PACKAGE;
        if (flags.isPublic())
        {
            access = AccessModifier.PUBLIC;
        }
        else if (flags.isProtected())
        {
            access = AccessModifier.PROTECTED;
        }
        else if (flags.isPrivate())
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
        }
        else if (type instanceof ReferenceType)
        {
            retNode = buildReferenceTypeNode(type);
        }
        else
        {
            throw new IllegalStateException("Unknown type: " + type.toString());
        }
        
        return retNode;
   }

    private TypeNode buildReferenceTypeNode(Type type)
    {
        // TODO handle type parameters (extract from fields)
        
        TypeNode retNode = null;
        
        if (type instanceof ArrayType)
        {
            // get the basic type then wrap it in the proper number of levels of array types
            retNode = buildTypeNode(((ArrayType)type).getBasicType());            
            for (int i = 0; i < ((ArrayType)type).getDimensions(); i++)
            {
                retNode = factory.makeArrayTypeNode(retNode);
            }
        }
        else if (type instanceof ObjectType)
        {
            retNode = factory.makeUnparameterizedTypeNode(
                    buildNameNode(((ObjectType)type).getClassName()));
        }
        
        return retNode;
    }

    private TypeNode buildPrimitiveTypeNode(BasicType type)
    {
        PrimitiveType primitiveType = null;
        
        if (type.equals(BasicType.BOOLEAN))
        {
            primitiveType = PrimitiveType.BOOLEAN;
        }
        else if (type.equals(BasicType.BYTE))
        {
            primitiveType = PrimitiveType.BYTE;
        }
        else if (type.equals(BasicType.CHAR))
        {
            primitiveType = PrimitiveType.CHAR;
        }
        else if (type.equals(BasicType.DOUBLE))
        {
            primitiveType = PrimitiveType.DOUBLE;
        }
        else if (type.equals(BasicType.FLOAT))
        {
            primitiveType = PrimitiveType.FLOAT;
        }
        else if (type.equals(BasicType.INT))
        {
            primitiveType = PrimitiveType.INT;
        }
        else if (type.equals(BasicType.LONG))
        {
            primitiveType = PrimitiveType.LONG;
        }
        else if (type.equals(BasicType.SHORT))
        {
            primitiveType = PrimitiveType.SHORT;
        }
        else if (type.equals(BasicType.VOID))
        {
            primitiveType = PrimitiveType.VOID;
        }
        else
        {
            throw new IllegalStateException("Invalid type: " + type.toString());
        }
        
        return factory.makePrimitiveTypeNode(primitiveType);
    }

    private BlockNode buildEmptyBlockNode()
    {
        return factory.makeBlockNode(factory.makeBlockStatementListNode());
    }

    private ClassModifiersNode buildClassModifiersNode(JavaClass clazz)
    {
        return factory.makeClassModifiersNode(
                buildAccessModifier(clazz), 
                clazz.isAbstract(), 
                clazz.isStatic(), 
                clazz.isFinal(), 
                clazz.isStrictfp(), 
                factory.makeAnnotationListNode());
    }

    private NameNode buildNameNode(String name)
    {
        // if the name is not qualified, just return a simple name node
        if (!name.contains("."))
        {
            return factory.makeSimpleNameNode(factory.makeIdentifierNode(name), null);            
        }
        
        // recursively build qualified names
        String[] tokens = name.split("\\.");
        NameNode retNode = factory.makeQualifiedNameNode(
                buildNameNode(name.substring(0, name.lastIndexOf('.'))), 
                factory.makeIdentifierNode(tokens[tokens.length-1]), 
                null);

        return retNode;
    }
}
