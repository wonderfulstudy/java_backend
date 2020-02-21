package jar;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Demo011 extends JFrame {
    public Demo011(){
        setBounds(100,100,217,167);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(null);

        String items[]={"元素1","元素2","元素3","元素4","元素5","元素6","元素7","元素8"};
        // JList<String> jl=new JList<>(items);

        DefaultListModel<String> model=new DefaultListModel<>();
        for(String tmp:items){
            model.addElement(tmp);//向数据模型添加元素
        }
        final JList<String> jl=new JList<>();
        model.addElement("添加元素");//数据模型添加新元素
        jl.setModel(model);//列表框载入数据模型

        /**
         * SINGLE_SELECTION：单选
         * SINGLE_INTERVAL_SELECTION：只能连续选择相邻的元素
         * MULTIPLE_INTERVAL_SELECTION：随便选
         * 
         */
        jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//设置选择模式

        JScrollPane js=new JScrollPane(jl);//为列表框添加滚动条
        js.setBounds(10,10,100,100);//设定坐标和大小
        c.add(js);

        JButton btn=new JButton("确认");
        btn.setBounds(120,90,70,25);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                //获取列表框中选中的所有元素
                java.util.List<String> value=jl.getSelectedValuesList();
                for(String tmp:value){
                    System.out.println(tmp);
                }
                System.out.println("---------end----------");
            }
        });
        c.add(btn);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Demo011();
    }
}