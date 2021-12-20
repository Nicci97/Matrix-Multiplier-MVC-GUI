import java.util.Scanner;

public class FloydTriangle {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  
        
        System.out.println("Enter row number: ");
        int row = Integer.parseInt(myObj.nextLine());  // Read user input
        
        System.out.println("Enter column number: ");
        int col = Integer.parseInt(myObj.nextLine());  // Read user input

        System.out.println(FloydTriangleElementCalc(row)+col+1);
    }

    public static int FloydTriangleElementCalc(int row) {
        if (row == 0) return 0;
        return FloydTriangleElementCalc(row-1) + row;
    }


    
}
