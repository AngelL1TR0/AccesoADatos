package service;

import dao.FileDAO;
import dao.FileDAOImpl;
import entity.Fichero;
import exception.FileWithoutExtensionException;

import java.io.File;

public class FileService {

    private final FileDAO fileDAO = new FileDAOImpl();

    public void listarFicheros(){
        File[] ficheros = fileDAO.listarFicheros("/home/angel");

        for (File file : ficheros) {
            Fichero fichero = new Fichero(file.getName());
            if(file.isDirectory()){
                fichero.setTipo("directorio");
            } else {
                fichero.setTipo("fichero");
            }
            System.out.println("El fichero " + fichero.getNombre() + " es un " + fichero.getTipo());
        }
    }

    public void renameFileWithPermission(String path){
        File[] files = fileDAO.listarFicheros(path);
        for (File file : files){
            Fichero fichero = new Fichero(file.getName());
            setPermissions(fichero, file);
            if (fichero.getPermisos().equals("_")){
                //renombrar
                String[] extensionAndPath = getExtensionAndPatth(file);
            }
        }
    }

    private String[] getExtensionAndPatth(File file) {
        String[] retorno = new String[2];
        String absolutePath = file.getAbsolutePath();
        int i = absolutePath.lastIndexOf(".");
        if (i > 0){
            retorno[0] = absolutePath.substring(i);
            retorno[1] = absolutePath.substring(0, i);
        } else {
            throw new FileWithoutExtensionException("El fichero no tiene extension");
        }
    }

    private void setPermissions(Fichero fichero, File file) {
        String permissions = "_";
        permissions = file.canRead() ? permissions + "R" : permissions;
        permissions = file.canWrite() ? permissions + "W" : permissions;
        permissions = file.canExecute() ? permissions + "X" : permissions;

        fichero.setPermisos(permissions);
    }
}
