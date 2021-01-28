package cn.tedu.anno;

import cn.tedu.enums.PrivEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//用在方法上
@Retention(RetentionPolicy.RUNTIME)//保留到什么阶段
public @interface PrivAnno {
    public PrivEnum[] value();
}
