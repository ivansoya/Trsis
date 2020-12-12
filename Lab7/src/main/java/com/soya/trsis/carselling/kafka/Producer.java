package com.soya.trsis.carselling.kafka;

import com.soya.trsis.carselling.db.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class Producer {    
    
    private static final String TOPIC = "TEST2";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Car car) throws JsonProcessingException {
        log.info(String.format("#### -> Producing message -> %s", car.toString()));
        ObjectMapper mapper = new ObjectMapper();
        String message  = mapper.writeValueAsString(car);
        this.kafkaTemplate.send(TOPIC, message);
    }

}