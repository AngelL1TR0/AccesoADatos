package dao;

import java.io.File;

public class FileDAOImpl implements FileDAO{

    @Override
    public File[] listarFicheros(String path) {
        File directorio = new File(path);
        return directorio.listFiles();
    }
}
