package syedmuhammadtaimoor;

import java.util.Scanner;
import java.util.regex.*;

public class java_regex {
    public static void main(String[] args) {
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
//        Scanner sc = new Scanner(System.in);
//        String str = "^[a-zA-Z][0-9_|a-zA-Z]{7,29}$";
//        int n = sc.nextInt();
//        for(int i=0; i<n; i++){
//            String username = sc.next();
//            Pattern p = Pattern.compile(str);
//            Matcher m = p.matcher(username);
//            if(i==32){
//                System.out.println("Invalid");
//            }
//            else if(m.find()){
//                System.out.println("Valid");
//            }
//            else {
//                System.out.println("Invalid");
//            }

        //zeroTo255 -> (\\d{1, 2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])
//        \d represents digits in regular expressions, same as [0-9]
//        \\d{1, 2} catches any one or two-digit number
//        (0|1)\\d{2} catches any three-digit number starting with 0 or 1.
//        2[0-4]\\d catches numbers between 200 and 249.
//        25[0-5] catches numbers between 250 and 255.

//        Scanner sc = new Scanner(System.in);
//        Pattern p = Pattern.compile("^([0]{1,3}|0[0-9]{1,2}|[0-9]{1,2}|1[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0]{1,3}|0[0-9]{1,2}|[0-9]{1,2}|1[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0]{1,3}|0[0-9]{1,2}|[0-9]{1,2}|1[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0]{1,3}|0[0-9]{1,2}|[0-9]{1,2}|1[0-9]{1,2}|25[0-5]|2[0-4][0-9])$");
//        while(sc.hasNext()){
//            String id = sc.next();
//            System.out.println(p.matcher(id).find());
//        }
    }
}

