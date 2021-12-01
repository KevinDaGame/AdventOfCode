import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File input = new File("src/main/resources/input.txt");
        ArrayList<Integer> values = getValues(input);
        int count = getSingleElementGreaterThenCount(values);
        System.out.println("amount of single elements greater then previous: " + count);
        //1139
        count = getAvgOfThreeGreaterThenCount(values);
        System.out.println("amount of sums of 3 elements greater then previous: " + count);
        //1103
    }

    private static int getAvgOfThreeGreaterThenCount(ArrayList<Integer> input) {
        int count = 0;
        ArrayList<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            int sum = 0;
            if (i >= 2) {
                for (int j = i; j > i - 3; j--) {
                    sum += input.get(j);
                }
                sumList.add(sum);

            }
        }
        for(int i = 0; i < sumList.size(); i++){
            if (i > 0) {
                if (sumList.get(i) > sumList.get(i - 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int getSingleElementGreaterThenCount(ArrayList<Integer> input) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (i > 0) {
                if (input.get(i) > input.get(i - 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static ArrayList<Integer> getValues(File input) {
        ArrayList<Integer> values = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                values.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
            return values;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
