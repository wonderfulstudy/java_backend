package jar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.*;

public class Demo003 extends JFrame{
    public Demo003(){
        setBounds(100,100,300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c=getContentPane();
        setVisible(true);

        JLabel l=new JLabel("这是一个标签");
        // l.setText("更改标签内容");
        // System.out.println(l.getText());
        l.setFont(new Font("微软雅黑",Font.BOLD,16));
        l.setForeground(Color.RED);//更改前景色，更改字体颜色
        
        c.add(l);
    }

    public static void main(String[] args) {
        new Demo003();
    }
}