package com.kafka.Repository;

import com.kafka.Entity.WikiMediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaConsumerRepository extends JpaRepository<WikiMediaData,Long> {
}
