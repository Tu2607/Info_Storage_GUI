import java.util.*;
import java.io.*;

class Database {
    private Map<String, Integer> map;

    Database() {
        map = new HashMap<>();
    }

    // Could as more check for variable typing
    public boolean Insert(String name, Integer age) {
        try {
            map.put(name, age);
            return true;
        } catch (Exception e) {
            System.out.print("Can't add to map");
            return false;
        }
    }

    public void writeOut() throws IOException {
        File myFile = new File("data.txt");

        // This if/else is for testing
        if (myFile.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File existed");
        }

        //map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()));
        map.entrySet().stream().forEach(entry -> {
            try {
                FileWriter file = new FileWriter(myFile, true);
                file.write(entry.getKey() + ":" + Integer.toString(entry.getValue()));
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}