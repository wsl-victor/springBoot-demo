package com.wsl.rabbitmq.mail.service.impl;

import com.wsl.rabbitmq.common.ResponseCode;
import com.wsl.rabbitmq.common.ServerResponse;
import com.wsl.rabbitmq.conifg.RabbitConfig;
import com.wsl.rabbitmq.mail.mapper.MsgLogMapper;
import com.wsl.rabbitmq.mail.service.MailSendService;
import com.wsl.rabbitmq.mail.vo.Mail;
import com.wsl.rabbitmq.mail.vo.MsgLog;
import com.wsl.rabbitmq.mq.MessageHelper;
import com.wsl.rabbitmq.util.RandomUtil;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSendServiceImpl implements MailSendService {


    @Autowired
    private MsgLogMapper msgLogMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public ServerResponse testIdempotence() {
        return ServerResponse.success("testIdempotence: success");
    }

    @Override
    public ServerResponse accessLimit() {
        return ServerResponse.success("accessLimit: success");
    }

    @Override
    public ServerResponse send(Mail mail) {
        String msgId = RandomUtil.UUID32();
        mail.setMsgId(msgId);

        MsgLog msgLog = new MsgLog(msgId, mail, RabbitConfig.MAIL_EXCHANGE_NAME, RabbitConfig.MAIL_ROUTING_KEY_NAME);
        msgLogMapper.insert(msgLog);// 消息入库

        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplate.convertAndSend(RabbitConfig.MAIL_EXCHANGE_NAME, RabbitConfig.MAIL_ROUTING_KEY_NAME, MessageHelper.objToMsg(mail), correlationData);// 发送消息

        return ServerResponse.success(ResponseCode.MAIL_SEND_SUCCESS.getMsg());
    }

}
