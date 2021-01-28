package cn.tedu.mapper;

import cn.tedu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<User> selectOrderByAge();
    public List<User> selectBetweenAge(@Param("min") int min,@Param("max") int max);
}
