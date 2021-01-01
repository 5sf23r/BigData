package cn.tedu.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Component
public class Hero {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;
    @Value("#{@l1}")
    private List<String> list;
    @Value("#{@s1}")
    private Set<String> set;
    @Value("#{@m1}")
    private Map<String,String> map;
    @Value("#{@p1}")
    private Properties props;

    /**
     * 如果配置@Autowired但没有配置@Qualifier
     *      先按类型查找，找到唯一的一个 直接注入
     *          找不到或者找到多个,开始按id查找
     *          根据当前属性的名称寻找相同id的bean，如果找到就注入，找不到就抛异常
     *  如果同时配置@Autowired和@Qualifier
     *      不再按照类型查找，直接按指定id查找，找到就注入，找不到直接抛异常
     */

    @Autowired
    @Qualifier("JMDog")
    private Dog dog;

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", props=" + props +
                ", dog=" + dog +
                '}';
    }
}
