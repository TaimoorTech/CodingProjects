package syedmuhammadtaimoor;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

/**
 * @author Harry (CodeWithHarry)
 * @version 0.1
 * @since 2002
 */
public class filing {
    public static void main(String[] args) {
//        File f =  new File("jj.txt");
//        try {
//            f.createNewFile();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }


//        try{
//            FileWriter w = new FileWriter("jj.txt", true);
//            w.write("taimoor222");
//            w.close();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }

        String s = "";
        File n = new File("jj.txt");
        try {
            Scanner sc = new Scanner(n);
            while (sc.hasNextLine()){
                s = sc.nextLine();
            }
            sc.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String []arr = s.split("2");
        List<String> l = Arrays.asList(arr);


    }
}
