package syedmuhammadtaimoor;

// PROBLEM 1
class Employee{
    int Salary;
    String name;

    public void setSalary(int s){
        this.Salary = s;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public int getSalary(){
        return this.Salary;
    }
}

// PROBLEM 4
class Rectangle{

    int length = 565;
    int breadth = 99;

    void setLength(int length){
        this.length = length;
    }

    public void setBreadth(int breadth){
        this.breadth = breadth;
    }

    public int getLength(){
        return this.length;
    }

    public int getBreadth(){
        return this.breadth;
    }

    public int calculating_area(){
        return this.length * this.breadth;
    }

    public int calculating_perimeter(){
        return 2*(this.length + this.breadth);
    }
}


public class classes_ex {
    public static void main(String[] args) {
        /* PROBLEM 1
        Employee e = new Employee();
        e.setName("Taimoor");
        e.setSalary(20000000);
        System.out.println(e.getName());
        System.out.println(e.getSalary());
        */

        // PROBLEM 4
        Rectangle rec = new Rectangle();
        rec.setLength(5);
        rec.setBreadth(10);
        System.out.println(rec.calculating_area());
        System.out.println(rec.calculating_perimeter());
        rec.breadth = 5;
        System.out.println(rec.calculating_area());
        System.out.println(rec.calculating_perimeter());


    }

}
