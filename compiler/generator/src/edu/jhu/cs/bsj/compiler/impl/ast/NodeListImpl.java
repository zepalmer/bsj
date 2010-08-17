package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ClosureRule;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.EndElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SingleMetaprogramListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.StartElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.SymbolicElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ValueElement;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.MetaprogramListConflictExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.MetaprogramListMissingElementExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.AfterEffectKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.AfterInvariantKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.BeforeEffectKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.BeforeInvariantKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ContainmentEffectKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.EndElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.PredicateKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.StartElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.ValueElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.BinaryKnowledgeClosureRule;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.closure.UnaryKnowledgeClosureRule;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.AddAfterOperationKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.AddBeforeOperationKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.FilterOperationKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.GetAfterOperationKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.GetBeforeOperationKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.source.RemoveOperationKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;
import edu.jhu.cs.bsj.compiler.impl.utils.ProxyList;

/**
 * This node list implementation respects the conflict detection algebra proposed by the BSJ Language Specification.
 * 
 * @author Zachary Palmer
 * @param <T> The type of node contained in this list.
 */
public class NodeListImpl<T extends Node> implements NodeList<T>
{
	/** The logger to use for this class. */
	private static final Logger LOGGER = Logger.getLogger(NodeListImpl.class);

	/** The next UID to give to a list node implementation. */
	private static final AtomicLong NEXT_UID = new AtomicLong(0);

	/** The UID for this list. */
	private final long uid = NEXT_UID.getAndIncrement();

	/** The node manager for this list. */
	private BsjNodeManager manager;
	/** The backing list that actually contains the data. */
	private List<T> backing;
	/** The current knowledge base. */
	private Set<SingleMetaprogramListKnowledge<T>> base;
	/** The node which should be marked as the parent of any node entering this list. */
	private Node parent;
	/** Indicates whether or not the contents of this list are implicitly order dependent. */
	private boolean orderDependent;

	/**
	 * Indicates whether or not the list is in the process of initializing. If not, permission checks occur and history
	 * is recorded. During initialization, these events do not occur.
	 */
	private boolean initializing;

	public NodeListImpl(BsjNodeManager manager, Node parent, boolean orderDepedent, List<T> initial)
	{
		super();
		this.manager = manager;
		this.parent = parent;
		this.orderDependent = orderDepedent;
		this.backing = new ProxyList<T>(new ArrayList<T>())
		{

			@Override
			protected void elementAdded(int index, T element, boolean replaced)
			{
				if (!NodeListImpl.this.initializing)
				{
					NodeListImpl.this.manager.assertInsertable(NodeListImpl.this.parent);
				}
				if (element instanceof NodeImpl)
				{
					((NodeImpl) element).setParent(NodeListImpl.this.parent);
				}
				NodeListImpl.this.manager.notifyChange(NodeListImpl.this.parent);
			}

			@Override
			protected void elementRemoved(int index, T element, boolean replaced)
			{
				if (!NodeListImpl.this.initializing)
				{
					NodeListImpl.this.manager.assertMutatable(NodeListImpl.this.parent);
				}
				if (element instanceof NodeImpl)
				{
					((NodeImpl) element).setParent(null);
				}
				NodeListImpl.this.manager.notifyChange(NodeListImpl.this.parent);
			}

			@Override
			protected void elementRetrieved(int index, T element)
			{
			}

			@Override
			protected void sizeChecked()
			{
			}
		};
		this.base = new HashSet<SingleMetaprogramListKnowledge<T>>();

		// initialize the list
		this.initializing = true;
		for (T t : initial)
		{
			addLast(t);
		}
		this.initializing = false;
	}

	/**
	 * Used to determine whether or not list operations record knowledge. If the manipulations are occurring because of
	 * the BSJ compiler itself or if this list is still in initialization, knowledge recording will produce false
	 * positives in the conflict detection system.
	 * 
	 * @return <code>true</code> to record knowledge; <code>false</code> otherwise.
	 */
	private boolean isRecordingKnowledge()
	{
		return this.manager.getCurrentMetaprogram() != null && !this.initializing;
	}

	@Override
	public void addAfter(T member, T node) throws MetaprogramListMissingElementException
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".addAfter(" + member + "," + node + ")");
		}

		if (member == null)
			throw new NullPointerException();
		if (node == null)
			throw new NullPointerException();
		int index = this.backing.indexOf(member);
		if (index == -1)
		{
			throw new MetaprogramListMissingElementExceptionImpl(this.manager.getCurrentMetaprogram().getAnchor(),
					this.manager.getCurrentMetaprogram().getLocation(), member);
		}
		this.backing.add(index + 1, node);
		if (isRecordingKnowledge())
		{
			ValueElement<T> anchorElement = new ValueElementImpl<T>(member, isOrderDependent(member));
			ValueElement<T> nodeElement = new ValueElementImpl<T>(node, isOrderDependent(node));
			List<StackTraceElement> stackTrace = KnowledgeUtilities.getStackTrace();
			KnowledgeSource<T> knowledgeSource = new AddAfterOperationKnowledgeSourceImpl<T>(stackTrace, anchorElement,
					nodeElement);
			addKnowledge(new AfterEffectKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), knowledgeSource, anchorElement, nodeElement));
		}
	}

	@Override
	public void addBefore(T member, T node) throws MetaprogramListMissingElementException
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".addBefore(" + member + "," + node + ")");
		}

		if (member == null)
			throw new NullPointerException();
		if (node == null)
			throw new NullPointerException();
		int index = this.backing.indexOf(member);
		if (index == -1)
		{
			throw new MetaprogramListMissingElementExceptionImpl(this.manager.getCurrentMetaprogram().getAnchor(),
					this.manager.getCurrentMetaprogram().getLocation(), member);
		}
		this.backing.add(index, node);
		if (isRecordingKnowledge())
		{
			ValueElement<T> anchorElement = new ValueElementImpl<T>(member, isOrderDependent(member));
			ValueElement<T> nodeElement = new ValueElementImpl<T>(node, isOrderDependent(node));
			List<StackTraceElement> stackTrace = KnowledgeUtilities.getStackTrace();
			KnowledgeSource<T> knowledgeSource = new AddBeforeOperationKnowledgeSourceImpl<T>(stackTrace,
					anchorElement, nodeElement);
			addKnowledge(new BeforeEffectKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), knowledgeSource, anchorElement, nodeElement));
		}
	}

	@Override
	public void addFirst(T node)
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".addFirst(" + node + ")");
		}

		if (node == null)
			throw new NullPointerException();
		this.backing.add(0, node);
		if (isRecordingKnowledge())
		{
			StartElement<T> anchorElement = new StartElementImpl<T>();
			ValueElement<T> nodeElement = new ValueElementImpl<T>(node, isOrderDependent(node));
			List<StackTraceElement> stackTrace = KnowledgeUtilities.getStackTrace();
			KnowledgeSource<T> knowledgeSource = new AddAfterOperationKnowledgeSourceImpl<T>(stackTrace, anchorElement,
					nodeElement);
			addKnowledge(new AfterEffectKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), knowledgeSource, anchorElement, nodeElement));
		}
	}

	@Override
	public void addLast(T node)
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".addLast(" + node + ")");
		}

		if (node == null)
			throw new NullPointerException();
		this.backing.add(node);
		if (isRecordingKnowledge())
		{
			EndElement<T> memberElement = new EndElementImpl<T>();
			ValueElement<T> nodeElement = new ValueElementImpl<T>(node, isOrderDependent(node));
			List<StackTraceElement> stackTrace = KnowledgeUtilities.getStackTrace();
			KnowledgeSource<T> knowledgeSource = new AddBeforeOperationKnowledgeSourceImpl<T>(stackTrace,
					memberElement, nodeElement);
			addKnowledge(new BeforeEffectKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), knowledgeSource, memberElement, nodeElement));
		}
	}

	@Override
	public Set<T> filter(NodeFilter<? super T> filter)
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".filter(" + filter + ")");
		}

		PermissionPolicyManager permissionPolicyManager = new PermissionPolicyManager(this.parent.getFurthestAncestor());
		this.manager.pushPermissionPolicyManager(permissionPolicyManager);

		Set<T> ret = new HashSet<T>();
		for (T t : this.backing)
		{
			// TODO: catch the permission exceptions that fall out of this call and translate to a more contextual
			// error. (Instead of "no permission on node X", we should have "predicate P tried to modify node X".)
			boolean use = filter.filter(t);
			if (use)
			{
				ret.add(t);
			}
		}

		this.manager.popPermissionPolicyManager();

		if (isRecordingKnowledge())
		{
			addKnowledge(new PredicateKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), new FilterOperationKnowledgeSourceImpl<T>(
							KnowledgeUtilities.getStackTrace(), filter), filter));
		}
		return ret;
	}

	@Override
	public T getAfter(T member) throws MetaprogramListMissingElementException
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".getAfter(" + member + ")");
		}

		if (member == null)
			throw new NullPointerException();
		T ret;
		SymbolicElement<T> retElement;
		int index = this.backing.indexOf(member);
		if (index == -1)
		{
			throw new MetaprogramListMissingElementExceptionImpl(this.manager.getCurrentMetaprogram().getAnchor(),
					this.manager.getCurrentMetaprogram().getLocation(), member);
		}
		if (index == this.backing.size() - 1)
		{
			ret = null;
			retElement = new EndElementImpl<T>();
		} else
		{
			ret = this.backing.get(index + 1);
			retElement = new ValueElementImpl<T>(ret, isOrderDependent(ret));
		}
		if (isRecordingKnowledge())
		{
			ValueElement<T> anchorElement = new ValueElementImpl<T>(member, isOrderDependent(member));
			List<StackTraceElement> stackTrace = KnowledgeUtilities.getStackTrace();
			KnowledgeSource<T> knowledgeSource = new GetAfterOperationKnowledgeSourceImpl<T>(stackTrace, anchorElement,
					retElement);
			addKnowledge(new AfterInvariantKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), knowledgeSource, anchorElement, retElement));
		}
		return ret;
	}

	@Override
	public T getBefore(T member) throws MetaprogramListMissingElementException
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".getBefore(" + member + ")");
		}

		if (member == null)
			throw new NullPointerException();
		T ret;
		SymbolicElement<T> retElement;
		int index = this.backing.indexOf(member);
		if (index == -1)
		{
			throw new MetaprogramListMissingElementExceptionImpl(this.manager.getCurrentMetaprogram().getAnchor(),
					this.manager.getCurrentMetaprogram().getLocation(), member);
		}
		if (index == 0)
		{
			ret = null;
			retElement = new StartElementImpl<T>();
		} else
		{
			ret = this.backing.get(index - 1);
			retElement = new ValueElementImpl<T>(ret, isOrderDependent(ret));
		}
		if (isRecordingKnowledge())
		{
			ValueElement<T> anchorElement = new ValueElementImpl<T>(member, isOrderDependent(member));
			List<StackTraceElement> stackTrace = KnowledgeUtilities.getStackTrace();
			KnowledgeSource<T> knowledgeSource = new GetBeforeOperationKnowledgeSourceImpl<T>(stackTrace,
					anchorElement, retElement);
			addKnowledge(new BeforeInvariantKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), knowledgeSource, anchorElement, retElement));
		}
		return ret;
	}

	@Override
	public T getFirst()
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".getFirst()");
		}

		T ret;
		SymbolicElement<T> retElement;
		if (this.backing.size() > 0)
		{
			ret = this.backing.get(0);
			retElement = new ValueElementImpl<T>(ret, isOrderDependent(ret));
		} else
		{
			ret = null;
			retElement = new EndElementImpl<T>();
		}
		if (isRecordingKnowledge())
		{
			StartElement<T> anchorElement = new StartElementImpl<T>();
			List<StackTraceElement> stackTrace = KnowledgeUtilities.getStackTrace();
			KnowledgeSource<T> knowledgeSource = new GetAfterOperationKnowledgeSourceImpl<T>(stackTrace, anchorElement,
					retElement);
			addKnowledge(new AfterInvariantKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), knowledgeSource, anchorElement, retElement));
		}
		return ret;
	}

	@Override
	public T getLast()
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".getLast()");
		}

		T ret;
		SymbolicElement<T> retElement;
		if (this.backing.size() > 0)
		{
			ret = this.backing.get(this.backing.size() - 1);
			retElement = new ValueElementImpl<T>(ret, isOrderDependent(ret));
		} else
		{
			ret = null;
			retElement = new StartElementImpl<T>();
		}
		if (isRecordingKnowledge())
		{
			EndElement<T> memberElement = new EndElementImpl<T>();
			List<StackTraceElement> stackTrace = KnowledgeUtilities.getStackTrace();
			KnowledgeSource<T> knowledgeSource = new GetBeforeOperationKnowledgeSourceImpl<T>(stackTrace,
					memberElement, retElement);
			addKnowledge(new BeforeInvariantKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), knowledgeSource, memberElement, retElement));
		}
		return ret;
	}

	@Override
	public boolean remove(T node)
	{
		if (LOGGER.isTraceEnabled() && isRecordingKnowledge())
		{
			LOGGER.trace(uid + ".remove(" + node + ")");
		}

		boolean ret = this.backing.remove(node);
		if (isRecordingKnowledge())
		{
			SymbolicElement<T> element = new ValueElementImpl<T>(node, isOrderDependent(node));
			addKnowledge(new ContainmentEffectKnowledgeImpl<T>(this.manager.getCurrentMetaprogramId(),
					this.manager.getCurrentMetaprogram().getLocation(), new RemoveOperationKnowledgeSourceImpl<T>(
							KnowledgeUtilities.getStackTrace(), element), element));
		}
		return ret;
	}

	/**
	 * Determines whether or not the provided element is order dependent.
	 * 
	 * @param node The node to check.
	 * @return <code>true</code> if that node is order dependent; <code>false</code> otherwise.
	 */
	private boolean isOrderDependent(T node)
	{
		return this.orderDependent || (node instanceof InitializerDeclarationNode);
	}

	/**
	 * A convenience function for computing a closure with one additional piece of information.
	 * 
	 * @param knowledge The new information to use.
	 */
	private void addKnowledge(ListKnowledge<T> knowledge)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Adding knowledge " + knowledge + " to knowledge base " + this.base + " from operation");
		}

		Set<ConflictKnowledge<T>> conflictKnowledge = new HashSet<ConflictKnowledge<T>>(); // used for conflicts only
		Set<SingleMetaprogramListKnowledge<T>> closureKnowledge = new HashSet<SingleMetaprogramListKnowledge<T>>();
		categorizeNewKnowledge(knowledge, closureKnowledge, conflictKnowledge, null);
		while (closureKnowledge.size() > 0)
		{
			// Select a new knowledge from the waiting pool
			Iterator<SingleMetaprogramListKnowledge<T>> it = closureKnowledge.iterator();
			SingleMetaprogramListKnowledge<T> newKnowledge = it.next();
			it.remove();
			LOGGER.trace("Now processing knowledge " + newKnowledge + " with knowledge base " + this.base);

			// Close over all unary rules with this new knowledge
			for (UnaryKnowledgeClosureRule rule : KnowledgeUtilities.UNARY_CLOSURE_RULES)
			{
				categorizeNewKnowledge(rule.calculateClosure(newKnowledge), closureKnowledge, conflictKnowledge, rule);
			}

			// Close over all binary rules with this new knowledge
			for (BinaryKnowledgeClosureRule rule : KnowledgeUtilities.BINARY_CLOSURE_RULES)
			{
				for (SingleMetaprogramListKnowledge<T> baseKnowledge : this.base)
				{
					// Note: the assumption here is that the resulting knowledge only applies if the metaprograms
					// are not cooperative. This holds for the current set of closure rules, especially as binary rules
					// are always used to produce conflicts and nothing else.
					if (!this.manager.hasCooperation(baseKnowledge.getMetaprogramId()))
					{
						categorizeNewKnowledge(rule.calculateClosure(newKnowledge, baseKnowledge), closureKnowledge,
								conflictKnowledge, rule);
						categorizeNewKnowledge(rule.calculateClosure(baseKnowledge, newKnowledge), closureKnowledge,
								conflictKnowledge, rule);
					}
				}
			}

			// Finally, commit this new knowledge to the knowledge base
			this.base.add(newKnowledge);
		}

		if (conflictKnowledge.size() > 0)
		{
			// find an example conflict knowledge to use for metaprogram IDs
			ConflictKnowledge<T> twoMetaprogramConflictKnowledge = null;
			int firstMetaprogramId = 0;
			int secondMetaprogramId = 0;
			for (ConflictKnowledge<T> candidate : conflictKnowledge)
			{
				int count = 0;
				for (ListKnowledge<T> element : candidate.getKnowledgeSource().getKnowledge())
				{
					if (element instanceof SingleMetaprogramListKnowledge<?>)
					{
						SingleMetaprogramListKnowledge<T> singleMetaprogramListKnowledge = (SingleMetaprogramListKnowledge<T>) element;
						switch (count)
						{
							case 0:
								firstMetaprogramId = singleMetaprogramListKnowledge.getMetaprogramId();
								break;
							case 1:
								secondMetaprogramId = singleMetaprogramListKnowledge.getMetaprogramId();
								break;
						}
						count++;
					}
				}
				if (count == 2)
				{
					twoMetaprogramConflictKnowledge = candidate;
					break;
				}
			}
			MetaprogramAnchorNode<?> firstAnchor;
			MetaprogramAnchorNode<?> secondAnchor;
			if (twoMetaprogramConflictKnowledge == null)
			{
				firstAnchor = null;
				secondAnchor = null;
			} else
			{
				firstAnchor = this.manager.getAnchorByID(firstMetaprogramId);
				secondAnchor = this.manager.getAnchorByID(secondMetaprogramId);
			}

			// Now throw the exception with our example anchors
			throw new MetaprogramListConflictExceptionImpl(firstAnchor, secondAnchor, this.parent, conflictKnowledge);
		}
	}

	private void categorizeNewKnowledge(ListKnowledge<T> learnedKnowledge,
			Set<SingleMetaprogramListKnowledge<T>> closureKnowledge, Set<ConflictKnowledge<T>> conflictKnowledge,
			ClosureRule rule)
	{
		if (learnedKnowledge != null && !closureKnowledge.contains(learnedKnowledge)
				&& !this.base.contains(learnedKnowledge))
		{
			LOGGER.trace("Learned knowledge " + learnedKnowledge + " from "
					+ (rule != null ? ("rule " + rule) : "operation") + "; deferring for processing");
			if (learnedKnowledge instanceof SingleMetaprogramListKnowledge<?>)
			{
				closureKnowledge.add((SingleMetaprogramListKnowledge<T>) learnedKnowledge);
			} else if (learnedKnowledge instanceof ConflictKnowledge<?>)
			{
				conflictKnowledge.add((ConflictKnowledge<T>) learnedKnowledge);
			} else
			{
				throw new IllegalStateException("Unknown knowledge type: " + learnedKnowledge.getClass());
			}
		}
	}

	@Override
	public String toString()
	{
		return "NodeListImpl [backing=" + backing + ", base=" + base + "]";
	}
}
