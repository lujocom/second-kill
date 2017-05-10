package com.xcalculas.study.service;

import com.xcalculas.study.domain.Car;
import com.xcalculas.study.domain.CarExample;
import com.xcalculas.study.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;


    public List<Car> getAllCar(){
        CarExample carExample = new CarExample();
        return carMapper.selectByExample(carExample);
    }






}
