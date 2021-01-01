package cn.tedu.factory;

import cn.tedu.domain.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * Spring工厂
 */
public class PersonSpringFactory implements FactoryBean<Person> {
    /**
     * 生产bean对象方法
     */
    @Override
    public Person getObject() throws Exception {
        return new Person("ww");
    }

    /**
     * 获取bean类型方法
     */
    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    /**
     * 告知当前bean是否要采用单例模式
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
