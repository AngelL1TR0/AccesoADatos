package service;

import dao.FileDAO;
import dao.FileDAOImpl;
import entity.FileEntity;
import exception.FileWithoutExtensionException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileService {

    FileDAO fileDAO = new FileDAOImpl();

    public void listFiles(String path){
        File[] files = fileDAO.listFiles(path);
        for (File file : files) {
            FileEntity fileEntity = new FileEntity(file.getName());
            if (file.isDirectory()){
                fileEntity.setType("directorio");
            } else {
                fileEntity.setType("fichero");
            }
            System.out.println("El fichero " + fileEntity.getName() + " es un " + fileEntity.getName());
        }
    }

    public void renameFilesWithPermissions(String path) throws FileWithoutExtensionException {
        File[] files = fileDAO.listFiles(path);
        for (File file : files) {
            FileEntity fileEntity = new FileEntity(file.getName());
            setPermissions(fileEntity, file);
            if (!fileEntity.getPermissions().equals("_")){
                String[] extensionAndPath = getExtensionAndPathFromFile(file);
                fileDAO.rename(file, extensionAndPath[1] + fileEntity.getPermissions() + extensionAndPath[0]);
            }
        }
    }

    private String[] getExtensionAndPathFromFile(File file) throws FileWithoutExtensionException {
        String[] retorno = new String[2];
        int i = file.getAbsolutePath().lastIndexOf(".");
        if (i>0){
            //extension
            retorno[0] = file.getAbsolutePath().substring(i);
            retorno[1] = file.getAbsolutePath().substring(0, i);
        } else {
            throw new FileWithoutExtensionException("El fichero no tiene extension");
        }
        return retorno;
    }

    private void setPermissions(FileEntity fichero, File file) {
        String permissions = "_";
        permissions = file.canRead() ? permissions + "R" : permissions;
        permissions = file.canWrite() ? permissions + "W" : permissions;
        permissions = file.canRead() ? permissions + "X" : permissions;
        fichero.setPermissions(permissions);
    }

    public void insertTextInFile(String path) {
        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Introduce un nombre para el fichero: ");
            String fileName = sc.nextLine();
            File file = new File(path + fileName + ".txt");
            if (file.createNewFile()){
                System.out.println("Introduce un texto: ");
                String text = sc.nextLine();
                fileDAO.insertTextIntoFile(file, text);
                fileDAO.readTextInFile(file, text);
            } else {
                System.out.println("The file cannot be created");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void insertIntegerInDataStreamFile(String path) {
        try (Scanner sc = new Scanner(System.in)){
            File file = new File(path);
            fileDAO.showDataStreamFile(file);
            System.out.println("Introduce un numero entero: ");
            int numero = sc.nextInt();
            fileDAO.insertIntoDataStreamFile(numero, file);
            fileDAO.showDataStreamFile(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void modIntegerInDataStreamFile(String path) {
        File file = new File(path);
        try(Scanner sc = new Scanner(System.in)){
            fileDAO.showDataStreamFile(file);
            System.out.println("Introduce la posicion a modificar");
            int pos = sc.nextInt();
            if(pos > 0 && pos <= file.length() / 4){
                System.out.println("Que numero quieres introducir");
                int num = sc.nextInt();
                fileDAO.updateIntegerInStreamFile(file,num, pos -1);
                System.out.println("Nuevo archivo:");
                fileDAO.showDataStreamFile(file);
            } else {
                System.out.println("La posicion no existe");
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public void createExcell(String path) {
        File file = new File(path + ".xlsx");

    }
}