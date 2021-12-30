package syedmuhammadtaimoor;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

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
//        Scanner sc = new Scanner(System.in);
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
//        String s1 = sc.next();
//        String s2 = sc.next();
//        System.out.println(s1.length() + s2.length());
//        if(s1.compareTo(s2) > 0){
//            System.out.println("Yes");
//        }
//        else if(s1.compareTo(s2) < 0) {
//            System.out.println("No");
//        }
//        System.out.println(s1.substring(0,1).toUpperCase() + s1.substring(1)
//        + " " + s2.substring(0,1).toUpperCase() + s2.substring(1));

//        Scanner sc =  new Scanner(System.in);
//        String st = sc.next();
//        sc.nextLine();
//        String st2 = sc.nextLine();
//        String []arr = st2.split(" ");
//        int num1 = Integer.parseInt(arr[0]);
//        int num2 = Integer.parseInt(arr[1]);
//        System.out.println(st.substring(num1, num2));

//        Scanner sc =  new Scanner(System.in);
//        String st = sc.next();
//        int num = sc.nextInt();
//        ArrayList<String> arr = new ArrayList<>();
//        for (int i = 0; i < st.length(); i++) {
//            if(i<=(st.length()-num)){
//                arr.add(st.substring(i, i+num));
//            }
//        }
//        Collections.sort(arr);
//        System.out.println(arr.get(0)+"\n"+arr.get(arr.size()-1));

//        Scanner sc =  new Scanner(System.in);
//        String st = sc.next();
//        boolean check = true;
//        for (int i = 0; i < (st.length()/2)+1; i++) {
//            if(st.charAt(i) == st.charAt(st.length()-i-1)){
//                check = true;
//            }
//            else {
//                check = false;
//            }
//        }
//        if (check == true){
//            System.out.println("Yes");
//        }
//        else {
//            System.out.println("No");
//        }
//        boolean check = true;
//        Scanner sc =  new Scanner(System.in);
//        String st1 = sc.next().toLowerCase();
//        String st2 = sc.next().toLowerCase();
//        for(int i=0; i< st1.length(); i++){
//            char s = st1.charAt(i);
//            if(st1.chars().filter(ch -> ch == s).count() == st2.chars().filter(ch -> ch == s).count()){
//                check = true;
//            }
//            else {
//                check = false;
//                break;
//            }
//        }
//        if(check){
//            System.out.println("Anagrams");
//        }
//        else {
//            System.out.println("Not Anagrams");
//        }

//        Scanner sc = new Scanner(System.in);
//        String s = "";
//        long length;
//        String l = sc.nextLine();
//        String[] tokens = l.split("[\\s  !,?._'@]+");
//        length = tokens.length;
//        long l2 = Arrays.stream(tokens).filter(ch -> ch == s).count();
//        String w = "";
//        length-=l2;
//        System.out.println(length);
//        //System.out.println(Arrays.toString(tokens));
//        for (String str: tokens) {
//            if(str.isEmpty()){
//                length--;
//                continue;
//            }
//            else {
//                System.out.println(str);
//            }
//        }
//        Scanner sc = new Scanner(System.in);
//        boolean flag = false;
////        String s = sc.nextLine();
////        System.out.println(s);
//        int num = sc.nextInt();
//        sc.nextLine();
//        for (int i = 0; i < num; i++) {
//            String s = sc.nextLine();
//            try {
//                Pattern p = Pattern.compile(s);
//                flag = true;
//            } catch (PatternSyntaxException e) {
//                System.out.println("Invalid");
//                flag = false;
//            }
//            if(flag == true){
//                System.out.println("Valid");
//            }
//        }
//        System.out.println("Taimoor");

        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        String US = NumberFormat.getCurrencyInstance(Locale.US).format(number);
        String CHINA = NumberFormat.getCurrencyInstance(Locale.CHINA).format(number);
        String FRANCE = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(number);
        System.out.println("US: " + US);
        String INDIAN = US.replace("$", "Rs.");
        System.out.println("India: " + INDIAN);
        System.out.println("China: " + CHINA);
        System.out.println("France: " + FRANCE);
    }
}