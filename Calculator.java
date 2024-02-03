
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number");
        double num1=sc.nextDouble();
        System.out.println("Enter the second number");
        double num2=sc.nextDouble();
        double result;
        System.out.println("choose any operator among (+,-,*,/) :");
        char operator=sc.next().charAt(0);
        switch(operator)
        {
            case'+':
                result=num1+num2;
                System.out.println("Result :"+num1+"+"+num2+"="+result);
                break;
            case'-':
                result=num1-num2;
                System.out.println("Result :"+num1+"-"+num2+"="+result);
                break;
            case'*':
                result=num1*num2;
                System.out.println("Result :"+num1+"*"+num2+"="+result);
                break;
            case'/':
                if(num2>0) {
                    result = num1 / num2;
                    System.out.println("Result :" + num1 + "/" + num2 + "=" + result);
                }
                else {
                    System.out.println("ERROR!!! Number Can't be divide by zero");
                }
                break;
            default:
                System.out.println("Invalid operator !, choose any operator only among (+,-,*,/)");
        }

    }
}
