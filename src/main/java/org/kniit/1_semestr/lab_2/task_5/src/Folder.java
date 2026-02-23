import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{
    private ArrayList<FileSystemComponent> FilesList = new ArrayList<>();
    private String Name;

    public Folder(String Name){
        this.Name = Name;
    }
    @Override
    public String getName()
    {
        return Name;
    }
    @Override
    public int getSize(){
        int counter = 0;
        for (FileSystemComponent file : FilesList)
        {
            counter += file.getSize();
        }
        return counter;
    }

    @Override
    public void add(FileSystemComponent component){
        FilesList.add(component);
    }
    @Override
    public void remove(FileSystemComponent component){
        FilesList.remove(component);
    }
    @Override
    public void display(String indent ){
        System.out.println(indent + getName());
        for (FileSystemComponent file : FilesList)
        {
            file.display(indent + " ");
        }
    }
}
