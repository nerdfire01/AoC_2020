import java.util.ArrayList;

public class Task2 extends Task1 {

    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day6/src/Input.txt";
        ArrayList<Group> groups = new ArrayList<>();
        Task1 task2 = new Task2();
        int sum = 0;
        groups = task2.decode(task2.readfile(file));
        sum = task2.answer_sum(groups);
        System.out.println("Die gesamt Summe ist: " + sum);
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

                    // für die restlichen Zeilen wird getestet, ob die Buchstaben, die im Array sind
                    // auch in den Antwort der Zeile ist. Die fehlenden Buchstaben werden entfernt
                    for (int o = 0; o < characters.size(); o++) {

                        int count = 0;
                        for (int p = 0; p < h1.length(); p++) {
                            character = h1.charAt(p);
                            if (character == characters.get(o)) {
                                count++;
                            }
                        }

                        if (count == 0) {
                            characters.remove(o);
                            o--;

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
}
