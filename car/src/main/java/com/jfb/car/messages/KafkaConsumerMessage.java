package com.jfb.car.messages;

import com.jfb.car.dtos.CarPostDTO;
import com.jfb.car.services.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "${kafka.listener.topic}", groupId = "${kafka.listener.group-id}")
    public void listening(CarPostDTO carPostDTO) {
        LOG.info("Received Car Post information: {}", CarPostDTO.class);
        carPostService.newPostDetails(carPostDTO);
    }
}
