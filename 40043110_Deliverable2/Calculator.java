package calculator_main;

public class Calculator {
    public enum Operators {
        normal, add, minus, multiply, divide, silverRatio
    }
    private Double num, num1, num2;
    private Operators mode = Operators.normal;

    private Double calculate() {
        if (mode == Operators.normal) {
            return num2;
        }
        if (mode == Operators.add) {
            return num1 + num2;
        }
        if (mode == Operators.minus) {
            return num1 - num2;
        }
        if (mode == Operators.multiply) {
            return num1 * num2;
        }
        if (mode == Operators.divide) {
            return num1 / num2;
        }
        if (mode == Operators.silverRatio) {
        	num = 2 * (1 + 1.41 )*(num1*num1);
            return num ;
        }
        throw new Error();
    }

    public Double calculate(Operators newMode, Double num) {
        if (mode == Operators.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return Double.NaN;
        }
//        else if (mode == Operators.silverRatio){
//        	num2 = 0.0;
//        	num1 = num;
//        	num2 = calculate();
//            //mode = newMode;
//            return num2;
//        }
        else {
            num2 = num;
            num1 = calculate();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculate(Operators.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = Operators.normal;

        return Double.NaN;
    }
}

