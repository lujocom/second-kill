package com.xcalculas.study.service;

import com.google.common.collect.Lists;
import com.xcalculas.study.constant.ReturnCode;
import com.xcalculas.study.domain.SecondKill;
import com.xcalculas.study.domain.SecondKillExample;
import com.xcalculas.study.domain.SuccessKill;
import com.xcalculas.study.dto.Exposer;
import com.xcalculas.study.dto.SecondKillDto;
import com.xcalculas.study.exception.RepeatKillException;
import com.xcalculas.study.exception.SecondKillCloseException;
import com.xcalculas.study.exception.SecondKillException;
import com.xcalculas.study.mapper.SecondKillMapper;
import com.xcalculas.study.mapper.SuccessKillMapper;
import com.xcalculas.study.model.Result;
import com.xcalculas.study.utils.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

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
@Service
public class SecondKillServiceImpl implements ISecondKillService {

    private final static Logger logger = LoggerFactory.getLogger(SecondKillServiceImpl.class);

    @Autowired
    private SecondKillMapper secondKillMapper;

    @Autowired
    private SuccessKillMapper successKillMapper;

    private String pattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 产生md5的掩码
     */
    private String mask = "dshjaksdhui1y271*&^&*!^@(!)*#@*!*@BKJHKHK";

    @Override
    public List<SecondKillDto> getSecondKillList() {

        List<SecondKill> secondKillList = secondKillMapper.getAllSecondKill();
        List<SecondKillDto> secondKillDtoList = Lists.newArrayList();
        for (SecondKill item : secondKillList) {
            SecondKillDto secondKillDto = new SecondKillDto(item);
            secondKillDto.setStartTimeStr(DateFormatUtils.format(item.getStartTime(), pattern));
            secondKillDto.setEndTimeStr(DateFormatUtils.format(item.getEndTime(), pattern));
            secondKillDtoList.add(secondKillDto);
        }

        return secondKillDtoList;
    }

    @Override
    public SecondKillDto getSecondKillById(String seckillId) {

        SecondKill secondKill = secondKillMapper.getSecondKillById(seckillId);
        SecondKillDto secondKillDto = new SecondKillDto(secondKill);
        secondKillDto.setStartTimeStr(DateFormatUtils.format(secondKillDto.getStartTime(), pattern));
        secondKillDto.setEndTimeStr(DateFormatUtils.format(secondKillDto.getEndTime(), pattern));
        return secondKillDto;

    }

    @Override
    public Result<Exposer> exposeSecondKillUrl(String seckillId) {
        SecondKillExample example = new SecondKillExample();
        SecondKillExample.Criteria criteria = example.createCriteria();
        criteria.andSeckillIdEqualTo(seckillId);
        Date currentDate = new Date();
        criteria.andStartTimeLessThanOrEqualTo(currentDate);
        criteria.andEndTimeGreaterThanOrEqualTo(currentDate);
        criteria.andNumberGreaterThan(0);

        List<SecondKill> secondKillList = secondKillMapper.selectByExample(example);
        Exposer exposer;
        if (secondKillList.isEmpty()) {
            exposer = new Exposer(seckillId);
            return ResultUtil.error(ReturnCode.ERROR_SECOND_KILL_CLOSED, exposer);
        }
        exposer = new Exposer(generateMd5(seckillId), seckillId);
        return ResultUtil.success(exposer);
    }

    @Override
    @Transactional
    public Result<SuccessKill> executeSecondKill(String seckillId, String userPhone, String md5) throws SecondKillException, RepeatKillException, SecondKillCloseException {

        if (StringUtils.isBlank(md5) || !StringUtils.equals(generateMd5(seckillId), md5)) {
            throw new SecondKillException(ReturnCode.ERROR_MD5_REWRITE.getMsg());
//            return ResultUtil.error(ReturnCode.ERROR_MD5_REWRITE);
        }
        try {
            Date currentDate = new Date();
            SecondKillExample example = new SecondKillExample();
            SecondKillExample.Criteria criteria = example.createCriteria();
            criteria.andSeckillIdEqualTo(seckillId);
            criteria.andStartTimeLessThanOrEqualTo(currentDate);
            criteria.andEndTimeGreaterThanOrEqualTo(currentDate);
            criteria.andNumberGreaterThan(0);
            int row = secondKillMapper.reduceNumber(example);
            if (row <= 0) {
                throw new SecondKillCloseException(ReturnCode.ERROR_SECOND_KILL_CLOSED.getMsg());
            }

            SuccessKill successKill = new SuccessKill();
            successKill.setSeckillId(seckillId);
            successKill.setUserPhone(userPhone);
            successKill.setCreateTime(new Date());
            successKill.setState(new Integer(1).byteValue());
            row = successKillMapper.insert(successKill);
            if (row <= 0) {
                throw new RepeatKillException(ReturnCode.ERROR_REPEAT_SECOND_KILL.getMsg());
            }
            return ResultUtil.success(successKill);

        } catch (SecondKillCloseException | RepeatKillException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw  e;
        }

    }

    private String generateMd5(String seckillId) {
        return DigestUtils.md5DigestAsHex((seckillId + "/" + mask).getBytes());
    }

}
