import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task1 {

    int length = 2233;

    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day6/src/Input.txt";
        ArrayList<Group> groups = new ArrayList<>();
        Task1 task1 = new Task1();
        int sum = 0;
        groups = task1.decode(task1.readfile(file));
        sum = task1.answer_sum(groups);
        System.out.println("Die gesamt Summe ist: " + sum);
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

    public ArrayList<Group> decode(ArrayList<String> input) {
        ArrayList<Group> groups = new ArrayList<>();

        for (int i = 0; i < length; ) {

            int line_counter = 0;
            int line_counter2 = 0;

            //for Schleife zählt, wie lang die nächste Gruppe ist
            for (int j = i; j <= i + 8; j++) {
                line_counter++;
                if (j == length - 1) {
                    break;
                }
                if (input.get(j).isBlank()) {
                    break;
                }

            }
            line_counter2 = line_counter - 1;

            //Erstellen einer neuen Gruppe
            Group group1 = new Group();

            //some helping variables
            String h1;
            Character character;
            ArrayList<Character> characters = new ArrayList<>();

            //for für jede einzelne Zeile
            for (int m = i; m < i + line_counter2; m++) {


                //reading the line
                h1 = input.get(m);

                //variables for length of line
                int l_h1 = h1.length();

                // for für die einzelnen Buchstaben der Zeile
                if (m == i) {
                    // in der ersten Zeile der Gruppe alle Buchstaben reinschreiben in das Array
                    for (int n = 0; n < l_h1; n++) {
                        character = h1.charAt(n);
                        characters.add(character);

                    }

                } else {

                    // für die restlichen Zeilen wird getestet, ob der Buchstabe schon im Array ist, alternativ wird er hinzugefügt
                    for (int n = 0; n < l_h1; n++) {
                        character = h1.charAt(n);

                        int l = characters.size();
                        int j = 0;
                        for (int o = 0; o < l; o++) {
                            if (character == characters.get(o)) {
                                j = 1;
                            }


                        }
                        if (j == 0) {
                            characters.add(character);
                        }

                    }

                }

            }

            //zählen der übrigen Buchstaben im Array
            int count = characters.size();
            group1.answers = count;
            groups.add(group1);

            i = i + line_counter;

        }


        return groups;
    }

    public int answer_sum(ArrayList<Group> groups) {
        int sum = 0;

        for (int i = 0; i < groups.size(); i++) {
            sum = sum + groups.get(i).answers;
        }

        return sum;
    }


}
