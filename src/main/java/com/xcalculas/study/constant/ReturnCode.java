package com.xcalculas.study.constant;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年03月22日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public enum ReturnCode {
    SUCCESS("000","操作成功"),
    ERROR_MD5_REWRITE("100", "md5被重写"),
    ERROR_NONE_SECOND_KILL("104", ""),
    ERROR_BUSINESS("103", "业务异常"),
    ERROR_SECOND_KILL_CLOSED("101","秒杀关闭"),
    ERROR_REPEAT_SECOND_KILL("102","重复秒杀");


    private String code;

    private String msg;

    ReturnCode(String code,String message) {
        this.code = code;
        this.msg = message;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
