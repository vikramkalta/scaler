import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTrial {
    public static void main(String args[]) {
        // https://www.javatpoint.com/java-hashmap
        HashMap<Integer, String> map = new HashMap<Integer,String>(); //Creating HashMap
        map.put(1, "Mango"); //Put elements in the map
        map.put(2, "Apple");
        map.put(3, "Banana");
        map.put(4, "Grapes");

        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        boolean isEmpty = map.isEmpty();
        Set set = map.keySet();
        boolean contains1 = map.containsKey(5);
        boolean contains2 = map.containsKey(4);
        System.out.println("Hashmap...");
    }
}