package com.trxk.scpww.utils;

//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.protocol.HTTP;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2019/07/17
 * Description:
 * Version: V1.0
 */
public class PostRequest {
    /**
     * 此工具类传递一个request对象，通过request对象获取头文件字节流，封装成json对象，并且返回json对象
     * 静态方法没有副本，整个项目只有一个，静态方法不能滥用
     * 冗余(重复)级别
     */
//    @SuppressWarnings("unchecked")
    public String readHeader(Map<String, String> map, String url, List<String> keyList) {
        // 设置头文件
//        resp.setContentType("application/json;charset=utf-8");
//        PrintWriter out = null;
        try {
//            out = resp.getWriter();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream(), "UTF-8"));
//            JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
            HttpPost httpPost = new HttpPost();
            // 动态接口服务路径  url   "http://www.chepiao100.com/api/yupiao"
            httpPost.setURI(new URI(url));
            // 存储所有的请求参数 每一个参数，基于k-v关系，存入到NameValuePair对象中，然后把所有的请求参数基于list封装
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            // 存储每一个k-v参数
            for (String key : keyList) {
                list.add(new BasicNameValuePair(key, map.get(key)));
            }
            // 设置语言编码格式
            httpPost.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));

            // 创建一个可以发起远程服务请求的对象
            HttpClient httpClient = new DefaultHttpClient();
            // 此请求对象需要带走请求路径和请求参数，而请求路径和请求参数是封装在httppost对象中
            HttpResponse httpResponse = httpClient.execute(httpPost);  // 此行代码发起请求，并且返回远程服务器响应对象
            // 通过远程服务器返回的响应对象，获取对象http 状态码
            int actionCode = httpResponse.getStatusLine().getStatusCode();
            // http状态码中，200代表成功，其余都可能是失败
            if (actionCode == 200) {
                //              bufferedReader = new BufferedReader(new InputStreamReader(req.getInputStream(), "UTF-8"));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                    /*
                    因为远程服务器返回的json报文数据，可能不止一行，所以不能只是用一次readLine()完成读取，必须使用循环处理
                     */
                String line = "";
                String NL = System.getProperty("line.separator");
                // 1.readLine()返回的值赋值为line变量  2.用line变量和null比较
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append(NL);
                }
                bufferedReader.close();
//                JSONObject jsonObject1 = new JSONObject(stringBuilder.toString());
//                jsonObject1.put("code", 200);
////                resp.getWriter().print(jsonObject1);
                return stringBuilder.toString();
            }
        } catch (IOException e) {
//            out.print("IO异常");
            e.printStackTrace();
        } catch (URISyntaxException e) {
//            out.print("URI异常");
            e.printStackTrace();
        }
        return null;
    }
}
