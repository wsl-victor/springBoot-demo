package com.wsl.rabbitmq.mail.service.batch;

import java.util.List;

public interface BatchProcessMapper<T> {

    void batchInsert(List<T> list);

    void batchUpdate(List<T> list);

}
