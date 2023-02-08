import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator {
    private JPanel pane1;
    private JButton bt1;
    private JButton dotbt;
    private JButton equalbt;
    private JButton bt0;
    private JButton bt00;
    private JButton bt2;
    private JButton bt6;
    private JButton plusbt;
    private JButton bt3;
    private JButton bt5;
    private JButton bt4;
    private JButton minusbt;
    private JButton bt9;
    private JButton timesbt;
    private JButton bt8;
    private JButton bt7;
    private JButton dividebt;
    private JButton btx;
    private JButton percentagebt;
    private JButton btc;
    private JTextField tf1;

    double a,b,result;
    String op;

    public calculator() {
        btc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             tf1.setText("");
            }
        });
        bt7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt7.getText());
            }
        });
        bt8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt8.getText());
            }
        });
        bt9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt9.getText());
            }
        });
        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt4.getText());
            }
        });
        bt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt5.getText());
            }
        });
        bt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt6.getText());
            }
        });
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tf1.setText(tf1.getText()+bt1.getText());
            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt2.getText());
            }
        });
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt3.getText());
            }
        });
        bt00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt00.getText());
            }
        });
        bt0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText()+bt0.getText());
            }
        });
        dotbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        if(!tf1.getText().contains(".")){
            tf1.setText(tf1.getText()+dotbt.getText());
        }
            }
        });
        plusbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=Double.parseDouble(tf1.getText());
                op="+";
                tf1.setText("");
            }
        });
        minusbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=Double.parseDouble(tf1.getText());
                op="-";
                tf1.setText("");
            }
        });
        timesbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=Double.parseDouble(tf1.getText());
                op="*";
                tf1.setText("");
            }
        });
        dividebt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=Double.parseDouble(tf1.getText());
                op="÷";
                tf1.setText("");
            }
        });

        percentagebt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=Double.parseDouble(tf1.getText());
                op="%";
                tf1.setText("");
            }
        });
        btx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String backspace=null;
                if(tf1.getText().length()>0){
                    StringBuilder strB=new StringBuilder(tf1.getText());
                    strB.deleteCharAt(tf1.getText().length()-1);
                    backspace=String.valueOf(strB);
                    tf1.setText(backspace);
                }
            }
        });
        equalbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b=Double.parseDouble(tf1.getText());
                if(op=="+"){
                    result=a+b;
                    tf1.setText(String.valueOf(result));
                }else if(op=="-"){
                    result=a-b;
                    tf1.setText(String.valueOf(result));
                } else if (op=="*") {
                    result=a*b;
                    tf1.setText(String.valueOf(result));
                } else if (op=="/") {
                    result=a/b;
                    tf1.setText(String.valueOf(result));
                }else {
                    result=a/100;
                    tf1.setText(String.valueOf(result));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("calculator");
        frame.setContentPane(new calculator().pane1);
        frame.setBounds(150,150,500,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}

