/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *  The <tt>Bag</tt> class represents a bag (or multiset) of
 *  generic items. It supports insertion and iterating over the
 *  items in arbitrary order.
 *  <p>
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em>  operation
 *  take constant time. Iteration takes time
 *  proportional to the number of items.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.
 *  cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * number of elements in bag.
     */
    private int n;
    /**
     * beginning of bag.
     */
    private Node first;
    // helper linked list class
    /**
     * Class for node.
     */
    private class Node {
        /**
         * item.
         */
        private Item item;
        /**
         * Next node.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    public Bag() {
        first = null;
        n = 0;
    }
    /**
     * Determines if empty.
     * time complexity of this method is O(1).
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Returns the size.
     * time complexity of this method is O(1).
     * @return     size.
     */
    public int size() {
        return n;
    }
    /**
     * Adds a item.
     * time complexity of this method is O(1).
     *
     * @param      item  The item
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**
     * Returns the iteration.
     * time complexity of this method is O(N).
     * @return     list.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * Current node.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         * time complexity of this method is O(1).
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * Removes.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * Next function.
         * time complexity of this method is O(1).
         * @return     next item.
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
