package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
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
	/** The Unicode character we will use to represent the left delimiter of effects. */
	private static final String EFFECT_LEFT = "╓";
	/** The Unicode character we will use to represent the right delimiter of effects. */
	private static final String EFFECT_RIGHT = "╖";
	/** The Unicode character we will use to represent the left delimiter of invariants. */
	private static final String INVARIANT_LEFT = "╙";
	/** The Unicode character we will use to represent the right delimiter of invariants. */
	private static final String INVARIANT_RIGHT = "╜";

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
	private Set<Knowledge<T>> base;
	/** The node which should be marked as the parent of any node entering this list. */
	private Node parent;
	/** Indicates whether or not the contents of this list are implicitly order dependent. */
	private boolean orderDependent;

	/** Indicates whether or not permission checks are currently occurring. */
	private boolean permissionCheck;

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
				if (NodeListImpl.this.permissionCheck)
				{
					NodeListImpl.this.manager.assertInsertable(NodeListImpl.this.parent);
				}
				if (element instanceof NodeImpl)
				{
					((NodeImpl) element).setParent(NodeListImpl.this.parent);
				}
			}

			@Override
			protected void elementRemoved(int index, T element, boolean replaced)
			{
				if (NodeListImpl.this.permissionCheck)
				{
					NodeListImpl.this.manager.assertMutatable(NodeListImpl.this.parent);
				}
				if (element instanceof NodeImpl)
				{
					((NodeImpl) element).setParent(null);
				}
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
		this.base = new HashSet<Knowledge<T>>();

		// initialize the list
		this.permissionCheck = false;
		for (T t : initial)
		{
			addLast(t);
		}
		this.permissionCheck = true;
	}

	@Override
	public void addAfter(T member, T node) throws IllegalArgumentException
	{
		if (LOGGER.isTraceEnabled())
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
			throw new IllegalArgumentException(member + " is not a member of this list");
		}
		this.backing.add(index + 1, node);
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new EffectAfterKnowledge<T>(this.manager.getCurrentMetaprogramId(), new ElementValue<T>(node),
					new ElementValue<T>(member)), new EffectInKnowledge<T>(this.manager.getCurrentMetaprogramId(),
					new ElementValue<T>(node)));
		}
	}

	@Override
	public void addBefore(T member, T node) throws IllegalArgumentException
	{
		if (LOGGER.isTraceEnabled())
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
			throw new IllegalArgumentException(member + " is not a member of this list");
		}
		this.backing.add(index, node);
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new EffectBeforeKnowledge<T>(this.manager.getCurrentMetaprogramId(),
					new ElementValue<T>(node), new ElementValue<T>(member)), new EffectInKnowledge<T>(
					this.manager.getCurrentMetaprogramId(), new ElementValue<T>(node)));
		}
	}

	@Override
	public void addFirst(T node)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace(uid + ".addFirst(" + node + ")");
		}

		if (node == null)
			throw new NullPointerException();
		this.backing.add(0, node);
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new EffectAfterKnowledge<T>(this.manager.getCurrentMetaprogramId(), new ElementValue<T>(node),
					new StartValue<T>()), new EffectInKnowledge<T>(this.manager.getCurrentMetaprogramId(),
					new ElementValue<T>(node)));
		}
	}

	@Override
	public void addLast(T node)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace(uid + ".addLast(" + node + ")");
		}

		if (node == null)
			throw new NullPointerException();
		this.backing.add(node);
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new EffectBeforeKnowledge<T>(this.manager.getCurrentMetaprogramId(),
					new ElementValue<T>(node), new EndValue<T>()), new EffectInKnowledge<T>(
					this.manager.getCurrentMetaprogramId(), new ElementValue<T>(node)));
		}
	}

	@Override
	public Set<T> filter(NodeFilter<? super T> filter)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace(uid + ".filter(" + filter + ")");
		}

		PermissionPolicyManager permissionPolicyManager = new PermissionPolicyManager(this.parent.getFurthestAncestor());
		this.manager.pushPermissionPolicyManager(permissionPolicyManager);

		Set<T> ret = new HashSet<T>();
		for (T t : this.backing)
		{
			// TODO: catch the permission exceptions that fall out of this call and translate to a more contextual
			// error.  (Instead of "no permission on node X", we should have "predicate P tried to modify node X".)
			boolean use = filter.filter(t);
			if (use)
			{
				ret.add(t);
			}
		}

		this.manager.popPermissionPolicyManager();

		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new PredicateKnowledge<T>(this.manager.getCurrentMetaprogramId(), filter));
		}
		return ret;
	}

	@Override
	public T getAfter(T member) throws IllegalArgumentException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace(uid + ".getAfter(" + member + ")");
		}

		if (member == null)
			throw new NullPointerException();
		T ret;
		SymbolicValue<T> value;
		int index = this.backing.indexOf(member);
		if (index == -1)
		{
			throw new IllegalArgumentException(member + " is not a member of this list");
		}
		if (index == this.backing.size() - 1)
		{
			ret = null;
			value = new EndValue<T>();
		} else
		{
			ret = this.backing.get(index + 1);
			value = new ElementValue<T>(ret);
		}
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new InvariantInKnowledge<T>(this.manager.getCurrentMetaprogramId(), value),
					new InvariantAfterKnowledge<T>(this.manager.getCurrentMetaprogramId(), value, new ElementValue<T>(
							member)));
		}
		return ret;
	}

	@Override
	public T getBefore(T member) throws IllegalArgumentException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace(uid + ".getBefore(" + member + ")");
		}

		if (member == null)
			throw new NullPointerException();
		T ret;
		SymbolicValue<T> value;
		int index = this.backing.indexOf(member);
		if (index == -1)
		{
			throw new IllegalArgumentException(member + " is not a member of this list");
		}
		if (index == 0)
		{
			ret = null;
			value = new StartValue<T>();
		} else
		{
			ret = this.backing.get(index - 1);
			value = new ElementValue<T>(ret);
		}
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new InvariantInKnowledge<T>(this.manager.getCurrentMetaprogramId(), value),
					new InvariantBeforeKnowledge<T>(this.manager.getCurrentMetaprogramId(), value, new ElementValue<T>(
							member)));
		}
		return ret;
	}

	@Override
	public T getFirst()
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace(uid + ".getFirst()");
		}

		T ret;
		SymbolicValue<T> value;
		if (this.backing.size() > 0)
		{
			ret = this.backing.get(0);
			value = new ElementValue<T>(ret);
		} else
		{
			ret = null;
			value = new EndValue<T>();
		}
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new InvariantAfterKnowledge<T>(this.manager.getCurrentMetaprogramId(), value,
					new StartValue<T>()), new InvariantInKnowledge<T>(this.manager.getCurrentMetaprogramId(), value));
		}
		return ret;
	}

	@Override
	public T getLast()
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace(uid + ".getLast()");
		}

		T ret;
		SymbolicValue<T> value;
		if (this.backing.size() > 0)
		{
			ret = this.backing.get(this.backing.size() - 1);
			value = new ElementValue<T>(ret);
		} else
		{
			ret = null;
			value = new StartValue<T>();
		}
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new InvariantBeforeKnowledge<T>(this.manager.getCurrentMetaprogramId(), value,
					new EndValue<T>()), new InvariantInKnowledge<T>(this.manager.getCurrentMetaprogramId(), value));
		}
		return ret;
	}

	@Override
	public boolean remove(T node)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace(uid + ".remove(" + node + ")");
		}

		boolean ret = this.backing.remove(node);
		if (this.manager.getCurrentMetaprogramId() != null)
		{
			addKnowledge(new EffectInKnowledge<T>(this.manager.getCurrentMetaprogramId(), new ElementValue<T>(node)));
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
	private void addKnowledge(Knowledge<T> knowledge)
	{
		addKnowledge(Collections.singleton(knowledge));
	}

	/**
	 * A convenience function for computing a closure with two additional pieces of information.
	 * 
	 * @param knowledge1 The new information to use.
	 * @param knowledge2 The new information to use.
	 */
	private void addKnowledge(Knowledge<T> knowledge1, Knowledge<T> knowledge2)
	{
		List<Knowledge<T>> list = new ArrayList<Knowledge<T>>(2);
		list.add(knowledge1);
		list.add(knowledge2);
		addKnowledge(list);
	}

	/**
	 * Adds the specified knowledge to this node list and closes over the result.
	 * 
	 * @param knowledgeSet The set of knowledge to add.
	 */
	private void addKnowledge(Collection<Knowledge<T>> knowledgeSet)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Adding knowledge " + knowledgeSet + " to knowledge base " + this.base);
		}

		// Calculate the set of knowledge for non-cooperating metaprograms
		Set<Knowledge<T>> uncooperativeMetaprogramKnowledge = calculateUncooperativeMetaprogramKnowledge();

		// For each knowledge element, verify that it does not produce a contradiction and then add it to our knowledge
		// base.
		for (Knowledge<T> k : knowledgeSet)
		{
			// *** Now compute contradictions

			if (k instanceof NodeRelationKnowledge<?>)
			{
				NodeRelationKnowledge<T> kk = (NodeRelationKnowledge<T>) k;
				// For each relation, make sure that it does not conflict with an existing containment change
				for (Knowledge<T> uk : uncooperativeMetaprogramKnowledge)
				{
					if (uk instanceof EffectInKnowledge<?>)
					{
						EffectInKnowledge<T> ukk = (EffectInKnowledge<T>) uk;
						checkContainmentChangeOnOrderKnowledge(kk, ukk, ukk.getMetaprogramID());
					}
				}
			}

			if (k instanceof EffectAfterKnowledge<?>)
			{
				EffectAfterKnowledge<T> kk = (EffectAfterKnowledge<T>) k;
				// ╓◁→e╖⇒⊥ (sanity check - this should never happen)
				checkAfterEnd(kk);
				for (Knowledge<T> uk : uncooperativeMetaprogramKnowledge)
				{
					if (uk instanceof InvariantAfterKnowledge<?>)
					{
						InvariantAfterKnowledge<T> ukk = (InvariantAfterKnowledge<T>) uk;
						// ╙e→e1╜m ∧ ╓e→e2╖n ⇒ ⊥ where this metaprogram is m
						checkReadWriteAfterConflict(kk, ukk, ukk.getMetaprogramID());
					}
					if (uk instanceof EffectAfterKnowledge<?>)
					{
						EffectAfterKnowledge<T> ukk = (EffectAfterKnowledge<T>) uk;
						// ╓e→e1╖m ∧ ╓e→e2╖n ∧ ω(e1,e2) ⇒ ⊥
						checkOrderDependentAfterConflict(kk, ukk);
					}
				}
			}

			if (k instanceof EffectBeforeKnowledge<?>)
			{
				EffectBeforeKnowledge<T> kk = (EffectBeforeKnowledge<T>) k;
				// ╓e←▷╖⇒⊥ (sanity check - this should never happen)
				checkBeforeStart(kk);
				for (Knowledge<T> uk : uncooperativeMetaprogramKnowledge)
				{
					if (uk instanceof InvariantBeforeKnowledge<?>)
					{
						InvariantBeforeKnowledge<T> ukk = (InvariantBeforeKnowledge<T>) uk;
						// ╙e1←e╜m ∧ ╓e2←e╖n ⇒ ⊥ where this metaprogram is m
						checkReadWriteBeforeConflict(kk, ukk, ukk.getMetaprogramID());
					}
					if (uk instanceof EffectBeforeKnowledge<?>)
					{
						EffectBeforeKnowledge<T> ukk = (EffectBeforeKnowledge<T>) uk;
						// ╓e←e1╖m ∧ ╓e←e2╖n ∧ ω(e1,e2) ⇒ ⊥
						checkOrderDependentBeforeConflict(kk, ukk);
					}
				}
			}

			if (k instanceof EffectInKnowledge<?>)
			{
				EffectInKnowledge<T> kk = (EffectInKnowledge<T>) k;
				// ╓◁∈*╖⇒⊥ and ╓▷∈*╖⇒⊥ (sanity check - this should never happen)
				checkRemoveMarker(kk);
				for (Knowledge<T> uk : uncooperativeMetaprogramKnowledge)
				{
					if (uk instanceof EffectInKnowledge<?>)
					{
						EffectInKnowledge<T> ukk = (EffectInKnowledge<T>) uk;
						// ╓e∈*╖m ∧ ╓e∈*╖n ⇒⊥
						checkDualContainment(kk, ukk);
					}
					if (uk instanceof InvariantInKnowledge<?>)
					{
						InvariantInKnowledge<T> ukk = (InvariantInKnowledge<T>) uk;
						// ╓e∈*╖m ∧ ╙e∈*╜n ⇒⊥ where this metaprogram is m
						checkDualContainment(kk, ukk);
					}
					if (uk instanceof NodeRelationKnowledge<?>)
					{
						NodeRelationKnowledge<T> ukk = (NodeRelationKnowledge<T>) uk;
						// check for any kind of change or learning of an arrow relation overlapping with this
						// containment effect
						checkContainmentChangeOnOrderKnowledge(ukk, kk, ukk.getMetaprogramID());
					}
					if (uk instanceof PredicateKnowledge<?>)
					{
						PredicateKnowledge<T> ukk = (PredicateKnowledge<T>) uk;
						// ╙P╜m ∧ ╙e∈*╜n ∧ P(e) where this metaprogram is n
						checkPredicateMatch(ukk, kk, ukk.getMetaprogramID());
					}
				}
			}

			if (k instanceof InvariantAfterKnowledge<?>)
			{
				InvariantAfterKnowledge<T> kk = (InvariantAfterKnowledge<T>) k;
				// ╙◁→e╜⇒⊥ (sanity check - this should never happen)
				checkAfterEnd(kk);
				for (Knowledge<T> uk : uncooperativeMetaprogramKnowledge)
				{
					if (uk instanceof EffectAfterKnowledge<?>)
					{
						EffectAfterKnowledge<T> ukk = (EffectAfterKnowledge<T>) uk;
						// ╙e→e1╜m ∧ ╓e→e2╖n ⇒ ⊥ where this metaprogram is n
						checkReadWriteAfterConflict(ukk, kk, ukk.getMetaprogramID());
					}
				}
			}

			if (k instanceof InvariantBeforeKnowledge<?>)
			{
				InvariantBeforeKnowledge<T> kk = (InvariantBeforeKnowledge<T>) k;
				// ╙e←▷╜⇒⊥ (sanity check - this should never happen)
				checkBeforeStart(kk);
				for (Knowledge<T> uk : uncooperativeMetaprogramKnowledge)
				{
					if (uk instanceof EffectBeforeKnowledge<?>)
					{
						EffectBeforeKnowledge<T> ukk = (EffectBeforeKnowledge<T>) uk;
						// ╙e1←e╜m ∧ ╓e2←e╖n ⇒ ⊥ where this metaprogram is n
						checkReadWriteBeforeConflict(ukk, kk, ukk.getMetaprogramID());
					}
				}
			}

			if (k instanceof InvariantInKnowledge<?>)
			{
				InvariantInKnowledge<T> kk = (InvariantInKnowledge<T>) k;
				for (Knowledge<T> uk : uncooperativeMetaprogramKnowledge)
				{
					if (uk instanceof EffectInKnowledge<?>)
					{
						EffectInKnowledge<T> ukk = (EffectInKnowledge<T>) uk;
						// ╓e∈*╖m ∧ ╙e∈*╜n ⇒⊥ where this metaprogram is n
						checkDualContainment(kk, ukk);
					}
				}
			}

			if (k instanceof PredicateKnowledge<?>)
			{
				PredicateKnowledge<T> kk = (PredicateKnowledge<T>) k;
				for (Knowledge<T> uk : uncooperativeMetaprogramKnowledge)
				{
					if (uk instanceof EffectInKnowledge<?>)
					{
						EffectInKnowledge<T> ukk = (EffectInKnowledge<T>) uk;
						// ╙P╜m ∧ ╙e∈*╜n ∧ P(e) where this metaprogram is m
						checkPredicateMatch(kk, ukk, ukk.getMetaprogramID());
					}
				}
			}

			// *** If we got this far, the rule does not contradict; add it to the knowledge base
			this.base.add(k);

			// *** Now compute actual closure for those rules that do not imply contradiction

			// ╙e←e'╜ ⇒ ╙e'→e╜
			if (k instanceof InvariantBeforeKnowledge<?>)
			{
				InvariantBeforeKnowledge<T> invariantK = (InvariantBeforeKnowledge<T>) k;
				InvariantAfterKnowledge<T> converse = new InvariantAfterKnowledge<T>(invariantK.getMetaprogramID(),
						invariantK.getSecond(), invariantK.getFirst());
				if (!this.base.contains(converse))
				{
					addKnowledge(converse);
				}
			}

			// ╙e'→e╜ ⇒ ╙e←e'╜
			if (k instanceof InvariantAfterKnowledge<?>)
			{
				InvariantAfterKnowledge<T> invariantK = (InvariantAfterKnowledge<T>) k;
				InvariantBeforeKnowledge<T> converse = new InvariantBeforeKnowledge<T>(invariantK.getMetaprogramID(),
						invariantK.getSecond(), invariantK.getFirst());
				if (!this.base.contains(converse))
				{
					addKnowledge(converse);
				}
			}
		}
	}

	private Integer lastUncooperativeCalculationMetaprogram = null;
	private Set<Knowledge<T>> uncooperativeMetaprogramKnowledge = Collections.emptySet();

	private Set<Knowledge<T>> calculateUncooperativeMetaprogramKnowledge()
	{
		if (this.manager.getCurrentMetaprogramId() != this.lastUncooperativeCalculationMetaprogram)
		{
			this.lastUncooperativeCalculationMetaprogram = this.manager.getCurrentMetaprogramId();
			if (this.lastUncooperativeCalculationMetaprogram == null)
			{
				this.uncooperativeMetaprogramKnowledge = Collections.emptySet();
			} else
			{
				this.uncooperativeMetaprogramKnowledge = new HashSet<Knowledge<T>>();
				for (Knowledge<T> k : this.base)
				{
					if (!this.manager.hasCooperation(k.getMetaprogramID()))
					{
						this.uncooperativeMetaprogramKnowledge.add(k);
					}
				}
			}
		}
		return this.uncooperativeMetaprogramKnowledge;
	}

	/**
	 * Calculates ╙P╜m ∧ ╙e∈*╜n ∧ P(e)
	 */
	private void checkPredicateMatch(PredicateKnowledge<T> kk, EffectInKnowledge<T> ukk, int metaprogramID)
	{
		if (kk.getFilter().filter(ukk.getElement().getValue()))
		{
			this.manager.assertCooperation(metaprogramID, this.parent);
		}
	}

	/**
	 * Calculates ╓e←e1╖m ∧ ╓e←e2╖n ∧ ω(e1,e2) ⇒ ⊥
	 */
	private void checkOrderDependentBeforeConflict(EffectBeforeKnowledge<T> kk, EffectBeforeKnowledge<T> ukk)
	{
		if (kk.getSecond().equals(ukk.getSecond()) && isOrderDependent(kk.getSecond().getValue())
				&& isOrderDependent(ukk.getSecond().getValue()))
		{
			this.manager.assertCooperation(ukk.getMetaprogramID(), this.parent);
		}
	}

	/**
	 * Calculates ╓e→e1╖m ∧ ╓e→e2╖n ∧ ω(e1,e2) ⇒ ⊥
	 */
	private void checkOrderDependentAfterConflict(EffectAfterKnowledge<T> kk, EffectAfterKnowledge<T> ukk)
	{
		if (kk.getSecond().equals(ukk.getSecond()) && isOrderDependent(kk.getSecond().getValue())
				&& isOrderDependent(ukk.getSecond().getValue()))
		{
			this.manager.assertCooperation(ukk.getMetaprogramID(), this.parent);
		}
	}

	/**
	 * Performs calculation of ╙e1←e╜m ∧ ╓e2←e╖n ⇒ ⊥.
	 */
	private void checkReadWriteBeforeConflict(EffectBeforeKnowledge<T> ek, InvariantBeforeKnowledge<T> ik,
			int metaprogramID)
	{
		if (ek.getSecond().equals(ik.getSecond()))
		{
			this.manager.assertCooperation(metaprogramID, this.parent);
		}
	}

	/**
	 * Performs calculation of ╙e→e1╜m ∧ ╓e→e2╖n ⇒ ⊥.
	 */
	private void checkReadWriteAfterConflict(EffectAfterKnowledge<T> ek, InvariantAfterKnowledge<T> ik,
			int metaprogramID)
	{
		if (ek.getSecond().equals(ik.getSecond()))
		{
			this.manager.assertCooperation(metaprogramID, this.parent);
		}
	}

	/**
	 * Performs calculation of ((╓e←e'╖)m ∨ (╓e→e'╖)m ∨ (╙e←e'╜)m ∨ (╙e→e'╜)m) ∧ ((╓e∈*╖)n ∨ (╓e'∈*╖)n)
	 */
	private void checkContainmentChangeOnOrderKnowledge(NodeRelationKnowledge<T> rel, EffectInKnowledge<T> in,
			int metaprogramID)
	{
		if (rel.getFirst().equals(in.getElement()) || (rel.getSecond().equals(in.getElement())))
		{
			this.manager.assertCooperation(metaprogramID, this.parent);
		}
	}

	/**
	 * Performs calculation of ╓e∈*╖m ∧ ╓e∈*╖n ⇒ ⊥ and ╓e∈*╖m ∧ ╙e∈*╜n ⇒ ⊥. For sake of sanity, one of these arguments
	 * must be an effect knowledge.
	 */
	private void checkDualContainment(InKnowledge<T> kk, InKnowledge<T> ukk)
	{
		if (!(kk instanceof EffectInKnowledge<?>) && !(ukk instanceof EffectInKnowledge<?>))
		{
			throw new IllegalStateException();
		}
		if (kk.getElement().equals(ukk.getElement()))
		{
			this.manager.assertCooperation(ukk.getMetaprogramID(), this.parent);
		}
	}

	/**
	 * Performs calculation of ╓◁∈*╖⇒⊥ or of ╓▷∈*╖⇒⊥
	 */
	private void checkRemoveMarker(EffectInKnowledge<T> k)
	{
		if (k.getElement().equals(new EndValue<T>()))
		{
			throw new IllegalArgumentException("Logical failure in ListNodeImpl: ╓◁∈*╖");
		}
		if (k.getElement().equals(new StartValue<T>()))
		{
			throw new IllegalArgumentException("Logical failure in ListNodeImpl: ╓▷∈*╖");
		}
	}

	/**
	 * Performs calculation of ╓◁→e╖⇒⊥ or ╙◁→e╜⇒⊥.
	 * 
	 * @param e The element involved.
	 */
	private void checkAfterEnd(AfterKnowledge<T> k)
	{
		if (k.getSecond().equals(new EndValue<T>()))
		{
			throw new IllegalStateException("Logical failure in NodeListImpl: " + k.getLeftDelimiter() + "◁→e"
					+ k.getRightDelimiter() + " !");
		}
	}

	/**
	 * Performs calculation of ╓e←▷╖⇒⊥ or ╙e←▷╜⇒⊥.
	 * 
	 * @param e The element involved.
	 */
	private void checkBeforeStart(BeforeKnowledge<T> k)
	{
		if (k.getSecond().equals(new StartValue<T>()))
		{
			throw new IllegalStateException("Logical failure in NodeListImpl: " + k.getLeftDelimiter() + "e←▷"
					+ k.getRightDelimiter() + " !");
		}
	}

	/**
	 * Represents a symbolic list value.
	 */
	private static abstract class SymbolicValue<T extends Node>
	{
		public abstract boolean equals(Object o);

		public abstract int hashCode();

		public abstract T getValue();
	}

	/**
	 * Represents a list value containing an element.
	 */
	private static class ElementValue<T extends Node> extends SymbolicValue<T>
	{
		private T element;

		public ElementValue(T element)
		{
			super();
			this.element = element;
		}

		public T getValue()
		{
			return element;
		}

		@Override
		public int hashCode()
		{
			long nodeUid = this.element.getUid();
			return ((int) nodeUid) ^ (int) (nodeUid >> 32);
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (getClass() != obj.getClass())
				return false;
			ElementValue<?> other = (ElementValue<?>) obj;
			return other.element.getUid() == this.element.getUid();
		}

		@Override
		public String toString()
		{
			return String.valueOf(this.element.getUid());
		}
	}

	/**
	 * Represents a list value representing the start of the list.
	 */
	private static class StartValue<T extends Node> extends SymbolicValue<T>
	{
		@Override
		public int hashCode()
		{
			return -1;
		}

		@Override
		public boolean equals(Object obj)
		{
			return getClass() == obj.getClass();
		}

		@Override
		public T getValue()
		{
			return null;
		}

		@Override
		public String toString()
		{
			return "▷";
		}
	}

	/**
	 * Represents a list value representing the start of the list.
	 */
	private static class EndValue<T extends Node> extends SymbolicValue<T>
	{
		@Override
		public int hashCode()
		{
			return -2;
		}

		@Override
		public boolean equals(Object obj)
		{
			return getClass() == obj.getClass();
		}

		@Override
		public T getValue()
		{
			return null;
		}

		@Override
		public String toString()
		{
			return "◁";
		}
	}

	/**
	 * An interface representing a unit of conflict detection knowledge.
	 */
	private static interface Knowledge<T extends Node>
	{
		public int getMetaprogramID();

		public abstract String getLeftDelimiter();

		public abstract String getRightDelimiter();

		public abstract String toString();

		public abstract String getDescription();
	}

	/**
	 * An abstract class representing a unit of conflict detection knowledge.
	 */
	private static abstract class AbstractKnowledge<T extends Node> implements Knowledge<T>
	{
		/** The ID of the metaprogram that created this knowledge. */
		private int metaprogramID;

		public AbstractKnowledge(int metaprogramID)
		{
			super();
			this.metaprogramID = metaprogramID;
		}

		public int getMetaprogramID()
		{
			return metaprogramID;
		}

		public String toString()
		{
			return getLeftDelimiter() + getDescription() + getRightDelimiter() + "^" + metaprogramID;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + metaprogramID;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AbstractKnowledge<?> other = (AbstractKnowledge<?>) obj;
			if (metaprogramID != other.metaprogramID)
				return false;
			return true;
		}
	}

	/**
	 * Represents a piece of knowledge about a single node.
	 */
	private static abstract class SingleNodeKnowledge<T extends Node> extends AbstractKnowledge<T>
	{
		/** The node involved. */
		private SymbolicValue<T> element;

		public SingleNodeKnowledge(int metaprogramID, SymbolicValue<T> element)
		{
			super(metaprogramID);
			this.element = element;
		}

		public SymbolicValue<T> getElement()
		{
			return element;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((element == null) ? 0 : element.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SingleNodeKnowledge<?> other = (SingleNodeKnowledge<?>) obj;
			if (element == null)
			{
				if (other.element != null)
					return false;
			} else if (!element.equals(other.element))
				return false;
			return true;
		}
	}

	/**
	 * Represents a piece of knowledge about two nodes.
	 */
	private static abstract class NodeRelationKnowledge<T extends Node> extends AbstractKnowledge<T>
	{
		/** The first node in the relation. */
		private SymbolicValue<T> first;
		/** The second node in the relation. */
		private SymbolicValue<T> second;

		public NodeRelationKnowledge(int metaprogramID, SymbolicValue<T> first, SymbolicValue<T> second)
		{
			super(metaprogramID);
			this.first = first;
			this.second = second;
		}

		public SymbolicValue<T> getFirst()
		{
			return first;
		}

		public SymbolicValue<T> getSecond()
		{
			return second;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((first == null) ? 0 : first.hashCode());
			result = prime * result + ((second == null) ? 0 : second.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			NodeRelationKnowledge<?> other = (NodeRelationKnowledge<?>) obj;
			if (first == null)
			{
				if (other.first != null)
					return false;
			} else if (!first.equals(other.first))
				return false;
			if (second == null)
			{
				if (other.second != null)
					return false;
			} else if (!second.equals(other.second))
				return false;
			return true;
		}
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram affected or learned the presence status of an
	 * element.
	 */
	private static interface InKnowledge<T extends Node> extends Knowledge<T>
	{
		public SymbolicValue<T> getElement();
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram affected or learned that an element appears before
	 * another element. The first element is the node that appears before; the second element is the reference node.
	 */
	private static interface BeforeKnowledge<T extends Node> extends Knowledge<T>
	{
		public SymbolicValue<T> getFirst();

		public SymbolicValue<T> getSecond();
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram affected or learned that an element appears after
	 * another element. The first element is the node that appears after; the second element is the reference node.
	 */
	private static interface AfterKnowledge<T extends Node> extends Knowledge<T>
	{
		public SymbolicValue<T> getFirst();

		public SymbolicValue<T> getSecond();
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram affected the presence status of a given element
	 * (╓e∈*╖).
	 */
	private static class EffectInKnowledge<T extends Node> extends SingleNodeKnowledge<T> implements InKnowledge<T>
	{
		public EffectInKnowledge(int metaprogramID, SymbolicValue<T> node)
		{
			super(metaprogramID, node);
		}

		@Override
		public String getLeftDelimiter()
		{
			return EFFECT_LEFT;
		}

		@Override
		public String getRightDelimiter()
		{
			return EFFECT_RIGHT;
		}

		@Override
		public String getDescription()
		{
			return getElement() + "∈*";
		}
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram learned the presence status of a given element
	 * (╙e∈╜).
	 */
	private static class InvariantInKnowledge<T extends Node> extends SingleNodeKnowledge<T> implements InKnowledge<T>
	{
		public InvariantInKnowledge(int metaprogramID, SymbolicValue<T> node)
		{
			super(metaprogramID, node);
		}

		@Override
		public String getLeftDelimiter()
		{
			return INVARIANT_LEFT;
		}

		@Override
		public String getRightDelimiter()
		{
			return INVARIANT_RIGHT;
		}

		@Override
		public String getDescription()
		{
			return getElement() + "∈";
		}
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram inserted a node before another node. The first node
	 * is the inserted node; the second node is the reference node. (╓e←e'╖)
	 */
	private static class EffectBeforeKnowledge<T extends Node> extends NodeRelationKnowledge<T> implements
			BeforeKnowledge<T>
	{
		public EffectBeforeKnowledge(int metaprogramID, SymbolicValue<T> first, SymbolicValue<T> second)
		{
			super(metaprogramID, first, second);
		}

		@Override
		public String getLeftDelimiter()
		{
			return EFFECT_LEFT;
		}

		@Override
		public String getRightDelimiter()
		{
			return EFFECT_RIGHT;
		}

		@Override
		public String getDescription()
		{
			return getFirst() + "←" + getSecond();
		}
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram inserted a node after another node. The first node
	 * is the inserted node; the second node is the reference node. (╓e'→e╖)
	 */
	private static class EffectAfterKnowledge<T extends Node> extends NodeRelationKnowledge<T> implements
			AfterKnowledge<T>
	{
		public EffectAfterKnowledge(int metaprogramID, SymbolicValue<T> first, SymbolicValue<T> second)
		{
			super(metaprogramID, first, second);
		}

		@Override
		public String getLeftDelimiter()
		{
			return EFFECT_LEFT;
		}

		@Override
		public String getRightDelimiter()
		{
			return EFFECT_RIGHT;
		}

		@Override
		public String getDescription()
		{
			return getSecond() + "→" + getFirst();
		}
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram learned that a node appears before another node.
	 * The first node is the leftmost node; the second node is the rightmost node. (╙e←e'╜)
	 */
	private static class InvariantBeforeKnowledge<T extends Node> extends NodeRelationKnowledge<T> implements
			BeforeKnowledge<T>
	{
		public InvariantBeforeKnowledge(int metaprogramID, SymbolicValue<T> first, SymbolicValue<T> second)
		{
			super(metaprogramID, first, second);
		}

		@Override
		public String getLeftDelimiter()
		{
			return INVARIANT_LEFT;
		}

		@Override
		public String getRightDelimiter()
		{
			return INVARIANT_RIGHT;
		}

		@Override
		public String getDescription()
		{
			return getFirst() + "←" + getSecond();
		}
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram learned that a node appears after another node. The
	 * first node is the rightmost node; the second node is the leftmost node. (╙e'→e╜)
	 */
	private static class InvariantAfterKnowledge<T extends Node> extends NodeRelationKnowledge<T> implements
			AfterKnowledge<T>
	{
		public InvariantAfterKnowledge(int metaprogramID, SymbolicValue<T> first, SymbolicValue<T> second)
		{
			super(metaprogramID, first, second);
		}

		@Override
		public String getLeftDelimiter()
		{
			return INVARIANT_LEFT;
		}

		@Override
		public String getRightDelimiter()
		{
			return INVARIANT_RIGHT;
		}

		@Override
		public String getDescription()
		{
			return getSecond() + "→" + getFirst();
		}
	}

	/**
	 * Represents a piece of knowledge indicating that a metaprogram used the specified node filtering predicate to read
	 * the contents of this list. (╙P╜)
	 */
	private static class PredicateKnowledge<T extends Node> extends AbstractKnowledge<T>
	{
		private NodeFilter<? super T> filter;

		public PredicateKnowledge(int metaprogramID, NodeFilter<? super T> filter)
		{
			super(metaprogramID);
			this.filter = filter;
		}

		public NodeFilter<? super T> getFilter()
		{
			return filter;
		}

		@Override
		public String getLeftDelimiter()
		{
			return INVARIANT_LEFT;
		}

		@Override
		public String getRightDelimiter()
		{
			return INVARIANT_RIGHT;
		}

		@Override
		public String getDescription()
		{
			return this.filter.toString();
		}
	}

	@Override
	public String toString()
	{
		return "NodeListImpl [backing=" + backing + ", base=" + base + "]";
	}
}
