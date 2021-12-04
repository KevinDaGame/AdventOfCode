public class Board {
    private int[][] fields = new int[5][5];

    public Board(int[][] board) {
        this.fields = board;
    }

    public int[][] getFields() {
        return fields;
    }

    public void setFields(int[][] fields) {
        this.fields = fields;
    }

    public void drawNumber(int value) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j] == value) {
                    fields[i][j] = -1;
                }
            }
        }
    }

    public boolean hasBingo() {
        for (int i = 0; i < fields.length; i++) {
            boolean bingo = true;
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j] != -1) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) return true;
        }
        for (int j = 0; j < fields.length; j++) {
            boolean bingo = true;
            for (int i = 0; i < fields[j].length; i++) {
                if (fields[i][j] != -1) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++){
                System.out.print(fields[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getSum() {
        int sum = 0;
        for(int[] row: fields){
            for(int field: row){
                if(field != -1){
                    sum += field;
                }
            }
        }
        return sum;
    }
}
