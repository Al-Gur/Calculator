package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: 3 arguments must be entered in command line!");
            return;
        }
        double x = Double.NaN;
        double y = Double.NaN;
        double res = Double.NaN;
        String operation = "";
        try {
            x = Double.parseDouble(args[0]);
            y = Double.parseDouble(args[1]);
            operation = args[2];
        } catch (Exception e) {
            System.out.println("Error: type of first 2 arguments must be double!");
        }

        try {
            switch (operation) {
                case "Add":
                    res = Calc.Add(x, y);
                    break;
                case "Subtract":
                    res = Calc.Subtract(x, y);
                    break;
                default:
                    System.out.println("Error: 3th argument denotes unknown operation!");
                    return;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Arguments: " + x + ", " + y);
        System.out.println("Operation: " + operation);
        System.out.println("Result = " + res);
    }
}
