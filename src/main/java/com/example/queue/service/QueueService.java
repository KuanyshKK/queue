package com.example.queue.service;

import com.example.queue.model.entity.Queue;

public interface QueueService {

    /**
     * Получить следующую очередь
     *
     * @return
     */
    Queue getNextQueue();

    /**
     * Получить следующий код очереди
     *
     * @param code {@link Queue#getCode()}
     * @return {@link String code}
     */
    String getNextQueue(String code);

}
