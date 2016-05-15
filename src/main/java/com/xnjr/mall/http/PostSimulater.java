/**
 * @Title NetUtils.java 
 * @Package com.ibis.pz.http 
 * @Description 
 * @author miyb  
 * @date 2015-5-12 下午4:34:54 
 * @version V1.0   
 */
package com.xnjr.mall.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;

/** 
 * @author: miyb 
 * @since: 2015-5-12 下午4:34:54 
 * @history:
 */
public class PostSimulater {
    public static final String CHARACTER_ENCODING = "UTF-8";

    public static final String PATH_SIGN = "/";

    public static final String METHOD_POST = "POST";

    public static final String METHOD_GET = "GET";

    public static final String CONTENT_TYPE = "Content-Type";

    /**  
     * 以POST方式向指定地址发送数据包请求,并取得返回的数据包  
     *   
     * @param urlString  
     * @param requestData  
     * @param requestProperties  
     * @return 返回数据包  
     * @throws Exception  
     */
    public static String requestPost(String urlString, byte[] requestData,
            Properties requestProperties) throws Exception {
        String responseData = null;

        HttpURLConnection con = null;

        try {
            URL url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();

            if ((requestProperties != null) && (requestProperties.size() > 0)) {
                for (Map.Entry<Object, Object> entry : requestProperties
                    .entrySet()) {
                    String key = String.valueOf(entry.getKey());
                    String value = String.valueOf(entry.getValue());
                    con.setRequestProperty(key, value);
                }
            }
            con.setConnectTimeout(10000);
            con.setRequestMethod(METHOD_POST); // 置为POST方法
            con.setDoInput(true); // 开启输入流
            con.setDoOutput(true); // 开启输出流
            // con.setUseCaches(false); // 不使用缓存
            // logger.debug("打开连接:" + url);
            con.connect();
            // 如果请求数据不为空，输出该数据。
            if (requestData != null) {
                DataOutputStream out = new DataOutputStream(
                    con.getOutputStream());
                out.write(requestData);
                out.flush();
                out.close();
            }
            // 返回值
            StringBuffer resposne = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
            String responseMessage = "";
            while ((responseMessage = reader.readLine()) != null) {
                resposne.append(responseMessage);
            }
            responseData = resposne.toString();
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.disconnect();
                con = null;
            }
        }

        return responseData;
    }

    /**  
     * 以POST方式向指定地址发送数据包请求,并取得返回的数据包  
     *   
     * @param urlString  
     * @param requestData  
     * @return 返回数据包  
     * @throws Exception  
     */
    public static String requestPost(String urlString, byte[] requestData)
            throws Exception {
        Properties requestProperties = new Properties();
        requestProperties.setProperty(CONTENT_TYPE,
            "application/octet-stream; charset=utf-8");

        return requestPost(urlString, requestData, requestProperties);
    }

    /**  
     * 以POST方式向指定地址提交表单<br>  
     * arg0=urlencode(value0)&arg1=urlencode(value1)  
     *   
     * @param urlString  
     * @param formProperties  
     * @return 返回数据包  
     * @throws Exception  
     */
    public static String requestPostForm(String urlString,
            Properties formProperties) throws Exception {
        return requestPostForm(urlString, formProperties, new Properties());
    }

    /**  
     * 以POST方式向指定地址提交表单<br>  
     * arg0=urlencode(value0)&arg1=urlencode(value1)  
     *   
     * @param urlString  
     * @param formProperties  
     * @param requestProperties  
     * @return 返回数据包  
     * @throws Exception  
     */
    public static String requestPostForm(String urlString,
            Properties formProperties, Properties requestProperties)
            throws Exception {
        requestProperties.setProperty(CONTENT_TYPE,
            "application/x-www-form-urlencoded");

        StringBuilder sb = new StringBuilder();

        if ((formProperties != null) && (formProperties.size() > 0)) {
            for (Map.Entry<Object, Object> entry : formProperties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                sb.append(key);
                sb.append("=");
                sb.append(encode(value));
                sb.append("&");
            }
        }

        String str = sb.toString();
        str = str.substring(0, (str.length() - 1)); // 截掉末尾字符&

        return requestPost(urlString, str.getBytes(CHARACTER_ENCODING),
            requestProperties);

    }

    /**  
     * url解码  
     *   
     * @param str  
     * @return 解码后的字符串,当异常时返回原始字符串。  
     */
    public static String decode(String url) {
        try {
            return URLDecoder.decode(url, CHARACTER_ENCODING);
        } catch (UnsupportedEncodingException ex) {
            return url;
        }
    }

    /**  
     * url编码  
     *   
     * @param str  
     * @return 编码后的字符串,当异常时返回原始字符串。  
     */
    public static String encode(String url) {
        try {
            return URLEncoder.encode(url, CHARACTER_ENCODING);
        } catch (UnsupportedEncodingException ex) {
            return url;
        }
    }

}
