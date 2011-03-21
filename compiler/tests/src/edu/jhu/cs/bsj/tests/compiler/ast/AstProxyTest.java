package edu.jhu.cs.bsj.tests.compiler.ast;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.tests.AbstractTest;

public class AstProxyTest extends AbstractTest
{
    @Test
    public void astProxyTest() throws Exception
    {
        BsjToolkit toolkit = BsjServiceRegistry.getInstance().newToolkitFactory().newToolkit();
        BsjNodeFactory coreFactory = toolkit.getNodeFactory();

        FieldDeclarationNode fieldDecl = coreFactory.makeFieldDeclarationNode(
                coreFactory.makeFieldModifiersNode(AccessModifier.PRIVATE),
                coreFactory.makePrimitiveTypeNode(PrimitiveType.INT),
                coreFactory.makeVariableDeclaratorListNode(coreFactory.makeVariableDeclaratorNode(
                        coreFactory.makeIdentifierNode("x"), coreFactory.makeIntLiteralNode(0))), null);
        
        // extract the node manager from the field - this is horrific but necessary at the moment
        Field f = NodeImpl.class.getDeclaredField("manager");
        f.setAccessible(true);
        BsjNodeManager manager = (BsjNodeManager)f.get(fieldDecl);
        
        BsjNodeProxyFactory proxyFactory = new BsjNodeProxyFactoryImpl(manager);
        
        // create a proxy of the field declaration
        FieldDeclarationNode fieldProxy = proxyFactory.makeFieldDeclarationNode(fieldDecl);
        
        // assert that they have the same structure
        Assert.assertEquals(fieldDecl.toSourceCode(), fieldProxy.toSourceCode());
        
        // change the overlying node and confirm that the underlying node has not changed
        fieldProxy.getModifiers().setAccess(AccessModifier.PUBLIC);
        Assert.assertEquals(AccessModifier.PRIVATE, fieldDecl.getModifiers().getAccess());
        
        // again for lists
        fieldProxy.getDeclarators().add(coreFactory.makeVariableDeclaratorNode(coreFactory.makeIdentifierNode("y"),null));
        Assert.assertEquals(1, fieldDecl.getDeclarators().size());
    }
}
