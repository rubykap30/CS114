import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/*
 *
 *  BinarySearchTree.java
 *
 */

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    public Iterator<E> iterator() {
      vector = new Vector<E>();
      traverse(root);
      return vector.iterator();
      }
      
    private void traverse(Node<E> curr) {
      if (curr != null) {
         traverse(curr.left);
         vector.add(curr.data);
         traverse(curr.right);
      }
   }
   
   private Vector<E> vector;
      
    public void insert(E data){
      root = insertRec(root, data);
     }
      
    private Node insertRec(Node<E> curr, E data){
          if (curr == null){
          curr = new Node<E> (data);
          curr.data = data;
          return curr;
        }
       if (data.compareTo(curr.data) <= 0){
         if (curr.left == null){
            curr.left = new Node<E> (data);
            curr.left.data = data;
            return curr;
            }
          else{
            curr.left = insertRec(curr.left,data);
            }
          }
       if (data.compareTo(curr.data)> 0){
         if (curr.right == null){
            curr.right = new Node<E> (data);
            curr.right.data = data;
            return curr;
            }
          else{
            curr.right = insertRec(curr.right,data);
            }
         }
      return curr;
    }
        
    public void remove(E data){
      root = deleteRec(root,data);
      }
    
    private Node deleteRec(Node<E> curr, E data){
      if (curr == null){
            return curr;
            }
        if (data.compareTo(curr.data) < 0){
            curr.left = deleteRec(curr.left, data);
            }
        else if (data.compareTo(curr.data) > 0){
            curr.right = deleteRec(curr.right, data);
            }
        else {
            if (curr.left == null){
                return curr.right;
                }
            else if (curr.right == null){
                return curr.left;
               }
           curr.data = minValue(curr.right);
           curr.right = deleteRec(curr.right, curr.data);
        }
        return curr;
        
    }
 
    private E minValue(Node root){
        E minv = (E)root.data;
        while (root.left != null){
            minv = (E)root.left.data;
            root = root.left;
        }
        return minv;
    }
    
    public boolean search(E data){
      return searchRec(root, data);    
      }
    
    private boolean searchRec(Node<E> curr, E data){
       if (curr==null){
         return false;
         }
       if (data.compareTo(curr.data) == 0){
         return true;
         }
    if (data.compareTo(curr.data) < 0){
       return searchRec(curr.left, data);
        }
    return searchRec(curr.right, data);
   }          
}

