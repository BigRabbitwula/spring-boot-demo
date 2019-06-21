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

    private Long id;

    private String name;

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
}
