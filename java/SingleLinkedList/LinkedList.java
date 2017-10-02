/**
 * Class for a model of a very simple Single Linked List
 * @author Liam Jensen
 */
public class LinkedList<T>
{
    private Node head, tail;
    private int size;

    /**
     * Constructor
     * 
     * TODO: Overload constructor to initialize a List of values
     */
    public LinkedList()
    {
        size = 0;
    }

    /**
     * Add a piece of data to the current list
     * @return true if data was appended
     */
    public boolean add(T data)
    {
        if(head == null)
        {
            head = new Node(data); 
            tail = head;           
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
        return true;
    }

    /**
     * Simple string representation of the list
     * @return String of the list
     */
    public String toString()
    {
        String s = new String();
        Node current = head;
        while(current != null)
        {
            s += current.data + " -> ";
            current = current.next;            
        }
        
        return s;
    }

    /**
     * Remove from index of the list
     * 
     * TODO: Overload remove and search for an object
     * 
     * @return true if item was removed
     */
    public boolean remove(int index)
    {
        Node current = head;
        int i = index;

        //Head corner case
        if(index == 0)
        {
            head = current.next;
            size--;
            return true;
        }
        
        while(--i > 0)
        {
            if(current.next == null)
                throw new IndexOutOfBoundsException();
            else
                current = current.next;
        }


        //Tail corner case
        if(index == size - 1)
        {
            tail = current;
        }

        size--;
        current.next = current.next.next;
        return true;
    }

    /**
     * Append another list to the current list
     * @return true if list was appended
     */
    public boolean append(LinkedList list)
    {
        this.tail.next = list.head;
        this.tail = list.tail;
        this.size += list.getSize();
        return true;
    }

    /**
     * Returns the current size of the list
     * @return size of the list
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Private inner class to hold generic data used in the LinkedList
     */
    private class Node<T>
    {
        private T data;
        private Node next;
        
        public Node(T data)
        {
            this.data = data;
        }
    }
}

