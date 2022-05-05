package com.wsl.druid.report.dao.entity;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2022-05-05 21:38:17
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = -49650727465188588L;
    
    private Integer id;
    
    private String username;
    
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}