package com.wsl.rabbitmq.mail.service;


import com.wsl.rabbitmq.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    ServerResponse createToken();

    void checkToken(HttpServletRequest request);

}
