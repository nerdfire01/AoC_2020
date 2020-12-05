import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task1 {

    int length=908;

    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day5/src/Input.txt";
        ArrayList<BoardingPass> boardingPasses=new ArrayList<>();
        Task1 task1 = new Task1();
        int SeatID=0;

        //Methodes
        boardingPasses = task1.decode(task1.readfile(file));
        SeatID=task1.highest_SeatID(boardingPasses);
        System.out.println("The highest SeatID is: "+SeatID);
    }

    public ArrayList<String> readfile(String file) {
        ArrayList<String> input = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < length; i++) {
                String h1 = new String();
                h1 = reader.readLine();
                input.add(h1);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return input;
    }

    public ArrayList<BoardingPass> decode(ArrayList<String> input){
        ArrayList<BoardingPass> boardingPasses=new ArrayList<>();
        String h1;
        String h2;

        for(int i=0; i<length; i++){
            h1=input.get(i).substring(0,7);
            h2=input.get(i).substring(7,10);
            System.out.println(h1);
            System.out.println(h2);

            BoardingPass boardingPass=new BoardingPass();
            boardingPass.row=boardingPass.row(h1);
            boardingPass.column=boardingPass.column(h2);

            boardingPasses.add(boardingPass);

        }

        return boardingPasses;
    }

    public int highest_SeatID(ArrayList<BoardingPass> boardingPasses){
        int SeatID=0;
        int l=boardingPasses.size();
        for(int i=0; i<l;i++){
            int produkt=(boardingPasses.get(i).column)+(boardingPasses.get(i).row)*8;
            if(produkt>SeatID){
                SeatID=produkt;
            }

        }

        return SeatID;
    }
}
