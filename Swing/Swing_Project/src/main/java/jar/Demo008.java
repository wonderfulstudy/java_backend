package jar;

import java.awt.*;
import javax.swing.*;

public class Demo008 extends JFrame{
    /**
     * 
     * GridLayout(int 列，int 行)
     * 
     * GridLayout(int 列，int 行，int 水平间距，int 垂直距离)
     */
    public Demo008(){
        setBounds(100,100,300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new GridLayout(7,3,5,5));//设置为网格布局，7行3列，水平间距5像素，垂直间距也是5像素

        for(int i=0;i<20;i++){
            c.add(new JButton("按钮"+i));
        }
        /**
         * 如果组件数量比网格多，Java会自动布局
         */

        setVisible(true);

    }

    public static void main(String[] args) {
        new Demo008();
    }
}