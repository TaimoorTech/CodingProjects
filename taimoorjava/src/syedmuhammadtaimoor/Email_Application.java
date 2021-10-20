package syedmuhammadtaimoor;

//import java.nio.file.Files;
 //import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

public class Email_Application
{
    public boolean create_mail() throws IOException {
        while(true){
            Scanner input = new Scanner(System.in);
            //String IdPattern = "^[A-Za-z]+[0-9]+@gmail\\.com+$";
            String IdPattern = "^.+[A-Za-z].+[0-9](@gmail\\.com)$";
            Pattern mail_pattern = Pattern.compile(IdPattern);

            String PasswordPattern = "^(?=.*[A-Za-z])(?=.*[0-9]).{7,16}$";
            Pattern password_pattern = Pattern.compile(PasswordPattern);

            System.out.println("Enter the Gmail Id you want to create : ");
            String email_id = input.next();
            Matcher check_id = mail_pattern.matcher(email_id);
            if (check_id.find()){
                System.out.println("Enter the Password for Id ");
                String password = input.next();
                Matcher check_password = password_pattern.matcher(password);
                if (check_password.find()){
                    System.out.println("Your Id is registered");
                    try {
                        FileWriter registration =  new FileWriter("Registration.txt", true);
                        registration.write(email_id + "," + password);
                        registration.close();
                        return true;
                    }
                    catch (IOException e) {
                        File creating =  new File("Registration.txt");
                        creating.createNewFile();
                        FileWriter registration =  new FileWriter("Registration.txt", true);
                        registration.write(email_id + "," + password);
                        registration.close();
                        return true;
                    }
                }
                else {
                    System.out.println("Kindly enter at least 1 number and 1 alphabet and should be of length at least 8..");
                    continue;
                }
            }
            else {
                System.out.println("Kindly correct way of email....");
                continue;
            }
        }
    }

//    public void changePassword() throws  IOException
//    {
////        Stream<String> lines = Files.lines(Paths.get("Registration.txt"));
////        List<String> list = lines.map(x -> x.split(","))
////                .map(String v -> String[][1]);
//        Boolean flag = true;
//        ArrayList<String> EmailAddresses = new ArrayList<>();
//        ArrayList<String> Passwords = new ArrayList<>();
//        File file = new File("Registration.txt");
//        try
//        {
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine())
//            {
//                String[] arr = sc.nextLine().split(",");
//                EmailAddresses.add(arr[0]);
//                String change = arr[1].replace("\n","");
//                System.out.println(change);
//                Passwords.add(change);
//            }
//            sc.close();
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter the User Gmail Id : ");
//        String user_name = input.next();
//        int i = 0;
//        for (String name : EmailAddresses)
//        {
//            if(user_name.equals(name))
//            {
//                System.out.println("Enter Old Password : ");
//                String old = input.next();
//                if(old.equals(Passwords.get(i)))
//                {
//                    System.out.println("Enter the new Password : ");
//                    String newpass = input.next();
//                    Passwords.remove(i);
//                    Passwords.add(i, newpass);
//                    flag = true;
//                    break;
//                }
//                else
//                {
//                    System.out.println("Incorrect Old Password...");
//                }
//            }
//            else {
//                flag = false;
//            }
//            i++;
//        }
//        if (flag == true)
//        {
//            try {
//                FileWriter writing = new FileWriter("Registration.txt");
//                for (int j = 0; j < EmailAddresses.size(); j++) {
//                    writing.write(EmailAddresses.get(j) + "," + Passwords.get(j) + "\n");
//                }
//                writing.close();
//            }
//            catch (IOException e) {
//                System.out.println("");
//            }
//        }
//        else
//        {
//            System.out.println("Incorrect Gmail Id...");
//        }
//    }

    // using streams
    public void changePassword() throws  IOException{
        Map<String, String> matters = new HashMap<>();
        try {
            Stream<String> file = Files.lines(Paths.get("Registration.txt"));
            matters = file
                    .map(x -> x.split(","))
                    .collect(Collectors.toMap(x -> x[0], x-> x[1]));
            file.close();
//            System.out.println(matters);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Id name : ");
        String id = sc.next();
        if(matters.containsKey(id)){
            System.out.println("Enter old password : ");
            String old = sc.next();
            if(old.equals(matters.get(id))){
                System.out.println("Enter new password");
                String newPass = sc.next();
                matters.replace(id, newPass);
                try{
                    FileWriter writing = new FileWriter("Registration.txt");
                    for (String ids : matters.keySet()) {
                        writing.write(ids + "," + matters.get(ids) + "\n");
                    }
                    writing.close();
                }
                catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args){
        Email_Application email = new Email_Application();
//        email.create_mail();
        try {
            email.changePassword();
        } catch (IOException e) {
            System.out.println("");
        }

    }
}
