package com.xcalculas.study.controller;

import com.xcalculas.study.base.BaseController;
import com.xcalculas.study.constant.ReturnCode;
import com.xcalculas.study.domain.SecondKill;
import com.xcalculas.study.domain.SuccessKill;
import com.xcalculas.study.dto.Exposer;
import com.xcalculas.study.dto.SecondKillDto;
import com.xcalculas.study.exception.RepeatKillException;
import com.xcalculas.study.exception.SecondKillCloseException;
import com.xcalculas.study.model.Result;
import com.xcalculas.study.service.ISecondKillService;
import com.xcalculas.study.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年03月23日</dd>
 * </dl>
 *
 * @author LuoHui
 */
@RestController
@RequestMapping("/second-kill/api")
public class SecondKillApiController extends BaseController {

    @Autowired
    private ISecondKillService secondKillService;

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Result<List<SecondKillDto>> getAllSecondKill() {
        return ResultUtil.success(secondKillService.getSecondKillList());
    }

    @RequestMapping(value = "/expose/{id}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Result<Exposer> exposeSecondKillUrl(@PathVariable String id) {
        return secondKillService.exposeSecondKillUrl(id);
    }

    @RequestMapping(value = "/execute/{id}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Result<SuccessKill> executeSecondKill(@PathVariable String id, String phoneNumber, String md5) {
        try {
            return secondKillService.executeSecondKill(id, phoneNumber, md5);
        } catch (SecondKillCloseException | RepeatKillException e1) {
            return ResultUtil.error(ReturnCode.ERROR_SECOND_KILL_CLOSED);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultUtil.error(ReturnCode.ERROR_REPEAT_SECOND_KILL);

        }
    }
    @RequestMapping(value = "/now", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Result<Long> getCurrentDate() {
        return ResultUtil.success(new Date().getTime());
    }

}
