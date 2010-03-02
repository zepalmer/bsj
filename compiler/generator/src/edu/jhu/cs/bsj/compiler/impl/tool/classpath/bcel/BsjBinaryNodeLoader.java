package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaFileObject.Kind;

import org.apache.bcel.classfile.AccessFlags;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.ExceptionTable;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.BasicType;
import org.apache.bcel.generic.ReferenceType;
import org.apache.bcel.generic.Type;
import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
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
                factory.makeImportListNode(), 
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
                buildNameName(clazz.getPackageName()));
    }

    private TypeDeclarationNode buildTypeDeclarationNode(JavaClass clazz)
    {
        if (clazz.isClass())
        {
            return buildClassDeclarationNode(clazz);
        }
        else if (clazz.isInterface())
        {
            return buildInterfaceDeclarationNode(clazz);
        }
        else if (clazz.isEnum())
        {
            return buildEnumDeclarationNode(clazz);
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
                buildTypeParamsListNode(clazz), 
                factory.makeIdentifierNode(clazz.getClassName()), 
                null);
        
        return retNode;
    }
    
    private TypeDeclarationNode buildInterfaceDeclarationNode(JavaClass clazz)
    {
        InterfaceDeclarationNode retNode = 
            factory.makeInterfaceDeclarationNode(
                    buildInterfaceModifiersNode(clazz), 
                    buildExtendsListNode(clazz), 
                    buildInterfaceBodyNode(clazz), 
                    buildTypeParamsListNode(clazz), 
                    factory.makeIdentifierNode(clazz.getClassName()),
                    null);
        return retNode;
    }
    
    private TypeDeclarationNode buildEnumDeclarationNode(JavaClass clazz)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private DeclaredTypeListNode buildExtendsListNode(JavaClass clazz)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private InterfaceBodyNode buildInterfaceBodyNode(JavaClass clazz)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private InterfaceModifiersNode buildInterfaceModifiersNode(JavaClass clazz)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private DeclaredTypeListNode buildImplementsClause(JavaClass clazz)
    {
        List<DeclaredTypeNode> list = new ArrayList<DeclaredTypeNode>();
        
        for (String iface : clazz.getInterfaceNames())
        {
            list.add(factory.makeUnparameterizedTypeNode(buildNameName(iface)));
        }

        return factory.makeDeclaredTypeListNode(list);
    }

    private TypeParameterListNode buildTypeParamsListNode(JavaClass clazz)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private DeclaredTypeNode buildExtendsNode(JavaClass clazz)
    {
        DeclaredTypeNode retNode = null;
        
        if (clazz.getSuperclassName() != null && !clazz.getSuperclassName().equals("java.lang.Object"))
        {
            retNode = factory.makeUnparameterizedTypeNode(
                    buildNameName(clazz.getSuperclassName()));
        }
        return retNode;
    }

    private ClassBodyNode buildClassBodyNode(JavaClass clazz)
    {
        List<ClassMemberNode> list = new ArrayList<ClassMemberNode>();
        
        for (Method method : clazz.getMethods())
        {
            list.add(buildMethodDeclarationNode(method));
        }
        
        for (Field field : clazz.getFields())
        {
            list.add(buildFieldDeclarationNode(field));
        }
        
        return factory.makeClassBodyNode(factory.makeClassMemberListNode(list));
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
        // TODO finish argument parsing
        MethodDeclarationNode retNode = 
            factory.makeMethodDeclarationNode(
                buildEmptyBlockNode(), 
                buildMethodModifiersNode(method), 
                factory.makeIdentifierNode(method.getName()), 
                null, 
                null, 
                buildTypeNode(method.getReturnType()), 
                buildThrowTypes(method.getExceptionTable()), 
                buildTypeParamsListNode(method), 
                null);
        
        return retNode;
    }

    private TypeParameterListNode buildTypeParamsListNode(Method method)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private UnparameterizedTypeListNode buildThrowTypes(
            ExceptionTable exceptionTable)
    {
        // TODO Auto-generated method stub
        return null;
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
            PrimitiveType primitiveType = null;
            
            if (BasicType.getType(type.getType()).equals(BasicType.BOOLEAN))
            {
                primitiveType = PrimitiveType.BOOLEAN;
            }
            else if (BasicType.getType(type.getType()).equals(BasicType.BYTE))
            {
                primitiveType = PrimitiveType.BYTE;
            }
            else if (BasicType.getType(type.getType()).equals(BasicType.CHAR))
            {
                primitiveType = PrimitiveType.CHAR;
            }
            else if (BasicType.getType(type.getType()).equals(BasicType.DOUBLE))
            {
                primitiveType = PrimitiveType.DOUBLE;
            }
            else if (BasicType.getType(type.getType()).equals(BasicType.FLOAT))
            {
                primitiveType = PrimitiveType.FLOAT;
            }
            else if (BasicType.getType(type.getType()).equals(BasicType.INT))
            {
                primitiveType = PrimitiveType.INT;
            }
            else if (BasicType.getType(type.getType()).equals(BasicType.LONG))
            {
                primitiveType = PrimitiveType.LONG;
            }
            else if (BasicType.getType(type.getType()).equals(BasicType.SHORT))
            {
                primitiveType = PrimitiveType.SHORT;
            }
            else if (BasicType.getType(type.getType()).equals(BasicType.VOID))
            {
                primitiveType = PrimitiveType.VOID;
            }
            
            retNode = factory.makePrimitiveTypeNode(primitiveType);
        }
        else if (type instanceof ReferenceType)
        {
            //TODO
        }
        else
        {
            throw new IllegalStateException("Unknown type: " + type.toString());
        }
        
        return retNode;
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

    private NameNode buildNameName(String name)
    {
        // if the name is not qualified, just return a simple name node
        if (!name.contains("\\."))
        {
            return factory.makeSimpleNameNode(factory.makeIdentifierNode(name), null);            
        }
        
        
        String[] tokens = name.split("\\.");
        
        if (tokens.length == 1)
        {
            
        }
        
     // TODO Auto-generated method stub
        
        NameNode retNode = null;//factory.makeQualifiedNameNode(base, identifier, null);
        
        
        

        return factory.makeSimpleNameNode(factory.makeIdentifierNode(name), null);
    }

}
