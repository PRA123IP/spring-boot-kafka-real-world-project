package com.kafka;

import com.kafka.Entity.WikiMediaData;
import com.kafka.Repository.KafkaConsumerRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private  static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private KafkaConsumerRepository kafkaConsumerRepository;
    @KafkaListener(
            topics = "wikimedia-recentchange",
            groupId = "my-consumer-group"
    )
    public  void sentmessage(String eventMessage)
    {
        logger.info(String.format("Event message recieved --> %s",eventMessage ));
        WikiMediaData wikiMediaData=new WikiMediaData();
        wikiMediaData.setWikiEventData(eventMessage);
        kafkaConsumerRepository.save(wikiMediaData);
    }








}
