package syedmuhammadtaimoor;


class SmartPhone implements GPS{
    public void trackingLocation(){
        System.out.println("Here, it is.....");
    }

    public void latitudePosition(String latitude){
        System.out.println("The man is here....." + latitude);
    }

    public void greet(){
        System.out.println("Good Morning......");
    }
}

public class interface1 {
    public static void main(String[] args) {
        GPS g = new SmartPhone();
        //g.greet();

        SmartPhone g1 = new SmartPhone();
        g1.greet();
    }
}
