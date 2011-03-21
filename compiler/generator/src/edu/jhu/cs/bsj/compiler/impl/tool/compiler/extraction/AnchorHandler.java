package edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction;

import java.io.IOException;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;

/**
 * A general interface for handling anchors. Anchor handlers are broken into distinct classes to reduce module
 * complexity. In general, an object meeting this interface intends to register a metaprogram (based on an anchor) with
 * a metacompilation context.
 * 
 * @author Zachary Palmer
 */
public interface AnchorHandler<A extends MetaprogramAnchorNode<B>, B extends Node>
{
    /**
     * Performs the handling operation.
     * 
     * @return A metaprogram profile to be registered with the metacompilation process or <code>null</code> if no such
     *         profile could be produced.
     * @throws IOException If an I/O error occurs while handling the anchor.
     */
    public MetaprogramProfile<A, B> handle() throws IOException;
    
    /**
     * Retrieves the anchor over which this operation was performed.  This anchor may be a proxy over another
     * anchor.  If it is, that anchor is the canonical anchor reported by {@link #getCanonicalAnchor()}.  Otherwise,
     * this method and {@link #getCanonicalAnchor()} report the same node.
     * @return The target anchor for this handler.
     */
    public A getTargetAnchor();
    
    /**
     * The canonical anchor with which this handler works.
     * @return The canonical anchor for this handler.
     */
    public A getCanonicalAnchor();
}
