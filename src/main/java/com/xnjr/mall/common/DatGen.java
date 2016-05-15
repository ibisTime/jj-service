package com.xnjr.mall.common;

/**
 * Created by wulp on 2015/4/3.
 */
public class DatGen {
    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() throws Exception {
        ConfigFileProc
            .genConfigFile(
                "{\"ipList\":[\"127.0.0.1\",\"127.0.0.2\"],\"codeList\":[\"832001\",\"832002\",\"832003\",\"832004\""
                        + ",\"832021\",\"832022\",\"832023\",\"832024\",\"832025\",\"832026\",\"832027\""
                        + ",\"832041\",\"832042\",\"832043\""
                        + ",\"832061\",\"832062\",\"832063\",\"832064\",\"832065\",\"832066\",\"832067\",\"832068\""
                        + ",\"832071\",\"832072\",\"832073\""
                        + ",\"832997\",\"832998\",\"832999\"]}",
                "src/main/resources/config.dat");
    }

}
