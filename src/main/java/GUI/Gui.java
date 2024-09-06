package GUI;
import Logic.Conversions;
import Logic.MultiNumberOperations;
import Logic.SingleButtonFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui implements ActionListener{

    ArrayList<JButton> buttons = new ArrayList<>();
    JFrame frame = new JFrame();

    JLabel text = new JLabel();
    Font font = new Font("font",Font.PLAIN,40);
    boolean reset=false;



    public Gui(){
        makeButtons();

        text.setBounds(0,0,450,100);
        text.setFont(font);
        frame.add(text);

        frame.setSize(450,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    void makeButtons(){
        String[][] buttonText = {
                {"0", "1", "+",},
                {"2", "3", "-",},
                {"*", "/", "=",},
                {"sqr", "root", "dec"}
        };
        int[] x = {0,150,300}, y = {100, 180, 260, 340};
        for(int o=0;o<buttonText.length;o++){
            for(int i=0;i<buttonText[o].length;i++){
                JButton button = new JButton(buttonText[o][i]);
                button.setBounds(x[i],y[o],150,80);
                button.addActionListener(this);
                button.setFont(font);

                buttons.add(button);
                frame.add(button);

            }
        }
    }

    Conversions conversions = new Conversions();
    MultiNumberOperations multi = new MultiNumberOperations();
    SingleButtonFunctions single = new SingleButtonFunctions();
    boolean quat = true;
    ArrayList<String> calculationValues = new ArrayList<>();
    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton b: buttons){
            if(b==e.getSource()){
                String value;
                switch(b.getText()){
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        value = text.getText();
                        if(!quat){
                            value = conversions.decToQuat(Integer.parseInt(value));
                        }
                        calculationValues.add(value);
                        calculationValues.add(b.getText());
                        reset = true;
                        break;

                    case "sqr":
                    case "root":
                        value = text.getText();
                        if(!quat){
                            value = conversions.decToQuat(Integer.parseInt(value));
                        }
                        text.setText(single.calculate(value, b.getText()));
                        reset=true;
                        break;


                    case "=":
                        value = text.getText();
                        if(!quat){
                            value = conversions.decToQuat(Integer.parseInt(value));
                        }
                        String result = multi.calculate(calculationValues.get(0), calculationValues.get(1), value);
                        text.setText(result);
                        calculationValues.clear();
                        reset=true;
                        break;

                    case "dec":
                        b.setText("quat");
                        quat = false;
                        text.setText(String.valueOf(conversions.quatToDec(text.getText())));
                        break;

                    case "quat":
                        b.setText("dec");
                        text.setText(conversions.decToQuat(Integer.parseInt(text.getText())));
                        break;

                    default:
                        if(reset){
                            text.setText(b.getText());
                            reset=false;
                        }else text.setText(text.getText() + b.getText());

                        break;
                }
                break;
            }
        }

    }
}
