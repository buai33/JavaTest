import java.util.*;

// sort HashMap by its values
public class SortByValues {
    /**
     * Sort a HashMap based on its values
     * @param hm
     * @return a sorted hashMap
     */
    public static HashMap<String, Integer> sortByValue (HashMap<String, Integer> hm) {
        // 1- Get all entries by calling entrySet() method of Map, Convert entry set to list
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // 2- Create a custom Comparator to sort entries, sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()));
            }
        });

        // 3- Create a LinkedHashMap to put data from sorted list to hashMap
        HashMap<String, Integer> sortedMp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            sortedMp.put(aa.getKey(), aa.getValue());
        }
        return sortedMp;
    }



    // Driver Code
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("Math", 98); hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        System.out.println("Before Sorted: ");
        for (Map.Entry<String, Integer> en : hm.entrySet()) {
            System.out.println("Key: " + en.getKey() + ", Value: " + en.getValue());
        }

        System.out.println("After Sorted: ");
        Map<String, Integer> shm = sortByValue(hm);
        // print the sorted hashMap
        for (Map.Entry<String, Integer> en : shm.entrySet()) {
            System.out.println("Key: " + en.getKey() + ", Value: " + en.getValue());
        }
    }
}
