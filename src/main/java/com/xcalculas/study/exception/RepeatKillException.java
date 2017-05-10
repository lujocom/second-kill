package com.xcalculas.study.exception;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:重复秒杀异常</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年03月20日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class RepeatKillException extends SecondKillException {

    public RepeatKillException(String message) {
        super(message);

    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
