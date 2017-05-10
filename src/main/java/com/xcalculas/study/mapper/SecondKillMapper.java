package com.xcalculas.study.mapper;

import com.xcalculas.study.domain.SecondKill;
import com.xcalculas.study.domain.SecondKillExample;
import java.util.List;

import com.xcalculas.study.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface SecondKillMapper extends MyMapper<SecondKill>{

    Integer reduceNumber(SecondKillExample example);

    SecondKill getSecondKillById(@Param("seckillId") String secondKillId);

    List<SecondKill> getAllSecondKill();
}