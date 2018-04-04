package com.mike.auto.mian;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;

public class TestOpenCV {
    public static void main(String[] args) {
        System.loadLibrary("opencv_java331");
        System.out.println("------" + Core.getBuildInformation());
        //通过图片生成一个矩阵
        Mat mat = Imgcodecs.imread("/Users/Mike/IdeaProjects/AutoScriptss/pic/desktop.jpg");

        System.out.println("w===" + mat.width() + "h===" + mat.height());

//        JFrame frame = new JFrame("PIC");
//        JLabel jLabel = new JLabel();
//        JScrollPane pane = new JScrollPane(jLabel);
//        pane.setPreferredSize(mat.width(),mat.height());
//        frame.add()


    }
}
