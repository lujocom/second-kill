package com.xcalculas.study.controller;

import com.xcalculas.study.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
@RestController
@RequestMapping("/car/page")
public class CarPageController extends BaseController{

    @RequestMapping("/index")
    public ModelAndView go2carList(){
        return packagingMAV(null,"html/index");
    }


}
