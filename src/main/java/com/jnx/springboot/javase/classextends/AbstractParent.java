package com.jnx.springboot.javase.classextends;

/**
 * @author 蒋楠鑫
 * @since 2020/12/3
 */
public abstract class AbstractParent<T> {

    /**
     * 打印子类具体的泛型类型
     *
     * @return  具体的泛型类型
     */
    protected abstract T print();

    protected void doSomeThing() {
        T print = print();
        System.out.println(print.getClass().getName());
    }
}
