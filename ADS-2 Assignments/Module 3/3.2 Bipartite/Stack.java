import java.util.Iterator;
/**
 * Stack class.
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * size of the stack.
     */
    private int n;
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
        n = 0;
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * returns the size.
     * @return     size.
     */
    public int size() {
        return n;
    }
    /**
     * adds the item to the stack.
     * @param      item  The item
     */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**
     * Delete and return the item
     * most recently added to the stack.
     * Throw an exception if no such item
     * exists because the stack is empty.
     * @return     Item.
     */
    public Item pop() {
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }
    /**
     * Return the item most recently added to the stack.
     * Throw an exception if no such item
     * exists because the stack is empty.
     * @return    Item.
     */
    public Item peek() {
        return first.item;
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }
    /**
     * Return an iterator to the stack that
     * iterates through the items in LIFO order.
     * @return     Iterator.
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

