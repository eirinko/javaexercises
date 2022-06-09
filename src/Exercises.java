import java.util.Scanner;

public class Exercises {
    public static void main (String[] args) {
        //https://www.w3resource.com/java-exercises/basic/index.php
        //1:
        System.out.println("Hello");
        System.out.println("Eirin Korvald");

        //2:
        int x_2=74;
        int y_2=36;
        System.out.println(x_2 + y_2);

        //3:
        int x_3=50;
        int y_3=3;
        System.out.println(x_3 / y_3);

        //4:
        System.out.println(-5 + 8 * 6);
        System.out.println((55+9) %9);
        System.out.println(20 + -3*5 / 8);
        System.out.println(5 + 15 / 3 * 2 - 8 % 3);

        //5:
        Scanner scan_5=new Scanner(System.in);
        System.out.print("Input first number: ");
        int num5_1=scan_5.nextInt();
        System.out.print("Input second number: ");
        int num5_2=scan_5.nextInt();
        int mul5=num5_1*num5_2;
        System.out.println(num5_1 + " x " + num5_2 + " = " + mul5);

        //6:
        System.out.print("Input first number: ");
        int num6_1=scan_5.nextInt();
        System.out.print("Input second number: ");
        int num6_2=scan_5.nextInt();
        int sum6=num6_1+num6_2;
        int sub6=num6_1-num6_2;
        int mul6=num6_1*num6_2;
        int div6=num6_1/num6_2;
        int mod6=num6_1%num6_2;
        
        System.out.println("Sum: " + num6_1 + " + " + num6_2 + " = " + sum6);
        System.out.println("Multiplication: " + num6_1 + " x " + num6_2 + " = " + mul6);
        System.out.println("Subtraction: " + num6_1 + " - " + num6_2 + " = " + sub6);
        System.out.println("Division: " + num6_1 + " / " + num6_2 + " = " + div6);
        System.out.println("Remainder: " + num6_1 + " mod " + num6_2 + " = " + mod6);

        //7:

        //8:

        scan_5.close();
    }
}
