package cn.tedu.service;

import cn.tedu.dao.UserDao;
import cn.tedu.pojo.User;

/* service业务逻辑层：
*  1. 对不同的功能，需要处理的具体的步骤就是业务逻辑
*
* */
public class UserService  {

    /* 编写一个方法：专门处理注册的业务逻辑
    *
    * */
    public void regist(User user){
        //1.先查询是否存在此人
        UserDao dao = new UserDao();
        boolean flag = dao.findByUsername(user.getUsername());
        //2.分情况判断flag
        if (flag) {//用户名不能注册
            //返回一个错误信息
            //在执行业务逻辑时，把异常返回给servlet层
            throw new RuntimeException("用户名已存在，不能注册");
        } else {
            dao.insertUserInfo(user);
        }

    }

}
