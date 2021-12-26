package syedmuhammadtaimoor;

import java.util.Scanner;
import java.util.regex.*;

public class java_regex {
    public static void main(String[] args)
    {
//        System.out.println("Enter Email : ");
//        Scanner sc = new Scanner(System.in);
//        String email = sc.next();
//        //Pattern p = Pattern.compile("^[A-z]+[a-z]+[0-9]+@gmail\\.com$");
//        Pattern p = Pattern.compile("^[3][A-Za-z]+@gmail\\.com$");
//        Matcher m = p.matcher(email);
//        if (m.find())
//        {
//            System.out.println("Email is Valid");
//        }
//        else
//        {
//            System.out.println("Email is not Valid");
//        }
//        Scanner sc = new Scanner(System.in);
//        String id = sc.next();
//        Pattern p = Pattern.compile("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$");
//        Matcher m  = p.matcher(id);
//        if(m.find()){
//            System.out.println("ID is valid");
//        }
//        else {
//            System.out.println("ID is not valid");
//        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String username = sc.next();
            Pattern p = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_ ]{7,29}$");
            Matcher m = p.matcher(username);
            if(m.find()){
                System.out.println("Valid");
            }
            else {
                System.out.println("Invalid");
            }
        }
    }
}
