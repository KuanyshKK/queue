package com.example.queue.repository;

import com.example.queue.model.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Long> {

    Queue findTopByOrderByIdDesc();

}
