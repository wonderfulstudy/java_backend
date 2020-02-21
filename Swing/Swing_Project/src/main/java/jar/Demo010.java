package jar;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Demo010 extends JFrame{
    /**
     * Java下拉列表框组件
     */
    public Demo010(){
        setBounds(100,100,190,120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c=getContentPane();
        c.setLayout(null);

        // JComboBox<String> comboBox=new JComboBox<>();
        // comboBox.addItem("身份证");
        // comboBox.addItem("学生证");
        // comboBox.addItem("工作证");

        // String items[]={"数组元素1","数组元素2","数组元素3"};
        // JComboBox<String> comboBox=new JComboBox<>(items);//使用String数组添加下拉列表元素
        
        final JComboBox<String> comboBox=new JComboBox<>();
        String items[]={"身份证","学生证","军人证"};
        ComboBoxModel cm=new DefaultComboBoxModel<>(items);
        comboBox.setModel(cm);//向列表中添加数据模型
        
        JButton btn=new JButton("打印");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("选中的索引"+comboBox.getSelectedIndex());//获取选中的索引
                System.out.println("选中的值"+comboBox.getSelectedItem());//获取选中的值
            }
        });
        btn.setBounds(100,10,60,20);
        c.add(btn);

        comboBox.setEditable(true);//是否可以编辑

        comboBox.setBounds(10,10,80,21);//设置坐标和大小
        c.add(comboBox);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Demo010();
    }
}    