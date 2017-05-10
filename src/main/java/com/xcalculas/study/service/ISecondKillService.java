package com.xcalculas.study.service;

import com.xcalculas.study.domain.SecondKill;
import com.xcalculas.study.domain.SuccessKill;
import com.xcalculas.study.dto.Exposer;
import com.xcalculas.study.dto.SecondKillDto;
import com.xcalculas.study.exception.RepeatKillException;
import com.xcalculas.study.exception.SecondKillCloseException;
import com.xcalculas.study.exception.SecondKillException;
import com.xcalculas.study.model.Result;

import java.util.List;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年03月20日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public interface ISecondKillService {

    List<SecondKillDto> getSecondKillList();

    SecondKillDto getSecondKillById(String seckillId);

    /**
     * 秒杀开启输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     * @return
     */
    Result<Exposer> exposeSecondKillUrl(String seckillId);

    /**
     * 执行秒杀
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    Result<SuccessKill>  executeSecondKill(String seckillId, String userPhone, String md5)
            throws SecondKillException, RepeatKillException, SecondKillCloseException;

}
