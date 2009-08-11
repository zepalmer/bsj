package edu.jhu.cs.bsj.compiler;

import java.util.List;

import javax.tools.JavaFileObject;

public interface CompilationUnitNode extends Node
{
    List<? extends ImportNode> getImports();

    LineMap getLineMap();

    List<? extends AnnotationNode> getPackageAnnotations();

    ExpressionNode getPackageName();

    JavaFileObject getSourceFile();

    List<? extends Node> getTypeDecls();
}
