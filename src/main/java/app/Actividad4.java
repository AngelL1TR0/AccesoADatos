package app;

import service.FileService;

public class Actividad4 {

    private static final String PATH = "/angel/Descargas/enteros.dat";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.insertNum(PATH);
    }
}
