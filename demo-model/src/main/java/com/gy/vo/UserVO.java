package com.gy.vo;

import com.gy.annotation.TestAnnotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description 用户类
 * @Author guyu
 * @Date 2019/1/11 18:38
 * @Version 1.0
 * @Precept 哈哈哈
 */
@TestAnnotation(name = "guyu",phoneNum = 18861763819L)
public class UserVO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 住址
     */
    private String address;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 订单号
     */
    private Long orderCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderCode=" + orderCode +
                '}';
    }
}
