

public class File implements FileSystemComponent{
    private int Size;
    private String Name;

    public File(String Name, int Size){
        this.Name = Name;
        this.Size = Size;
    }
    @Override
    public String getName()
    {
        return Name;
    }
    @Override
    public int getSize(){
        return Size;
    }

    @Override
    public void add(FileSystemComponent component){
        throw new UnsupportedOperationException("Нельзя добавлять компоненты в файл.");
    }
    @Override
    public void remove(FileSystemComponent component){
        throw new UnsupportedOperationException("Нельзя удалять компоненты из файла.");
    }
    @Override
    public void display(String indent ){
        System.out.println(indent + Name + " (" + Size + " bytes)");
    }
}
