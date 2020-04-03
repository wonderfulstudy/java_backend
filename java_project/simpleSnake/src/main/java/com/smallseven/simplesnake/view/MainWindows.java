/** 
 * @Description: 程序主界面
 * @Author: smallSeven
 * @Date: 2020-03-30 17:10:03
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-04-01 11:06:43
 * @FilePath: /simpleSnake/src/main/java/com/smallseven/simplesnake/view/MainWindows.java
 */
package com.smallseven.simplesnake.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class MainWindows extends JFrame {
    /**
     * @Description: 游戏窗口类
     * @param {type}
     * @return:
     */
    private static final long serialVersionUID = 3762250404050230951L;
    public static final int BLOCK_WIDTH = 15;// 贪吃蛇方格的宽度
    public static final int BLOCK_HEIGHT = 15;// 贪吃蛇方法的高度
    public static final int ROW = 40;// 界面方格行数
    public static final int COLUMN = 40;// 界面方法的列数

    public MainWindows() {
        setTitle("Snake");// 设置窗口标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口默认关闭方式
        setLocation(400, 400);// 设置窗口大小,设置窗口起始位置,单位：像素
        JMenuBar jMenuBar = new JMenuBar();// 菜单栏工具类
        JMenu jMenu1 = new JMenu("游戏");// 菜单项类
        JTabbedPane jTabbedPane = new JTabbedPane();
        JMenu jMenu2 = new JMenu("积分榜");
        JPanel jPanel1 = new JPanel() {// JPanel面板
            /**
             * @Description: 定义匿名JPanel面板，绘制界面网格
             * @param {type}
             * @return: JPanel
             */
            private static final long serialVersionUID = -2838411185576106254L;

            @Override
            public void paint(Graphics graphics) {
                /**
                 * @Description: 覆写paint方法，绘制窗口网格
                 * @param {type}
                 * @return: void
                 */
                Color c = graphics.getColor();
                graphics.setColor(Color.GRAY);

                for (int i = 0; i < ROW; i++) {// 画横线
                    graphics.drawLine(0, i * BLOCK_HEIGHT, COLUMN * BLOCK_WIDTH, i * BLOCK_HEIGHT);
                }
                for (int i = 0; i <= COLUMN; i++) {// 画竖线
                    graphics.drawLine(i * BLOCK_WIDTH, 0, i * BLOCK_WIDTH, ROW * BLOCK_HEIGHT);
                }

                graphics.setColor(c);
            }
        };
        JPanel jPanel2 = new JPanel(new GridLayout(2, 1));
        JTextArea jTextArea = new JTextArea("游戏规则：上下左右控制蛇的方向，寻找吃的东西，" + "每吃一口就能得到一定的积分，而且蛇的身子会越吃越长，"
                + "身子越长玩的难度就越大，不能碰墙，不能咬到自己的身体，" + "更不能咬自己的尾巴，等到了一定的分数，就能过关，然后继续玩下一关。");

        jMenu1.add(new JMenuItem("开始游戏"));
        jMenu1.add(new JMenuItem("暂停游戏"));
        jMenu1.add(new JMenuItem("结束游戏"));
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        setJMenuBar(jMenuBar);
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jPanel2.add(jTextArea);
        jPanel2.add(new JLabel("当前积分："));
        jPanel1.setPreferredSize(new Dimension(COLUMN * BLOCK_WIDTH + 5, ROW * BLOCK_HEIGHT));
        jPanel2.setLocation(COLUMN * BLOCK_WIDTH + 5, 25);
        jPanel2.setPreferredSize(new Dimension(200, ROW * BLOCK_HEIGHT));
        add(jPanel1, BorderLayout.WEST);
        add(jPanel2, BorderLayout.EAST);
        pack();
        setResizable(false);// 设置窗口是否可以拉伸、缩小
        setVisible(true);// 显示窗口界面
    }
}