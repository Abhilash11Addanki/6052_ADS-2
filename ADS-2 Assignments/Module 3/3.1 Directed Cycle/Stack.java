import java.util.Iterator;
/**
 * Stack class.
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * size of the stack.
     */
    private int N;
    /**
     * top of stack.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * item of type Item.
         */
        private Item item;
        /**
         * next of type Node.
         */
        private Node next;
    }
   /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        N = 0;
    }
   /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return first == null;
    }
   /**
     * Return the number of items in the stack.
     */
    public int size() {
        return N;
    }
   /**
     * Add the item to the stack.
     */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
   /**
     * Delete and return the item 
     * most recently added to the stack.
     * Throw an exception if no such item
     * exists because the stack is empty.
     */
    public Item pop() {
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }
   /**
     * Return the item most recently added to the stack.
     * Throw an exception if no such item 
     * exists because the stack is empty.
     */
    public Item peek() {
        return first.item;
    }
   /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
   /**
     * Return an iterator to the stack that
     * iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    /**
     * an iterator, doesn't implement remove() since it's optional.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * current of type Node.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * returns the next item of the current item.
         * @return     Item.
         */
        public Item next() {
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
