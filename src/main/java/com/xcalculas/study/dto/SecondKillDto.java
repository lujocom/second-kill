package com.xcalculas.study.dto;

import com.xcalculas.study.domain.SecondKill;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年05月09日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class SecondKillDto extends SecondKill {

    public SecondKillDto() {
    }
    public SecondKillDto(SecondKill secondKill) {
        this.setSeckillId(secondKill.getSeckillId());
        this.setName(secondKill.getName());
        this.setNumber(secondKill.getNumber());
        this.setStartTime(secondKill.getStartTime());
        this.setEndTime(secondKill.getEndTime());
    }



    private String startTimeStr;

    private String endTimeStr;

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
}
