package com.cdkj.service.proxy;

import org.apache.log4j.Logger;

import com.cdkj.service.api.IProcessor;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;

public class DispatcherImpl implements IDispatcher {
    private static Logger logger = Logger.getLogger(DispatcherImpl.class);

    @Override
    public String doDispatcher(String transcode, String inputParams) {

        String result = null;
        ReturnMessage rm = new ReturnMessage();
        try {
            // 加载配置文件,proxy实例化
            String classname = "com.cdkj.service.api.impl.XNOther";
            // ConfigDescribe configDescribe = ConfigLoader.loadConfig();
            /*
             * if (StringUtils.isNotBlank(transcode) && configDescribe != null)
             * { List<String> codeList = configDescribe.getCodeList(); if
             * (codeList.contains(transcode)) { classname =
             * "com.xnjr.mall.api.impl.XN" + transcode; } }
             */
            classname = "com.cdkj.service.api.impl.XN" + transcode;
            IProcessor processor = (IProcessor) ReflectUtil
                .getInstance(classname);
            // 接口调用
            Object data = processor.doProcessor(inputParams);
            rm.setErrorCode(EErrorCode.SUCCESS.getCode());
            rm.setErrorInfo(EErrorCode.SUCCESS.getValue());
            rm.setData(data);
        } catch (Exception e) {
            logger.error("系统异常：" + e.getMessage());
            if (e instanceof BizException) {
                rm.setErrorCode(EErrorCode.BIZ_ERR.getCode());
                rm.setErrorInfo(((BizException) e).getErrorMessage());
                rm.setData("");
            } else if (e instanceof ParaException) {
                rm.setErrorCode(EErrorCode.PARA_ERR.getCode());
                rm.setErrorInfo(((ParaException) e).getErrorMessage());
                rm.setData("");
            } else if (e instanceof NullPointerException) {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                // rm.setErrorInfo("NPE");
                rm.setErrorInfo("系统错误，请稍后再试");
                rm.setData("");
            } else {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                // rm.setErrorInfo(e.getMessage());
                rm.setErrorInfo("系统错误，请稍后再试");
                rm.setData("");
            }
        } finally {
            result = JsonUtil.Object2Json(rm);
        }
        return result;
    }
}
