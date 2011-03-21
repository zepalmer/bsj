package edu.jhu.cs.bsj.compiler.impl.ast.delta.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.MetaprogramListConflictExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;

/**
 * <p>
 * Represents a list of nodes during a patch operation. Nodes are represented here by UIDs and are indirected through a
 * map as explained in {@link EditScriptElement}. This list type permits the merging of otherwise dissonant operations
 * by retaining a memory of the previous elements in the list. For instance, if metaprogram 1 has an edit script which
 * consists of adding an element <tt>B</tt> after an element <tt>A</tt> and metaprogram 2 has an edit script which
 * consists of removing the element <tt>A</tt>, this list can facilitate the merging of those operations. It does so by
 * remembering the position of the element <tt>A</tt> even after it has been deleted.
 * </p>
 * <p>
 * Elements are retained in this list along with an index indicating how many times they have appeared here. This
 * permits the merge mechanism to properly merge even if an element is added, removed, and then added again in a
 * different position. The indices which are stored in this list correspond to the indices stored by the list edit
 * script elements.
 * </p>
 * <p>
 * Many operations on this list return a node ID describing the node immediately to the left of the addition point. This
 * permits the caller to execute the corresponding operation in the actual list node's list.
 * </p>
 * 
 * @author Zachary Palmer
 */
public class ShadowList
{
    public static final int HEAD_OCCURRENCE = -1;
    public static final int TAIL_OCCURRENCE = -2;

    private DependencyManager dependencyManager;
    private ListNode<?> list;
    private ShadowCell head;
    private ShadowCell tail;
    private Map<ShadowCellContents, ShadowCell> cellMap;
    private Function<Long, Node> lookupFunction;

    /**
     * Creates a new shadow list.
     * 
     * @param dependencyManager The dependency manager for conflict detection.
     * @param contents The initial contents of the list. Each element is a pair between a UID and a flag indicating
     *            whether or not the element is ordered.
     * @param list The list over which conflicts will be reported. This value is used only for diagnostic reporting
     *            purposes.
     * @param lookupFunction A function for looking up nodes by their UIDs. This is used for the purpose of reporting
     *            diagnostics.
     */
    public ShadowList(DependencyManager dependencyManager, Iterable<Long> contents, ListNode<?> list,
            Function<Long, Node> lookupFunction)
    {
        this.dependencyManager = dependencyManager;
        this.head = new ShadowCell(new ShadowCellContents(null, HEAD_OCCURRENCE), null, null);
        this.tail = new ShadowCell(new ShadowCellContents(null, TAIL_OCCURRENCE), this.head, null);
        this.head.setRight(this.tail);
        this.cellMap = new HashMap<ShadowCellContents, ShadowCell>();
        this.cellMap.put(this.head.getContents(), this.head);
        this.cellMap.put(this.tail.getContents(), this.tail);

        this.list = list;
        this.lookupFunction = lookupFunction;

        ShadowCell current = this.head;
        for (long uid : contents)
        {
            // TODO: can we always assume 1 here? (yes... but we should replace with boolean as indicated in
            // ShadowCellContents)
            ShadowCell next = new ShadowCell(new ShadowCellContents(uid, 1), current, this.tail);
            current.setRight(next);
            this.tail.setLeft(next);
            this.cellMap.put(next.getContents(), next);
            current = next;
        }
    }

    private void metaprogramTouch(int metaprogramId, ShadowCell cell, Set<Integer> otherMetaprogramIds, boolean after, long added)
    {
        for (int otherMetaprogramId : otherMetaprogramIds)
        {
            if (!this.dependencyManager.checkOrdering(metaprogramId, otherMetaprogramId))
            {
                throw new MetaprogramListConflictExceptionImpl(
                        this.dependencyManager.getMetaprogramProfileByID(metaprogramId).getAnchor(),
                        this.dependencyManager.getMetaprogramProfileByID(otherMetaprogramId).getAnchor(),
                        this.list, this.list,
                        cell.getContents().getUid() == null? null:
                        this.lookupFunction.execute(cell.getContents().getUid()),
                        after,
                        this.lookupFunction.execute(added));
            }
        }
        otherMetaprogramIds.add(metaprogramId);
    }

    private void metaprogramTouchLeft(int metaprogramId, ShadowCell cell, long added)
    {
        metaprogramTouch(metaprogramId, cell, cell.getLeftAffectors(), false, added);
    }

    private void metaprogramTouchRight(int metaprogramId, ShadowCell cell, long added)
    {
        metaprogramTouch(metaprogramId, cell, cell.getRightAffectors(), true, added);
    }

    /**
     * Adds a UID after another UID in the list.
     * 
     * @param metaprogramId The ID of the metaprogram performing the operation.
     * @param uid The UID to add.
     * @param ordered <code>true</code> if this element is ordered; <code>false</code> if it is not.
     * @param occurenceCount The occurence count of the UID in the list.
     * @param targetUid The UID to use as a reference point. <code>null</code> indicates the head or tail of the list.
     * @param targetOccurrenceCount The occurrence count of that UID (in the event that it has existed in the list
     *            multiple times). Special occurrence counts are provided for the head and tail of the list.
     * @return The UID of the nearest live element in the list to the left or <code>null</code> if no such element
     *         exists. This method always returns a live element even if the target UID has been removed by another
     *         metaprogram; this return value should thus be used when modifying the actual node.
     */
    public Long addAfter(int metaprogramId, long uid, boolean ordered, int occurrenceCount, Long targetUid,
            int targetOccurrenceCount)
    {
        ShadowCell targetCell = this.cellMap.get(new ShadowCellContents(targetUid, targetOccurrenceCount));
        if (targetCell == null)
        {
            throw new IllegalStateException("Shadow list was given a non-existent reference point (" + targetUid + ","
                    + targetOccurrenceCount + ")!");
        }
        if (targetCell == this.tail)
        {
            throw new IllegalArgumentException("Cannot add after the tail of the list!");
        }
        if (ordered)
            metaprogramTouchRight(metaprogramId, targetCell, uid);
        ShadowCellContents contents = new ShadowCellContents(uid, occurrenceCount);
        ShadowCell cell = new ShadowCell(contents, targetCell, targetCell.getRight());
        targetCell.setRight(cell);
        this.cellMap.put(contents, cell);
        do
        {
            cell = cell.getLeft();
        } while (cell != null && cell.isDeleted());
        return cell == null ? null : cell.getContents().getUid();
    }

    /**
     * Adds a UID before another UID in the list.
     * 
     * @param metaprogramId The ID of the metaprogram performing the operation.
     * @param uid The UID to add.
     * @param ordered <code>true</code> if this element is ordered; <code>false</code> if it is not.
     * @param occurenceCount The occurence count of the UID in the list.
     * @param targetUid The UID to use as a reference point. <code>null</code> indicates the head or tail of the list.
     * @param targetOccurrenceCount The occurrence count of that UID (in the event that it has existed in the list
     *            multiple times). Special occurrence counts are provided for the head and tail of the list.
     * @return The UID of the nearest live element in the list to the left or <code>null</code> if no such element
     *         exists. This method always returns a live element even if the target UID has been removed by another
     *         metaprogram; this return value should thus be used when modifying the actual node.
     */
    public Long addBefore(int metaprogramId, long uid, boolean ordered, int occurrenceCount, Long targetUid,
            int targetOccurrenceCount)
    {
        ShadowCell targetCell = this.cellMap.get(new ShadowCellContents(targetUid, targetOccurrenceCount));
        if (targetCell == null)
        {
            throw new IllegalStateException("Shadow list was given a non-existent reference point (" + targetUid + ","
                    + targetOccurrenceCount + ")!");
        }
        if (targetCell == this.head)
        {
            throw new IllegalArgumentException("Cannot add before the head of the list!");
        }
        if (ordered)
            metaprogramTouchLeft(metaprogramId, targetCell, uid);
        ShadowCellContents contents = new ShadowCellContents(uid, occurrenceCount);
        ShadowCell cell = new ShadowCell(contents, targetCell.getLeft(), targetCell);
        targetCell.setLeft(cell);
        this.cellMap.put(contents, cell);
        do
        {
            cell = cell.getLeft();
        } while (cell != null && cell.isDeleted());
        return cell == null ? null : cell.getContents().getUid();
    }

    /**
     * Removes a UID from the list.
     * 
     * @param metaprogramId The ID of the metaprogram performing this operation.
     * @param uid The UID to remove.
     * @param occurrenceCount The occurrence count for the UID.
     */
    public void remove(int metaprogramId, long uid, int occurrenceCount)
    {
        ShadowCell targetCell = this.cellMap.get(new ShadowCellContents(uid, occurrenceCount));
        if (targetCell == null)
        {
            throw new IllegalStateException("Shadow list was given a non-existent reference point (" + uid + ","
                    + occurrenceCount + ")!");
        }
        if (targetCell.isDeleted())
        {
            // This is a problem. Suppose a list starts as [A,B,C]. Metaprogram 1 removes B and places it first,
            // producing [B,A,C]. Metaprogram 2 removes B and places it last, producing [A,C,B]. The problem here
            // is that successful removal implies that the removed element no longer has a parent; we cannot deliver
            // that guarantee to both metaprograms independently.

            // TODO: reconsider this situation.
            // This may *not* be a problem. We can let the double-delete slide and expect the parent property to object
            // when it is set by two different, unordered metaprograms. This does, however, make cleaning up merging
            // kind of tricky since the parent property is set to the *same* value by both metaprograms. This means
            // that a simple "you don't conflict if you both did the same thing" approach is insufficient here.

            throw new NotImplementedYetException("Conflicting list deletion not handled yet.");
        }
        targetCell.setDeleted(true);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        ShadowCell cell = this.head;
        while (cell != null)
        {
            if (!first)
                sb.append("; ");
            sb.append(cell.toString());
            first = false;
            cell = cell.getRight();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * A structure describing the contents of a cell. The head and tail shadow cells contain special occurrence counts
     * (defined by constants on the enclosing class) and <code>null</code> UIDs.
     */
    private static class ShadowCellContents
    {
        private Long uid;
        // TODO: can this be simplified considerably by replacing the int here with boolean?
        // every element which was already in the list when patching started is "false"; all other elements are "true"?
        // a "true" element represents one which, when the delta was being created, could only be seen by the
        // metaprogram performing the edit; thus, it's safe to simply delete a shadow cell in that state. "false" cells
        // are only special because they're visible to other metaprograms. THE CATCH, however, is that we would have
        // to mark every cell as "false" after each metaprogram's patch sequence completes. For instance, say
        // metaprogram A creates cell X. X would then be in a "true" state. But if metaprogram B removes X and
        // metaprogram C adds cell Y after X, we would need to ensure that it stays around for B's removal.
        private int occurrences;

        public ShadowCellContents(Long uid, int occurrences)
        {
            super();
            this.uid = uid;
            this.occurrences = occurrences;
        }

        public Long getUid()
        {
            return uid;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + occurrences;
            result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
            ShadowCellContents other = (ShadowCellContents) obj;
            if (occurrences != other.occurrences)
                return false;
            if (uid == null)
            {
                if (other.uid != null)
                    return false;
            } else if (!uid.equals(other.uid))
                return false;
            return true;
        }

        @Override
        public String toString()
        {
            if (this.uid == null)
            {
                if (this.occurrences == HEAD_OCCURRENCE)
                {
                    return "\u25b9"; // ▹
                } else if (this.occurrences == TAIL_OCCURRENCE)
                {
                    return "\u25c3"; // ◃
                } else
                {
                    return "??" + this.occurrences + "??";
                }
            } else if (this.occurrences == 1)
            {
                return "#" + this.uid;
            } else
            {
                return "#" + this.uid + ":" + this.occurrences;
            }
        }
    }

    /**
     * A cell for this list.
     * 
     * @author Zachary Palmer
     */
    private static class ShadowCell
    {
        private ShadowCellContents contents;
        private boolean deleted;
        private ShadowCell left;
        private ShadowCell right;
        private Set<Integer> leftAffectors;
        private Set<Integer> rightAffectors;

        public ShadowCell(ShadowCellContents contents, ShadowCell left, ShadowCell right)
        {
            super();

            this.deleted = false;
            this.leftAffectors = new HashSet<Integer>();
            this.rightAffectors = new HashSet<Integer>();

            this.contents = contents;
            this.left = left;
            this.right = right;
        }

        public boolean isDeleted()
        {
            return deleted;
        }

        public void setDeleted(boolean deleted)
        {
            if (getContents().getUid() == null)
                throw new IllegalStateException("Cannot delete beginning or end of list!");
            this.deleted = deleted;
        }

        public ShadowCell getLeft()
        {
            return left;
        }

        public void setLeft(ShadowCell left)
        {
            this.left = left;
        }

        public ShadowCell getRight()
        {
            return right;
        }

        public void setRight(ShadowCell right)
        {
            this.right = right;
        }

        public ShadowCellContents getContents()
        {
            return contents;
        }

        public Set<Integer> getLeftAffectors()
        {
            return leftAffectors;
        }

        public Set<Integer> getRightAffectors()
        {
            return rightAffectors;
        }

        @Override
        public String toString()
        {
            final String leftAffectors = "[" + StringUtilities.join(getLeftAffectors(), ",") + "]";
            final String contents = getContents().toString();
            final String deleted = isDeleted() ? "x" : "";
            final String rightAffectors = "[" + StringUtilities.join(getRightAffectors(), ",") + "]";
            return leftAffectors + "(" + contents + ")" + deleted + rightAffectors;
        }
    }
}
