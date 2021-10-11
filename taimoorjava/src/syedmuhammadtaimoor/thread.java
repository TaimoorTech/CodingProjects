package syedmuhammadtaimoor;



class my extends Thread{

    public my(String name, int id){
        super(name);

    }
    @Override
    public void run(){
        while (true){
            System.out.println("Running...");
        }
    }



}

public class thread {
    public static void main(String[] args) {
        my mythread = new my("Taimoor", 1);
        System.out.println("The name 1 is " + mythread.getName());
        System.out.println("The ID 1 is " + mythread.getId());

    }
}
