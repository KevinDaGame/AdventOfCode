import java.util.ArrayList;
import java.util.Arrays;

public class Bingo {
    private ArrayList<Integer> numbers;
    private ArrayList<Board> boards;
    public Bingo(ArrayList<String> values) {
        numbers = new ArrayList<>();
        boards = new ArrayList<>();
        for(int i = 0; i< values.size(); i++){
            if(i == 0){

                for(String s: values.get(0).split(",")){
                    numbers.add(Integer.parseInt(s));
                }
            }
            else{
                if(!values.get((i)).equals("")){
                    int[][] board = new int[5][5];

                    for(int j = 0; j < 5; j++){
                        String[] row = Arrays.stream(values.get(i + j).split(" ")).filter(value -> value.length() != 0).toArray(size -> new String[size]);
                        for(int k =0; k < 5; k++){
                            board[j][k] = Integer.parseInt(row[k]);
                        }
                    }
                    boards.add(new Board(board));
                    i += 4;
                }
            }
        }
        findLastWinner();
    }

    private void findFirstWinner() {
        Board winner;
        for(int number: numbers){
            winner = loopBoards(number);
            if(winner != null){
                winner.printBoard();
                System.out.println("value = " + winner.getSum() * number);
                break;
            }
        }
    }

    private void findLastWinner(){
        Board lastWinner = null;
        int lastNumber = 0;
        for(int number: numbers){
            lastNumber = number;
            ArrayList<Board> winners = lastLoopBoards(number);
            for(Board winner : winners){

                if(winner != null){
                    lastWinner = winner;
                    if(boards.size() < 10){
                        System.out.print("");
                    }
                    if(boards.size() > 1){

                    boards.remove(winner);
                    }
                    else{
                        lastWinner.printBoard();
                        System.out.println("value = " + lastWinner.getSum() * lastNumber);
                        return;
                    }
                }
            }
        }
    }
    private Board loopBoards(int number){
        for(Board board: boards){
            board.drawNumber(number);
            if(board.hasBingo()) {
                return board;
            }
        }
        return null;
    }

    private ArrayList<Board> lastLoopBoards(int number){
        ArrayList<Board> winners = new ArrayList<>();
        for(Board board: boards){
            board.drawNumber(number);
        }
        for(Board board : boards){
            if(board.hasBingo()){
                winners.add(board);
            }
        }
        return winners;
    }


}
