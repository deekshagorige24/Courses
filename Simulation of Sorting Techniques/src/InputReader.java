
import java.util.*;
import java.io.*; 
/**
 * This file reads record from CSV file and converts it to a list.
 * @author sumitha
 *
 */
public class InputReader{
    public static List<Float> readCSV(String csvFile, int numberOfData) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Float> values = new ArrayList<Float>();
        int index = 0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            while ((line = br.readLine()) != null && index<numberOfData) {

               
                String[] column = line.split(cvsSplitBy);
                values.add(Float.parseFloat(column[0]));
                index++;
            }
            return values;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return values;
    }
}