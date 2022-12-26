package com.example.queue.service;

import com.example.queue.service.impl.QueueServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QueueServiceTest {

    @InjectMocks
    QueueServiceImpl queueService;

    @Test
    void getNextCode() {
        String code = "a0a0";

        String result = queueService.getNextQueue(code);
        Assertions.assertEquals("a0a1", result);
    }

    @Test
    void getNextCodeWhenLastNumberMaxNumber() {
        String code = "a0a9";

        String result = queueService.getNextQueue(code);
        Assertions.assertEquals("a0b0", result);
    }

    @Test
    void getNextCodeWhenAllValuesMax() {
        String code = "z9z9";

        String result = queueService.getNextQueue(code);
        Assertions.assertEquals("a0a0a0", result);
    }

}
