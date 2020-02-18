//package gr.dit.hw1.tree;

public aspect AspectTree {
	
	private interface TreeInterface { }
	declare parents: Tree implements TreeInterface;
	
	//every tree has its own reader and writer code injection to Tree.java
	private int TreeInterface.readers = 0;
    private boolean TreeInterface.writer = false;
    
    pointcut pointLookUp_Called(Tree tree) : target(tree) && call(boolean Tree.search(int));
    
    before(Tree tree): pointLookUp_Called(tree) {
    	readerBefore(tree);
    }

    after(Tree tree): pointLookUp_Called(tree){
    	readerAfter(tree); 
    }
    
    pointcut pointWriter_Called(Tree tree) : target(tree) && (call(void Tree.insert(int)) || call(void Tree.deleteKey(int)));
    
    before(Tree tree): pointWriter_Called(tree) {
        writerBefore(tree);
    }
    

    after(Tree tree): pointWriter_Called(tree) {
        writerAfter(tree);
    }

    
	private void readerBefore(Tree tree) {
		synchronized (tree) {
            try {
                while (tree.writer){
                    System.out.println("Lookup Thread is in critical section");
                    tree.wait();
                }
                tree.readers++;
            } catch (Exception e){
                System.err.println(e);
            }
    	}
	}
	
	private void readerAfter(Tree tree) {
		synchronized (tree) {   		
	        try{
	            tree.readers--;
	            if (tree.readers == 0){
	                tree.notify();
	            }
	        }catch (Exception e){
	        	System.err.println(e);
	        }
    	}
	}
	
	private void writerBefore(Tree tree) {
		synchronized (tree){
            try{
                while (tree.readers > 0 || tree.writer){
                    System.out.println("Write or Delete Thread is in critical section");
                    tree.wait();
                }
                tree.writer = true;
            } catch (Exception e){
            	System.err.println(e);
            }
        }
	}
	
	private void writerAfter(Tree tree) {
		synchronized (tree){
            try{
                tree.writer = false;
                tree.notifyAll();
            } catch (Exception e){
            	System.err.println(e);
            }
        }
	}

}
