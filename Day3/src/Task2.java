import java.util.ArrayList;

public class Task2 extends Task1 {

    int l=323;
    int width=31;

    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day3/src/Input.txt";
        ArrayList<String> map=new ArrayList<>();
        int tree_conuter=0;
        Task2 task= new Task2();

        // Auslesen der Datei und Fahrenlassen des Schlittens
        map=task.readFile(file);
        tree_conuter=task.ride_1(map);
        tree_conuter=tree_conuter*task.ride_2(map);
        tree_conuter=tree_conuter*task.ride_3(map);
        tree_conuter=tree_conuter*task.ride_4(map);
        tree_conuter=tree_conuter*task.ride_5(map);
        System.out.println("Das Produkt aus den jeweiligen getroffeneb Bäumen isst: "+tree_conuter);


    }
    public int ride_1(ArrayList<String> map){
        // ride function for a slope of 1 down and 1 right
        return ride(map,1,1 );
    }
    public int ride_3(ArrayList<String> map){
        // ride function for a slope of 1 down and 5 right
        return ride(map,1,5 );
    }

    public int ride_4(ArrayList<String> map){
        // ride function for a slope of 1 down and 7 right
        return ride(map,1,7 );
    }

    public int ride_5(ArrayList<String> map){
        // ride function for a slope of 2 down and 1 right
        return ride(map,2,1 );
    }


}
