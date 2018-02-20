package beta;


public class HashMapImpl {
	 
    /* The initial size of the bucket array */
    private int BUCKET_ARRAY_SIZE = 1;
    private Entry bucketArray[] = new Entry[BUCKET_ARRAY_SIZE];
 
    /* Constructors */
    public HashMapImpl(){}
 
    public HashMapImpl(int initialSize){
        this.BUCKET_ARRAY_SIZE = initialSize;
    }
 
    /**
     * Used to put a key-value pair into the data structure.
     * @param key Key string that is used identify the key-value pair
     * @param value Value string in which the key string maps to.
     */
    public void put(String key, String value){
        /* Get the hash code */
        int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
        /* Create the Node to add to the linked list */
        Entry entry = new Entry(key, value, bucketArray[hash]);
 
        /* Insert the node to the bucket array at the hash index */
        if(bucketArray[hash] == null){
            /* No collision detected. Insert the node. */
            bucketArray[hash] = entry;
        }else{
            /* Collision detected. We must place the node at the end of the linked list. */
        	
        	bucketArray[hash] = new Entry(key, value, bucketArray[hash]);
        }
    }
 
    /**
     * Returns the value that is mapped to the given key.
     * @param key The key string which is used to search for the value it
     *            is mapped to.
     * @return The value string
     */
    public String get(String key){
        /* Get the hash */
        int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
        /* Search for key in linked list */
        Entry n = bucketArray[hash];
        /* Traverse linked list */
        while(n != null){
            if(n.getKey().equals(key)){
                return n.getValue();
            }
            n = n.getNext();
        }
        /* Not found? then return null */
        return null;
    }
 
 
    /* This is the simple object that we use to store each key-value pair */
    class Entry{
        private String key;
        private String value;
        private Entry next;
 
        public Entry(){}
 
        public Entry(String key, String value, Entry bucketArray){
            this.key = key;
            this.value = value;
        }
 
        public String getKey() {
            return key;
        }
 
        public void setKey(String key) {
            this.key = key;
        }
 
        public String getValue() {
            return value;
        }
 
        public void setValue(String value) {
            this.value = value;
        }
 
        public Entry getNext() {
            return next;
        }
 
        public void setNext(Entry next) {
            this.next = next;
        }
    }
}
    
    
    
    
 // Definition for binary tree
    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
     
    	TreeNode(int x) {
    		val = x;
    	}
    }
    //DFS and BFS
    class BinaryTreeConvert {
    	public TreeNode sortedArrayToBST(int[] num) {
    		if (num.length == 0)
    			return null;
     
    		return sortedArrayToBST(num, 0, num.length - 1);
    	}
     
    	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
    		if (start > end)
    			return null;
     
    		int mid = (start + end) / 2;
    		TreeNode root = new TreeNode(num[mid]);
    		root.left = sortedArrayToBST(num, start, mid - 1);
    		root.right = sortedArrayToBST(num, mid + 1, end);
     
    		return root;
    	}
    }

