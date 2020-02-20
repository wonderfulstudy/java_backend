package jar;

import java.awt.Container;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Demo004 extends JFrame{
    public Demo004(){
        setBounds(100,100,500,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c=getContentPane();

        JLabel l=new JLabel("这是一个展示图片的标签");//使用标签展示图片
        URL url=Demo004.class.getResource("../resources/java.jpg");//获取图片URL路径
        Icon icon=new ImageIcon(url);//获取相应路径下的图片文件
        // Icon icon=new ImageIcon("./src/main/java/resources/java.jpg");
        l.setIcon(icon);//添加图片
        l.setSize(20,20);//设置标签大小，即使设置标签大小，也不会改变图片大小
        c.add(l);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Demo004();
    }
}