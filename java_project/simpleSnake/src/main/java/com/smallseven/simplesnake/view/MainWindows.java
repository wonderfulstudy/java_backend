/** 
 * @Description: 程序主界面
 * @Author: smallSeven
 * @Date: 2020-03-30 17:10:03
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-03-31 10:33:34
 * @FilePath: /simpleSnake/src/main/java/com/smallseven/simplesnake/view/MainWindows.java
 */
package com.smallseven.simplesnake.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
        setSize(ROW * BLOCK_WIDTH + 200, COLUMN * BLOCK_HEIGHT + 50);// 设置窗口大小单位：像素
        setLocation(400, 400);// 设置窗口起始位置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口默认关闭方式
        setResizable(false);// 设置窗口是否可以拉伸、缩小
        setVisible(true);// 显示窗口界面
        JMenuBar jMenuBar = new JMenuBar();// 菜单栏工具类
        JMenu jMenu1 = new JMenu("游戏");// 菜单项类
        JMenu jMenu2 = new JMenu("积分榜");
        JPanel jPanel1 = new JPanel(){// JPanel面板
            /** 
             * @Description: 定义匿名JPanel面板，绘制界面网格
             * @param {type} 
             * @return: JPanel
             */
            private static final long serialVersionUID = -2838411185576106254L;

            @Override
            public void paint(Graphics graphics){
                /** 
                 * @Description: 覆写paint方法，绘制窗口网格
                 * @param {type} 
                 * @return: void
                 */
                Color c = graphics.getColor();
                graphics.setColor(Color.GRAY);

                for (int i = 0; i < ROW; i++){
                    graphics.drawLine(0, i * BLOCK_HEIGHT, COLUMN * BLOCK_WIDTH,
                                i * BLOCK_HEIGHT);
                }
                for (int i = 0; i < COLUMN; i++){
                    graphics.drawLine(i * BLOCK_WIDTH, 0, i * BLOCK_WIDTH,
                                ROW * BLOCK_HEIGHT);
                }

                graphics.setColor(c);
            }
        };
        JPanel jPanel2 = new JPanel();

        jPanel1.setSize(ROW * BLOCK_WIDTH, COLUMN * BLOCK_HEIGHT);
        jPanel2.setSize(200, COLUMN * BLOCK_HEIGHT);
        jMenu1.add(new JMenuItem("开始游戏"));
        jMenu1.add(new JMenuItem("暂停游戏"));
        jMenu1.add(new JMenuItem("结束游戏"));
        jMenuBar.setSize(getWidth(), 50);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        setJMenuBar(jMenuBar);
        add(jPanel1);
        add(jPanel2);
    }
}