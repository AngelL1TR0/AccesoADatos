package app;

import service.FileService;

import java.io.File;

public class Actividad7 {

    private static final String PATH = "/home/angel/Documentos/";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.readFile(PATH);
    }
}
