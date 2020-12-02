package backup;

public class BackupManager {

    public static void main(String[] args) throws Exception {
        LocalFileSystemBackup localFileSystemBackup = new LocalFileSystemBackup();
        ExternalFileSystemBackup externalFileSystemBackup = new ExternalFileSystemBackup();
        CloudBackup cloudBackup = new CloudBackup();

        Exception executionException = null;

        // try to backup to local storage
        try {
            localFileSystemBackup.save();
        }
        catch (Exception e) {
            executionException = chainExceptions(executionException, e);
        }

        // try to backup to external storage
        try {
            externalFileSystemBackup.save();
        }
        catch (Exception e) {
            executionException = chainExceptions(executionException, e);
        }

        // try to backup to cloud
        try {
            cloudBackup.save();
        }
        catch (Exception e) {
            executionException = chainExceptions(executionException, e);
        }

        if (executionException != null) {
            throw executionException;
        }
    }

    private static Exception chainExceptions(Exception suppressed, Exception suppressor) {
        if (suppressed == null && suppressor == null) {
            return null;
        }

        if (suppressed == null) {
            return suppressor;
        }

        if (suppressor == null) {
            return suppressed;
        }

        suppressor.addSuppressed(suppressed);
        return suppressor;
    }

}
