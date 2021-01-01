package cn.tedu.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

enum PL{
    协警,交警,刑警,警督;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Level{
    public PL value();
}

@Level(PL.协警)
class Police{
    public static void fakuan(){
        System.out.println("您好，超速了，付款200元..");
    }
}

/**
 * 反射注解
 */
public class Test03 {
    public static void main(String[] args) {
        Police.fakuan();

        Class clz = Police.class;
        if(clz.isAnnotationPresent(Level.class)){
            Level lvl = (Level) clz.getAnnotation(Level.class);
            PL pl = lvl.value();
            if(pl == PL.协警){
                System.out.println("大哥，少罚点，罚50得了..");
            }else if(pl == PL.交警){
                System.out.println("交200走人..");
            }else if(pl == PL.刑警){
                System.out.println("交200赶紧走，别查出别的事..");
            }else if(pl == PL.警督){
                System.out.println("领导抽根烟，这是200，不够还有..");
            }
        }else{
            System.out.println("揍一顿，扭送派出所..");
        }
    }
}
