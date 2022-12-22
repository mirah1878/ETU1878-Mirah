package function;

import main.Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Function {
    public static int manisaline(String nomfile) throws IOException {
        Path path = Paths.get(nomfile);
        int nbline = 0;

        nbline = (int) Files.lines(path).count();
        return nbline;
    }

    public static String[][] getData(String filename) throws Exception{
        int nbLine = manisaline(filename);
        String[][] data = new String[nbLine][2];

        FileReader read = new FileReader(filename);
        BufferedReader br = new BufferedReader(read);
        int i=0;
        String line = br.readLine();
        while(line != null){
            data[i] = line.split("///");
            line = br.readLine();
            i++;
        }

        return data;
    }

    public static void createFile(File file) throws IOException {
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    public static void enregistrer(String message, String nomfile) throws IOException{
        File file = new File(nomfile+".txt");

        FileWriter writer = new FileWriter(file,true);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String verif = bufferedReader.readLine();
        if (verif!= null){
            bufferedWriter.write("\n");
        }

        bufferedWriter.write(message);
        bufferedWriter.close();
    }
}
