package syedmuhammadtaimoor;

public class cew_lab2_q4 {
    public static void main(String[] args) {
        String sentence = "I am a Student of NED University..";
        boolean check = sentence.contains("NED");
        if (check){
            System.out.println("The specified sequence is present.....");
        }
        else {
            System.out.println("The specified sequence is not present.....");
        }
    }
}
