package KVTransaction;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IDStorageSession extends IDStorageImp{
    private String sessionId;
    private String currentSessionId;
    private HashMap<String, String> map = new HashMap<>();
    private List<String> deleteList = new LinkedList<>();
    

    @Override
    public void save(String key, String value) throws Exception {
        if(!IDStorageImp.map.containsKey(key) && !map.containsKey(key)){
            map.put(key, value);
        }else{
            throw new Exception("Key already exists in the map");
        }
    }
    
    @Override
    public void update(String key, String value) throws Exception{
        if(IDStorageImp.map.containsKey(key) || map.containsKey(key)){
            map.put(key, value);
        }else{
            throw new Exception("Key is not exists in the map");
        }
    }
    
    @Override
    public void delete(String key) throws Exception{
        if(IDStorageImp.map.containsKey(key) || map.containsKey(key)){
            if(map.containsKey(key))
                map.remove(key);
            deleteList.add(key);
        }else{
            throw new Exception("Key is not exists in the map");
        }
    }
    
    @Override
    public String get(String key) throws Exception{
        if(map.containsKey(key)){
            return map.get(key);
        }else if(IDStorageImp.map.containsKey(key)){
            return IDStorageImp.map.get(key);
        }
        else{
            throw new Exception("Key is not exists in the map");
        }
    }


    public void TRANS(){
        this.sessionId = startTransaction();
        this.currentSessionId = IDStorageImp.currentSessionId;
    }

    public void COMMIT(){
        if(IDStorageImp.currentSessionId.equals(currentSessionId) && !IDStorageImp.commitActive){
            IDStorageImp.commitActive = true;
            for(String i : map.keySet()){
                IDStorageImp.map.put(i, map.get(i));
            }
            for(String i : deleteList){
                if(IDStorageImp.map.containsKey(i)){
                    IDStorageImp.map.remove(i);
                }
            }
            IDStorageImp.commitActive = false;
            endTransaction(sessionId);
        }else{
            ROLLBACK();
            System.out.println("COMMIT failure " + "Session id is: " + sessionId);
        }
        // set to 1 and check then setback to 0, otherwise rollback
    }

    public void ROLLBACK(){
        // delete map don't need change
        
        return;
    }
}
