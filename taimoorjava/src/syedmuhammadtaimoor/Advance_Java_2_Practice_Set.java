package syedmuhammadtaimoor;
import java.io.*;
import java.util.Scanner;


public class Advance_Java_2_Practice_Set {
    public static void main(String[] args) {
        File f = new File("table.txt");
        try {
            f.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int num = sc.nextInt();
        for (int i = 1; i < 11; i++) {
            try {
                FileWriter w = new FileWriter("table.txt", true);
                String result = Integer.toString(num*i);
                if (i==10){
                    w.write(num+"x"+i+"="+result+",\n");
                }
                else {
                    w.write(num+"x"+i+"="+result+",");
                }
                w.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
