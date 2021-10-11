package syedmuhammadtaimoor;

import java.util.ArrayList;

public class java_generics {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(55);
        al.add("taimoor");
        String a = (String) al.get(1);
        System.out.println(a);
    }


}
