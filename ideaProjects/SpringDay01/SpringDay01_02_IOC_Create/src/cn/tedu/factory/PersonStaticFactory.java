package cn.tedu.factory;

import cn.tedu.domain.Person;

/**
 * 静态工厂
 */
public class PersonStaticFactory {
    //构造器私有化
    private PersonStaticFactory(){

    }

    public static Person getInstance(){
        return new Person("zs");
    }
}
