package com.spring.cloud.mqmessage.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Author MCC
 * @Create 2019/4/8 0:37
 */
@Data
public class User {

    private String name;
    private String sex;

    public User() {
    }
}
