package sistemaDeMatriculas.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DAO {
    public static void writeToFile(String filename, ArrayList entities) {
        try {
            FileWriter file = new FileWriter(filename, false);
            entities.forEach(entity -> {
                try {
                    file.write(entity.toString());
                    file.write("\n");
                } catch (IOException e) {
                    System.out.println("Erro ao escrever no arquivo");
                }
            });

            file.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> readFromFile(String filename) {
        var path = Paths.get(filename);

        try {
            return new ArrayList(Files.lines(path).collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
        }

        return null;
    }
}
