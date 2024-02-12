import java.util.*;
public class HashMapShuffle {
    public static void main(String[] args) {
        // Sample HashMap
         // Sample LinkedHashMap
         Map<String, Integer> myMap = new LinkedHashMap<>();
         myMap.put("a", 1);
         myMap.put("b", 2);
         myMap.put("c", 3);
         myMap.put("d", 4);
 
         // Extract entries into a list
         List<Map.Entry<String, Integer>> entryList = new ArrayList<>(myMap.entrySet());
 
         // Shuffle the list
         Collections.shuffle(entryList);
 
         // Create a new LinkedHashMap from the shuffled list
         Map<String, Integer> shuffledMap = new LinkedHashMap<>();
         for (Map.Entry<String, Integer> entry : entryList) {
             shuffledMap.put(entry.getKey(), entry.getValue());
         }
 
         System.out.println(shuffledMap);
    }
}
