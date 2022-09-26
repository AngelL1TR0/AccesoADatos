package dao;

import java.io.File;

public interface FileDAO {

    public File[] listFiles(String directory);

    void rename(File file, String name);

    boolean createFile(File file);

    void InsertTextInFile(File file, String text);
}
