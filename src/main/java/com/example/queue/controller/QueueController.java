package com.example.queue.controller;

import com.example.queue.facade.QueueFacade;
import com.example.queue.model.dto.QueueResponseDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/queues")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QueueController {

    QueueFacade queueFacade;

    @GetMapping
    public ResponseEntity<QueueResponseDto> getNextQueue() {
        return ResponseEntity.ok(queueFacade.getNextQueue());
    }

}
