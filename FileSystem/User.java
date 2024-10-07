package FileSystem;

import java.util.HashSet;

public class User {
    String name;
    HashSet<FileNode> files ;
    
    public User(String name){
        this.name = name;
        this.files = new HashSet<>();
    }

    public void userDeleteUser(){
        for(FileNode i : files){

        }
    }

    public void userDeleteFile(){
        
    }
}
