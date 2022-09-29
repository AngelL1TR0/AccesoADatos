package app;

import service.FileService;

import java.io.File;

public class Actividad3 {

    //Direccion de tu ordenador
    private static final String PATH = "/angel/Documentos";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.insertTextInFile(PATH);
    }
}
