package pckg_batch_processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Record;
import java.util.ArrayList;
import java.util.List;

public class JSONFileParser implements FileParser {
    @Override
    public List<Record> parseFile(File file) {
        List<Record> records = new ArrayList<>();
        try(FileReader fileReader = new FileReader(file)) {
            JsonReader jsonReader = Json.createReader(fileReader);
            JsonObject jsonObject = jsonReader.readObject();
            for(String courseName : jsonObject.keySet()){
                Json studentArray = jsonObject.getJsonArray(courseName);
                List<StudentRecord> students = new ArrayList<>();
                for(JsonValue studentValue : studentsArray){
                    JsonObject studentObject = studentValue.asJsonObject();
                    String name = studentObject.getString("name");
                    String id = studentObject.getString("id");
                    StudentRecord studentRecord = new StudentRecord(id, name);
                    students.add(studentRecord);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Some I/O exception while using a file!");
        }
        return records;
    }
}
