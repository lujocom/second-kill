package com.xcalculas.study.service;

import com.xcalculas.study.constant.ReturnCode;
import com.xcalculas.study.domain.SecondKill;
import com.xcalculas.study.domain.SuccessKill;
import com.xcalculas.study.dto.Exposer;
import com.xcalculas.study.dto.SecondKillDto;
import com.xcalculas.study.model.Result;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

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
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondKillServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(SecondKillServiceImplTest.class);

    @Autowired
    private ISecondKillService secondKillService;

    @Test
    public void getSecondKillListTest() throws Exception {
        List<SecondKillDto> getAllSecondKill = secondKillService.getSecondKillList();

        logger.debug("list size: {}", getAllSecondKill.size());

    }

    @Test
    public void getSecondKillByIdTest() throws Exception {
        String secondKillId = "1001";
        SecondKill secondKill = secondKillService.getSecondKillById(secondKillId);
        logger.debug("secondKill : {}", secondKill.toString());
    }

    @Test
    public void testExposeSecondKillUrl() throws Exception {
        String userPhone = "18227691203";
        Result<Exposer> result = secondKillService.exposeSecondKillUrl("1001");
        logger.debug("expose result : {}" , result.toString());
        if(StringUtils.equals(ReturnCode.SUCCESS.getCode(), result.getCode())){
            Result<SuccessKill> successKillResult = secondKillService.executeSecondKill(result.getData().getSeckillId(),
                    userPhone, result.getData().getMd5());
            logger.debug("secondKill : {}" , successKillResult.toString());
        }
    }

    @Test
    public void testExecuteSecondKill() throws Exception {

    }

}