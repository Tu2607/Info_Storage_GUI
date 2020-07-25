import java.util.*;
import java.io.*;

class Database {
    private Map<String, Integer> map;

    Database() {
        map = new HashMap<>();
        // May add in the functionality of reading from external file
        // to populate the database
    }

    public void Insert(String name, Integer age) {
        try {
            if (name instanceof String && age instanceof Integer) {
                map.put(name, age);
                Window.alertBox(1);
            } else {
                Window.alertBox(0);
            }

        } catch (Exception e) {
            System.out.print("Can't add to map");
        }
    }

    public void writeOut() throws IOException {
        File myFile = new File("data.txt");
        FileWriter file = new FileWriter(myFile, true);
        // This if/else is for testing
        if (myFile.createNewFile()) {
            System.out.println("Created");
        } else {
            System.out.println("Existed");
        }

        map.entrySet().stream().forEach(entry -> {
            try {
                file.write(entry.getKey() + ":" + Integer.toString(entry.getValue()) + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                Window.alertBox(2);
            }
        });
        file.close();
    }

    public List<String> search(String name){
        List<String> result = new ArrayList<String>();
        map.entrySet().stream().forEach(entry -> {
            if(entry.getKey().equals(name)){
                String str = entry.getKey() + "," + entry.getValue();
                result.add(str);
            }
        }
        );
        return result;
    }
}