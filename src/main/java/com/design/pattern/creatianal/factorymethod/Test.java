package com.design.pattern.creatianal.factorymethod;

public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory1 = new JavaVideoFactory();
        VideoFactory videoFactory2 = new PythonVideoFactory();
        VideoFactory videoFactory3 = new FEVideoFactory();
        Video video1 = videoFactory1.getVideo();
        Video video2 = videoFactory2.getVideo();
        Video video3 = videoFactory3.getVideo();
        video1.produce();
        video2.produce();
        video3.produce();

    }
}
