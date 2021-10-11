package syedmuhammadtaimoor;
import java.util.Arrays;
import java.util.Scanner;


public class ex_arrays {
    public static void main(String[] args) {
        String []list_of_books = {"Harry Potter", "John Cena", "hello", "bye", "cccc"};
        System.out.println(Arrays.toString(list_of_books));
        Arrays.asList(list_of_books).add("dddddd");
        //System.out.println(Arrays.toString(list_of_books));

        // PRACTICE PROBLEM 1
//        float sum = 0;
//        float [] marks = {40.5f,59.5f};
//        for(float element: marks){
//            sum+=element;
//        }
//        System.out.println(sum);

        // PRACTICE PROBLEM 2
//        float [] marks = {40.5f,59.5f};
//        float num = 59f;
//        int i = 0;
//        while(i<marks.length){
//            if(num == marks[i]){
//                System.out.println("The number is present in the array");
//                break;
//            }
//            i++;
//        }

        // PRACTICE PROBLEM 4
//        int [][] mat1 = {{1,2,3}, {4,5,6}};
//        int [][] mat2 = {{1,2,3}, {4,5,6}};
//        int [][] result = new int[2][3];
//        for (int i = 0; i < mat1.length; i++) {
//            for (int j = 0; j < mat1[i].length; j++) {
//                result[i][j] = mat1[i][j] + mat2[i][j];
//            }
//        }
//        System.out.println(Arrays.deepToString((result)));

        // PRACTICE PROBLEM 5
//        int [] arr = {1, 2, 3, 4, 5};
//        int l = arr.length;
//        int n = Math.floorDiv(l, 2);
//        int save;
//        for (int i = 0; i < n; i++) {
//            save = arr[i];
//            arr[i] = arr[l-1-i];
//            arr[l-1-i] = save;
//        }
//        System.out.println(Arrays.toString(arr));

        // PRACTICE PROBLEM 7
//        int [] arr = {11, 25, 82, 44, 59};
//        int min_element = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i]<min_element){
//                min_element = arr[i];
//            }
//        }
//        System.out.println(min_element);

        // PRACTICE PROBLEM 8

//        int [] arr = {11, 25, 82, 44, 59};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

    }
}
