package edu.jhu.cs.bsj.tests.compiler.ast.delta;

import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.MetaprogramExecutionStack;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScript;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState.PopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.Metaprogram;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.Dependency;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.utils.function.MappedFunction;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.tests.AbstractTest;

public class AstPatchTest extends AbstractTest
{
    private final class PatchStatePopulator implements PopulationStrategy
    {
        private final Map<Long, Node> originalNodeMap;
        private final BsjNodeProxyFactory proxyFactory;

        private PatchStatePopulator(Map<Long, Node> originalNodeMap, BsjNodeProxyFactory proxyFactory)
        {
            this.originalNodeMap = originalNodeMap;
            this.proxyFactory = proxyFactory;
        }

        @Override
        public Node populate(long argument)
        {
            return this.proxyFactory.makeNode(this.originalNodeMap.get(argument));
        }
    }

    @Test
    public void astPatchTest() throws Exception
    {
        BsjToolkit toolkit = BsjServiceRegistry.getInstance().newToolkitFactory().newToolkit();
        BsjNodeFactory coreFactory = toolkit.getNodeFactory();

        CompilationUnitNode c = toolkit.getParser().parse("Foo",
                new StringReader("public class Foo {\n    public void foo() {\n    }\n}\n"), null);
        PackageNode p = toolkit.getNodeFactory().makePackageNode(null);
        p.addCompilationUnit(c);

        // map each original node UID to the node
        final Map<Long, Node> originalNodeMap = new HashMap<Long, Node>();
        c.receive(new BsjNodeVisitor()
        {
            @Override
            public void visitStop(Node node)
            {
            }

            @Override
            public void visitStart(Node node)
            {
                originalNodeMap.put(node.getUid(), node);
            }
        });

        // extract the node manager from the field - this is horrific but necessary at the moment
        Field f = NodeImpl.class.getDeclaredField("manager");
        f.setAccessible(true);
        BsjNodeManager manager = (BsjNodeManager) f.get(p);

        // make some fake metaprograms
        MetaprogramProfile<TypeDeclarationMetaprogramAnchorNode, TypeDeclarationNode> profile1 = introduceProfile(
                coreFactory, c, 1);
        MetaprogramProfile<TypeDeclarationMetaprogramAnchorNode, TypeDeclarationNode> profile2 = introduceProfile(
                coreFactory, c, 2);

        // make a dependency manager
        DependencyManager dependencyManager = new DependencyManager();
        dependencyManager.registerMetaprogramProfile(profile1, null, null);
        dependencyManager.registerMetaprogramProfile(profile2, null, null);

        BsjNodeProxyFactory proxyFactory;
        MetaprogramExecutionStack.Element element;

        // create first delta
        proxyFactory = new BsjNodeProxyFactoryImpl(manager);
        List<EditScriptElement> editScriptElements = new ArrayList<EditScriptElement>();
        element = new MetaprogramExecutionStack.Element(dependencyManager, null, profile1, editScriptElements,
                proxyFactory);
        manager.getMetaprogramExecutionStack().push(element);
        applyDelta1(coreFactory, proxyFactory.makeCompilationUnitNode(c));
        EditScript delta1 = new EditScriptImpl(new BsjSourceLocation("None", 1, 1), editScriptElements);
        manager.getMetaprogramExecutionStack().pop(element);
        Map<Long, Long> proxyIdMap1 = proxyFactory.getProxyIdMapping();

        // create second delta
        proxyFactory = new BsjNodeProxyFactoryImpl(manager);
        editScriptElements = new ArrayList<EditScriptElement>();
        element = new MetaprogramExecutionStack.Element(dependencyManager, null, profile2, editScriptElements,
                proxyFactory);
        manager.getMetaprogramExecutionStack().push(element);
        applyDelta2(coreFactory, proxyFactory.makeCompilationUnitNode(c));
        EditScript delta2 = new EditScriptImpl(new BsjSourceLocation("None", 2, 1), editScriptElements);
        manager.getMetaprogramExecutionStack().pop(element);
        Map<Long, Long> proxyIdMap2 = proxyFactory.getProxyIdMapping();

        // translate the deltas into the original node namespace
        delta1 = delta1.translate(new TranslationState(proxyIdMap1));
        delta2 = delta2.translate(new TranslationState(proxyIdMap2));
        System.out.println(delta1);
        System.out.println(delta2);

        // try patching a proxy of the original AST with this stuff
        proxyFactory = new BsjNodeProxyFactoryImpl(manager);
        CompilationUnitNode compProxy = proxyFactory.makeCompilationUnitNode(c);
        PatchState patchState = new PatchState(dependencyManager, coreFactory, new PatchStatePopulator(originalNodeMap,
                proxyFactory), new MappedFunction<Long, Long>(proxyFactory.getProxyIdMapping()));
        delta1.apply(patchState);
        delta2.apply(patchState);

        // execute the same operations via code over the original tree
        proxyFactory = new BsjNodeProxyFactoryImpl(manager);
        CompilationUnitNode directCompProxy = proxyFactory.makeCompilationUnitNode(c);
        applyDelta1(coreFactory, directCompProxy);
        applyDelta2(coreFactory, directCompProxy);

        // make sure they wound up the same
        String patchedSource = compProxy.toSourceCode();
        String directSource = directCompProxy.toSourceCode();

        Assert.assertEquals(directSource, patchedSource);
    }

    private void applyDelta1(BsjNodeFactory coreFactory, CompilationUnitNode compilationUnitNode)
    {
        ClassMemberListNode members = ((ClassDeclarationNode) compilationUnitNode.getTypeDecls().get(0)).getBody().getMembers();
        members.add(coreFactory.makeFieldDeclarationNode(
                coreFactory.makeFieldModifiersNode(AccessModifier.PUBLIC),
                coreFactory.makePrimitiveTypeNode(PrimitiveType.BOOLEAN),
                coreFactory.makeVariableDeclaratorListNode(coreFactory.makeVariableDeclaratorNode(
                        coreFactory.makeIdentifierNode("x"), null)), null));
    }

    private void applyDelta2(BsjNodeFactory coreFactory, CompilationUnitNode compilationUnitNode)
    {
        BlockStatementListNode statements = ((MethodDeclarationNode) ((ClassDeclarationNode) compilationUnitNode.getTypeDecls().get(
                0)).getBody().getMembers().get(0)).getBody();
        statements.add(coreFactory.makeExpressionStatementNode(coreFactory.makeAssignmentNode(
                coreFactory.makeVariableAccessNode(coreFactory.makeIdentifierNode("x")), AssignmentOperator.ASSIGNMENT,
                coreFactory.makeBooleanLiteralNode(true))));
    }

    private MetaprogramProfile<TypeDeclarationMetaprogramAnchorNode, TypeDeclarationNode> introduceProfile(
            BsjNodeFactory coreFactory, CompilationUnitNode c, int id)
    {
        TypeDeclarationMetaprogramAnchorNode anchor = coreFactory.makeTypeDeclarationMetaprogramAnchorNode(coreFactory.makeMetaprogramNode(
                coreFactory.makeMetaprogramPreambleNode(coreFactory.makeMetaprogramImportListNode(),
                        coreFactory.makeMetaprogramTargetListNode(),
                        coreFactory.makeMetaprogramDependencyDeclarationListNode()),
                coreFactory.makeBlockStatementListNode()));
        c.getTypeDecls().add(anchor);
        MetaprogramProfile<TypeDeclarationMetaprogramAnchorNode, TypeDeclarationNode> profile = fakeProfile(id, anchor);
        return profile;
    }

    private MetaprogramProfile<TypeDeclarationMetaprogramAnchorNode, TypeDeclarationNode> fakeProfile(final int id,
            final TypeDeclarationMetaprogramAnchorNode anchor)
    {
        return new MetaprogramProfile<TypeDeclarationMetaprogramAnchorNode, TypeDeclarationNode>(
                new Metaprogram<TypeDeclarationMetaprogramAnchorNode, TypeDeclarationNode>()
                {
                    @Override
                    public void execute(Context<TypeDeclarationMetaprogramAnchorNode, TypeDeclarationNode> context)
                    {
                    }

                    @Override
                    public int getID()
                    {
                        return id;
                    }
                }, anchor, Collections.<Dependency> emptySet(), Collections.<String> emptySet(),
                MetaprogramLocalMode.FULL_MUTATE, MetaprogramPackageMode.INSERT, true);
    }
}
