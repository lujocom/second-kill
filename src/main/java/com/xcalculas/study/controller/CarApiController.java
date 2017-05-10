package com.xcalculas.study.controller;

import com.xcalculas.study.domain.Car;
import com.xcalculas.study.model.Result;
import com.xcalculas.study.service.CarService;
import com.xcalculas.study.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/car/api")
public class CarApiController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/all-cars", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Result<List<Car>> getAllCar(){
        return ResultUtil.success(carService.getAllCar());
    }







}
