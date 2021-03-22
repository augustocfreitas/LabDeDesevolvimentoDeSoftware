package sistemaDeMatriculas.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private File file;
    private FileOutputStream fos;
    private ObjectOutputStream outputFile;
    private ArrayList<ObjectWithID> objects;

    public DAO(String filename) {
        try {
            objects = new ArrayList<>();
            file = new File(filename);

            close();
            readFromFile();
        } catch (IOException e) {
            System.out.println("ERRO ao inicializar objeto!");
        }
    }

    private List<ObjectWithID> readFromFile() {
        ObjectWithID object = null;

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream inputFile = new ObjectInputStream(fis)) {

            while (fis.available() > 0) {
                object = (ObjectWithID)inputFile.readObject();
                objects.add(object);
            }
        } catch (Exception e) {
            System.out.println("ERRO ao ler arquivo no disco!");
            e.printStackTrace();
        }
        return objects;
    }

    private void saveToFile() {
        try {
            close();
            fos = new FileOutputStream(file, false);
            outputFile = new ObjectOutputStream(fos);

            for (ObjectWithID object : objects) {
                outputFile.writeObject(object);
            }
            outputFile.flush();
        } catch (Exception e) {
            System.out.println("ERRO ao gravar arquivo no disco!");
            e.printStackTrace();
        }
    }

    private int getNextId() {
        if (objects == null) {
            return 0;
        } else if (objects.isEmpty()) {
            return 1;
        }

        return objects.get(objects.size() - 1).getId() + 1;
    }

    private void close() throws IOException {
        if (outputFile != null) {
            outputFile.close();
            fos.close();
            outputFile = null;
            fos = null;
        }
    }

    public void create(ObjectWithID object) {
        try {
            objects.add(object);
            saveToFile();
        } catch (Exception e) {
            System.out.println("ERRO ao salvar o arquivo no disco!");
            e.printStackTrace();
        }

    }

    public ObjectWithID get(int id) {
        for (ObjectWithID object : objects) {
            if (object.getId() == id) {
                return object;
            }
        }

        return null;
    }

    public int getIndex(int id) {
        for (int i = 0; i < objects.size(); i++) {
            ObjectWithID object = objects.get(i);

            if (object.getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public ArrayList<ObjectWithID> getAll() {
        return objects;
    }

    public void update(ObjectWithID object) {
        int objectIndex = getIndex(object.getId());

        objects.set(objectIndex, object);
    }

    public void delete(ObjectWithID object) {
        int objectIndex = getIndex(object.getId());

        objects.remove(objectIndex);
    }
}
