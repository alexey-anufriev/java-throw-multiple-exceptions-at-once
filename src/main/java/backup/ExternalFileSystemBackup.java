package backup;

public class ExternalFileSystemBackup implements Backup {

    @Override
    public void save() throws Exception {
        throw new Exception("External Storage is not mounted");
    }

}
