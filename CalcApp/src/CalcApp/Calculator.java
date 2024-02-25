package CalcApp;

import java.lang.Math;

public class Calculator {

    public enum twoNumOps {
        normal, add, subtract, multiply, divide, toPowerOfY, customLog
    }

    public enum oneNumOps {
        squared, squareRoot, sin,cos, tan, ln, logBaseTen, pi
    }

    private double num1, num2;
    private twoNumOps mode = twoNumOps.normal;

    private Double calculateTwoNums() {
        if (mode.equals(twoNumOps.normal)) {
            return num2;
        }
        if (mode.equals(twoNumOps.add)) {
            return num1 + num2;
        }
        if (mode.equals(twoNumOps.subtract)) {
            return num1 - num2;
        }
        if (mode.equals(twoNumOps.multiply)){
            return num1 * num2;
        }
        if (mode.equals(twoNumOps.divide)){
            return num1 / num2;
        }
        if (mode.equals(twoNumOps.toPowerOfY)){
            return Math.pow(num1, num2);
        }
        if (mode.equals(twoNumOps.customLog)){
            return (Math.log(num1) / Math.log(num2));
        }

        throw new Error();

    }

    public Double calculateOneNum(oneNumOps newMode, double num) {

        if (newMode.equals(oneNumOps.squared)) {
            return num * num;
        }
        if (newMode.equals(oneNumOps.squareRoot)){
            return Math.sqrt(num);
        }
        if (newMode.equals(oneNumOps.sin)){
            return Math.sin(num);
        }
        if (newMode.equals(oneNumOps.cos)) {
            return Math.cos(num);
        }
        if (newMode.equals(oneNumOps.tan)){
            return Math.tan(num);
        }
        if (newMode.equals(oneNumOps.ln)) {
            return Math.log(num);
        }
        if (newMode.equals(oneNumOps.logBaseTen)){
            return Math.log10(num);
        }
        if (newMode.equals(oneNumOps.pi)){
             return Math.PI * num;
        }

        throw new Error();
    }

    public Double reset(){
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

   public Double calculateEqual(Double num){
            return calculateOps(twoNumOps.normal, num);}
    }

