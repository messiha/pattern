/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.yan.dp.composite;

/**
 * @author yan.zhang
 * @date 2020/9/22 22:42
 */
public class Client {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        Composite c1 = new Composite("treeNode1");
        Composite c2 = new Composite("treeNode2");
        Composite c3 = new Composite("treeNode3");
        Composite c4 = new Composite("treeNode4");


        Leaf l1 = new Leaf("leaf1");
        Leaf l2 = new Leaf("leaf2");

        root.add(c1);
        root.add(c2);
        root.add(c3);
        root.add(c4);
        c1.add(l1);
        c2.add(l2);

        invoke(root);
    }

    private static void invoke(Component component) {
        component.process();
    }
}
