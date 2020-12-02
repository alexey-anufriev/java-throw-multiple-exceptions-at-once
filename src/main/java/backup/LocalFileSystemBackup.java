package backup;

public class LocalFileSystemBackup implements Backup {

    @Override
    public void save() throws Exception {
        throw new Exception("Local Storage is full");
    }

}
