import java.util.HashMap;
import java.util.Random;

public class IDStorageImp implements IDStorage{

    static HashMap<String, String> map = new HashMap<>(); //for main branch
    static Random random = new Random(); 
    static String currentSessionId = "";
    static boolean commitActive = false;

    public void printMap(){
        System.out.println("\nMap =>");
        for(String i: map.keySet()){
            System.out.println(i + " " + map.get(i));
        }
    }

    @Override
    public void save(String key, String value) throws Exception {
        if(!map.containsKey(key)){
            map.put(key, value);
        }else{
            throw new Exception("Key already exists in the map");
        }
    }
    
    @Override
    public void update(String key, String value) throws Exception{
        if(map.containsKey(key)){
            map.put(key, value);
        }else{
            throw new Exception("Key is not exists in the map");
        }
    }
    
    @Override
    public void delete(String key) throws Exception{
        if(map.containsKey(key)){
            map.remove(key);
        }else{
            throw new Exception("Key is not exists in the map");
        }
    }
    
    @Override
    public String get(String key) throws Exception{
        if(map.containsKey(key)){
            return map.get(key);
        }else{
            throw new Exception("Key is not exists in the map");
        }
    }

    @Override
    public String startTransaction(){
        
        StringBuilder versionNumberstrb = new StringBuilder();
        for(int i = 0; i < 256; i ++){
            versionNumberstrb.append((char)('a' + random.nextInt(26)));
        }

        String versionNumber = versionNumberstrb.toString();
        return versionNumber;
    }

    @Override
    public void endTransaction(String versionNumber){

        //delete
        IDStorageImp.currentSessionId = versionNumber;
        
    }

    

    
}
