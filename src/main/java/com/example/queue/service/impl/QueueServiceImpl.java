package com.example.queue.service.impl;

import com.example.queue.model.entity.Queue;
import com.example.queue.repository.QueueRepository;
import com.example.queue.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class QueueServiceImpl implements QueueService {

    // Max, Min значении требуемых цифр и букв в ASCII
    public static final int NUMBER_MIN = 48;
    public static final int NUMBER_MAX = 57;

    public static final int LETTER_MIN = 97;
    public static final int LETTER_MAX = 122;

    private final QueueRepository queueRepository;

    @Override
    @Transactional
    public Queue getNextQueue() {
        Queue last = queueRepository.findTopByOrderByIdDesc();
        String code = getNextQueue(last.getCode());
        Queue newQueue = new Queue();
        newQueue.setCode(code);
        return queueRepository.save(newQueue);
    }

    @Override
    public String getNextQueue(String code) {
        int[] currentToIntArray = new int[code.length()];
        boolean isAllMax = true;
        char[] finalResult;
        for (int i = 0; i < code.length(); i++) {
            currentToIntArray[i] = code.charAt(i);
            if (i % 2 == 0) {
                if (currentToIntArray[i] != LETTER_MAX) {
                    isAllMax = false;
                }
            } else {
                if (currentToIntArray[i] != NUMBER_MAX) {
                    isAllMax = false;
                }
            }
        }

        if (isAllMax) {
            finalResult = getChars(currentToIntArray);
        } else {
            finalResult = getResult(currentToIntArray);
        }

        return String.copyValueOf(finalResult);
    }

    private char[] getResult(int[] currentToIntArray) {
        char[] result = new char[currentToIntArray.length];
        for (int i = currentToIntArray.length - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                if (currentToIntArray[i] < NUMBER_MAX) {
                    currentToIntArray[i] += 1;
                    break;
                }
                if (currentToIntArray[i] == NUMBER_MAX) {
                    currentToIntArray[i] = NUMBER_MIN;
                }
            } else {
                if (currentToIntArray[i] < LETTER_MAX) {
                    currentToIntArray[i] += 1;
                    break;
                }
                if (currentToIntArray[i] == LETTER_MAX) {
                    currentToIntArray[i] = LETTER_MIN;
                }
            }
        }
        for (int i = 0; i < currentToIntArray.length; i++) {
            result[i] = (char) currentToIntArray[i];
        }
        return result;
    }

    private char[] getChars(int[] currentToIntArray) {
        char[] result = new char[currentToIntArray.length + 2];
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = (char) LETTER_MIN;
            } else {
                result[i] = (char) NUMBER_MIN;
            }
        }
        return result;
    }
}
