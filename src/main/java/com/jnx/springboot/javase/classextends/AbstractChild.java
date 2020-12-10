package com.jnx.springboot.javase.classextends;

/**
 * @author 蒋楠鑫
 * @since 2020/12/3
 */
public abstract class AbstractChild extends AbstractParent<String> {

    @Override
    protected String print(){
        System.out.println("我是string类型");
        return "字符串";
    }
}
