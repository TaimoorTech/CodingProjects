package syedmuhammadtaimoor;

import java.util.ArrayList;

public class cew_lab2_q2 {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("RED");
        stringArrayList.add("BLUE");
        stringArrayList.add("GREEN");
        stringArrayList.add("YELLOW");
        for ( String colors: stringArrayList) {
            System.out.println(colors);
        }
    }
}
