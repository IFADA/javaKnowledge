package com.feng.knowlege.deleteifelsebest;

import org.springframework.beans.factory.InitializingBean;

/**
 * 模板方法设计模式
 */
public abstract class AbstractHandler implements InitializingBean {

    public void AAA(String name) {
        throw new UnsupportedOperationException();
    }

    public String BBB(String name) {
        throw new UnsupportedOperationException();
    }
}