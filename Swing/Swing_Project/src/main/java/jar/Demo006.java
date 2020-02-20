package jar;

import java.awt.*;
import javax.swing.*;

/**
 * 流布局
 * 
 * 从左到右排列，默认居中对齐
 * 
 * 像水一样，向某个方向流动，遇到障碍就折回
 */

public class Demo006 extends JFrame{
    public Demo006(){
        setBounds(100,100,300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new FlowLayout());//给容器设置流布局
        /**
         * 第一个参数：FlowLayout静态常量
         * 第二个参数：指定水平间距，单位：像素
         * 第三个参数：指定垂直间距，单位：像素
         */

        for(int i=0;i<10;i++){
            c.add(new JButton("按钮"+i));//循环添加按钮组件
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Demo006();
    }
}