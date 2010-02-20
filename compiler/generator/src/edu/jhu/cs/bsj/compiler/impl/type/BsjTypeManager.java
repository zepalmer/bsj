package edu.jhu.cs.bsj.compiler.impl.type;

import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;

/**
 * This class acts as a repository for object program type information.  It provides a hierarchical structure of the
 * Java namespace as well as semantic information about the object program's types.
 * <p/>
 * A type manager has access to a {@link BsjFileManager} for purposes of ascertaining the existence of existing binary
 * classes on the classpath as well as Java source files on the source path.  If, for example, the type manager is asked
 * to answer a question involving the type <code>com.example.Foo</code> and no such compilation unit or precompiled
 * binary exists, a file <code>com/example/Foo.bsj</code> or <code>com/example/Foo.java</code> may still exist on the
 * source path which satisfies that type.  Indeed, the source path actually gets first pick; if both a binary and a
 * source file existed which represented the type <code>com.example.Foo</code>, the source file would be loaded in
 * favor of the binary.
 * <p/>
 * This type manager must also have access to a TODO
 *  
 * @author Zachary Palmer
 */
public class BsjTypeManager
{

}
