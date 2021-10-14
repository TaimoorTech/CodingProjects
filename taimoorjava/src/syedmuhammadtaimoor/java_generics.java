package syedmuhammadtaimoor;

import java.util.ArrayList;

class initialize<T>{
    ArrayList<T> obj = new ArrayList<>();
//    public initialize(ArrayList obj1){
//        this.obj = obj1;
//    }
    public initialize(T obj){
        this.obj.add(obj);
    }

    public void display(){
        System.out.println(this.obj);
    }

}


public class java_generics {
    public static void main(String[] args) {
//        ArrayList al = new ArrayList();
//        al.add(55);
//        al.add("taimoor");
//        String a = (String) al.get(1);
//        System.out.println(a);
//        ArrayList<String> s2 = new ArrayList<>();
//        s2.add("Taimoor");
        initialize<Integer> s1 = new initialize<>(123);
        s1.display();
    }


}
