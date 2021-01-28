package cn.tedu.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    //private static Connection conn = JDBCUtils.getConn();
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>(){
        @Override
        protected Connection initialValue() {
            return C3P0Util.getConnection();
        }
    };

    /**
     * 开事务
     */
    public static void startTran(){
        try {
            tl.get().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
    public static void commitTran(){
        try {
            tl.get().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 回滚事务
     */
    public static void rollbackTran(){
        try {
            tl.get().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConn(){
        return tl.get();
    }

    /**
     * 释放资源
     */
    public static void relase(){
        try {
            tl.get().close();
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
