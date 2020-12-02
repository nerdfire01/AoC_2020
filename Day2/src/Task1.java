import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {

    public static void main(String[] args) {
        //Attribute
        int l = 1000;
        int valid_passwords=0;



        //Arrays
        String[]input_text = new String[l];
        String[]passwords = new String[l];
        //String[]cp = new String[l];


//        String[]lowNumber=new String[l];
//        String[]highNumber=new String[l];
        String[]letter=new String[l];
        int[]lowNumber=new int[l];
        int[]highNumber=new int[l];



        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/home/david/projects/InteliJ/AoC_2020/Day2/src/Input.txt"));
            for (int i = 0; i < l; i++) {
                input_text[i]= reader.readLine();

                //Split Text in cp and password
                String in_h1 =input_text[i];
                String[] in_h2 = in_h1.split(":");
                String cp_h1 = in_h2[0];
                passwords[i]= in_h2[1];

                //split Text in low number, high number and letter
                String[] cp_h2=cp_h1.split("-");
                lowNumber[i]= Integer.parseInt(cp_h2[0]);
                String cp_h3=cp_h2[1];
                String[] cp_h4=cp_h3.split(" ");
                highNumber[i]= Integer.parseInt(cp_h4[0]);
                letter[i]=cp_h4[1];

            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //for Schleife für jede Zeile
        for(int i=0; i<l; i++){

            String h1=passwords[i];
            Character h2 =letter[i].charAt(0);
            int count_letter = 0;

            //Zählen wie oft der Buchstabe im Wort vorhanden ist
            for (int m = 0; m < h1.length(); m++) {
                if (h1.charAt(m) == h2) count_letter++;
            }

            //Schauen, ob die Zahl des Buchstabens innerhalb des Rahmens ist
            if(count_letter <= highNumber[i] && count_letter >= lowNumber[i]){
                valid_passwords++;
            }


        }

        System.out.println("Es gibt "+valid_passwords+" mögliche Passwörter.");
    }
}
