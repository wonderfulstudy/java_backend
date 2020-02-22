package jar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo015 extends JFrame{
    /**
     * 监听和事件
     * 
     * 动作事件监听器
     */
    public Demo015(){
        Container c=getContentPane();
        setBounds(100,100,500,120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JPanel centerP=new JPanel();
        centerP.setLayout(new FlowLayout());
        c.add(centerP, BorderLayout.CENTER);

        JPanel southP=new JPanel();
        final JLabel console=new JLabel("点击组件");
        southP.add(console);
        c.add(southP, BorderLayout.SOUTH);

        JButton btn=new JButton("按钮");
        centerP.add(btn);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                console.setText("按钮被点击了");
            }
        });

        JTextField jt=new JTextField(10);
        centerP.add(jt);
        jt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Object obj=e.getSource();
                JTextField jtmp=(JTextField)obj;
                System.out.println(jtmp.getText());
                console.setText("文本框中点击了回车");
            }
        });

        JCheckBox jc=new JCheckBox("多选框");
        centerP.add(jc);
        jc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                console.setText("多选框被点击了");
            }
        });

        JRadioButton jr=new JRadioButton("单选框");
        centerP.add(jr);
        jr.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                console.setText("单选框被点击了");
            }
        });

        String values[]={"选项1","选项2","选项3"};
        JComboBox jb=new JComboBox<>(values);
        centerP.add(jb);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                console.setText("下拉列表被点击了");
            }
        });

        c.validate();//重新验证一下容器中的组件
    }
    
    public static void main(String[] args) {
        new Demo015();
    }
}