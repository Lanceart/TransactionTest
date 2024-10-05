
// implment a kv-store

/***
 * save(1,1)
 * get(1) : 1
 * 
 * Start Tran
 * save(2: 2)
 * save(1: 2)
 * get(1): 2
 * COMMIT()
 * 
 * Start Tran
 * save(2,3)
 * ROLLBACK()
 *  
 ***/
public class Main {

    
    public static void main(String[] args) {
        // Create an instance
        IDStorage storage = new IDStorageImp();
 
        try{
        // Part I
        // test1 basic CRUD
        System.out.println("=========Test1=========");
        storage.save("1", "1");
        storage.save("2", "1");
        storage.save("3", "1");
        storage.delete("3");
        ((IDStorageImp)storage).printMap();

        // Part II
        // TRAN will start a transaction
        // COMMIT will submit the changes
        // ROLLBACK
        // a set to store current version changes
        // and a local hashmap

        // test2 transaction COMMIT
        System.out.println("=========Test2=========");
        IDStorageSession session1 = new IDStorageSession();
        session1.TRANS();
        session1.update("2", "2");
        session1.COMMIT();

        ((IDStorageImp)storage).printMap();


        //test3 transaction ROLLBACK
        System.out.println("=========Test3=========");
        IDStorageSession session2 = new IDStorageSession();
        session2.TRANS();
        session2.save("3", "3");
        session2.ROLLBACK();

        ((IDStorageImp)storage).printMap();


        //test4 transaction failure
        System.out.println("=========Test4=========");
        IDStorageSession session3 = new IDStorageSession();
        IDStorageSession session4 = new IDStorageSession();
        session3.TRANS();
        session4.TRANS();
        session3.save("4", "4");

        session4.save("5", "5");
        session4.COMMIT();
        session3.COMMIT();

        ((IDStorageImp)storage).printMap();
        
    }
        catch(Exception e){
            System.out.println("error:  " + e);
        }

    }
}