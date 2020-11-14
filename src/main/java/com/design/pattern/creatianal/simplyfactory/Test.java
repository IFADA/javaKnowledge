package com.design.pattern.creatianal.simplyfactory;

public class Test {
    private static Object JavaVideo;

    public static void main(String[] args) {
//        Video video = new JavaVideo();
//        video.produce();
        VideoFactory videoFactory = new VideoFactory();
       Video video= videoFactory.getVideo((Class) JavaVideo);
       video.produce();

    }
}
