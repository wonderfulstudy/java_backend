package jar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo016 extends JFrame{
    /**
     * 焦点事件监听器
     * 
     */ 
    public Demo016(){
        setBounds(100,100,250,180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField jt1=new JTextField(10);
        jt1.setBounds(10,10,66,21);
        contentPane.add(jt1);

        JTextField jt2=new JTextField(10);
        jt2.setBounds(10,41,66,21);
        contentPane.add(jt2);

        JTextField jt3=new JTextField();
        jt3.setBounds(10,72,66,21);
        contentPane.add(jt3);

        // final JLabel jl1=new JLabel("未获得焦点");
        // jl1.setBounds(86,13,100,15);
        // contentPane.add(jl1);

        // final JLabel jl2=new JLabel("未获得焦点");
        // jl2.setBounds(86,44,100,15);
        // contentPane.add(jl2);

        // final JLabel jl3=new JLabel("未获的焦点");
        // jl3.setBounds(86,75,100,15);
        // contentPane.add(jl3);

        // 焦点监听方式一
        // jt1.addFocusListener(new FocusListener(){
        //     @Override
        //     public void focusLost(FocusEvent e){
        //         jl1.setText("失去焦点");
        //         jl1.setForeground(Color.RED);
        //     }

        //     @Override
        //     public void focusGained(FocusEvent e){
        //         jl1.setText("");
        //     }
        // });

        // jt2.addFocusListener(new FocusListener(){
        //     @Override
        //     public void focusLost(FocusEvent e){
        //         jl2.setText("失去焦点");
        //         jl2.setForeground(Color.RED);
        //     }

        //     @Override
        //     public void focusGained(FocusEvent e){
        //         jl2.setText("");
        //     }
        // });

        // jt3.addFocusListener(new FocusListener(){
        //     @Override
        //     public void focusLost(FocusEvent e){
        //         jl3.setText("失去焦点");
        //         jl3.setForeground(Color.RED);
        //     }

        //     @Override
        //     public void focusGained(FocusEvent e){
        //         jl3.setText("");
        //     }
        // });
        jt1.addFocusListener(new MyFocusListenter());//使用自定义监听实现类
        jt2.addFocusListener(new MyFocusListenter());//使用自定义监听实现类
        jt3.addFocusListener(new MyFocusListenter());//使用自定义监听实现类

        setVisible(true);
    }

    class MyFocusListenter implements FocusListener{
        //监听方式二
        //自定义的焦点事件监听类
        @Override
        public void focusLost(FocusEvent e){
            JTextField tmp=(JTextField)e.getSource();//获取触发事件的组件
            tmp.setBorder(BorderFactory.createLineBorder(Color.GREEN));//给失去焦点的文本框设置绿边框
        }

        @Override
        public void focusGained(FocusEvent e){
            JTextField tmp=(JTextField)e.getSource();//获取触发事件的组件
            tmp.setBorder(BorderFactory.createLineBorder(Color.RED));//给失去焦点的文本框设置红边框
        }
    }
    
    public static void main(String[] args) {
        new Demo016();
    }
}