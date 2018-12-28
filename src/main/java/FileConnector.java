import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class FileConnector implements Connectable {
    private static final String fileName = "data.txt";
    private static String line = null;

    private static final FileConnector instance = new FileConnector();

    static public FileConnector getInstance() {
        return instance;
    }

    private FileConnector() {}

    public ObservableList<Data> viewHistory() {
        ObservableList<Data> datas = FXCollections.observableArrayList();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] tmp = line.split(" ");
                datas.add(new Data(tmp[0], tmp[1], tmp[2]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    public void add(String type, String detail, String amount) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(type + " " + detail + " " + amount);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
