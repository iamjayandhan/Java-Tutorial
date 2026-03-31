public class ArraysMain {
    public static void main(String args[]){

        // Array VS ArrayList
        // https://en.wikipedia.org/wiki/Dynamic_array
        
        // -------------------------
        //          Array
        // -------------------------
        // - size is fixed when created
        // - can store primitives (int, double) and objects
        // - slightly faster
        // - uses less memory (no overhead)
        
        String[] friendsArray = new String[4];
        String[] friendsArray2 = {"John", "Chris", "Eric", "Luke"};
        
        // Get an element
        System.out.println(friendsArray2[1]);
        
        // Change an element
        friendsArray2[0] = "Carl";
        
        // Length of array
        System.out.println(friendsArray2.length);
        
        // -------------------------
        //        ArrayList
        // -------------------------
        // - dynamic size (grows and shrinks)
        // - can ONLY store objects (uses wrapper classes like Integer, Double)
        // - slightly slower (resizing overhead)
        // - uses more memory (stores internal array + size + methods)

        // Advantages:
        // 1. Random access of elements O(1)
        // 2. Good locality of reference and data cache utilization
        // 3. Easy to insert/delete at the end

        // Disadvantages:
        // 1. Wastes more memory
        // 2. Shifting elements is time consuming O(n)
        // 3. Expanding/Shrinking the array is time consuming O(n)

        java.util.ArrayList<String> friendsArrayList = new java.util.ArrayList<>();
        friendsArrayList.add("John");
        friendsArrayList.add("Chris");
        friendsArrayList.add("Eric");
        friendsArrayList.add("Luke");
        
        // Get an element
        System.out.println(friendsArrayList.get(1));
        
        // Change an element
        friendsArrayList.set(0, "Carl");
        
        // Add at specific index
        friendsArrayList.add(1, "Steve");
        
        // Remove an element
        friendsArrayList.remove("Chris"); // or friendsArrayList.remove(1);
        
        // Length of ArrayList (size)
        System.out.println(friendsArrayList.size());
        
        // Clear all elements
        // friendsArrayList.clear();
        
    }    
}
