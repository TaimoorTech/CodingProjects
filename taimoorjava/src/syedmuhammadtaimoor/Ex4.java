package syedmuhammadtaimoor;
import java.util.Arrays;
import java.util.Scanner;

class Online_Library
{
    String []list_of_books = new String[100];
    Online_Library()
    {
       list_of_books[0] = "Harry Potter and The Prisoner of Azkaban";
       list_of_books[1] = "Harry Potter and The Sorcerer Stone";
       list_of_books[2] = "Harry Potter and The Chamber of Secrets";
       list_of_books[3] = "Harry Potter and The Order of Phoenix";
       list_of_books[4] = "Harry Potter and The Half-Blood Prince";
    }

    public void Add_Book()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Name of the Book : ");
        String book_name = input.nextLine();
        int index = Arrays.asList(this.list_of_books).indexOf(null);
        this.list_of_books[index] = book_name;
        System.out.printf("The %s Book is added....\n", book_name);

    }

    public void Issue_Book()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Book name : ");
        String book_name = input.nextLine();
        boolean available = Arrays.asList(this.list_of_books).contains(book_name);
        if(available)
        {
            System.out.printf("The %s Book is issued....\n", book_name);
        }
        else
        {
            System.out.printf("The %s Book is not available in the store....\n", book_name);
        }
    }

    public void Return_Book()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Book name : ");
        String book_name = input.nextLine();
        boolean available = Arrays.asList(this.list_of_books).contains(book_name);
        if(available)
        {
            System.out.printf("The %s Book is returned....\n", book_name);
        }
        else
        {
            System.out.printf("The %s Book is not from our store....\n", book_name);
        }
    }

    public void ShowAvailableBooks()
    {
        System.out.println("-".repeat(63));
        String format = "|%-10s|%-50s|%n" ;
        System.out.format(format, "   S.No", "                       Name");
        System.out.println("-".repeat(63));
        for (int i = 0; i < this.list_of_books.length && this.list_of_books[i]!=null; i++)
        {
            if (i<10)
            {
                System.out.format(format,"    0"+ (i+1), "       "+this.list_of_books[i]);
            }
            else
            {
                System.out.format(format,"    "+ (i+1), "       "+this.list_of_books[i]);
            }
        }
        System.out.println("-".repeat(63));
    }
}

public class Ex4
{
    public static void main(String[] args)
    {
        Online_Library library = new Online_Library();
        Scanner sc = new Scanner(System.in);
        int num;
        while (true){
            System.out.println("WELCOME TO ONLINE LIBRARY");
            System.out.print("1.ADD BOOK\n2.ISSUE BOOK\n3.RETURN BOOK\n4.SHOW AVAILABLE BOOKS\n5.EXIT\nPRESS : ");
            num = sc.nextInt();
            if (num==1)
            {
                library.Add_Book();
            }
            else if(num==2)
            {
                library.Issue_Book();
            }
            else if(num==3)
            {
                library.Return_Book();
            }
            else if (num==4)
            {
                library.ShowAvailableBooks();
            }
            else if (num==5)
            {
                System.out.println("Thanks for coming....");
                System.exit(0);
            }
        }

    }
}
