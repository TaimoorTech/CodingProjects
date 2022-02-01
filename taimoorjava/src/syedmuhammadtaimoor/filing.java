package syedmuhammadtaimoor;
import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


        try{
            FileWriter w = new FileWriter("jj.txt", true);
            w.write("taimoor2222222");
            w.write("44444");
            w.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

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
        String []arr = s.split(",");
//        List<String> l = Arrays.asList(arr);
        ArrayList<String> m = new ArrayList<>(Arrays.asList(arr));

        System.out.println(m);


        try {
            Stream<String> file = Files.lines(Paths.get("Registration.txt"));
            Map<String, String> matters = new HashMap<>();
            matters = file
                    .map(x -> x.split(","))
                    .collect(Collectors.toMap(x -> x[0], x-> x[1]));
            file.close();
            System.out.println(matters);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
