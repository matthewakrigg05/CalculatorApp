package CalcApp;

public class Main {

    public static void main(String[] args){
        try {
            CalcUI uiCal = new CalcUI();
            uiCal.init();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
