package FileSystem;
import java.util.*;
public class FileSystem {
    
    private static FileNode root;
    private HashSet<User> user;

    public FileSystem(){
        root = new FileNode(null, false);
    }

    public void create(String path, boolean isFile){

    }

    public String readFile(String path){
        return "";
    }

    public void writeFile(String path, String content){

    }

    public List<String> ls(String path, String content){

    }

    public void cd(String path){

    }


}
