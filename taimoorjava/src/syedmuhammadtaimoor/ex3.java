package syedmuhammadtaimoor;

import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {
        // problem 3
//        String letter = "Dear <|name|>, Thanks a lot";
//        String some_name = "TAIMOOR";
//        letter = letter.replace("<|name|>",some_name);
//        System.out.println(letter);

        //ex4 pb4
//        String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
//        Scanner input_day = new Scanner(System.in);
//        System.out.print("Enter the Number of Day of Week : ");
//        int num = input_day.nextInt();
//        if (num>0 && num<=7) {
//            System.out.printf("Today is %s ........", days[num - 1]);
//        }
//        else {
//            System.out.println("Kindly, Enter the Right Day number........");
//        }
        //Scanner input_day = new Scanner(System.in);
//        int day;
//        System.out.print("Enter the Number of Day of Week : ");
//        day = input_day.nextInt();
//        switch (day){
//            case 1 -> System.out.println("Today is Monday.....");
//            case 2 -> System.out.println("Today is Tuesday.....");
//            case 3 -> System.out.println("Today is Wednesday.....");
//            case 4 -> System.out.println("Today is Thursday.....");
//            case 5 -> System.out.println("Today is Friday.....");
//            case 6 -> System.out.println("Today is Saturday.....");
//            case 7 -> System.out.println("Today is Sunday.....");
//            default -> System.out.println("Kindly, Enter the Right Day number........");
//        }
        //questiom 5
//        String web = "fffff.org";
//        if (web.endsWith(".in")){
//            System.out.println("It is an Indian Website");
//        }
//        else if (web.endsWith(".com")){
//            System.out.println("It is an Commercial Website");
//        }
//        else if (web.endsWith(".org")){
//            System.out.println("It is an Organizational Website");
//        }
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        double doub = scan.nextDouble();
        String str = scan.nextLine();
        System.out.println("String: " + str);
        System.out.println("Double: " + doub);
        System.out.println("Int: " + num);

    }

}
