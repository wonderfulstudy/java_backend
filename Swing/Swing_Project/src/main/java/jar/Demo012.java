package jar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo012 extends JFrame{
    /**
     * Java文本框组件
     */
    public Demo012(){
        setBounds(100,100,400,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        final JTextField jt=new JTextField(20);
        jt.setColumns(20);//设置文本框长度，20个字符
        jt.setText("aa");
        jt.setFont(new Font("微软雅黑",Font.PLAIN,20));//设置字体格式
        c.add(jt);
        
        JButton btn=new JButton("确认");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("文本框中的内容为："+jt.getText());//获取文本框中的文本值
                jt.setText("");//清空文本框的内容
                jt.requestFocus();//获取焦点，获取光标
            }
        });
        c.add(btn);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Demo012();
    }
}