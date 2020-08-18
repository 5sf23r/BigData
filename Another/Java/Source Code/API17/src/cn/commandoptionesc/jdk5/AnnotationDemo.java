package cn.commandoptionesc.jdk5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@FirstAnnotation(i = 3,d = 4.6,arr = 'e')
@SecondAnnotation("demo")
public class AnnotationDemo {

    @FirstAnnotation(i = 3,d = 4.6,arr = {'e','a'})
    int i = 5;
    public static void main(String[] args) {

    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FirstAnnotation{

    //表示给i这个属性一个默认值
    int i() default 5;

    double d();

    char[] arr();
}

@interface SecondAnnotation{
    String value();
}