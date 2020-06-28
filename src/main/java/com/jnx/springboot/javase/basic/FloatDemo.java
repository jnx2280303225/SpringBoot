package com.jnx.springboot.javase.basic;

/**
 * 浮点数的解析
 *
 * @author 蒋楠鑫
 * @date 2020/6/18
 */
public class FloatDemo {

    public static void main(String[] args) {
        double a = 1.25;
        float b = 1.25F;
        System.out.println(a - b == 0.0);

        double c = 0.2;
        double d = 0.3;
        double e = 0.4;
        System.out.println(c - d == d - e);

        System.out.println(1.0 / 0.0);

        System.out.println(0.0 / 0.0);

        g(1);
    }

    public static void g(double i) {
        System.out.println("double");
    }

    public static void g(float d) {
        System.out.println("float");
    }

    public static void g(long l) {
        System.out.println("long");
    }

    public static void g(short l) {
        System.out.println("short");
    }

    public static void g(Double dd) {
        System.out.println("Double");
    }

}
