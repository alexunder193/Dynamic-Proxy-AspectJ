//package gr.dit.hw1.tree;

public class Tree {
	 
    Node root; 
   
    Tree() {  
        root = null;  
    } 
    
    public void insert(int key) { 
       root = insertRec(root, key); 
    }
    
      
    Node insertRec(Node root, int key) { 
  
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        return root; 
    } 
    
    public boolean search(int key) {
    	return searchRec(root, key);
    }

	public /*Node*/boolean searchRec(Node root, int key) {  
//	    if (root==null || root.key==key) 
//	        return root;
//	    
//	    if (root.key > key) 
//	        return searchRec(root.left, key);
//	    
//	    return searchRec(root.right, key);
        if (root == null){
            return false;
        }
        if (root.key == key){
            return true;
        }

        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
	} 
	
    void inorder()  { 
       inorderRec(root); 
    } 
   
    void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.println(root.key); 
            inorderRec(root.right); 
        } 
    } 
     
    void deleteKey(int key) { 
        root = deleteRec(root, key); 
    } 
  
    Node deleteRec(Node root, int key) 
    { 
        if (root == null)  return root; 

        if (key < root.key) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.key) 
            root.right = deleteRec(root.right, key); 
  
        else
        { 

            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 

            root.key = minValue(root.right); 
 
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    } 
    
    int minValue(Node root) { 
        int minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 

}
