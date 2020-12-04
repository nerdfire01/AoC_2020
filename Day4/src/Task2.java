import java.util.ArrayList;

public class Task2 extends Task1 {
    int length = 1101;


    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day4/src/Input.txt";
        ArrayList<Passport> passwords = new ArrayList<>();
        Task2 task2 = new Task2();

        passwords = task2.analyze(task2.readfile(file));
        System.out.println("There are " + passwords.size() + " valid passwords.");
    }


    public ArrayList<Passport> analyze(ArrayList<String> file_input) {
        ArrayList<Passport> passports = new ArrayList<>();

        for (int i = 0; i < length; ) {

            int line_counter = 0;
            int line_counter2 = 0;

            //for Schleife zählt, wie lang der nächste Passport
            for (int j = i; j <= i + 8; j++) {
                line_counter++;
                if (j == length - 1) {
                    break;
                }
                if (file_input.get(j).isBlank()) {
                    break;
                }

            }
            line_counter2 = line_counter - 1;

            //Erstellen eines neuen Passports und füllen dieses mit Daten
            Passport passport = new Passport();

            //for für jede einzelne Zeile
            for (int m = i; m < i + line_counter2; m++) {

                //some helping variables
                String h1;
                String h2;
                String h3;

                //reading the line
                h1 = file_input.get(m);

                //variables for length of line
                int l = 0;
                int l_h1 = h1.length();

                // for für mehrere Werte in einer Zeile
                for (int n = 0; n < 8; n++) {

                    if (l >= l_h1) {
                        break;
                    }
                    h2 = h1.split(" ")[n];
                    l = l + h2.length() + 1;


                    //Trennen der Passwortdaten und
                    //Einfügen der Passwortdaten in das richtige Feld
                    h3 = h2.split(":")[0];

                    if (h3.equals("byr")) {
                        passport.byr = h2.split(":")[1];
                    } else if (h3.equals("iyr")) {
                        passport.iyr = h2.split(":")[1];
                    } else if (h3.equals("eyr")) {
                        passport.eyr = h2.split(":")[1];
                    } else if (h3.equals("hgt")) {
                        passport.hgt = h2.split(":")[1];
                    } else if (h3.equals("hcl")) {
                        passport.hcl = h2.split(":")[1];
                    } else if (h3.equals("ecl")) {
                        passport.ecl = h2.split(":")[1];
                    } else if (h3.equals("pid")) {
                        passport.pid = h2.split(":")[1];
                    } else if (h3.equals("cid")) {
                        passport.cid = h2.split(":")[1];
                    }
                }
            }

            if (passport.check_passport_valid()) {
                passports.add(passport);
            }

            i = i + line_counter;

        }


        return passports;
    }
}
