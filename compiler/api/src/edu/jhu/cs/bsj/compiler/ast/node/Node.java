package edu.jhu.cs.bsj.compiler.ast.node;

import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;

/**
 * The parent class for all BSJ AST nodes.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface Node
{
    /**
     * Gets the location at which this node's text starts (inclusive).
     * @return The location at which this node's text starts (inclusive).
     */
    public BsjSourceLocation getStartLocation();
    
    /**
     * Gets the location at which this node's text stops (exclusive).
     * @return The location at which this node's text stops (exclusive).
     */
    public BsjSourceLocation getStopLocation();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public Node deepCopy(BsjNodeFactory factory);
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p A parameter to pass to the operation.
     * @return The result of the operation.
     */
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p);
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 A parameter to pass to the operation.
     * @param p2 A parameter to pass to the operation.
     * @return The result of the operation.
     */
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2);
    
	/**
	 * Causes this node to receive a visitor. Visitors are received by nodes in a depth-first fashion. The order of the
	 * children receiving the visitor is dependent upon the type of node; however, a superclass's child nodes are always
	 * visited before the subclass's child nodes.
	 * 
	 * @param visitor The visitor which should visit this node.
	 */
	public void receive(BsjNodeVisitor visitor);

	/**
	 * Causes this node to receive a type-specific visitor. Visitors are received by nodes in a depth-first fashion. The
	 * order of the children receiving the visitor is dependent upon the type of node; however, a superclass's child
	 * nodes are always visited before the subclass's child nodes. For more information on exactly what calls are made,
	 * please see {@link BsjTypedNodeVisitor}.
	 * 
	 * @param visitor The visitor which should visit this node.
	 */
	public void receiveTyped(BsjTypedNodeVisitor visitor);

	/**
	 * Retrieves the unique ID number of this node.
	 * 
	 * @return The unique ID number of this node.
	 */
	public long getUid();

	/**
	 * Retrieves the parent of this node. If this node does not have a parent, <code>null</code> is returned. A node may
	 * be without a parent if it is a {@link CompilationUnitNode} or if it is a code fragment (such as an isolated
	 * expression).
	 * 
	 * @return This node's parent, or <code>null</code> if this node has no parent.
	 */
	public Node getParent();

	/**
	 * Retrieves the children of this node. The children are not in any guaranteed order. This method is intended to be
	 * used primarily for debugging purposes. It should not be called routinely at runtime for performance reasons.
	 * <p/>
	 * Note that the children of this node may not be nodes themselves (such as when a node property is of a primitive
	 * type).
	 * 
	 * @return A list of this node's children. The list in question is for reference purposes; it is mutable and
	 *         changing it has no effect on this node.
	 */
	public List<Object> getChildObjects();

	/**
	 * Replaces one child node value with another. This convenience method is provided to allow children to remove
	 * themselves from their parents when necessary, replacing themselves with another node. It is more efficient to
	 * call the appropriate setter directly (such as <tt>getParent().setPackageDeclaration(...)</tt>), but this method
	 * is convenient in cases in which the caller does not know where in its parent it resides (which is especially the
	 * case with lists).
	 * 
	 * @param before The node which is to be replaced. <code>null</code> is not a legal value.
	 * @param after The node with which it is to be replaced.
	 * @return <code>true</code> if the replacement was successful; <code>false</code> if the specified <tt>before</tt>
	 *         node was not found.
	 * @throws IllegalArgumentException If <tt>before</tt> is <code>null</code>.
	 */
	public boolean replace(Node before, Node after);

	/**
	 * A convenience method which retrieves the nearest ancestor of this node of the specified type. Note that a node is
	 * not its own ancestor; thus, providing this node's type as the node class will not retrieve this node.
	 * 
	 * @param nodeClass The class of ancestor to retrieve.
	 * @return The ancestor in question or <code>null</code> if no such ancestor exists.
	 */
	public <N> N getNearestAncestorOfType(Class<N> nodeClass);

	/**
	 * A convenience method which retrieves the nearest ancestor of this node of the specified type. If such an ancestor
	 * exists and the provided list is not <code>null</code>, all of the ancestors between this node and the returned
	 * ancestor are added to the list.
	 * 
	 * Note that a node is not its own ancestor; thus, providing this node's type as the node class will not retrieve
	 * this node.
	 * 
	 * @param nodeClass The class of ancestor to retrieve.
	 * @param list The list of ancestors or <code>null</code> for no ancestor recording.
	 * @return The ancestor in question or <code>null</code> if no such ancestor exists. If no such ancestor exists, the
	 *         provided list is unmodified.
	 */
	public <N> N getNearestAncestorOfType(Class<N> nodeClass, List<? super Node> list);

	/**
	 * A convenience method which retrieves the nearest ancestor of this node of any of the specified types. Note that a
	 * node is not its own ancestor; thus, providing this node's type as the node class will not retrieve this node. The
	 * first node with a type matching any of those in the provided collection will be returned.
	 * 
	 * @param nodeClasses The possible classes of ancestor to retrieve.
	 * @return The ancestor in question or <code>null</code> if no such ancestor exists.
	 */
	public <N> N getNearestAncestorOfTypes(Collection<Class<? extends N>> nodeClasses);

	/**
	 * A convenience method which retrieves the nearest ancestor of this node of any of the specified types. If such an
	 * ancestor exists and the provided list is not <code>null</code>, all of the ancestors between this node and the
	 * returned ancestor are added to the list.
	 * 
	 * Note that a node is not its own ancestor; thus, providing this node's type as the node class will not retrieve
	 * this node.
	 * 
	 * @param nodeClasses The possible classes of ancestor to retrieve.
	 * @param list The list of ancestors or <code>null</code> for no ancestor recording.
	 * @return The ancestor in question or <code>null</code> if no such ancestor exists. If no such ancestor exists, the
	 *         provided list is unmodified.
	 */
	public <N> N getNearestAncestorOfTypes(Collection<Class<? extends N>> nodeClasses, List<? super Node> list);

	/**
	 * Retrieves the top of the tree in which this node exists.
	 * 
	 * @return The furthest ancestor of this node (or this node if it has no parent).
	 */
	public Node getFurthestAncestor();

	/**
	 * Retrieves the root package associated with this node.
	 * 
	 * @return This node's root package (or <code>null</code> if this node is not part of a tree connected to the root
	 *         package).
	 */
	public PackageNode getRootPackage();

	/**
	 * Determines whether or not this node represents a binary node. Binary nodes are nodes which are constructed from
	 * binary files on the classpath. Binary nodes are always read-only and lack certain information (such as method
	 * bodies).
	 * 
	 * @return <code>true</code> if this node is a binary node; <code>false</code> if it is not.
	 */
	public boolean isBinary();

	/**
	 * Generates source code representing this AST node. Note that the output may be somewhat ambiguous and may lose
	 * information; for instance, it is possible for both a {@link NameNode} and an {@link IdentifierNode} to be
	 * serialized into source code as "<tt>var</tt>". This method is intended primarily for display and reporting
	 * purposes.
	 */
	public String toSourceCode();

	/**
	 * Retrieves an iterable view of the children of this node. Its iterator does not iterate in any particular order.
	 * Different views may not have consistent ordering. Calling this method causes a read operation to be performed
	 * over all of the children of this node which either are nodes or represent node children.
	 * <p/>
	 * It should be noted that <code>null</code> values may be present in the iterable object if this node has some
	 * <tt>Node</tt>-typed properties that are <code>null</code>.
	 * 
	 * @return The iterator of this node's children.
	 */
	public Iterable<? extends Node> getChildIterable();

	/**
	 * Retrieves a declaration in scope which corresponds to the specified name. This operation may involve the
	 * construction of a symbol table and thus may result in additional nodes being loaded.
	 * <p/>
	 * The type of returned nodes is dependent upon the category of the provided name.
	 * <ul>
	 * <li>{@link NameCategory#TYPE} names always produce {@link TypeNameBindingNode}s.</li>
	 * <li>{@link NameCategory#METHOD} names always produce {@link InvokableNameBindingNode}s.</li>
	 * <li>{@link NameCategory#EXPRESSION} names always produce {@link VariableNameBindingNode}s.</li>
	 * <li>{@link NameCategory#PACKAGE} names always produce {@link PackageNode}s.</li>
	 * <li>All other name categories (including {@link NameCategory#METAPROGRAM_TARGET}) raise an
	 * {@link IllegalArgumentException}.
	 * </ul>
	 * 
	 * @param name The name in question.
	 * @return The nodes corresponding to the declaration of the specified name.
	 * @throws IllegalArgumentException If the provided name has an invalid category.
	 */
	public Collection<? extends Node> getDeclarationsInScope(NameNode name);

	/**
	 * Retrieves a type declaration in scope which corresponds to the specified simple name component. This operation
	 * may involve the construction of a symbol table and thus may result in additional nodes being loaded.
	 * 
	 * @param name The simple name component to use.
	 * @return The nodes corresponding to the declaration of that specified name.
	 */
	public Collection<? extends TypeNameBindingNode> getTypeDeclarationsInScope(String name);

	/**
	 * Retrieves a type declaration in scope which corresponds to the specified simple name component. This operation
	 * may involve the construction of a symbol table and thus may result in additional nodes being loaded.
	 * 
	 * @param name The simple name component to use.
	 * @return The nodes corresponding to the declaration of that specified name.
	 */
	public Collection<? extends InvokableNameBindingNode> getMethodDeclarationsInScope(String name);

	// TODO: need a version which can apply to types as well

	/**
	 * Retrieves a type declaration in scope which corresponds to the specified simple name component. This operation
	 * may involve the construction of a symbol table and thus may result in additional nodes being loaded.
	 * 
	 * @param name The simple name component to use.
	 * @return The nodes corresponding to the declaration of that specified name.
	 */
	public Collection<? extends VariableNameBindingNode> getVariableDeclarationsInScope(String name);
}
