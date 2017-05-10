package com.xcalculas.study.controller;

import com.google.common.collect.Maps;
import com.xcalculas.study.base.BaseController;
import com.xcalculas.study.domain.SecondKill;
import com.xcalculas.study.dto.SecondKillDto;
import com.xcalculas.study.service.ISecondKillService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

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
@RequestMapping("/second-kill")
public class SecondKillPageController extends BaseController{

    @Autowired
    private ISecondKillService secondKillService;

    @RequestMapping("/list")
    public ModelAndView go2list(){
        Map<String, Object> result = Maps.newHashMap();
        return packagingMAV(result,"html/list");
    }

    @RequestMapping("/detail/{id}")
    public ModelAndView go2detail(@PathVariable String id){
        Map<String, Object> result = Maps.newHashMap();
        SecondKillDto secondKillDto = secondKillService.getSecondKillById(id);
        String pattern = "yyyy/MM/dd HH:mm:ss";
        Date today = new Date();
        result.put("today", today.getTime());
        result.put("startTime", DateFormatUtils.format(secondKillDto.getStartTime(), pattern));

        if (today.before(secondKillDto.getStartTime())){
            result.put("canSecondKill", 1);
        }else if(today.after(secondKillDto.getEndTime())){
            result.put("canSecondKill", -1);
        }else{
            result.put("canSecondKill", 0);
        }
        result.put("detail", secondKillDto);
        return packagingMAV(result,"html/detail");
    }








}
