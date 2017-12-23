package edu.cofc.csci230;
  
 
//Singly LinkedList Data Structure

 
public class SinglyLinkedList<AnyType extends Comparable<AnyType>> implements List<AnyType> {
     
    // instance variables
    private Node<AnyType> headNode = null;
    private int size = 0;
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
        addNode( new Node<AnyType>(t) );
         
    } // end add() method
    
    /**
     * implementation for public add(AnyType t) method
     * 
     * @param t
     */
    private void addNode(Node<AnyType> t) {
        
        if ( isEmpty() ) headNode = t;
        else getNode( size-1 ).setNextNode( t );
         
        size++;
         
    } // end addNote() method
 
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
    	addNode( index, new Node<AnyType>(t) );
         
    } // end add() method
    
    /*
     * 
     * Implementation for public add(int index, AnyType t) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
    	
    	
    	//Adds a node to desired index location
    	
    	//Checks if index entered is in range
    	if(index >= 0 && index <= size){
    		//Checks if the index is in front of the list
    		if (index == 0){
    			t.setNextNode(headNode);
    			headNode = t;
    			size++; //size increase as nodes are added
    		//Checks if the index is at the end of the list
    		}else if(index == size){
    			getNode(size-1).setNextNode(t);
    			size++;
    		}else{
    			//Set the t next node before breaking link of previous node
    			t.setNextNode(getNode(index));
    			getNode(index-1).setNextNode(t);
    			size++;
    		}
    	//If index is not in range
    	}else{
    		throw new IndexOutOfBoundsException();
    	}
     
        
        
    } // end addNode() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         
        setNode( index, new Node<AnyType>(t) );
         
    } // end set() method
    
    /**
     * 
     * Implementation for public set( int index, AnyType t ) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void setNode( int index, Node<AnyType> t ) throws IndexOutOfBoundsException {
    	
    	
    	
    	//Replaces node at index location
    	if(index >= 0 && index <= size-1){
    		if (index == 0){
    			t.setNextNode(getNode(1));
    			headNode = t;
    			
    		}else if(index == size-1){
    			//Don't allow to set at the end
    			getNode(size-2).setNextNode(t);
    			
    		}else{
    			t.setNextNode(getNode(index+1));
    			getNode(index-1).setNextNode(t);
    		}
    	}else{
    		throw new IndexOutOfBoundsException();
    	}
    	
    	
     
        
    	
    } // end setNode() method

 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
    	
    	return removeNode( index ).getData();
    	
    } // end remove() method
    
    /**
     *
     * Implementation for public remove( int index ) method
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode( int index ) throws IndexOutOfBoundsException {
         
        
    	
    	//removes node at index entered index location
    	
    	Node<AnyType> temp;
    	if(index >= 0 && index <= size-1){
    		temp = getNode(index);
    		if (index == 0){
    			headNode = headNode.getNextNode(); //reassign t to new headNode
    			size--; //size decreases as you remove nodes
    		}else if(index == size-1){
    			getNode(size-2).setNextNode(null);
    			size--;
    		}else{
    			getNode(index - 1).setNextNode(getNode(index + 1));
    			size--;
    		}
 
    	}else{
    		throw new IndexOutOfBoundsException();
    	}
    	return temp;
    	//returns the temporary node 
         
        
         
    } // end removeNode() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get( int index ) throws IndexOutOfBoundsException {
    	
    	return getNode( index ).getData();
    	
    } // end get() method
    
    /**
     *
     * Implementation for public get(int index) method
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
         
       
    	
    	Node<AnyType> tempNode = headNode;
    	
    	if(index >= 0 && index <= size-1){
    		for (int i = 0; i < index; i++){
    				tempNode = tempNode.getNextNode();
    		}
    		return tempNode;
    		
    	}else{
    		throw new IndexOutOfBoundsException();
    	}
         
        
         
    } // end get() method
 
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
         
        return size;
         
    } // end size() method
 
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
         
        return ( size == 0 ) ? true : false;
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * 
     */
    public void clear() {
         
        
    	//clears all nodes
    	headNode = null;
    	size = 0;

         
    } // end clear method
     
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
         
      
    	
    	SinglyLinkedList<Integer> test = new SinglyLinkedList<Integer>();
    	
    	//TEST ADD METHOD
    	for (int i =0; i<5;i++){
    		test.add(i);
    		System.out.println(test.toString());
    	}
    	
    	
    	
    	test.add(0,1); 
    	//test.add(-1,2);
    	//test.add(5,2);
    	test.add(1,2);
    	test.add(2,3);
    	test.add(3,4);
    	test.add(4,5);
    	test.add(6);
    	test.add(6,7);
    	test.add(7,-8);
    	
    	
    	
    	//TEST SET METHOD
    	test.set(0,16);
    	test.set(5, 1);
    	test.set(2, 6);
    	test.set(4,6);
    	//test.set(-22, 3);
    	test.set(5, 9);
    	//test.set(20, 7);
    	test.set(1, -9);
    	test.set(7,8);
   	
    	
    	//TEST REMOVE METHOD
    	test.remove(0);
    	test.remove(4);
    	test.remove(2);
    	test.add(1,6);
    	//test.remove(-3);
    	//test.add(1,7);
    	test.remove(0);
    	test.remove(2);
    	test.remove(0);
//    	test.add(3);
//    	test.add(1);
//    	test.add(1,3);
//    	test.add(0,0);
//    	test.remove(0);
//    	test.remove(0);
//    	test.remove(0);
    	
    	
    	//TEST GET METHOD
    	System.out.println(test.get(0));
    	System.out.println(test.get(1));
    	System.out.println(test.get(2));
    	//System.out.println(test.get(3));
    	//System.out.println(test.get(-1));

  
   
    	//TEST CLEAR METHOD
    	//test.clear();
    	
    	System.out.println(test.toString());
    	
         
         
    } // end main() method
    public String toString() {
		Node<AnyType> temp = headNode; 
		String rtnString = "";
		
		for (int i = 0; i<this.size; i++) {
			rtnString += temp.getData().toString() + " -> ";
			temp = temp.getNextNode();
			
		}
		rtnString += "null";
		
		return rtnString; 
		
	} 
} // end SinglyLinkedList class definition
