import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task1 {

    int length = 594;

    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day7/src/Input.txt";
        String color = "shiny gold";
        ArrayList<Lugage> lugages = new ArrayList<>();
        Task1 task1 = new Task1();
        int sum = 0;
        lugages = task1.decode(task1.readfile(file));
        sum = task1.count(task1.find_correct(lugages, color));
        System.out.println("Es gibt " + sum + " mögliche Farben der Taschen");
    }

    public ArrayList<String> readfile(String file) {
        ArrayList<String> input = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            for (int i = 0; i < length; i++) {
                String h1 = "";
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

    public ArrayList<Lugage> decode(ArrayList<String> input) {
        ArrayList<Lugage> lugages = new ArrayList<>();

        //some helping variables
        String h1;
        String h2;
        String color;
        int color_length;

        String h3;
        String h4;
        String h5;
        int number;
        String o_color;
        int o_color_length = 0;


        for (int i = 0; i < length; i++) {

            ArrayList<String> colors = new ArrayList<>();
            ArrayList<Integer> numbers = new ArrayList<>();

            //finden der Farbe des eigenen Gebäckstückes
            h1 = input.get(i).split(" ")[0];
            h2 = input.get(i).split(" ")[1];
            color = h1 + " " + h2;
            color_length = color.length() + 14;

            //Abspliten des voderen Teils
            h3 = input.get(i).substring(color_length);

            //Zählen, wie viele Kommas es gibt
            int kommas = 0;
            for (int j = 0; j < input.get(i).length(); j++) {
                if (input.get(i).charAt(j) == ',') {
                    kommas++;
                }
            }
            kommas++;

            //testen auf contains no
            if (!(h3.charAt(0) == 'n' && h3.charAt(1) == 'o')) {

                //durchführen für so viele einzelne Untertaschen, wie durch Komma herausgefunden wurde
                for (int m = 0; m < kommas; m++) {

                    //kürzen des Strings ab dem zweiten Durchlauf
                    if (m != 0) {
                        h3 = h3.substring(o_color_length);
                    }

                    //auftrennen des Strings
                    number = Integer.parseInt(h3.split(" ")[0]);
                    h4 = h3.split(" ")[1];
                    h5 = h3.split(" ")[2];
                    o_color = h4 + " " + h5;

                    //schreiben des counters und der Farbe in das jeweilige Array
                    numbers.add(number);
                    colors.add(o_color);
                    if (number == 1) {
                        o_color_length = o_color.length() + 8;
                    } else {
                        o_color_length = o_color.length() + 9;
                    }
                }
            }

            //Erstellen eines neuen Gebäckstückes und füllen dieses
            Lugage lugage = new Lugage();
            lugage.id = i;
            lugage.color = color;
            lugage.o_bags_color = colors;
            lugage.o_bags_number = numbers;
            lugages.add(lugage);

        }

        return lugages;

    }

    public ArrayList<String> find_correct(ArrayList<Lugage> lugages, String color_searched) {
        ArrayList<String> possible_color = new ArrayList<>();
        possible_color.add(color_searched);


//        for (int y = 0; y < lugages.size(); y++) {
//            System.out.println("Die " + lugages.get(y).color + "kann:");
//            for (int z = 0; z < lugages.get(y).o_bags_number.size(); z++) {
//                System.out.println(lugages.get(y).o_bags_number.get(z) + " Taschen, der Farbe " + lugages.get(y).o_bags_color.get(z));
//            }
//        }

        //Der Durchlauf h
        for (int h = 0; h < 10; h++) {


            //Das Gepäckstück i
            for (int i = 0; i < lugages.size(); i++) {

                //filtern ob in dem Gebäckstück kein weiteres Gepäckstück sein darf
                if (lugages.get(i).o_bags_number.size() == 0) {
                    lugages.remove(i);
                    i--;
                } else {


                    //Schauen ob die gewünschte Farbe j in die Tasche i gepackt werden kann
                    for (int j = 0; j < lugages.get(i).o_bags_number.size(); j++) {

                        int count = 0;

                        for (int m = 0; m < possible_color.size(); m++) {

                            // Die Tasche kann eine der gewünschten Farben aufnehmen
                            if (lugages.get(i).o_bags_color.get(j).equals(possible_color.get(m))) {
                                count++;
                            }
                        }

                        // Schauen ob die Farbe der Tasche bereits vorhanden ist
                        if (count != 0) {
                            int count2 = 0;
                            System.out.println("Die Farbe "+lugages.get(i).color+" wird behandelt.");

                            for (int m = 0; m < possible_color.size(); m++) {


                                //Taschen Farbe ist bereits vorhanden
                                if (lugages.get(i).color.equals(possible_color.get(m))) {
                                    System.out.println("Es geht um die Vergleichs-Farbe: "+possible_color.get(m));
                                    System.out.println("Die Farben sind gleich ");
                                    count2++;
                                }
                            }

                            if(count2==0) {
                                System.out.println("Die Farbe "+lugages.get(i).color+" wird hinzugefügt.");
                                possible_color.add(lugages.get(i).color);
                            }
                        }

                    }


                }

            }
        }


        return possible_color;
    }

    public int count(ArrayList<String> lugages) {
        return lugages.size()-1;

    }

}
