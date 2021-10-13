package syedmuhammadtaimoor;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Library_Management_System
{
    HashMap<String, List<String>> BooksInfo = new HashMap<>();
    public Library_Management_System()
    {
        this.BooksInfo.put("Harry Potter and The Prisoner of Azkaban", new ArrayList<>(Arrays.asList
                ("Jk Rowling", null, null)));
        this.BooksInfo.put("Harry Potter and The Sorcerer Stone", new ArrayList<>(Arrays.asList
                ("Jk Rowling", null, null)));
        this.BooksInfo.put("Harry Potter and The Half-Blood Prince", new ArrayList<>(Arrays.asList
                ("Jk Rowling", null, null)));
        this.BooksInfo.put("Harry Potter and The Order of Phoenix", new ArrayList<>(Arrays.asList
                ("Jk Rowling", null, null)));
        this.BooksInfo.put("Harry Potter and The Chamber of Secrets", new ArrayList<>(Arrays.asList
                ("Jk Rowling", null, null)));
    }

    public void Add_Book()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Book Name : ");
        String Book_name = input.nextLine();
        System.out.print("Enter Author Name : ");
        String Author_name = input.nextLine();
        this.BooksInfo.put(Book_name, new ArrayList<>(Arrays.asList
                (Author_name, null, null)));
    }

    public void Issue_Book()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d : M : u");
        LocalDate date = LocalDate.now();

        List<String> book;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Book Name : ");
        String Book_name = input.nextLine();
        System.out.print("Enter Name of the Receiver : ");
        String Receiver_name = input.nextLine();
        if (this.BooksInfo.containsKey(Book_name))
        {
            book = this.BooksInfo.get(Book_name);
            if(book.get(1) == null && book.get(2) == null)
            {
                book.set(1, Receiver_name);
                book.set(2, date.format(dtf));
                this.BooksInfo.replace(Book_name, book);
                System.out.printf("The %s Book is issued...\n", Book_name);
            }
            else
            {
                System.out.printf("The %s Book is issued already...\n", Book_name);
            }
        }
        else
        {
            System.out.format("The %s Book is not in store...\n", Book_name);
        }
    }

    public void Return_Book()
    {
        List<String> book;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Book Name : ");
        String Book_name = input.nextLine();
        System.out.print("Enter Name of the Receiver : ");
        String Receiver_name = input.nextLine();
        book = this.BooksInfo.get(Book_name);
        if (this.BooksInfo.containsKey(Book_name))
        {
            if (book.get(1) == null && book.get(2) == null)
            {
                System.out.printf("The %s Book is returned already...\n", Book_name);
            }
            else
            {
                book.set(1, null);
                book.set(2, null);
                this.BooksInfo.replace(Book_name, book);
                System.out.printf("The %s Book is returned...\n", Book_name);
            }
        }
        else
        {
            System.out.format("The %s Book is not from store...\n", Book_name);
        }
    }

    public void ShowAvailableBooks()
    {
        Set<String> keys = new HashSet<>(this.BooksInfo.keySet());
        System.out.println("-".repeat(166));
        String format = "|%-10s|%-50s|%-40s|%-40s|%-20s|%n";
        System.out.format(format, "   S.No", "                    Book Name", "             Author Name",
                "                Issue by", "     Issue Date");
        System.out.println("-".repeat(166));
        int i = 1;
        for (String name : keys)
        {
            if (i<10)
            {
                if (this.BooksInfo.get(name).get(1) == null && this.BooksInfo.get(name).get(2) == null)
                {
                    System.out.format(format, "    0" + (i), "       " + name,
                            "         " + this.BooksInfo.get(name).get(0),
                            "        " + "Not Issued",
                            "     " + "Not Issued");
                }
                else
                {
                    System.out.format(format, "    0" + (i), "       " + name,
                            "         " + this.BooksInfo.get(name).get(0),
                            "        " + this.BooksInfo.get(name).get(1),
                            "   " + this.BooksInfo.get(name).get(2));
                }

            }
            else
            {
                if (this.BooksInfo.get(name).get(1) == null && this.BooksInfo.get(name).get(2) == null)
                {
                System.out.format(format, "    " + (i), "       " + name,
                        "         " + this.BooksInfo.get(name).get(0),
                        "        " + "Not Issued",
                        "      " + "Not Issued");
                }
                else
                {
                System.out.format(format, "    " + (i), "       " + name,
                        "         " + this.BooksInfo.get(name).get(0),
                        "        " + this.BooksInfo.get(name).get(1),
                        "   " + this.BooksInfo.get(name).get(2));
                }
            }
            i++;
        }
        System.out.println("-".repeat(166));
    }
}

public class Java_Exercise_7_Library_Management_System
{
    public static void main(String[] args)
    {
        Library_Management_System library = new Library_Management_System();
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            System.out.println("WELCOME TO ONLINE LIBRARY");
            System.out.print("1.ADD BOOK\n2.ISSUE BOOK\n3.RETURN BOOK\n4.SHOW AVAILABLE BOOKS\n5.EXIT\nPRESS : ");
            num = sc.nextInt();
            if (num == 1)
            {
                library.Add_Book();
            }
            else if (num == 2)
            {
                library.Issue_Book();
            }
            else if (num == 3)
            {
                library.Return_Book();
            }
            else if (num == 4)
            {
                library.ShowAvailableBooks();
            }
            else if (num == 5)
            {
                System.out.println("Thanks for coming....");
                System.exit(0);
            }
        }
    }
}
