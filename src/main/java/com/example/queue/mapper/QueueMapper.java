package com.example.queue.mapper;

import com.example.queue.model.dto.QueueResponseDto;
import com.example.queue.model.entity.Queue;
import org.springframework.stereotype.Component;

@Component
public class QueueMapper {

    public QueueResponseDto toDto(Queue entity) {
        QueueResponseDto dto = new QueueResponseDto();
        dto.setCode(entity.getCode());

        return dto;
    }

}
