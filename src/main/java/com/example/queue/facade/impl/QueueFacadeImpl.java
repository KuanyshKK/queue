package com.example.queue.facade.impl;

import com.example.queue.facade.QueueFacade;
import com.example.queue.mapper.QueueMapper;
import com.example.queue.model.dto.QueueResponseDto;
import com.example.queue.service.QueueService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QueueFacadeImpl implements QueueFacade {

    QueueService queueService;
    QueueMapper queueMapper;

    @Override
    public QueueResponseDto getNextQueue() {
        return queueMapper.toDto(queueService.getNextQueue());
    }

}
