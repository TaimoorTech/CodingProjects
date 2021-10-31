package syedmuhammadtaimoor;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class java_newpractices {
//    static int B;
//    static int H;
//    static{
//        Scanner sc = new Scanner(System.in);
//        B = sc.nextInt();
//        H = sc.nextInt();
//    }
    public static void main(String[] args) {
//        Scanner sc =  new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int i = 0; i < T; i++) {
//            if (sc.hasNextByte()) {
//                byte num = sc.nextByte(); // stores result of upper checked value
//
//                System.out.printf("%d can be fitted in:\n* byte\n* short\n* int\n* long\n", num);
//            } else if (sc.hasNextShort()) {
//                short num = sc.nextShort();
//                System.out.printf("%d can be fitted in:\n* short\n* int\n* long\n", num);
//            } else if (sc.hasNextInt()) {
//                int num = sc.nextInt();
//                System.out.printf("%d can be fitted in:\n* int\n* long\n", num);
//            } else if (sc.hasNextLong()) {
//                long num = sc.nextLong();
//                System.out.printf("%d can be fitted in:\n* long\n", num);
//            } else if (sc.hasNext()) {
//                String num = sc.next();
//                System.out.printf("%s can't be fitted anywhere.\n", num);
//            }
//        }
//
//
//
//        int i = 1;
//        while(sc.hasNextLine()){
//            String result = sc.nextLine();
//            System.out.println(i +" " + result);
//            i++;
//        }
//
//
//        if(B>0 && H>0){
//            System.out.println(B*H);
//        }
//        else {
//            System.out.println("java.lang.Exception: Breadth and height must be positive");
//
//        }

//        String c = "";
//        System.out.println(c.getClass().getName());
//        int year = 2021;
//        int month = 10;
//        int date = 23;
//        LocalDate c =  LocalDate.of(year, month, date);
//        String day = String.valueOf(c.getDayOfWeek());
//        System.out.println(day.getClass().getName());

        // NumberFormat class
        Scanner sc = new Scanner(System.in);
//        double num = sc.nextDouble();
//        NumberFormat dol = NumberFormat.getCurrencyInstance(Locale.US);
//        NumberFormat ind = NumberFormat.getCurrencyInstance(Locale.US);
//        NumberFormat chin = NumberFormat.getCurrencyInstance(Locale.CHINA);
//        NumberFormat fra = NumberFormat.getCurrencyInstance(Locale.FRANCE);
//        String indian = ind.format(num).replace("$", "Rs.");
//        System.out.println("US:" + dol.format(num));
//        System.out.println("India:" + indian);
//        System.out.println("China:" + chin.format(num));
//        System.out.println("France:" + fra.format(num));
//        Locale l = new Locale();
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(s1.length() + s2.length());
        if(s1.compareTo(s2) > 0){
            System.out.println("Yes");
        }
        else if(s1.compareTo(s2) < 0) {
            System.out.println("No");
        }
        System.out.println(s1.substring(0,1).toUpperCase() + s1.substring(1)
        + " " + s2.substring(0,1).toUpperCase() + s2.substring(1));
    }
}
