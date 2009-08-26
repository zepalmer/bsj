package edu.jhu.cs.bsj.compiler.utils;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaCompiler;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

import com.sun.source.tree.ArrayTypeTree;
import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.BlockTree;
import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.ExpressionStatementTree;
import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.LiteralTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.MethodInvocationTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.ModifiersTree;
import com.sun.source.tree.NewArrayTree;
import com.sun.source.tree.ParenthesizedTree;
import com.sun.source.tree.PrimitiveTypeTree;
import com.sun.source.tree.ReturnTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.Trees;

public class JavaAstExaminer
{
    public static void main(String[] arg)
    {
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        SimpleJavaFileObject fileObject = new JavaSourceFromString(
                "GenSource",
                "public class GenSource {" +
                "    public static void main(String[] arg) {" +
                "        System.out.println(\"Hello, world!\");" +
                "    }" +
                "    public static void foo() {" +
                "        System.out.println(java.io.InputStream.class);" +
                "    }" +
                "    private static char[][] foo1 = new char[][]{new char[]{'a','b'}};" +
                "    private static int[] foo2 = new int[5];" +
                "    private int foo3 = 2 + (4 + 5);" +
                "    public String toString() { return \"hey!\"; }" + 
                "}"
        );
        
        JavaCompiler.CompilationTask task = javaCompiler.getTask(
                null, null, null, null, null,
                Collections.singletonList(fileObject));
        
        task.setProcessors(Collections.singletonList(new CodeAnalyzerProcessor(task)));
        
        task.call();
    }
}

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("*")
class CodeAnalyzerProcessor extends AbstractProcessor {
    
    private JavaCompiler.CompilationTask task;
    
    public CodeAnalyzerProcessor(JavaCompiler.CompilationTask task)
    {
        this.task = task;
    }

    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnvironment) {
        
        for (Element e : roundEnvironment.getRootElements()) {
            examine(e, 0);
            
            Trees t = Trees.instance(task);
            Tree tree = t.getTree(e);
            
            examineTree("root", tree, 0);
        }
        return true;
    }
    
    public void examine(Element e, int indent)
    {
        for (int i=0;i<indent;i++) System.out.print("    ");
        
        String s = e.getSimpleName() + ": " + e.getKind().toString();
        System.out.println(s);
        for (Element child : e.getEnclosedElements())
        {
            examine(child, indent+1);
        }
    }
    
    public void examineTree(String desc, Tree tree, int indent)
    {
        for (int i=0;i<indent;i++) System.out.print("    ");
        if (desc!=null)
        {
            System.out.print(desc + ": ");
        }
        for (int i=(desc==null?0:desc.length()+2);i<60-indent*4;i++)
        {
            System.out.print(' ');
        }
        
        if (tree instanceof CompilationUnitTree)
        {
             CompilationUnitTree cTree = (CompilationUnitTree)tree;
             System.out.println("Compilation Unit:");
             examineTree("package", cTree.getPackageName(), indent+1);
             examineList("imports", "import", cTree.getImports(), indent+1);
             examineList("type decls", "type decl", cTree.getTypeDecls(), indent+1);
        } else if (tree instanceof ClassTree)
        {
            ClassTree cTree = (ClassTree)tree;
            System.out.println("Class: " + cTree.getSimpleName());
            examineTree("modifiers", cTree.getModifiers(), indent+1);
            examineList("implements", "implements", cTree.getImplementsClause(), indent+1);
            examineTree("extends", cTree.getExtendsClause(), indent+1);
            examineList("typeParams", "typeParam", cTree.getTypeParameters(), indent+1);
            examineList("members", "member", cTree.getMembers(), indent+1);
        } else if (tree instanceof ModifiersTree)
        {
            ModifiersTree mTree = (ModifiersTree)tree;
            System.out.print("Modifiers: ");
            boolean first = true;
            for (Modifier m : mTree.getFlags())
            {
                if (!first) System.out.print(',');
                System.out.print(m);
                first = false;
            }
            System.out.println();
            examineList("annotations", "annotation", mTree.getAnnotations(), indent+1);
        } else if (tree instanceof MethodTree)
        {
            MethodTree mTree = (MethodTree)tree;
            System.out.println("Method: " + mTree.getName());
            examineTree("modifiers", mTree.getModifiers(), indent+1);
            examineList("params", "param", mTree.getParameters(), indent+1);
            examineTree("returns", mTree.getReturnType(), indent+1);
            examineList("throws", "throws", mTree.getThrows(), indent+1);
            examineList("typeParams", "typeParam", mTree.getTypeParameters(), indent+1);
            examineTree("body", mTree.getBody(), indent+1);
            examineTree("default", mTree.getDefaultValue(), indent+1);
        } else if (tree instanceof BlockTree)
        {
            BlockTree bTree = (BlockTree)tree;
            System.out.println("Block:");
            examineList("statements", "statement", bTree.getStatements(), indent+1);
        } else if (tree instanceof PrimitiveTypeTree)
        {
            PrimitiveTypeTree pTree = (PrimitiveTypeTree)tree;
            System.out.println("Primitive Type: " + pTree.getPrimitiveTypeKind().toString());
        } else if (tree instanceof VariableTree)
        {
            VariableTree vTree = (VariableTree)tree;
            System.out.println("Variable: " + vTree.getName());
            examineTree("modifiers", vTree.getModifiers(), indent+1);
            examineTree("type", vTree.getType(), indent+1);
            examineTree("init", vTree.getInitializer(), indent+1);
        } else if (tree instanceof ArrayTypeTree)
        {
            ArrayTypeTree aTree = (ArrayTypeTree)tree;
            System.out.println("Array type: ");
            examineTree("elementType", aTree.getType(), indent+1);
        } else if (tree instanceof ExpressionStatementTree)
        {
            ExpressionStatementTree eTree = (ExpressionStatementTree)tree;
            System.out.println("Expression statement:");
            examineTree("expression", eTree.getExpression(), indent+1);
        } else if (tree instanceof IdentifierTree)
        {
            IdentifierTree iTree = (IdentifierTree)tree;
            System.out.println("Identifier: " + iTree.getName());
        } else if (tree instanceof MethodInvocationTree)
        {
            MethodInvocationTree mTree = (MethodInvocationTree)tree;
            System.out.println("Method invocation:");
            examineList("arguments","argument",mTree.getArguments(),indent+1);
            examineList("typeArgs","typeArg",mTree.getTypeArguments(),indent+1);
            examineTree("select",mTree.getMethodSelect(),indent+1);
        } else if (tree instanceof MemberSelectTree)
        {
            MemberSelectTree mTree = (MemberSelectTree)tree;
            System.out.println("Member selection: " + mTree.getIdentifier());
            examineTree("expression",mTree.getExpression(),indent+1);
        } else if (tree instanceof NewArrayTree)
        {
        	NewArrayTree nTree = (NewArrayTree)tree;
        	System.out.println("New array: ");
        	examineTree("type",nTree.getType(),indent+1);
        	examineList("dimensions", "dimension", nTree.getDimensions(), indent+1);
        	examineList("inits","init",nTree.getInitializers(), indent+1);
        } else if (tree instanceof LiteralTree)
        {
            LiteralTree lTree = (LiteralTree)tree;
            System.out.println("Literal: " + lTree.getValue());
        } else if (tree instanceof BinaryTree)
        {
        	BinaryTree bTree = (BinaryTree)tree;
        	System.out.println("Binary operation: " + bTree.getKind());
        	examineTree("left", bTree.getLeftOperand(), indent+1);
        	examineTree("right", bTree.getRightOperand(), indent+1);
        } else if (tree instanceof ParenthesizedTree)
        {
        	ParenthesizedTree pTree = (ParenthesizedTree)tree;
        	System.out.println("Parens:");
        	examineTree("inner", pTree.getExpression(), indent+1);
        } else if (tree instanceof ReturnTree)
        {
        	ReturnTree rTree = (ReturnTree)tree;
        	System.out.println("Return:");
        	examineTree("expr", rTree.getExpression(), indent+1);
        } else if (tree==null)
        {
            System.out.println("null");
        } else
        {
            StringBuffer sb = new StringBuffer();
            Stack<Class<?>> s = new Stack<Class<?>>();
            s.push(tree.getClass());
            while (s.size()>0)
            {
                Class<?> c = s.pop();
                Class<?> sc = c.getSuperclass();
                if (sc!=null) s.push(sc);
                
                if (sb.length()>0) sb.append(',');
                sb.append(c.getName());
                
                for (Class<?> iface : c.getInterfaces())
                {
                    s.push(iface);
                }
            }
            System.out.println("Unrecognized tree type " + tree.getClass() + " (" + sb.toString() + ")");
        }
    }
    
    public void examineList(String desc, String innerDesc, List<? extends Tree> list, int indent)
    {
        for (int i=0;i<indent;i++) System.out.print("    ");
        if (desc!=null)
        {
            System.out.print(desc + ": ");
        }
        for (int i=(desc==null?0:desc.length()+2);i<60-indent*4;i++)
        {
            System.out.print(' ');
        }
        
        if (list==null)
        {
        	System.out.println("List: null");
        } else
        {
	        System.out.println("List: " + list.size());
	        for (Tree t : list)
	        {
	            examineTree(innerDesc, t, indent+1);
	        }
        }
    }
}

/**
* A file object used to represent source coming from a string.
*/
class JavaSourceFromString extends SimpleJavaFileObject {
   /**
    * The source code of this "file".
    */
   final String code;

   /**
    * Constructs a new JavaSourceFromString.
    * @param name the name of the compilation unit represented by this file object
    * @param code the source code for the compilation unit represented by this file object
    */
   JavaSourceFromString(String name, String code) {
       super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension),
             Kind.SOURCE);
       this.code = code;
   }

   @Override
   public CharSequence getCharContent(boolean ignoreEncodingErrors) {
       return code;
   }
}

