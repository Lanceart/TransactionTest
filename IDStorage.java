
public interface IDStorage {
    void save(String key, String value) throws Exception;
    void update(String key, String value) throws Exception;
    void delete(String key) throws Exception;
    String get(String key) throws Exception;

    String startTransaction();
    void endTransaction(String version);
}
