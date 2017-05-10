package com.xcalculas.study.dto;

/**
 * <dl>
 * <dt>second-kill</dt>
 * <dd>Description:秒杀状态返回数据结构</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 成都微积分科技有限公司</dd>
 * <dd>CreateDate: 2017年03月20日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class Exposer {

    private String md5;

    private String seckillId;

    /**
     * 当前系统时间（单位：毫秒）
     */
    private Long now;

    /**
     * 开始时间（单位：毫秒）
     */
    private Long start;

    /**
     * 结束时间（单位：毫秒）
     */
    private Long end;

    public Exposer() {
    }

    public Exposer(String md5, String seckillId) {
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer( Long now, Long start, Long end) {
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(String seckillId) {
        this.seckillId = seckillId;
    }


    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(String seckillId) {
        this.seckillId = seckillId;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
