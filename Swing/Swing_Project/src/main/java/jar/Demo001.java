package jar;

import javax.swing.*;

import java.awt.*;

/**
 * 使用Java中的Swing组件创建窗体
 * 
 */

public class Demo001 extends JFrame{

    public Demo001(){
        setVisible(true);//设置窗体可见
        // setTitle("窗体标题");//设置窗体标题
        
        /**
         * 窗体规则
         * EXIT_ON_CLOSE:隐藏窗口,并停止程序
         * DO_NOTHING_ON_CLOSE:无任何操作
         * HIDE_ON_CLOSE:隐藏窗体,但不停止程序
         * DISPOSE_ON_CLOSE:释放窗体资源
         * 
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(300,200);//设置窗体的大小,单位:像素
        // setLocation(200,200);//设置坐标,单位:像素
        setBounds(200,200,300,200);//设置窗体坐标和大小,单位:像素

        Container c = getContentPane();//获取窗体容器
        c.setBackground(Color.WHITE);//设置背景颜色
        JLabel l = new JLabel("这是一个窗体");
        c.add(l);//添加组件
        // c.remove(l);//删除组件
        c.validate();//验证容器中的组件，刷新
        // setContentPane(c);//重新载入容器

        setResizable(false);//设置窗体是否可以改变大小
        System.out.println("x="+this.getX()+" y="+this.getY());
    }
    public static void main(String[] args) {
        new Demo001();
    }
}
