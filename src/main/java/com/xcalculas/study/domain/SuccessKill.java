package com.xcalculas.study.domain;

import java.util.Date;

public class SuccessKill {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success_kill.seckill_id
     *
     * @mbggenerated Mon Mar 20 20:51:08 CST 2017
     */
    private String seckillId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success_kill.user_phone
     *
     * @mbggenerated Mon Mar 20 20:51:08 CST 2017
     */
    private String userPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success_kill.state
     *
     * @mbggenerated Mon Mar 20 20:51:08 CST 2017
     */
    private Byte state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column success_kill.create_time
     *
     * @mbggenerated Mon Mar 20 20:51:08 CST 2017
     */
    private Date createTime;

    public String getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(String seckillId) {
        this.seckillId = seckillId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column success_kill.state
     *
     * @return the value of success_kill.state
     *
     * @mbggenerated Mon Mar 20 20:51:08 CST 2017
     */
    public Byte getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column success_kill.state
     *
     * @param state the value for success_kill.state
     *
     * @mbggenerated Mon Mar 20 20:51:08 CST 2017
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column success_kill.create_time
     *
     * @return the value of success_kill.create_time
     *
     * @mbggenerated Mon Mar 20 20:51:08 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column success_kill.create_time
     *
     * @param createTime the value for success_kill.create_time
     *
     * @mbggenerated Mon Mar 20 20:51:08 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}