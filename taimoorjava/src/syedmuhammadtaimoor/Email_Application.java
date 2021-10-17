package syedmuhammadtaimoor;

import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

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

    public static void main(String[] args) throws IOException {
        Email_Application email = new Email_Application();
        email.create_mail();
    }
}
