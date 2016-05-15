package com.xnjr.mall.core;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.google.gson.Gson;

/**
 * Created by wulp on 2015/4/7.
 */
public class ConfigLoader {
    /**
     * 加载配置文件到配置管理类
     * @return
     * @throws Exception
     */
    public static ConfigDescribe loadConfig() throws Exception {
        DESUtil des = new DESUtil();
        // 解密获取配置文件路径

        InputStream is = ConfigLoader.class.getResourceAsStream(des
            .decrypt("00CA312C2F85A60D69262E77D19884D3"));

        /*
         * FileInputStream fo = new FileInputStream(new File(
         * des.decrypt("00CA312C2F85A60D69262E77D19884D3")));
         */
        /* 开始读取配置文件 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];// 一次读取8K
        int len;
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        is.close();
        String configjson = des.decrypt(des.byteArr2HexStr(bos.toByteArray()));
        return new Gson().fromJson(configjson, ConfigDescribe.class);
    }
}
