package syedmuhammadtaimoor;

// PROBLEM 1,2,3
class Cylinder{

    private int radius;
    private int height;

     Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }


    public void setRadius(int radius){
         this.radius = radius;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getRadius(){
        return this.radius;
    }
    public int getHeight(){
        return this.height;
    }

    public double calculating_surface_area(){
        return 2 * Math.PI * this.radius * (this.height + this.radius);
    }

    public double calculating_volume(){
        return Math.PI * (this.radius * this.radius) * this.height;
    }
}



public class constructors_exercise {
    public static void main(String[] args) {
        // PROBLEM 1,2,3
        Cylinder c = new Cylinder(9,  12 );
        System.out.println(c.calculating_surface_area());
        System.out.println(c.calculating_volume());
    }
}
