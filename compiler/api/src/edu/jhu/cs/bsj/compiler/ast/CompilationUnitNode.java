package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

import javax.tools.JavaFileObject;

/**
 * A node for compilation units.
 */
public interface CompilationUnitNode extends Node
{
    List<? extends ImportNode> getImports();

    LineMap getLineMap();

    List<? extends AnnotationNode> getPackageAnnotations();

    ExpressionNode getPackageName();

    JavaFileObject getSourceFile();

    List<? extends Node> getTypeDecls();
}
