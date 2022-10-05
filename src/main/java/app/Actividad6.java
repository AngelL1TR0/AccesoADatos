package app;

import service.FileService;

public class Actividad6 {

    private static final String PATH = "/angel/Documentos";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.createExcell(PATH);
    }
}
