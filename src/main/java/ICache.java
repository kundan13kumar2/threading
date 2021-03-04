public interface ICache {

    void put(String key, Employee employee);

    Employee get(String key);

    void printCache();

}
