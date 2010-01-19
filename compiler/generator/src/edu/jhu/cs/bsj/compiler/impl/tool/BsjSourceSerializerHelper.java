package edu.jhu.cs.bsj.compiler.impl.tool;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;

public class BsjSourceSerializerHelper implements BsjNodeOperation<PrependablePrintStream, Void>
{
    @Override
    public Void executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    } 

    @Override
    public Void executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationArrayValueNode(AnnotationArrayValueNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationBodyNode(AnnotationBodyNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationDeclarationNode(AnnotationDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationElementNode(AnnotationElementNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationModifiersNode(AnnotationModifiersNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnonymousClassBodyNode(AnonymousClassBodyNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayAccessNode(ArrayAccessNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayInitializerNode(ArrayInitializerNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayTypeNode(ArrayTypeNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAssertStatementNode(AssertStatementNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAssignmentNode(AssignmentNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeBinaryExpressionNode(BinaryExpressionNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeBlockStatementNode(BlockStatementNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeBooleanLiteralNode(BooleanLiteralNode node, PrependablePrintStream p)
    {
        p.print(node.getValue() ? "true" : "false");
        return null;
    }

    @Override
    public Void executeBreakNode(BreakNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeCaseNode(CaseNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeCatchNode(CatchNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeCharLiteralNode(CharLiteralNode node, PrependablePrintStream p)
    {
        p.print("'");
        p.print(node.getValue());
        p.print("'");
        return null;
    }

    @Override
    public Void executeClassBodyNode(ClassBodyNode node, PrependablePrintStream p)
    {
        p.print("{\n");
        p.incPrependCount();
        handleListNode(node.getMembers(), "", "\n", "", p, true);  
        p.decPrependCount();
        p.print("}");
        return null;
    }

    @Override
    public Void executeClassDeclarationNode(ClassDeclarationNode node, PrependablePrintStream p)
    {
        node.getModifiers().executeOperation(this, p);
        p.print("class ");
        node.getIdentifier().executeOperation(this, p);
        handleListNode(node.getTypeParameters(), "<", ", ", ">", p, true);
        if (node.getExtendsClause() != null)
        {
            p.print(" ");
            node.getExtendsClause().executeOperation(this, p);
        }
        handleListNode(node.getImplementsClause(), " ", ", ", "", p, true);
        p.print("\n");
        node.getBody().executeOperation(this, p);
        return null;
    }

    @Override
    public Void executeClassLiteralNode(ClassLiteralNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeClassModifiersNode(ClassModifiersNode node, PrependablePrintStream p)
    {
        //TODO annotations
        p.print(accessModifierToString(node.getAccess()));

        if (node.getAbstractFlag())
        {
            p.print("abstract ");
        }
        
        if (node.getFinalFlag())
        {
            p.print("final ");
        }
        
        if (node.getStaticFlag())
        {
            p.print("static ");
        }
        
        if (node.getStrictfpFlag())
        {
            p.print("strictfp ");
        }
        
        return null;
    }

    @Override
    public Void executeCodeLiteralNode(CodeLiteralNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeCompilationUnitNode(CompilationUnitNode node, PrependablePrintStream p)
    {
        node.getPackageDeclaration().executeOperation(this, p);
        p.print("\n\n");
        handleListNode(node.getImports(), "", "\n", "\n", p, true);
        p.print("\n");
        handleListNode(node.getTypeDecls(), "", "\n\n", "\n", p, true);
        return null;
    }

    @Override
    public Void executeConditionalExpressionNode(ConditionalExpressionNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeConstructorBodyNode(ConstructorBodyNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeConstructorDeclarationNode(ConstructorDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeConstructorModifiersNode(ConstructorModifiersNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeContinueNode(ContinueNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeDoWhileLoopNode(DoWhileLoopNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeDoubleLiteralNode(DoubleLiteralNode node, PrependablePrintStream p)
    {
        p.print(node.getValue().toString());
        return null;
    }

    @Override
    public Void executeEnhancedForLoopNode(EnhancedForLoopNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnumBodyNode(EnumBodyNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnumDeclarationNode(EnumDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnumModifiersNode(EnumModifiersNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeExpressionStatementNode(ExpressionStatementNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeFieldAccessByNameNode(FieldAccessByNameNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeFieldDeclarationNode(FieldDeclarationNode node, PrependablePrintStream p)
    {
        for (Node item : node.getDeclarators().getChildren())
        {
            if (node.getJavadoc() != null)
            {
                node.getJavadoc().executeOperation(this, p);
                p.print("\n");
            }
            node.getModifiers().executeOperation(this, p);            
            item.executeOperation(this, p);
            p.print(";\n");
        }

        return null;
    }

    @Override
    public Void executeFieldModifiersNode(FieldModifiersNode node, PrependablePrintStream p)
    {
        // TODO annotations
        p.print(accessModifierToString(node.getAccess()));
        
        if (node.getFinalFlag())
        {
            p.print("final ");
        }
        
        if (node.getStaticFlag())
        {
            p.print("static ");
        }
        
        if (node.getTransientFlag())
        {
            p.print("transient ");
        }
        
        if (node.getVolatileFlag())
        {
            p.print("volatile ");
        }

        return null;
    }

    @Override
    public Void executeFloatLiteralNode(FloatLiteralNode node, PrependablePrintStream p)
    {
        p.print(node.getValue().toString());
        return null;
    }

    @Override
    public Void executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeForInitializerExpressionNode(ForInitializerExpressionNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeForLoopNode(ForLoopNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeIdentifierNode(IdentifierNode node, PrependablePrintStream p)
    {
        p.print(node.getIdentifier());
        return null;
    }

    @Override
    public Void executeIfNode(IfNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeImportOnDemandNode(ImportOnDemandNode node, PrependablePrintStream p)
    {
        p.print("import ");
        if (node.getStaticImport())
        {
            p.print("static ");
        }
        node.getName().executeOperation(this, p);
        p.print(".*;");
        return null;
    }

    @Override
    public Void executeImportSingleTypeNode(ImportSingleTypeNode node, PrependablePrintStream p)
    {
        p.print("import ");
        if (node.getStaticImport())
        {
            p.print("static ");
        }
        node.getName().executeOperation(this, p);
        p.print(";");
        return null;
    }

    @Override
    public Void executeInitializerDeclarationNode(InitializerDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInstanceOfNode(InstanceOfNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeIntLiteralNode(IntLiteralNode node, PrependablePrintStream p)
    {
        p.print(node.getValue().toString());
        return null;
    }

    @Override
    public Void executeInterfaceBodyNode(InterfaceBodyNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInterfaceDeclarationNode(InterfaceDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInterfaceModifiersNode(InterfaceModifiersNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeJavadocNode(JavadocNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeLabeledStatementNode(LabeledStatementNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends Node> Void executeListNode(ListNode<T> node, PrependablePrintStream p)
    {
        // TODO done?
        
        // just call the utility method with some defaults
        handleListNode(node, "", ",", "\n", p, false);
        return null;
    }

    @Override
    public Void executeLongLiteralNode(LongLiteralNode node, PrependablePrintStream p)
    {
        p.print(node.getValue().toString());
        return null;
    }

    @Override
    public Void executeMethodDeclarationNode(MethodDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        if (node.getJavadoc() != null)
        {
            node.getJavadoc().executeOperation(this, p);
            p.print("\n");
        }
        node.getModifiers().executeOperation(this, p);
        //TODO FINISH
        return null;
    }

    @Override
    public Void executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeMethodInvocationByNameNode(MethodInvocationByNameNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeMethodModifiersNode(MethodModifiersNode node, PrependablePrintStream p)
    {
        // TODO annotations
        p.print(accessModifierToString(node.getAccess()));
        
        if (node.getAbstractFlag())
        {
            p.print("abstract ");
        }
        
        if (node.getFinalFlag())
        {
            p.print("final ");
        }
        
        if (node.getNativeFlag())
        {
            p.print("native ");
        }
        
        if (node.getStaticFlag())
        {
            p.print("static ");
        }
        
        if (node.getStrictfpFlag())
        {
            p.print("strictfp ");
        }
        
        if (node.getSynchronizedFlag())
        {
            p.print("synchronized ");
        }

        return null;
    }

    @Override
    public Void executeNormalAnnotationNode(NormalAnnotationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeNullLiteralNode(NullLiteralNode node, PrependablePrintStream p)
    {
        p.print("null");
        return null;
    }

    @Override
    public Void executePackageDeclarationNode(PackageDeclarationNode node, PrependablePrintStream p)
    {
        // TODO annotations
        p.print("package ");
        node.getName().executeOperation(this, p);
        p.print(";");
        return null;
    }

    @Override
    public Void executeParameterizedTypeNode(ParameterizedTypeNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executePrimitiveTypeNode(PrimitiveTypeNode node, PrependablePrintStream p)
    {
        p.print(primitiveTypeToString(node.getPrimitiveType()));
        return null;
    }

    @Override
    public Void executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeQualifiedNameNode(QualifiedNameNode node, PrependablePrintStream p)
    {
        node.getBase().executeOperation(this, p);
        p.print('.');
        executeIdentifierNode(node.getIdentifier(), p);
        return null;
    }

    @Override
    public Void executeReturnNode(ReturnNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSimpleNameNode(SimpleNameNode node, PrependablePrintStream p)
    {
        executeIdentifierNode(node.getIdentifier(), p);
        return null;
    }

    @Override
    public Void executeSingleElementAnnotationNode(SingleElementAnnotationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeStringLiteralNode(StringLiteralNode node, PrependablePrintStream p)
    {
        p.print("\"");
        p.print(node.getValue());
        p.print("\"");
        return null;
    }

    @Override
    public Void executeSuperFieldAccessNode(SuperFieldAccessNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSuperMethodInvocationNode(SuperMethodInvocationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSwitchNode(SwitchNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSynchronizedNode(SynchronizedNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeThisNode(ThisNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeThrowNode(ThrowNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeTryNode(TryNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeTypeCastNode(TypeCastNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeTypeParameterNode(TypeParameterNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeUnaryExpressionNode(UnaryExpressionNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeUnparameterizedTypeNode(UnparameterizedTypeNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVariableDeclarationNode(VariableDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVariableDeclaratorNode(VariableDeclaratorNode node, PrependablePrintStream p)
    {
        node.getType().executeOperation(this, p);
        p.print(" ");
        node.getName().executeOperation(this, p);
        if (node.getInitializer() != null)
        {
            p.print(" ");
            node.getInitializer().executeOperation(this, p);
        }
        return null;
    }

    @Override
    public Void executeVariableModifiersNode(VariableModifiersNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVariableNode(VariableNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVoidStatementNode(VoidStatementNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVoidTypeDeclarationNode(VoidTypeDeclarationNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVoidTypeNode(VoidTypeNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeWhileLoopNode(WhileLoopNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeWildcardTypeNode(WildcardTypeNode node, PrependablePrintStream p)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    protected void handleListNode(ListNode<? extends Node> node, 
            String begin, String separator, String end, PrependablePrintStream p, boolean doNothingIfEmpty)
    {
        if (doNothingIfEmpty && node.getChildren().isEmpty())
        {
            return;
        }
        
        p.print(begin);
        boolean first = true;
        
        for (Node item : node.getChildren())
        {   
            if (first == true)
            {
                first = false;
            } else
            {
                p.print(separator);
            }
            item.executeOperation(this, p);
        }
        
        p.print(end);
    }
    
    protected String accessModifierToString(AccessModifier modifier)
    {
        if (modifier == null)
        {
            throw new IllegalStateException("Null AccessModifier");
        }
        
        switch (modifier)
        {
            case PACKAGE:
                return "";
            case PRIVATE:
                return "private ";
            case PROTECTED:
                return "protected ";
            case PUBLIC:
                return "public ";
            default:
                throw new IllegalStateException("Invalid AccessModifier");
        }
    }
    
    protected String primitiveTypeToString(PrimitiveType type)
    {
        if (type == null)
        {
            throw new IllegalStateException("Null PrimitiveType");
        }
        
        switch (type)
        {
            case BOOLEAN:
                return "boolean";
            case BYTE:
                return "byte";
            case CHAR:
                return "char";
            case DOUBLE:
                return "double";
            case FLOAT:
                return "float";
            case INT:
                return "int";
            case LONG:
                return "long";
            case SHORT:
                return "short";
            case VOID:
                return "void";
            default:
                throw new IllegalStateException("Invalid PrimitiveType");
        }
    }
}
