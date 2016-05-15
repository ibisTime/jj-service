package com.xnjr.mall.enums;

public enum ESmsBizType {
    REGISTER("1", "平台账户-注册"), FINDLOGINPWD("2", "平台账户-找回登陆密码"), RESETLOGINPWD(
            "3", "平台账户-重置登陆密码"), SETTRADEPWD("4", "平台账户-设置交易密码"), FINDTRADEPWD(
            "5", "平台账户-找回交易密码"), RESETTRADEPWD("6", "平台账户-重置交易密码"), CHANGEMOBILE(
            "7", "平台账户-修改手机号码"), FUND_ADD("99", "平台账户-资金方代理添加")

    , ChargeWithdraw("20", "平台账户-充值取现"), Charge("21", "平台账户-充值"), Charge_Yes(
            "22", "平台账户-充值成功"), Charge_No("23", "平台账户-充值失败"), Withdraw("25",
            "平台账户-取现"), Withdraw_Yes("26", "平台账户-取现成功"), Withdraw_No("27",
            "平台账户-取现失败")

    , HongLan("30", "平台账户-红冲蓝补"), Hong("31", "平台账户-红冲"), Lan("32", "平台账户-蓝补"), MOOM_startMJ(
            "M1", "生意家，标的开始募集"), MOOM_reapplyProject("M2", "生意家，重新提交标的"), MOOM_CPS_ResetTP(
            "M11", "生意家，操盘手重置交易密码"), MOOM_CPS_FindTP("M12", "生意家，操盘手找回交易密码"), MOOM_CPS_ChangePH(
            "M13", "生意家，操盘手更换手机"), Invest("M14", "生意家，真实认购"), WillInvest("M15",
            "生意家，意向认购"), InvestYes("M16", "生意家，确认认购"), InvestNo("M17",
            "生意家，取消认购"), KY("K1", "生意家，企业KYC审核通过"), KN("K2", "生意家，企业KYC审核不通过");

    ESmsBizType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
