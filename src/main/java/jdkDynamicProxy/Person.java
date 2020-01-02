package jdkDynamicProxy;

public class Person implements Say{


    @Override
    public String say(String content) {
        System.out.println("这是我说的内容:"+content);
        return content;
    }
}
