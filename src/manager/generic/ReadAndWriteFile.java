package manager.generic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static <T> void writeToFile(List<T> list, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(list);
            fileOut.close();
            objOut.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static <T> List<T> readFromFile(String fileName) {
        List<T> list = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            list = (List<T>) objIn.readObject();
            fileIn.close();
            objIn.close();

        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
