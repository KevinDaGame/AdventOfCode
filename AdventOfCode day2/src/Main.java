import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        File input = new File("src/input.txt");
        ArrayList<String> list = getValues(input);
        MovementHandler handler = new MovementHandler(list);
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
