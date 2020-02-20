package jar;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo002 extends JDialog{

    public Demo002(JFrame frame){
        /**
         * 第一个参数,父窗体对象
         * 第二个参数,对话框标题
         * 第三个参数,是否阻塞父窗体
         */
        super(frame, "对话框标题", true);

        Container c = getContentPane();//获取窗体容器
        c.add(new JLabel("这是一个对话框"));

        setBounds(100,100,100,100);//设置窗体坐标和大小
    }
    public static void main(String[] args) {
        final JFrame f = new JFrame("父窗体");
        f.setBounds(50,50,300,300);
        Container c = f.getContentPane();
        JButton btn = new JButton("弹出对话框");
        c.setLayout(new FlowLayout());//设置布局,使用流布局
        c.add(btn);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Demo002 d = new Demo002(f);
                d.setVisible(true);//设置窗体可见
            }
        });//添加动作监听
    }
}