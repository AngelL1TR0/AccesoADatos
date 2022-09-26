package app;

import exception.FileWithoutExtensionException;
import service.FileService;

public class Actividad2 {
    private static final String PATH = "C:\\temp\\ad\\ut2\\actividad1";

    public static void main(String[] args) throws FileWithoutExtensionException {
        FileService myServiceFile = new FileService();
        myServiceFile.renameFilesWithPermissions(PATH);

    }
}
