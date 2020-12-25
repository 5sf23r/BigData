package com.easymall.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
//官方编码格式做的不好
public class MyHttpServletRequest extends HttpServletRequestWrapper {
    //创建父类的构造器
    public MyHttpServletRequest(HttpServletRequest request) {

        super(request);
    }

    //该方法中存在了请求中的所有参数：
    //需要遍历map集合，注意取出value值，逐一进行编码
    @Override
    public Map<String, String[]> getParameterMap() {
        //1. 获取请求中的参数map集合：原始的没有编码处理的map
        Map<String, String[]> parameterMap = super.getParameterMap();
        //2. 定义一个新的map集合：已经进行编码处理过的map
        HashMap<String, String[]> newmap = new HashMap<String,String[]>();
        //3. 遍历原始的map集合，然后注意进行编码处理
        for(Map.Entry<String,String[]> entry:parameterMap.entrySet()){
            String key = entry.getKey();
            //3.1 获取原始的没有编码处理的values数组
            String[] value = entry.getValue();
            //3.2 定义一个新的数组，存放编码处理之后的value
            String[] newvalue = new String[value.length];
            //3.3 遍历原始values数组
            for(int i = 0;i < value.length;i++){
                try {
                    String s = new String(value[i].getBytes("iso-8859-1"),"utf-8");
                    newvalue[i] = s;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            //3.4 每一个key对应的values数组处理完毕后，放入到newmap中
            newmap.put(key,newvalue);
        }
        return newmap;
    }

    //该方法中存在了某一个name也就是map中的key，对应的value值
    //需要传入参数name，遍历value值的数组，注意进行编码
    @Override
    public String[] getParameterValues(String name) {
        //1. 直接调用this.getParameterMap()方法
        Map<String, String[]> parameterMap = this.getParameterMap();
        //2. 通过name 获取values数组
        String[] strings = parameterMap.get(name);
        return strings;
    }

    //该方法中的name也是map中的key，先获取对应的values数组
    //然后取出下标为0的第一个元素，然后进行编码即可
    @Override
    public String getParameter(String name) {
        //1. 直接调用this.getParamterValues
        String[] paramterValues = this.getParameterValues(name);
        return paramterValues!=null?paramterValues[0]:"";
    }


}
