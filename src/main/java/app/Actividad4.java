package app;

import service.FileService;

public class Actividad4 {

    private static final String PATH = "/home/angel/Descargas/enteros.dat";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.insertIntegerInDataStreamFile(PATH);
    }
}
