package syedmuhammadtaimoor;
import  syedmuhammadtaimoor.Rectangle;
// Practice Problem no 1
abstract class Pen{
    abstract void write();
    abstract void refill();
}

// Practice Problem no 2
class FountainPen extends Pen{
    @Override
    public void write(){
        System.out.println("Pen is Writing....");
    }

    @Override
    public void refill(){
        System.out.println("Pen is Refilling....");
    }

    public void changeNib(){
        System.out.println("Nib is Changing....");
    }
}

// Practice Problem no 3
interface BasicAnimal{
    void sleep();
    void eat();
}

class Monkey extends Rectangle{
    public void jump(){
        System.out.println(length);
        System.out.println("Jumping....");
    }

    public void bite(){
        System.out.println("Biting....");
    }
}

class Human extends Monkey implements BasicAnimal{
    int x;
    public void sleep(){
        x = 88;
        System.out.println();
        System.out.println("Sleeping...");
    }

    public void eat(){
        System.out.println("Eating...");
    }
}

// Practice Problem no 4

public class Practice_Questions_on_Abstract_Classes_and_Interfaces {
    public static void main(String[] args) {
//        Rectangle R = new Rectangle();
//        R.setBreadth(5);
//        R.setLength(10);
//        System.out.println(R.calculating_perimeter());
//        System.out.println(R.calculating_area());
//        R.breadth = 4;
//        System.out.println(R.breadth);
//        Human h =new Human();
//        h.sleep();
        Monkey m = new Monkey();
        m.jump();

    }
}
