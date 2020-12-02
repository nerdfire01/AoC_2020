import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task2 extends Task1{

    //Attribute
    int l = 1000;

    //Arrays

    public static void main(String[] args) {
        String file = "/home/david/projects/InteliJ/AoC_2020/Day2/src/Input.txt";
        int counter_passwords = 0;
        Task2 task = new Task2();

        ArrayList<Password> password=task.readFile(file);
        counter_passwords = task.valid_Passwords(password);
        System.out.println("Es gibt " + counter_passwords + " mögliche Passwörter.");


    }


    public int valid_Passwords(ArrayList<Password> password) {
        int valid_passwords = 0;

        for (int i = 0; i < l; i++) {

            String h1 = password.get(i).passwords;
            Character h2 = password.get(i).letter;

            //Schauen, ob die Zahl des Buchstabens innerhalb des Rahmens ist
            if ((h1.charAt(password.get(i).lowNumber) == h2) ^ (h1.charAt(password.get(i).highNumber) == h2)) {
                valid_passwords++;

            }


        }
        return valid_passwords;
    }
}
