package com.xcalculas.study.mapper;

import com.xcalculas.study.domain.SuccessKill;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
@RunWith(SpringRunner.class)
@SpringBootTest
public class SuccessKillMapperTest {

    private final static Logger logger = LoggerFactory.getLogger(SuccessKillMapperTest.class);


    @Autowired
    private SuccessKillMapper successKillMapper;



}
