package com.jfb.car_analitycs_data.messages;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.jfb.car_analitycs_data.dtos.CarPostDTO;
import com.jfb.car_analitycs_data.services.PostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-post-group")
    public void listening(@Payload CarPostDTO carPost) {
        System.out.println("Receiving Car post information: " + carPost);
        LOG.info("ANALYTICS DATA - Receiving Car post information: {}", carPost);
        postAnalyticsService.saveDataAnalytics(carPost);
    }
}
