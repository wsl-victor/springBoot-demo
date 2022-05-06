package com.wsl.rabbitmq.mail.service;


import com.wsl.rabbitmq.common.ServerResponse;
import com.wsl.rabbitmq.mail.vo.Mail;

public interface MailSendService {

    ServerResponse testIdempotence();

    ServerResponse accessLimit();

    ServerResponse send(Mail mail);
}
