/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.yan.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan.zhang
 * @date 2020/9/22 22:33
 */
public class Composite implements Component {
    private String name;
    private List<Component> elements;

    public Composite(String name) {
        this.name = name;
        elements = new ArrayList<Component>();
    }

    public String getName() {
        return name;
    }

    public void add(Component component) {
        elements.add(component);
    }

    public void remove(Component component) {
        elements.remove(component);
    }

    public void process() {
        for (Component element : elements) {
            element.process();
            System.out.println("I'm Composite! my name is :" + element.name());
        }
    }

    public String name() {
        return this.name;
    }
}
