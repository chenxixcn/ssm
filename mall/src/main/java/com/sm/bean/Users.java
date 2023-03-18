package com.sm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String status;
    private String code;
}
