package com.jfb.api.messages;

import com.jfb.api.controllers.OwnerPostController;
import com.jfb.api.dto.CarPostDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.jfb.api.utils.Constantes.KAFKA_TOPIC;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;
    private static final Logger LOG = LoggerFactory.getLogger(KafkaProducerMessage.class);

    public void sendMessage(CarPostDTO carPostDTO) {
        LOG.info("Sending message: {}", carPostDTO);
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }
}
