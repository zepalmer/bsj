package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

public interface ClassNode extends StatementNode
{
    Node getExtendsClause();
    
    List<? extends Node> getImplementsClause();
              
    List<? extends Node> getMembers();
              
    ModifiersNode getModifiers();
              
    Identifier getSimpleName();
              
    List<? extends TypeParameterNode> getTypeParameters();
}
