import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> values = readFile(new File("src/input.txt"));
        Bingo bingo = new Bingo(values);
//        Board board = new Board();
//        board.setFields(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}});
//        board.drawNumber(1);
//        System.out.println(board.hasBingo());
//        board.drawNumber(2);
//        System.out.println(board.hasBingo());
//        board.drawNumber(3);
//        System.out.println(board.hasBingo());
//        board.drawNumber(4);
//        System.out.println(board.hasBingo());
//        board.drawNumber(5);
//        System.out.println(board.hasBingo());
    }

    private static ArrayList<String> readFile(File input) {
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
