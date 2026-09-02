package all_in_one;

import javax.swing.*;
import java.io.*;

public class IOUtils {

    public static void saveTxTDataToFile(File file, String data){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(data);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Can not write to a file!", "Write error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static String importTxtDataFromFile(File file){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = null;
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine())!= null){
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"File not found!", "File missing error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Can not read from a file!", "File IO error", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }
}
