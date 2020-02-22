package jar;

import java.awt.*;
import javax.swing.*;

public class Demo014 extends JFrame{
    /**
     * 文本域组件
     */
    public Demo014(){
        setBounds(100,100,400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container c=getContentPane();
        c.setLayout(new FlowLayout());

        JTextArea area=new JTextArea();
        area.setText("这是文本域");//设定文本内容
        area.setRows(5);//设定行
        area.setColumns(20);//设定列
        area.append("添加内容");//添加内容
        area.insert("插入",2);//在第二个字符后插入内容
        area.setFont(new Font("微软雅黑",Font.PLAIN,20));
        JScrollPane js=new JScrollPane(area);//给文本域添加滚动
        c.add(js);
        
        setVisible(true);    
    }
    
    public static void main(String[] args) {
        new Demo014();
    }
}