import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {

    public static void main(String[] args) {
        //Attribute
        int l = 200;
//        int zahl1=0;
//        int zahl2=0;
//        int zahl3=0;

        //Arrays
//        String[]input_text = new String[l];
        int[] input = new int[l];

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/home/david/projects/InteliJ/AoC_2020/Day1/src/Input.txt"));
            for (int i = 0; i < l; i++) {
//            input_text[i]= reader.readLine();
//            input[i]= Integer.parseInt(input_text[i]);
                input[i] = Integer.parseInt(reader.readLine());
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < l; i++) {
//           zahl1=input[i];
            for (int j = (i + 1); j < l; j++) {
//                zahl2=input[j];
                for (int m = (j + 1); m < l; m++) {
//                    zahl3=input[m];
//                    int sum=zahl1+zahl2+zahl3;
                    int sum = input[i] + input[j] + input[m];

                    if (sum == 2020) {
                        int ergebnis = input[i] * input[j] * input[m];
//                        System.out.println("Die Zahlen sind "+zahl1+", "+zahl2+" und "+zahl3);
                        System.out.println("Das Ergebnis ist: " + ergebnis);
                        return;
                    }
                }

            }
        }
    }
}