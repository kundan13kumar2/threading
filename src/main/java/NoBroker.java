
import java.util.*;

public class NoBroker implements ICache {
    Map<String, Employee> cache = new HashMap<>();
    Deque<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        /**
         * LRU Eviction Policy
         * get(Key)
         * put((String) key, Object)
         * size = 10
         *
         */
        Employee emp1 = new Employee("A", "W");
        Employee emp2 = new Employee("B", "X");
        Employee emp3 = new Employee("C", "Y");
        Employee emp4 = new Employee("D", "Z");
        Employee emp5 = new Employee("E", "M");

        ICache iCache = new NoBroker();
        iCache.put("A", emp1);
        iCache.put("B", emp2);
        iCache.put("C", emp3);
        iCache.put("D", emp4);


        iCache.printCache();

        System.out.println(iCache.get("B"));
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        iCache.printCache();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        iCache.put("E", emp5);
        System.out.println("+++++++++++++++++++++++++");
        iCache.printCache();


    }


    @Override
    public void put(String key, Employee employee) {
        if (cache.containsKey(key)) {
            queue.remove(key);
        } else {
            if (queue.size() == 4) {
                String firstElement = queue.removeFirst();
                cache.remove(firstElement);
            }
            cache.put(key, employee);
        }
        queue.add(key);


    }

    @Override
    public Employee get(String key) {
        Employee value = cache.get(key);
        if (value != null) {
            queue.remove(key);
            queue.add(key);
        }
        return value;

    }

    @Override
    public void printCache() {
        for (String str : queue) {
            System.out.println(cache.get(str));
        }
    }

}
