# setPreferredSize和serSize的区别及用法

1.  setPreferredSize需要在使用布局管理器的时候使用，布局管理器会获取空间的preferredsize，因而可以生效。例如borderlayout在north中放入一个panel，panel的高度可以通过这样实现：panel.setPreferredSize(new Dimension(0, 100));这样就设置了一个高度为100的panel，宽度随窗口变化。
2.  setSize,setLocation,setBounds方法需要在不使用布局管理器的时候使用，也就是setLayout(null)的时候可以使用这三个方法控制布局。