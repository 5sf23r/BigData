package cn.tedu.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PersonFactory {
    @Bean("person")
    public Person getInstance(){
        return new Person("zs");
    }
}
