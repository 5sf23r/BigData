package cn.tedu.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class JDBCUtils {
    @PostConstruct
    public void initConn(){
        System.out.println("初始化连接..");
    }
    public void insert(){
        System.out.println("insert..");
    }
    public void update(){
        System.out.println("update..");
    }
    @PreDestroy
    public void closeConn(){
        System.out.println("关闭连接..");
    }
}
