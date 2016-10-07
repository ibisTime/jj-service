package com.cdkj.service.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by wulp on 2015/4/7.
 */
public class ConfigFileProc {
    /**
     * 生成配置文件
     * @param configstr
     * @param outfilepath
     * @throws Exception
     */
    public static void genConfigFile(String configstr, String outfilepath)
            throws Exception {
        DESUtil des = new DESUtil();
        byte[] charbyte = des.hexStr2ByteArr(des.encrypt(configstr));
        FileOutputStream fo = new FileOutputStream(new File(outfilepath));
        fo.write(charbyte, 0, charbyte.length);
        fo.flush();
        fo.close();
    }

    /**
     * 读取配置文件，一般用于测试读取
     * @param outfilepath
     * @return
     * @throws Exception
     */
    public static String readConfigFile(String outfilepath) throws Exception {
        DESUtil des = new DESUtil();
        FileInputStream fi = new FileInputStream(new File(outfilepath));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];// 一次读取8K
        int len;
        while ((len = fi.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        fi.close();
        return des.decrypt(des.byteArr2HexStr(bos.toByteArray()));
    }
}
