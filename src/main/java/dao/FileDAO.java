package dao;


import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileDAO {

    public File[] listFiles(String directory);

    void rename(File file, String name);

    void insertIntoDataStreamFile(int numero, File file) throws IOException;

    void showDataStreamFile(File file);

    void insertTextIntoFile(File file, String text);

    void readTextInFile(File file, String text);

    void updateIntegerInStreamFile(File file, int num, int pos) throws IOException;
}