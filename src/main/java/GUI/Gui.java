package GUI;
import Logic.Conversions;
import Logic.MultiNumberOperations;
import Logic.SingleButtonFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

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

    String[] equation = {"","","",""};
    int equationLoc = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton b: buttons){
            if(b==e.getSource()){
                String value = text.getText();
                switch(b.getText()){
                    case "+","-","*","/":
                        if(equationLoc<=1) {
                            if (equationLoc == 0) equationLoc++;
                            equation[1] = b.getText();
                        }
                        break;

                    case "sqr","root":
                        if(equationLoc==0){
                            equation[1]=b.getText();
                            equation[3]=single.calculate(equation[0],b.getText());
                            equationLoc=3;
                        }
                        reset=true;
                        break;


                    case "=":
                        if(equationLoc==2) {
                            equation[3]=multi.calculate(equation[0],equation[1],equation[2]);
                            equationLoc++;
                            reset = true;
                        }
                        break;

                    case "dec":
                        b.setText("quat");
                        quat = false;
                        break;

                    case "quat":
                        b.setText("dec");
                        quat = true;
                        break;

                    default:
                        if(reset){
                            equationLoc=0;
                            equation=new String[]{"","","",""};
                            text.setText(b.getText());
                            reset=false;
                        }else {
                            if(equationLoc==0){
                                equation[equationLoc]+=b.getText();
                            }else if(equationLoc<=2){
                                if(equationLoc==1) equationLoc++;
                                equation[2]+=b.getText();
                            }
                        }
                        break;
                }
                if(quat){
                    text.setText(equation[0]+equation[1]+equation[2]+"="+equation[3]);
                }else{
                    String disp = equation[1];
                    if(!equation[0].isEmpty()) disp = conversions.quatToDec(equation[0])+disp;
                    if(!equation[2].isEmpty()) disp = disp+conversions.quatToDec(equation[2]);
                    if(!equation[3].isEmpty()) disp = disp+"="+conversions.quatToDec(equation[3]);
                    text.setText(disp);
                }
                break;
            }
        }

    }
}
