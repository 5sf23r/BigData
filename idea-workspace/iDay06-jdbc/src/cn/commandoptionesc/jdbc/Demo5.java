package cn.commandoptionesc.jdbc;

import cn.commandoptionesc.utils.JDBCUtils1;
import org.junit.Test;
import java.sql.*;

/**
 * 向数据路mydb1.exam表插入和更新数据
 */
public class Demo5 {
    @Test
    public void add(){
        Connection conn = null;
        Statement stat = null;
        try {
            conn = JDBCUtils1.getConnection();
            stat = conn.createStatement();
            int count = stat.executeUpdate("insert into exam values(null,'鸣人',10,20,30)");
            if(count >0){
                System.out.println("恭喜插入成功，受到影响的行数为："+count);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils1.close(null,stat,conn);
        }
    }
    @Test
    public void update(){
        Connection conn = null;
        Statement stat = null;
        try {
            conn = JDBCUtils1.getConnection();
            stat = conn.createStatement();
            int count = stat.executeUpdate("update exam set chinese = 80 where id = 2");
            if(count >0){
                System.out.println("更新成功，受到影响的行数为："+count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils1.close(null,stat,conn);
        }
    }
    @Test
    public void delete()  {
        Connection conn = null;
        Statement stat = null;
        try {
            conn = JDBCUtils1.getConnection();
            stat = conn.createStatement();
            int count = stat.executeUpdate("delete from exam where id = 8");
            if(count >0){
                System.out.println("删除成功，受到影响的行数为："+count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils1.close(null,stat,conn);
        }
    }
    @Test
    public void select(){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils1.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from exam");
            while(rs.next()){
                //next()调用的时候会先将光标向下移动一行
                //如果向下移动的一行有效则返回true
                //如果向下移动的一行无效则返回false
                //利用返回值可以遍历整张则返回false
                //利用返回值可以遍历整张表的数据
                int id = rs.getInt(1);
                String name = rs.getString("name");
                System.out.println("id:"+id+">>>>name:"+name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils1.close(rs,stat,conn);
        }
    }
}
