package com.xcalculas.study.domain;

public class Car {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.id
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_brand
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    private String carBrand;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_name
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    private String carName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.car_type
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    private String carType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.id
     *
     * @return the value of car.id
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.id
     *
     * @param id the value for car.id
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_brand
     *
     * @return the value of car.car_brand
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    public String getCarBrand() {
        return carBrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_brand
     *
     * @param carBrand the value for car.car_brand
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_name
     *
     * @return the value of car.car_name
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    public String getCarName() {
        return carName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_name
     *
     * @param carName the value for car.car_name
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.car_type
     *
     * @return the value of car.car_type
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    public String getCarType() {
        return carType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.car_type
     *
     * @param carType the value for car.car_type
     *
     * @mbggenerated Fri Mar 17 15:53:22 CST 2017
     */
    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }
}