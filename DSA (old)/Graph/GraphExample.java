/*
 * GRAPHS
 * Types => Directed,Non Directed, Weighted, Non Weighted, Cyclic , Acyclic
 * Adjacency list is used to represent a graph.
 * It is like a dict.
 * It has multiple key value pairs
 * We use HashMap!
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// class GraphNode{
// }

public class GraphExample{
    static boolean isAquainted(Map<String, String[]> adjacencyList,String name1,String name2){
        String friends[] = adjacencyList.get(name1);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(name1);
        visited.add(name1);

        while(!queue.isEmpty()){
            String current = queue.poll();
            if(current.equals(name2)){
                return true;
            }
            for(String friend : adjacencyList.get(current)){
                if(!visited.contains(friend)){
                    queue.offer(friend);
                    visited.add(friend);
                }
            }
        }
        return false;
    }



    public static void main(String args[]){
        // Graph
        Map<String, String[]> adjacencyList = new HashMap<>();

        adjacencyList.put("Ravi",new String[] {"Tanya","John","Soniya"});
        adjacencyList.put("Tanya",new String[] {"Ravi"});
        adjacencyList.put("John",new String[] {"Ravi"});
        adjacencyList.put("Soniya",new String[] {"Ravi","Yasha"});
        adjacencyList.put("Yasha",new String[] {"Soniya"});
    }
}