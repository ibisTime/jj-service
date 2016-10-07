/**
 * @Title RegularExpUtils.java 
 * @Package com.ibis.pz.util 
 * @Description 
 * @author miyb  
 * @date 2015-5-13 上午10:47:43 
 * @version V1.0   
 */
package com.cdkj.service.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @author: miyb 
 * @since: 2015-5-13 上午10:47:43 
 * @history:
 */
public class RegexUtils {
    public static String find(String baseStr, String rex, int group) {
        String targetStr = null;
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(baseStr);
        if (matcher.find()) {
            targetStr = matcher.group(group);
        }
        return targetStr;
    }

}
