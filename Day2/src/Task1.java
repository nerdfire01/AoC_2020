import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task1 {
    //Attribute
    int l = 1000;

    //Arrays
    String[] input_text = new String[l];


    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day2/src/Input.txt";
        int counter_passwords = 0;
        Task1 task = new Task1();

        ArrayList<Password> password = task.readFile(file);
        counter_passwords = task.valid_Passwords(password);
        System.out.println("Es gibt " + counter_passwords + " mögliche Passwörter.");


    }


    public ArrayList<Password> readFile(String Filename) {
        ArrayList<Password> password = new ArrayList<>();
        BufferedReader reader = null;
        String[] input_text = new String[l];


        try {
            reader = new BufferedReader(new FileReader(Filename));
            for (int i = 0; i < l; i++) {
                input_text[i] = reader.readLine();
                Password p1 = new Password();

                //Split Text in cp and password
                String in_h1 = input_text[i];
                String cp_h1 = in_h1.split(":")[0];
                p1.passwords = in_h1.split(":")[1];

                //split Text in low number, high number and letter
                p1.lowNumber = Integer.parseInt(cp_h1.split("-")[0]);
                String cp_h3 = cp_h1.split("-")[1];
                p1.highNumber = Integer.parseInt(cp_h3.split(" ")[0]);
                p1.letter = cp_h3.split(" ")[1].charAt(0);

                password.add(p1);

            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return password;

    }

    public int valid_Passwords(ArrayList<Password> password) {
        int valid_passwords = 0;

        //for Schleife für jede Zeile
        for (int i = 0; i < l; i++) {

            String passowrd_current = password.get(i).passwords;
            Character letter_curent = password.get(i).letter;
            int count_letter = 0;

            //Zählen wie oft der Buchstabe im Wort vorhanden ist
            for (int m = 0; m < passowrd_current.length(); m++) {
                if (passowrd_current.charAt(m) == letter_curent) count_letter++;
            }

            //Schauen, ob die Zahl des Buchstabens innerhalb des Rahmens ist
            if ((count_letter <= password.get(i).highNumber) && (count_letter >= password.get(i).lowNumber)) {
                valid_passwords++;
            }


        }
        return valid_passwords;
    }
}
