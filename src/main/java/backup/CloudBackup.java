package backup;

public class CloudBackup implements Backup {

    @Override
    public void save() throws Exception {
        throw new Exception("Cloud storage is not accessible");
    }

}
