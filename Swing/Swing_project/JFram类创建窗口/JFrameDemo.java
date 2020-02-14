package Swing.Swing_project.JFram类创建窗口;
import javax.swing.JFrame;//导入Swing JFrame类
import javax.swing.JLabel;
import java.awt.*;

public class JFrameDemo extends JFrame{
    private static final long serialVersionUID = 1L;

    public JFrameDemo() {
        setTitle("Java第一个GUI程序");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jl=new JLabel("这是使用JFrame类创建的窗口");
        Container c=getContentPane();
        c.add(jl);
        setVisible(true);
    }
    public static void main(String[] args){
        new JFrameDemo();
    }
}