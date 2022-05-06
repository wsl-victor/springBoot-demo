package com.wsl.rabbitmq.mail.mapper;


import com.wsl.rabbitmq.mail.service.batch.BatchProcessMapper;
import com.wsl.rabbitmq.mail.vo.MsgLog;

import java.util.List;

public interface MsgLogMapper extends BatchProcessMapper<MsgLog> {

    void insert(MsgLog msgLog);

    void updateStatus(MsgLog msgLog);

    List<MsgLog> selectTimeoutMsg();

    void updateTryCount(MsgLog msgLog);

    MsgLog selectByPrimaryKey(String msgId);

}
