// Mason's Calculator Java Edition Beta 1.0
// Build using Java 18.0.2 and Eclipse.

package com.mason.calculator;

import java.util.*;

public class Calculator
{
    public static String restartWord;
    public static double num1;
    public static double num2;
    public static String function;
    public static Scanner input = new Scanner(System.in);

    // Main() method, used to select which mathematical function the user wants to perform.
    // Java doesn't seem to have a built-in console-clearing function like C#/.NET did, so for now, the console no longer clears when a function is performed.
    public static void main(String... args)
    {
        String category;
        
        System.out.println("Welcome to Mason's Calculator. Type in one of the following function categories to perform.\nType 'Exit' to exit the program.\n \nArithmetic, Trigonometry, Inverse Trigonometry\nAbsolute Values, Logarithms, Natural Logarithms\nPercentages, Exponents, Roots");
        category = input.nextLine();

        switch (category.toLowerCase())
        {
            case "arithmetic":
                CalculatorArithmetic();
                break;
            case "trigonometry":
                CalculatorTrigonometry();
                break;
            case "inverse trigonometry":
                CalculatorInverseTrig();
                break;
            case "absolute values":
                CalculatorAbsolute();
                break;
            case "logarithms":
                CalculatorLogarithms();
                break;
            case "natural logarithms":
                CalculatorNaturalLogs();
                break;
            case "percentages":
                CalculatorPercentages();
                break;
            case "exponents":
                CalculatorExponents();
                break;
            case "roots":
                CalculatorRoots();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("An invalid function category was entered. The program has restarted.");
                main();
        }
    }

    // Resets the program once an equation has successfully been calculated. Called in every function method.
    static void RestartWhenSuccessful()
    {
        boolean isPrinted = true;

        if (isPrinted)
        {
            System.out.println("The function was successfully performed. Type 'restart' to restart the program, or 'exit' to close the program.");
            restartWord = input.nextLine();

            if (restartWord.equals("restart"))
            {
                System.out.println("\n \n");
            	main();
            }
            else if (restartWord.equals("exit"))
            {
            	System.exit(0);
            }
            else
            {
                System.out.println("The input was not recognized. The program has restarted.");
                main();
            }
        }
    }

    // Restarts the program after an error has occurred.
    static void RestartAfterError()
    {
        boolean errorOccurred = true;

        if (errorOccurred)
        {
            System.out.println("An error has occurred. Type 'restart' to restart the program, or 'exit' to close the program.");
            restartWord = input.nextLine();

            if (restartWord.equals("restart"))
            {
                main();
            }
            else if (restartWord.equals("exit"))
            {
            	System.exit(0);
            }
            else
            {
                System.out.println("The input was not recognized. The program has restarted.");
                main();
            }
        }
    }

    // The arithmetic set of functions (addition, subtraction, multiplication, division, and modular).
    static void CalculatorArithmetic()
    {
        try
        {
            String arithOp;

            System.out.println("Enter a number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println("Enter a second number.");
            num2 = Double.parseDouble(input.nextLine());

            System.out.println("Enter one of the following operators.\n+, -, *, /, %, ^");
            arithOp = input.nextLine();

            switch (arithOp)
            {
                case "+":
                    System.out.println(num1 + num2);
                    RestartWhenSuccessful();
                    break;
                case "-":
                    System.out.println(num1 - num2);
                    RestartWhenSuccessful();
                    break;
                case "*":
                    System.out.println(num1 * num2);
                    RestartWhenSuccessful();
                    break;
                case "/":
                    System.out.println(num1 / num2);
                    RestartWhenSuccessful();
                    break;
                case "%":
                    System.out.println(num1 % num2);
                    RestartWhenSuccessful();
                    break;
                default:
                    System.out.println("An invalid operator was entered. The program has restarted.");
                    RestartAfterError();
                    break;
            }
        }
        catch (ArithmeticException e)
        {
            RestartAfterError();
        }
        catch (NumberFormatException e)
        {
            RestartAfterError();
        }
    }

    // The trigonometric set of functions (sine, cosine, tangent, cosecant, secant, and cotangent).
    static void CalculatorTrigonometry()
    {
        try
        {
            System.out.println("Enter a number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println("Enter one of the following trigonometric functions.\nsin, cos, tan, csc, sec, cot");
            function = input.nextLine();

            switch (function.toLowerCase())
            {
                case "sin":
                    System.out.println(Math.sin(num1));
                    RestartWhenSuccessful();
                    break;
                case "cos":
                    System.out.println(Math.cos(num1));
                    RestartWhenSuccessful();
                    break;
                case "tan":
                    System.out.println(Math.tan(num1));
                    RestartWhenSuccessful();
                    break;
                case "csc":
                    System.out.println(1 / Math.sin(num1));
                    RestartWhenSuccessful();
                    break;
                case "sec":
                    System.out.println(1 / Math.cos(num1));
                    RestartWhenSuccessful();
                    break;
                case "cot":
                    System.out.println(1 / Math.tan(num1));
                    RestartWhenSuccessful();
                    break;
                default:
                    System.out.println("An invalid function was entered. The program has restarted.");
                    RestartAfterError();
                    break;
            }
        }
        catch (NumberFormatException e)
        {
            RestartAfterError();
        }
    }

    // The inverse trigonometric set of functions (arcsine, arccosine, arctangent, arccosecant, arcsecant, and arccotangent).
    static void CalculatorInverseTrig()
    {
        try
        {

            System.out.println("Enter a number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println("Enter one of the following inverse trigonometric functions.\narcsin, arccos, arctan, arccsc, arcsec, arccot");
            function = input.nextLine();

            switch (function.toLowerCase())
            {
                case "arcsin":
                    System.out.println(Math.asin(num1));
                    RestartWhenSuccessful();
                    break;
                case "arccos":
                    System.out.println(Math.acos(num1));
                    RestartWhenSuccessful();
                    break;
                case "arctan":
                    System.out.println(Math.atan(num1));
                    RestartWhenSuccessful();
                    break;
                case "arccsc":
                    System.out.println(Math.asin(1 / num1));
                    RestartWhenSuccessful();
                    break;
                case "arcsec":
                    System.out.println(Math.acos(1 / num1));
                    RestartWhenSuccessful();
                    break;
                case "arccot":
                    System.out.println(Math.atan(1 / num1));
                    RestartWhenSuccessful();
                    break;
                default:
                    System.out.println("An invalid function was entered. The program has restarted.");
                    RestartAfterError();
                    break;
            }
        }
        catch (NumberFormatException e)
        {
            RestartAfterError();
        }
    }

    // The absolute value function.
    static void CalculatorAbsolute()
    {
        try
        {
            System.out.println("Enter a number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println(Math.abs(num1));

            RestartWhenSuccessful();
        }
        catch (IllegalFormatException e)
        {
            RestartAfterError();
        }
    }

    // The logarithm function (base 10).
    static void CalculatorLogarithms()
    {
        try
        {
            System.out.println("Enter a number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println(Math.log10(num1));

            RestartWhenSuccessful();
        }
        catch (NumberFormatException e)
        {
            RestartAfterError();
        }
    }

    // The natural logarithm / ln function.
    static void CalculatorNaturalLogs()
    {
        try
        {
            System.out.println("Enter a number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println(Math.log(num1));

            RestartWhenSuccessful();
        }
        catch (NumberFormatException e)
        {
            RestartAfterError();
        }
    }

    // The percentage function (converts a number into a percentage decimal form, AKA divides the number by 100).
    static void CalculatorPercentages()
    {
        try
        {
            System.out.println("Enter a number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println(num1 / 100);

            RestartWhenSuccessful();
        }
        catch (NumberFormatException e)
        {
            RestartAfterError();
        }
    }

    // The exponent function.
    static void CalculatorExponents()
    {
        try
        {
            System.out.println("Enter a base number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println("Enter an exponent.");
            num2 = Double.parseDouble(input.nextLine());

            System.out.println(Math.pow(num1, num2));

            RestartWhenSuccessful();
        }
        catch (NumberFormatException e)
        {
            RestartAfterError();
        }
    }

    // The root function.
    static void CalculatorRoots()
    {
        try
        {
            System.out.println("Enter a base number.");
            num1 = Double.parseDouble(input.nextLine());

            System.out.println("Enter a root number.");
            num2 = Double.parseDouble(input.nextLine());
            double root = 1 / num2;

            System.out.println(Math.pow(num1, root));

            RestartWhenSuccessful();
        }
        catch (NumberFormatException e)
        {
            RestartAfterError();
        }
    }
}
