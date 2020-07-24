import java.util.*;
import java.io.*;

class Database {
    private Map<String, Integer> map;

    Database() {
        map = new HashMap<>();
        //May add in the functionality of reading from external file
        //to populate the database
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
            System.out.println("Created");
        } else {
            System.out.println("Existed");
        }

        map.entrySet().stream().forEach(entry -> {
            try {
                FileWriter file = new FileWriter(myFile, true);
                file.write(entry.getKey() + ":" + Integer.toString(entry.getValue()) + System.lineSeparator());
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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