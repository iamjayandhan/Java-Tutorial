/*
* HashMap is like a dict, a Non-Linear Data Structure
* Uses hashtable and hashfunction to find location to store data
* so get and set func are done in O(1) complexity
* if hashfunc returns addr that is already occupied, then
* we create linkedlist there! so O(1) changes to O(<than n value)
*/

import java.util.*;

public class HashMapExample{
    public static void main(String args[]){
        HashMap<String, String> dictionary = new HashMap<>();

        
        dictionary.put("key","value");
        dictionary.put("key2","value2");
        System.out.println(dictionary.get("key"));

        HashMap<Character, String[]> studentsMap = new HashMap<>();
        String sectionA[] = {"Name1","Name2"};
        String sectionB[] = {"Name1","Name2"};

        studentsMap.put('A',sectionA);
        studentsMap.put('B',sectionB);

        System.out.println(studentsMap.get('A')[0]);
        System.out.println(studentsMap.get('A')[1]);

        System.out.println(studentsMap.get('B')[0]);
        System.out.println(studentsMap.get('B')[1]);
    }
}