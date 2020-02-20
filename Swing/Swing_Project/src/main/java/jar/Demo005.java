package jar;

import java.awt.*;

import javax.swing.*;

/**
 * 绝对布局 Null布局
 * 
 * 使用绝对布局的窗口通常都是固定大小的，
 * 组件的位置和形状不会随着窗体的改变而发生变化
 */

public class Demo005 extends JFrame{
    /**
     * 
     * @param args
     */
    public Demo005(){
        setBounds(100,100,200,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c=getContentPane();

        c.setLayout(null);//将容器的布局设置为绝对布局
        JButton b1=new JButton("按钮1"), b2=new JButton("按钮2");
        b1.setBounds(10,30,80,30);//设置按钮在容器中的坐标和大小
        b2.setBounds(60,70,100,20);
        c.add(b1);
        c.add(b2);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Demo005();
        
    }
}