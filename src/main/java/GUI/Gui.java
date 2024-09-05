package src.gui;

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

    //todo: integrate converter and calculator code
    String getCalculations(String string){
        String[] ops = {"+","-","*","/"};
        String val = "";
        for(String s: ops){
            if(string.contains(s)){
                val = string.substring(0,string.indexOf(s))+string.substring(string.indexOf(s)+1);
                break;
            }
        }
        return val;
    }



    //todo: integrate calculator functions
    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton b: buttons){
            if(b==e.getSource()){
                switch(b.getText()){
                    case "=":
                        text.setText(text.getText()+"="+getCalculations(text.getText()));
                        reset=true;
                        break;
                    case "sqr":
                        text.setText(text.getText()+"="+"to be implemented");
                        reset=true;
                        break;

                    case "root":
                        text.setText(text.getText()+"="+"to be implemented");
                        reset=true;
                        break;

                    case "dec":
                        b.setText("quat");
                        text.setText("to be implemented");
                        break;

                    case "quat":
                        b.setText("dec");
                        text.setText("to be implemented");
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
