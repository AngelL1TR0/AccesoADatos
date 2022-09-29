package dao;

import java.io.*;

public class FileDAOImpl implements FileDAO {

    @Override
    public File[] listFiles(String directorio) {
        File path = new File(directorio);
        return path.listFiles();
    }

    @Override
    public void rename(File file, String name) {
        file.renameTo(new File(name));
    }

    @Override
    public boolean createNewFile(File file) throws IOException {
        return file.createNewFile();
    }
    @Override
    public void insertTextIntoFile(File file, String text) {
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(text);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readTextInFile(File file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)){
            String text = "";
            String line;
            System.out.printf("Lectura del fichero %s: \n", file.getName());
            while((line=br.readLine())!=null) {
                text += line + "\n";
            }
            return text;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readIntInFile(File file) {
        try(FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader)){
            int nums = 0;
            System.out.println(file.getName()+":");
            while ((br.readLine()) != null){
                nums += nums;
            }
            return nums;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
