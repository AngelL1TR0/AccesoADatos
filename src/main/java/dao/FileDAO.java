package dao;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileDAO {

    public File[] listFiles(String directory);

    void rename(File file, String name);

    boolean createNewFile(File file) throws IOException;

    void insertTextIntoFile(File file, String text);

    String readTextInFile(File file);

    int readIntInFile(File file) throws FileNotFoundException;
}
