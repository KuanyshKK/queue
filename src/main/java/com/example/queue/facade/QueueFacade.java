package com.example.queue.facade;

import com.example.queue.model.dto.QueueResponseDto;

public interface QueueFacade {

    QueueResponseDto getNextQueue();

}
