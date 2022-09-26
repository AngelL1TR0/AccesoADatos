package dao;

import java.io.File;
import java.io.IOException;

public class FileDAOImpl implements FileDAO{

    @Override
    public File[] listFiles(String directorio) {
        File path = new File(directorio);
        return path.listFiles();
    }

    @Override
    public void rename(File file, String name) {
        file.renameTo(new File(name));
    }

    @Override
    public boolean createFile(File file) throws IOException {
        return file.createNewFile();
    }

    @Override
    public void InsertTextInFile(File file, String text) {

    }


}
