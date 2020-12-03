import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task1 {


    int l=323;
    int width=31;

    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day3/src/Input.txt";
        ArrayList<String> map=new ArrayList<>();
        int tree_conuter=0;
        Task1 task= new Task1();

        // Auslesen der Datei und Fahrenlassen des Schlittens
        map=task.readFile(file);
        tree_conuter=task.ride_1(map);
        System.out.println("Es werden "+tree_conuter+" Bäume getroffen.");


    }

    public ArrayList<String> readFile(String Filename) {
        ArrayList<String> map = new ArrayList<>();
        BufferedReader reader = null;


        try {
            reader = new BufferedReader(new FileReader(Filename));
            for (int i = 0; i < l; i++) {
                String h1=new String();
                h1 = reader.readLine();

                map.add(h1);

            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;

    }

    public int ride_1(ArrayList<String> map){
        return ride(map,1,3);
    }

    public int ride(ArrayList<String> map, int slope_d, int slope_r){
        int tree_counter=0;

        //some help Variables
        int position=0;

        for (int i=0; i<l; i=i+slope_d){

            if(position>=width){
                position=position%width;

            }

            if(map.get(i).charAt(position)=='#'){
                tree_counter++;
            }
            position=position+slope_r;

        }


        return tree_counter;
    }

}
