import java.util.ArrayList;

public class Task2 extends Task1 {

    int length = 908;

    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day5/src/Input.txt";
        ArrayList<BoardingPass> boardingPasses = new ArrayList<>();
        Task2 task2 = new Task2();
        int SeatID = 0;

        //Methodes
        boardingPasses = task2.decode(task2.readfile(file));
        SeatID = task2.my_SeatID(boardingPasses);
        System.out.println("My Seat ID is: " + SeatID);
    }

    public int my_SeatID(ArrayList<BoardingPass> boardingPasses) {
        int maxSeatID = 953;
        int l = boardingPasses.size();
        int SeatID_m = 0;
        int SeatID_1 = 0;

        ArrayList<Integer> SeatID = new ArrayList<Integer>();

        //fluten einer ArrayListe mit allen möglichen SeatIDs
        for (int i = 0; i < maxSeatID; i++) {
            SeatID.add(i);
        }

        //entfernen der belegten Sitze
        for (int i = 0; i < l; i++) {
            SeatID_1 = boardingPasses.get(i).SeatID;
            for (int j = 0; j < SeatID.size(); j++) {
                if (SeatID_1 == SeatID.get(j)) {
                    SeatID.remove(j);
                }
            }

        }

        for (int i = 0; i < SeatID.size(); i++) {

            SeatID_1 = SeatID.get(i);
            if (i != 0 && i != SeatID.size() - 1) {
                if (SeatID.get(i - 1) != SeatID_1 - 1 && SeatID.get(i + 1) != SeatID_1 + 1) {
                    SeatID_m = SeatID_1;
                }
            } else if (SeatID.size() - 1 == i) {
                if (SeatID.get(i - 1) != SeatID_1 - 1) {
                    SeatID_m = SeatID_1;
                }
            }
        }


        return SeatID_m;
    }
}
