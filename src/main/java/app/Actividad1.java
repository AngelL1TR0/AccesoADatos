package app;

import exception.FileWithoutExtensionException;
import service.FileService;

public class Actividad1 {
    private static final String PATH = "C:\\temp\\ad\\ut2\\actividad1";

    public static void main(String[] args) {
        FileService myServiceFile = new FileService();
        myServiceFile.listFiles(PATH);

    }

}

