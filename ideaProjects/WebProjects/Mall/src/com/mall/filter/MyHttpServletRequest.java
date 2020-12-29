package com.mall.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

//继承HttpServletRequestWrapper才能重写request获取参数的API
//只有重写这些API才能重新定义解码过程
public class MyHttpServletRequest extends HttpServletRequestWrapper {
    //需要在web.xml中配置context-param标签
    String encode = null;
    //调用父类有参构造
    //encode参数来接收过滤器传入的字符集
    public MyHttpServletRequest(HttpServletRequest request,String encode) {
        super(request);
        this.encode = encode;
    }
    //该方法中存在了请求中的所有参数：需要遍历map集合，注意取出value值，逐一进行编码
    @Override
    public Map<String, String[]> getParameterMap() {
        //1. 获取请求中的参数的map集合
        Map<String, String[]> parameterMap = super.getParameterMap();
        //2. 定义一个新的map集合：已经进行编码处理过的map
        HashMap<String, String[]> newmap = new HashMap<String,String[]>();
        //3. 遍历原始的map集合，然后注意进行编码处理
        for(Map.Entry<String,String[]> entry:parameterMap.entrySet()){
            String key = entry.getKey();
            //3.1 获取原始的没有编码处理的values数组
            String[] value = entry.getValue();
            //3.2 定义一个新的数组，存放编码处理之后devalue
            String[] newvalue = new String[value.length];
            //3.3 遍历原始的values数组
            for(int i = 0;i<value.length;i++){
                try {
                    String s = new String(value[i].getBytes("iso-8859-1"), encode);
                    newvalue[i] = s;
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                }
            }
            //3.4 map中每一个key对应的values数组处理完毕后，放入到newmap中
            newmap.put(key,newvalue);
        }
        return newmap;
    }

    //该方法中存在了某一个name，也就是map中的key，对应的value值需要出入参数name，便利value值的数组，注意进行编码
    @Override
    public String[] getParameterValues(String name) {
        //1. 直接调用
        Map<String, String[]> parameterMap = this.getParameterMap();
        //2. 通过name 获取values数组
        String[] strings = parameterMap.get(name);
        return strings;
    }

    //该方法中的name也是map中的key，先获取对应的values数组，然后取出下标为0的第一个元素，然后进行编码即可
    @Override
    public String getParameter(String name) {
        //根据用户传入的参数名获取对应名称的参数值
        //结果为一个数组，取出数组第一个元素即为getParameter方法的返回值
        //1. 直接调用
        String[] parameterValues = this.getParameterValues(name);
        //考虑方法中的参数可能不存在，导致执行方法出现values=null的结果
        //为了避免null[0]这种情况，应该对结果做出如下判断
        return parameterValues!=null?parameterValues[0]:"";
    }
}
