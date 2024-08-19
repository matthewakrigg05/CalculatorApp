import java.lang.Math;

public class Calculator {

    public enum twoNumOps {
        normal, add, subtract, multiply, divide, toPowerOfY, customLog
    }

    public enum oneNumOps {
        squared, squareRoot, sin, cos, tan, ln, logBaseTen, pi, e
    }

    private double num1, num2;
    private twoNumOps mode = twoNumOps.normal;

    private Double calculateTwoNums() {
        switch (mode) {
            case normal: return num1;
            case add: return num1 + num2;
            case subtract: return num1 - num2;
            case multiply: return num1 * num2;
            case divide: return num1 / num2;
            case toPowerOfY: return Math.pow(num1, num2);
            case customLog: return Math.log(num1) / Math.log(num2);
            default: throw new Error();
        }
    }

    public Double calculateOneNum(oneNumOps newMode, double num) {

        switch (newMode) {
            case squared: return num * num;
            case squareRoot: return Math.sqrt(num);
            case sin: return Math.sin(num);
            case cos: return Math.cos(num);
            case tan: return Math.tan(num);
            case ln: return Math.log(num);
            case logBaseTen: return Math.log10(num);
            case pi: return Math.PI * num;
            case e: return Math.exp(num);
            default: throw new Error();
        }
    }

    public Double reset() {
        num1 = 0.0;
        num2 = 0.0;
        mode = twoNumOps.normal;
        return Double.NaN;
    }

    public Double calculateOps(twoNumOps newMode, Double num) {
        if (mode.equals(twoNumOps.normal)) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return Double.NaN;
        } else {
            num2 = num;
            num1 = calculateTwoNums();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateOps(twoNumOps.normal, num);
    }

}