package com.sherlocky.learning.java8.lambda;

/**
 *  lambdas 来实现 Runnable 接口
 *
 *  <p>
 *  Lambda表达式并不是匿名内部类的语法糖，它是基于 invokedynamic 指令（java7引入的新指令），不会产生新的class文件。
 *  在运行时使用 ASM 动态生成类文件来实现的，可以参考{@link java.lang.invoke.LambdaMetafactory#metafactory}。
 *  </p>
 *  可参考：<a href="https://github.com/CarpenterLee/JavaLambdaInternals/blob/master/2-Lambda%20and%20Anonymous%20Classes(II).md">Lambda VS 内部类</a>
 *
 * @author zhangcx
 */
public class LambdaInnerClazz {
    public static void main(String[] args) {
        // java8之前的写法 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();
        // lambda 写法

        new Thread(() -> System.out.println("Hello world ! Lambda~")).start();

        new Thread(() -> {
            System.out.println("Hello world ! Lambda~{}");
        }).start();



        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world ! run 1");
            }
        };
        Runnable race2 = () -> System.out.println("Hello world ! run 2");
        race1.run();
        race2.run();
    }
}
