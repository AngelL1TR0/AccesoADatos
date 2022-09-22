package service;

import dao.FileDAO;
import dao.FileDAOImpl;
import entity.Fichero;

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
}
