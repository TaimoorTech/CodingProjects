package syedmuhammadtaimoor;

// Practice Problem 1
class GoodMorning extends Thread{
    public void run(){
        while (true){
            System.out.println("Good Morning");
        }
    }
}

class Welcome extends Thread{
    public void run(){
        while (true){
//            try {
//                Thread.sleep(10);
//            }
//            catch (Exception e){
//                System.out.println(e);
//            }
            System.out.println("Welcome");
        }
    }
}

public class Practice_Questions_on_Thread {
    public static void main(String[] args) {
        GoodMorning g1 = new GoodMorning();
        Welcome w1 = new Welcome();
        g1.start();
        w1.start();
        g1.setPriority(5);
        w1.setPriority(9);
        System.out.println("The Priority of GoodMorning : " + g1.getPriority());
        System.out.println("The Priority of Welcome : " + w1.getPriority());
        System.out.println(g1.getState());
        System.out.println(Thread.currentThread().getState());
    }
}