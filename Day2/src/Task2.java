import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task2{

    //Attribute
    int l = 1000;

    //Arrays
    String[]input_text = new String[l];
    String[]passwords = new String[l];
    String[]letter=new String[l];
    int[]lowNumber=new int[l];
    int[]highNumber=new int[l];

    public static void main(String[] args){
        String file= "/home/david/projects/InteliJ/AoC_2020/Day2/src/Input.txt";
        int counter_passwords=0;
        Task2 task= new Task2();
        task.readFile(file);
        counter_passwords= task.valid_Passwords();
        System.out.println("Es gibt "+counter_passwords+" mögliche Passwörter.");


    }
    public void readFile(String Filename){
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

    }

    public int valid_Passwords() {
        int valid_passwords=0;

        for(int i=0; i<l; i++){

            String h1=passwords[i];
            Character h2 =letter[i].charAt(0);

            //Schauen, ob die Zahl des Buchstabens innerhalb des Rahmens ist
            if((h1.charAt(lowNumber[i])== h2) ^ (h1.charAt(highNumber[i])== h2)){
                valid_passwords++;

            }


        }
        return valid_passwords;
    }
}
