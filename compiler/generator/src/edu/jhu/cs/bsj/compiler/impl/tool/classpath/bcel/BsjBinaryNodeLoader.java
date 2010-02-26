package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaFileObject.Kind;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationManager;

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

        CompilationUnitNode retNode = factory.makeCompilationUnitNode(
                className, 
                buildPackageDeclarationNode(clazz), 
                factory.makeImportListNode(), 
                factory.makeTypeDeclarationListNode(
                        buildClassDeclarationNode(clazz)));

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
                buildQualifiedNameNode(clazz.getPackageName()));
    }

    private TypeDeclarationNode buildClassDeclarationNode(JavaClass clazz)
    {
        // TODO interfaces
        ClassDeclarationNode retNode = factory.makeClassDeclarationNode(
                buildModifiersNode(clazz.getModifiers()), 
                buildExtendsNode(clazz), 
                buildImplementsClause(clazz), 
                buildClassBodyNode(clazz), 
                buildTypeParamsListNode(clazz), 
                factory.makeIdentifierNode(clazz.getClassName()), 
                null);
        
        // TODO add isBinary field to nodes
        
        return retNode;
    }

    private DeclaredTypeListNode buildImplementsClause(JavaClass clazz)
    {
        List<DeclaredTypeNode> list = new ArrayList<DeclaredTypeNode>();
        
        for (String iface : clazz.getInterfaceNames())
        {
            list.add(factory.makeUnparameterizedTypeNode(buildQualifiedNameNode(iface)));
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
                    buildQualifiedNameNode(clazz.getSuperclassName()));
        }
        return retNode;
    }

    private ClassBodyNode buildClassBodyNode(JavaClass clazz)
    {
        // TODO Auto-generated method stub
        List<ClassMemberNode> list = new ArrayList<ClassMemberNode>();
        
        for (Method method : clazz.getMethods())
        {
            
        }
        
        for (Field field : clazz.getFields())
        {
            
        }
        
        return factory.makeClassBodyNode(factory.makeClassMemberListNode(list));
    }

    private ClassModifiersNode buildModifiersNode(int modifiers)
    {
        // TODO Auto-generated method stub
        return null;
    }

    private NameNode buildQualifiedNameNode(String name)
    {
        if (!name.contains("\\."))
        {
            return factory.makeSimpleNameNode(factory.makeIdentifierNode(name), null);            
        }
        
        // TODO Auto-generated method stub
        String[] tokens = name.split("\\.");
        
        if (tokens.length == 1)
        {
            
        }
        
        
        
        NameNode retNode = null;//factory.makeQualifiedNameNode(base, identifier, null);
        
        
        

        return factory.makeSimpleNameNode(factory.makeIdentifierNode(name), null);
    }

}
