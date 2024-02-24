package CalcApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.ImageIcon;
import java.io.*;

public class CalcUI implements ActionListener {

    private final JFrame frame;

    private final JPanel panel;
    private final JPanel panelSub1;
    private final JPanel panelSub2;
    private final JPanel panelSub3;
    private final JPanel panelSub4;
    private final JPanel panelSub5;
    private final JPanel panelSub6;
    private final JPanel panelSub7;
    private final JPanel panelSub8;

    private final JTextArea text;

    private final JButton but[],butAdd, butMinus, butMultiply, butDivide,
            butEqual, butCancel, butSquareRoot, butSquared,
            butCos, butSin, butTan, toPowerOfY, butlogBaseTen, butBinary, butln;

    private final Calculator calc;

    private final String[] buttons = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Pi", "e"};

    private final Font font;
    private final Font textFont;
   // private final ImageIcon image;


    public CalcUI() throws IOException {
        frame = new JFrame("Matts Calculator");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panelSub1 = new JPanel(new FlowLayout());
        panelSub2 = new JPanel(new FlowLayout());
        panelSub3 = new JPanel(new FlowLayout());
        panelSub4 = new JPanel(new FlowLayout());
        panelSub5 = new JPanel(new FlowLayout());
        panelSub6 = new JPanel(new FlowLayout());
        panelSub7 = new JPanel(new FlowLayout());
        panelSub8 = new JPanel(new FlowLayout());

        font = new Font("Consolas", Font.PLAIN, 18);
        text = new JTextArea(1, 30);
        textFont = new Font("Consolas", Font.BOLD, 24);

        but = new JButton[10];
        for (int i = 0; i < 10; i++) but[i] = new JButton(String.valueOf(i));

        butAdd = new JButton("+");
        butMinus = new JButton("-");
        butMultiply = new JButton("*");
        butDivide = new JButton("/");
        butEqual = new JButton("=");
        butSquareRoot = new JButton("sqrt");
        butSquared = new JButton("x*x");
        butCos = new JButton("Cos");
        butSin = new JButton("Sin");
        butTan = new JButton("Tan");
        butln = new JButton("ln");
        toPowerOfY = new JButton("x^y");
        butlogBaseTen = new JButton("log10(x)");
        butCancel = new JButton("C");
        butBinary = new JButton("Bin");

        calc = new Calculator();
    }

    public void init(){
        frame.setSize(450,450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        text.setFont(textFont);
        text.setEditable(false);

        for (int i = 0; i < 10; i++) {
            but[i].setFont(font);
        }

        butAdd.setFont(font);
        butMinus.setFont(font);
        butMultiply.setFont(font);
        butDivide.setFont(font);
        butEqual.setFont(font);
        butSquareRoot.setFont(font);
        butSquared.setFont(font);
        butCos.setFont(font);
        butSin.setFont(font);
        butTan.setFont(font);
        butln.setFont(font);
        toPowerOfY.setFont(font);
        butlogBaseTen.setFont(font);
        butCancel.setFont(font);
        butBinary.setFont(font);

        panel.add(Box.createHorizontalStrut(100));
        panelSub1.add(text);
        panel.add(panelSub1);

        panelSub2.add(but[1]);
        panelSub2.add(but[2]);
        panelSub2.add(but[3]);
        panelSub2.add(Box.createHorizontalStrut(15));
        panelSub2.add(butAdd);
        panelSub2.add(butMinus);
        panel.add(panelSub2);

        panelSub3.add(but[4]);
        panelSub3.add(but[5]);
        panelSub3.add(but[6]);
        panelSub3.add(Box.createHorizontalStrut(15));
        panelSub3.add(butMultiply);
        panelSub3.add(butDivide);
        panel.add(panelSub3);

        panelSub4.add(but[7]);
        panelSub4.add(but[8]);
        panelSub4.add(but[9]);
        panelSub4.add(Box.createHorizontalStrut(15));
        panelSub4.add(butEqual);
        panelSub4.add(butCancel);
        panel.add(panelSub4);

        panelSub5.add(Box.createHorizontalStrut(92));
        panelSub5.add(but[0]);
        panelSub5.add(butln);
        panelSub5.add(Box.createHorizontalStrut(210));
        panel.add(panelSub5);

        panelSub6.add(butSquared);
        panelSub6.add(butSquareRoot);
        panelSub6.add(toPowerOfY);
        panel.add(panelSub6);

        panelSub7.add(butCos);
        panelSub7.add(butSin);
        panelSub7.add(butTan);
        panel.add(panelSub7);

        panelSub8.add(butlogBaseTen);
        panelSub8.add(butBinary);
        panel.add(panelSub8);

        for (int i = 0; i < 10; i++) {
            but[i].addActionListener(this);
        }
        butAdd.addActionListener(this);
        butMinus.addActionListener(this);
        butMultiply.addActionListener(this);
        butDivide.addActionListener(this);
        butSquared.addActionListener(this);
        butSquareRoot.addActionListener(this);
        butCos.addActionListener(this);
        butSin.addActionListener(this);
        butTan.addActionListener(this);
        butln.addActionListener(this);
        toPowerOfY.addActionListener(this);
        butlogBaseTen.addActionListener(this);
        butBinary.addActionListener(this);

        butEqual.addActionListener(this);
        butCancel.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        Double checkNum = null;

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttons[i]);
                return;
            }
        }


        try {
            checkNum = Double.parseDouble(text.getText());
        }
        catch(NumberFormatException ignored) {}

        if (checkNum != null || source == butCancel) {
            if (source == butAdd) {
                writer(calc.calculateOps(Calculator.twoNumOps.add, reader()));
                text.replaceSelection(butAdd.getText());
            }

            if (source == butMinus) {
                writer(calc.calculateOps(Calculator.twoNumOps.subtract, reader()));
                text.replaceSelection(butMinus.getText());
            }

            if (source == butMultiply) {
                writer(calc.calculateOps(Calculator.twoNumOps.multiply, reader()));
                text.replaceSelection(butMultiply.getText());
            }

            if (source == butDivide) {
                writer(calc.calculateOps(Calculator.twoNumOps.divide, reader()));
                text.replaceSelection(butDivide.getText());
            }

            if (source == toPowerOfY) {
                writer(calc.calculateOps(Calculator.twoNumOps.toPowerOfY, reader()));
            }

            if (source == butSquared) {
                writer(calc.calculateOneNum(Calculator.oneNumOps.squared, reader()));
            }

            if (source == butSquareRoot)
                writer(calc.calculateOneNum(Calculator.oneNumOps.squareRoot, reader()));

            if (source == butCos)
                writer(calc.calculateOneNum(Calculator.oneNumOps.cos, reader()));

            if (source == butSin)
                writer(calc.calculateOneNum(Calculator.oneNumOps.sin, reader()));

            if (source == butTan)
                writer(calc.calculateOneNum(Calculator.oneNumOps.tan, reader()));

            if (source == butlogBaseTen)
                writer(calc.calculateOneNum(Calculator.oneNumOps.logBaseTen, reader()));

            if (source == butln)
                writer(calc.calculateOneNum(Calculator.oneNumOps.ln, reader()));


            if (source == butEqual)
                writer(calc.calculateEqual(reader()));

            if (source == butCancel)
                writer(calc.reset());

            if (source == butBinary)
                parsetoBinary();
        }

        text.selectAll();
    }

    private void parsetoBinary() {
        try {
            text.setText(Long.toBinaryString(Long.parseLong(text.getText())));
        } catch (NumberFormatException ex) {
            System.err.println("Error while parse to binary." + ex.toString());
        }
    }

    public Double reader() {
        double num;
        String str;
        str = text.getText();
        num = Double.parseDouble(str);

        return num;
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }
}











