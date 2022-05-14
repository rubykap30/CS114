//Ruby Kapoor
//CS 114H01 project 2 
//SortedList.java


import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> extends List<E> {

   // iterator did not have to be recursive and creates the curr node for other methods 
   public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            private Node<E> curr = head;
        };
    }
    // recursive insert method, calls private helperInsert method
    public void insert(E data) {
        head = helperInsert(head, new Node<E>(data));
      }
   // called and keeps track of where and how to insert the node
    private Node<E> helperInsert(Node<E> curr, Node<E> node) {
        if (curr == null){
          return node;
          }
        if (node.data.compareTo(curr.data) < 0) {
            node.next = curr;
            return node;
        }
        curr.next = helperInsert(curr.next, node);
        return curr;
      }
   // recursively removes data 
    public void remove(E data) {
        head = helperRemove(head, data);
      }
   // checks if data is null or skips and reassigns curr removing the data
    private Node<E> helperRemove(Node<E> curr, E data) {
        if (curr == null){
          return null;
          }
        if (data.compareTo(curr.data) == 0){
             return curr.next;
             }
        curr.next = helperRemove(curr.next, data);
        return curr;
      }
    // retrieves E data from specific index
    public E retrieve(int index) {
        return helperRetrieve(head, 0, index);
      }
   //checks if node at that x is equal to index and then return the next curr to check
    private E helperRetrieve(Node<E> curr, int x, int index) {
        if (x == index){
         return curr.data;
         }
        else if (x <= index){
            if(curr.next == null){
               return null;
               }
            else{
            return helperRetrieve(curr.next, x + 1, index);
            } 
          } 
        else{
         return null;
         } 
      }
   // searches through list for possible data
    public boolean search(E data) {
        return helperSearch(head, data);
    }
   // checks if data is the same as what it is looking for, else changes curr
    private boolean helperSearch(Node<E> curr, E data) {
        if (curr == null){
         return false;
         }
        if (data.compareTo(curr.data) == 0){
         return true;
         }
        return helperSearch(curr.next, data);
    }
  }




