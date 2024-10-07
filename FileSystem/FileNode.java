package FileSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class FileNode {

    String name;
    boolean isFile;
    String content;
    Map<String, FileNode> children;
    Set<String> owner;
    FileNode pre;

    FileNode(String Name, boolean isFile) {
        this.name = Name;
        this.isFile = isFile;
        this.content = "";
        this.children = new HashMap<>();
        this.owner = new HashSet<>();
    }

    public void create(String content){
        this.content = content;
    }

    public String read(){
        if(isFile){
            return content;
        }
        else{
            return "";
        }
    }

    public boolean delete(){
        if(isFile){
            //delete all user's reference
        }


    }

}
