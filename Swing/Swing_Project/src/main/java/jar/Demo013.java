package jar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo013 extends JFrame{
    public Demo013(){
        setBounds(100,100,350,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        final JPasswordField jp=new JPasswordField();
        jp.setColumns(20);//设置密码框长度为20个字符
        jp.setFont(new Font("Arial",Font.BOLD,18));//设置字体
        jp.setEchoChar('*');//设置回显字符
        jp.addActionListener(new ActionListener(){//添加动作监听，回车
            public void actionPerformed(ActionEvent arg0){
                char ch[]=jp.getPassword();//获取密码的字符数组
                String str=new String(ch);
                System.out.println(str);
            }
        });
        c.add(jp);


        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Demo013();
    }
}