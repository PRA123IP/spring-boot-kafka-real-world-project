package com.kafka.producer;

import com.kafka.Handler.WikimediaChangeHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.net.URI;

@Service
public class WikimediaChangesProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;
    public  WikimediaChangesProducer(KafkaTemplate<String,String> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }
    public void sentMessage() throws Exception
    {
        String topic ="wikimedia-recentchange";
        // to read real strem data from wikimedia , we

        EventHandler eventHandler=new WikimediaChangeHandler(kafkaTemplate,topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }


}
