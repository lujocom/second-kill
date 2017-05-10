package com.xcalculas.study.mapper;

import com.xcalculas.study.domain.SecondKill;
import com.xcalculas.study.domain.SecondKillExample;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年03月18日</dd>
 * </dl>
 *
 * @author LuoHui
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondKillMapperTest {

    private final static Logger logger = LoggerFactory.getLogger(SecondKillMapperTest.class);

    @Autowired
    private SecondKillMapper secondKillMapper;

    @Test
    public void testReduceNumber(){

        SecondKillExample example = new SecondKillExample();
        SecondKillExample.Criteria criteria = example.createCriteria();
        criteria.andSeckillIdEqualTo("1000");
        Date currentDate = new Date();
        criteria.andStartTimeLessThanOrEqualTo(currentDate);
        criteria.andEndTimeGreaterThanOrEqualTo(currentDate);
        criteria.andNumberGreaterThan(0);
        int row = secondKillMapper.reduceNumber(example);

        Assert.assertEquals(1, row);

    }

    @Test
    public void testGetSecondKill(){

        SecondKillExample example = new SecondKillExample();
        SecondKillExample.Criteria criteria = example.createCriteria();
        criteria.andSeckillIdEqualTo("1000");

        List<SecondKill> secondKill = secondKillMapper.selectByExample(example);
        for(SecondKill item : secondKill){
            logger.info(item.toString());
        }

    }

    @Test
    public void testGetSecondKillByPrimaryKey(){
        SecondKill secondKill = secondKillMapper.selectByPrimaryKey("1000");
        logger.info(secondKill.toString());
    }




}
