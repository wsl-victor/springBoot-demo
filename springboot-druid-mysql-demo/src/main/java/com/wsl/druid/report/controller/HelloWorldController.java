package com.wsl.druid.report.controller;


import com.wsl.druid.report.dao.mapper.TUserDao;
import com.wsl.druid.report.dao.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloWorldController {


    @Autowired
    private TUserDao userDao;

    @RequestMapping("/query")
    @ResponseBody
    public TUser query(){
        return userDao.queryById(1);
    }
}
