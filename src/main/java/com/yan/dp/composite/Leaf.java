/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.yan.dp.composite;

/**
 * @author yan.zhang
 * @date 2020/9/22 22:40
 */
public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void process() {
        System.out.println("I'm Leaf! my name is :" + name);
    }

    @Override
    public String name() {
        return this.name;
    }
}
