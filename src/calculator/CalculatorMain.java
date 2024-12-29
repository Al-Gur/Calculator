package calculator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CalculatorMain {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: 3 arguments must be entered in command line!");
            return;
        }
        double x;
        double y;
        double res;
        String operation;
        try {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            operation = args[2];
        } catch (Exception e) {
            System.out.println("Error: type of first 2 arguments must be double!");
            return;
        }

        try {
            Method method = Calc.class.getDeclaredMethod(operation, double.class, double.class);
            method.setAccessible(true);
            Constructor constructor = Calc.class.getDeclaredConstructor();
            res = (double) method.invoke(constructor.newInstance(), x, y);

//            switch (operation) {
//                case "Add":
//                    res = Calc.Add(x, y);
//                    break;
//                case "Subtract":
//                    res = Calc.Subtract(x, y);
//                    break;
//                default:
//                    System.out.println("Error: 3th argument denotes unknown operation!");
//                    return;
//            }

        } catch (NoSuchMethodException e) {
            System.out.println("Error: 3th argument in the command line (" + operation + ") denotes unknown operation!");
            return;
        } catch (Exception e) {
            System.out.println("Error (" + e + "), message = " + e.getMessage());
            return;
        }

        System.out.println("Arguments: " + x + ", " + y);
        System.out.println("Operation: " + operation);
        System.out.println("Result = " + res);
    }
}
