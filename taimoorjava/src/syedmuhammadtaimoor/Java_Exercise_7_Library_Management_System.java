package syedmuhammadtaimoor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Library_Management_System
{
    private HashMap<String, String[]> BooksInfo = new HashMap<>();
    public Library_Management_System()
    {
        this.BooksInfo.put("Harry Potter and The Prisoner of Azkaban", new String[]{"Jk Rowling", null, null});
        this.BooksInfo.put("Harry Potter and The Sorcerer Stone", new String[]{"Jk Rowling", null, null});
        this.BooksInfo.put("Harry Potter and The Half-Blood Prince", new String[]{"Jk Rowling", null, null});
        this.BooksInfo.put("Harry Potter and The Order of Phoenix", new String[]{"Jk Rowling", null, null});
        this.BooksInfo.put("Harry Potter and The Chamber of Secrets", new String[]{"Jk Rowling", null, null});
    }

    public void Add_Book()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Book Name : ");
        String Book_name = input.nextLine();
        System.out.print("Enter Author Name : ");
        String Author_name = input.nextLine();
        this.BooksInfo.put(Book_name, new String[]{Author_name, null, null});
    }

    public void Issue_Book()
    {

    }

}

public class Java_Exercise_7_Library_Management_System
{
    public static void main(String[] args)
    {
        Library_Management_System library = new Library_Management_System();
        library.Add_Book();
        library.Add_Book();
    }
}
