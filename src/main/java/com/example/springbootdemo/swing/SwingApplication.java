package com.example.springbootdemo.swing;

import javax.swing.*;

public class SwingApplication {
    public static void main(String[] args) {
        /**
         *description：创建窗体对象
         * */
        JFrame j = new JFrame("我的第一个Swing");
        /**
         * 设置窗体可见
         * */
        j.setVisible(true);
        /**
         * 设置关闭按钮的默认功能为 释放窗体资源
         * */
        j.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        j.setSize(300, 200);
        j.setLocation(400, 200);


    }

}
