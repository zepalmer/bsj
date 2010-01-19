package edu.jhu.cs.bsj.compiler.ast;

/**
 * Classes which implement this class are capable of transforming a BSJ AST node into legal BSJ source code.
 * @author Zachary Palmer
 */
public interface BsjSourceSerializer extends BsjNodeOperation<StringBuilder, Void>
{

}
