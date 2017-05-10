package com.xcalculas.study.utils;

import com.xcalculas.study.constant.ReturnCode;
import com.xcalculas.study.model.Result;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年03月17日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class ResultUtil {


    public static <T> Result<T> success(T object){
        return new Result<>("000","成功", object);
    }

    public static <T> Result<T> success(){
        return new Result<>(ReturnCode.SUCCESS);
    }

    public static <T> Result<T> error(String code, String msg){
        return new Result<>(code, msg);
    }

    public static <T> Result<T> error(ReturnCode returnCode){
        return new Result<>(returnCode);
    }
    public static <T> Result<T> error(ReturnCode returnCode, T data){
        return new Result<>(returnCode, data);
    }

}
