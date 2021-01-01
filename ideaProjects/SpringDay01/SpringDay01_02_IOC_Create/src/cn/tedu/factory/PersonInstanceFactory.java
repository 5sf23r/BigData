package cn.tedu.factory;

import cn.tedu.domain.Person;

/**
 * 实例工厂
 */
public class PersonInstanceFactory {
    public Person getInstance(){
        return new Person("ls");
    }
}
