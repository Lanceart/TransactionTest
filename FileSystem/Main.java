package FileSystem;

public class Main {

    //1. store file, and users
    //2. create file by user, default is admin
    //3. grant file to user
    //4. delete file
    //5. delete user
    public static void main(String[] args) {
        //test1  create file and users by admin
        FileSystem fileSystem = new FileSystem();
        fileSystem.create("apple.txt", true);
        fileSystem.cat("apple.txt");
        
        //test2 create file by users

        //test3 grant file to other user

        //test4 delete file

        //test5 delete user
        
    }
}
