public class BoardingPass {

    int row;
    int column;
    int SeatID;

    public static void main(String[] args) {
        BoardingPass bp = new BoardingPass();
    }

    public int row(String decode_1) {
        int row_1 = 0;
        double z = 6;
        for (int i = 0; i < 7; i++) {
            if (decode_1.charAt(i) == 'B') {
                row_1 = (int) (row_1 + Math.pow(2.0, z));
            }
            z--;

        }

        return row_1;
    }

    public int column(String decode_2) {
        int column_1 = 0;
        double z = 2;
        for (int i = 0; i < 3; i++) {
            if (decode_2.charAt(i) == 'R') {
                column_1 = (int) (column_1 + Math.pow(2.0, z));
            }
            z--;

        }

        return column_1;
    }
}
