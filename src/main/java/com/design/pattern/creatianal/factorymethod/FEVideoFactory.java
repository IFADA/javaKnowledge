package com.design.pattern.creatianal.factorymethod;


public class FEVideoFactory extends  VideoFactory {
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}
