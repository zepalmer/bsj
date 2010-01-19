package edu.jhu.cs.bsj.compiler.impl.tool;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceSerializer;
import edu.jhu.cs.bsj.compiler.ast.node.*;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;

public class BsjSourceSerializerImpl implements BsjSourceSerializer
{
    @Override
    public Void executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationArrayValueNode(AnnotationArrayValueNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationBodyNode(AnnotationBodyNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationDeclarationNode(AnnotationDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationElementNode(AnnotationElementNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnnotationModifiersNode(AnnotationModifiersNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAnonymousClassBodyNode(AnonymousClassBodyNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayAccessNode(ArrayAccessNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayInitializerNode(ArrayInitializerNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeArrayTypeNode(ArrayTypeNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAssertStatementNode(AssertStatementNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeAssignmentNode(AssignmentNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeBinaryExpressionNode(BinaryExpressionNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeBlockStatementNode(BlockStatementNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeBooleanLiteralNode(BooleanLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeBreakNode(BreakNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeCaseNode(CaseNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeCatchNode(CatchNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeCharLiteralNode(CharLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeClassBodyNode(ClassBodyNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        
        return null;
    }

    @Override
    public Void executeClassDeclarationNode(ClassDeclarationNode node, StringBuilder p)
    {
        node.getModifiers().executeOperation(this, p);
        p.append("class ");
        node.getIdentifier().executeOperation(this, p);
        handleListNode(node.getTypeParameters(), "<", ", ", ">", p, true);
        if (node.getExtendsClause() != null)
        {
            p.append(" ");
            node.getExtendsClause().executeOperation(this, p);
        }
        handleListNode(node.getImplementsClause(), " ", ", ", "", p, true);
        p.append("\n");
        node.getBody().executeOperation(this, p);
        return null;
    }

    @Override
    public Void executeClassLiteralNode(ClassLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeClassModifiersNode(ClassModifiersNode node, StringBuilder p)
    {
        p.append(accessModifierToString(node.getAccess()));
        p.append(" ");
        
        if (node.getAbstractFlag())
        {
            p.append("abstract ");
        }
        
        if (node.getFinalFlag())
        {
            p.append("final ");
        }
        
        if (node.getStaticFlag())
        {
            p.append("static ");
        }
        
        if (node.getStrictfpFlag())
        {
            p.append("strictfp ");
        }
        
        return null;
    }

    @Override
    public Void executeCodeLiteralNode(CodeLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeCompilationUnitNode(CompilationUnitNode node, StringBuilder p)
    {
        node.getPackageDeclaration().executeOperation(this, p);
        p.append("\n\n");
        handleListNode(node.getImports(), "", "\n", "\n", p, true);
        p.append("\n");
        handleListNode(node.getTypeDecls(), "", "\n\n", "\n", p, true);
        return null;
    }

    @Override
    public Void executeConditionalExpressionNode(ConditionalExpressionNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeConstructorBodyNode(ConstructorBodyNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeConstructorDeclarationNode(ConstructorDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeConstructorModifiersNode(ConstructorModifiersNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeContinueNode(ContinueNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeDoWhileLoopNode(DoWhileLoopNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeDoubleLiteralNode(DoubleLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnhancedForLoopNode(EnhancedForLoopNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnumBodyNode(EnumBodyNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnumDeclarationNode(EnumDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeEnumModifiersNode(EnumModifiersNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeExpressionStatementNode(ExpressionStatementNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeFieldAccessByExpressionNode(FieldAccessByExpressionNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeFieldAccessByNameNode(FieldAccessByNameNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeFieldDeclarationNode(FieldDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeFieldModifiersNode(FieldModifiersNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeFloatLiteralNode(FloatLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeForInitializerExpressionNode(ForInitializerExpressionNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeForLoopNode(ForLoopNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeIdentifierNode(IdentifierNode node, StringBuilder p)
    {
        p.append(node.getIdentifier());
        return null;
    }

    @Override
    public Void executeIfNode(IfNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeImportOnDemandNode(ImportOnDemandNode node, StringBuilder p)
    {
        p.append("import ");
        if (node.getStaticImport())
        {
            p.append("static ");
        }
        node.getName().executeOperation(this, p);
        p.append(".*;");
        return null;
    }

    @Override
    public Void executeImportSingleTypeNode(ImportSingleTypeNode node, StringBuilder p)
    {
        p.append("import ");
        if (node.getStaticImport())
        {
            p.append("static ");
        }
        node.getName().executeOperation(this, p);
        p.append(";");
        return null;
    }

    @Override
    public Void executeInitializerDeclarationNode(InitializerDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInlineTypeDeclarationNode(InlineTypeDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInstanceOfNode(InstanceOfNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeIntLiteralNode(IntLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInterfaceBodyNode(InterfaceBodyNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInterfaceDeclarationNode(InterfaceDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeInterfaceModifiersNode(InterfaceModifiersNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeJavadocNode(JavadocNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeLabeledStatementNode(LabeledStatementNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends Node> Void executeListNode(ListNode<T> node, StringBuilder p)
    {
        // TODO done?
        
        // just call the utility method with some defaults
        handleListNode(node, "", ",", "\n", p, false);
        return null;
    }

    @Override
    public Void executeLongLiteralNode(LongLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeMethodDeclarationNode(MethodDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeMethodInvocationByNameNode(MethodInvocationByNameNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeMethodModifiersNode(MethodModifiersNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeNormalAnnotationNode(NormalAnnotationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeNullLiteralNode(NullLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executePackageDeclarationNode(PackageDeclarationNode node, StringBuilder p)
    {
        // TODO annotations
        p.append("package ");
        node.getName().executeOperation(this, p);
        p.append(";");
        return null;
    }

    @Override
    public Void executeParameterizedTypeNode(ParameterizedTypeNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executePrimitiveTypeNode(PrimitiveTypeNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeQualifiedNameNode(QualifiedNameNode node, StringBuilder p)
    {
        node.getBase().executeOperation(this, p);
        p.append('.');
        executeIdentifierNode(node.getIdentifier(), p);
        return null;
    }

    @Override
    public Void executeReturnNode(ReturnNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSimpleNameNode(SimpleNameNode node, StringBuilder p)
    {
        executeIdentifierNode(node.getIdentifier(), p);
        return null;
    }

    @Override
    public Void executeSingleElementAnnotationNode(SingleElementAnnotationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeStringLiteralNode(StringLiteralNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSuperFieldAccessNode(SuperFieldAccessNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSuperMethodInvocationNode(SuperMethodInvocationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSwitchNode(SwitchNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeSynchronizedNode(SynchronizedNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeThisNode(ThisNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeThrowNode(ThrowNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeTryNode(TryNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeTypeCastNode(TypeCastNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeTypeParameterNode(TypeParameterNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeUnaryExpressionNode(UnaryExpressionNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeUnparameterizedTypeNode(UnparameterizedTypeNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVariableDeclarationNode(VariableDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVariableDeclaratorNode(VariableDeclaratorNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVariableModifiersNode(VariableModifiersNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVariableNode(VariableNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVoidStatementNode(VoidStatementNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVoidTypeDeclarationNode(VoidTypeDeclarationNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeVoidTypeNode(VoidTypeNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeWhileLoopNode(WhileLoopNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void executeWildcardTypeNode(WildcardTypeNode node, StringBuilder p)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public void handleListNode(ListNode<? extends Node> node, 
            String begin, String separator, String end, StringBuilder p, boolean doNothingIfEmpty)
    {
        if (doNothingIfEmpty && node.getChildren().isEmpty())
        {
            return;
        }
        
        p.append(begin);
        boolean first = true;
        
        for (Node item : node.getChildren())
        {   
            if (first == true)
            {
                first = false;
            } else
            {
                p.append(separator);
            }
            item.executeOperation(this, p);
        }
        
        p.append(end);
    }
    
    public String accessModifierToString(AccessModifier modifier)
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
                return "private";
            case PROTECTED:
                return "protected";
            case PUBLIC:
                return "public";
            default:
                throw new IllegalStateException("Invalid AccessModifier");
        }
    }
}
