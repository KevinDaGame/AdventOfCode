import java.awt.*;
import java.util.ArrayList;

public class MovementHandler {
    private int depth;
    private int hPos;
    private int aim;
    public MovementHandler(ArrayList<String> list) {
        part1(list);
        part2(list);
    }

    private void part1(ArrayList<String> list) {
        System.out.println("Part 1: ");
        for (String line : list){
            if(line.contains("forward")){
                line = line.substring(8);
                hPos += Integer.parseInt(line);
            }
            else if(line.contains("up")){
                line = line.substring(3);
                depth -= Integer.parseInt(line);
            }
            else if(line.contains("down")){
                line = line.substring(5);
                depth += Integer.parseInt(line);
            }

        }

        System.out.println("depth = " + depth);
        System.out.println("Horizontal position = " + hPos);
        System.out.println("Total = " + depth * hPos);
    }

    private void part2(ArrayList<String> list) {
        depth = 0;
        hPos = 0;
        System.out.println("Part 2: ");
        for (String line : list){
            if(line.contains("forward")){
                line = line.substring(8);
                hPos += Integer.parseInt(line);
                depth += Integer.parseInt(line) * aim;
            }
            else if(line.contains("up")){
                line = line.substring(3);
                aim -= Integer.parseInt(line);
            }
            else if(line.contains("down")){
                line = line.substring(5);
                aim += Integer.parseInt(line);
            }

        }

        System.out.println("depth = " + depth);
        System.out.println("Horizontal position = " + hPos);
        System.out.println("Total = " + depth * hPos);
    }
}

