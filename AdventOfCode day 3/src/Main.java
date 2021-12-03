import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        File file = new File("src/input.txt");
        ArrayList<String> values = getValues(file);
        Decoder decoder = new Decoder();
        decoder.getHighAndLow(values);
        decoder.getLifeRating(values);
    }

    private static ArrayList<String> getValues(File input) {
        ArrayList<String> values = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                values.add(scanner.nextLine());
            }
            scanner.close();
            return values;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
