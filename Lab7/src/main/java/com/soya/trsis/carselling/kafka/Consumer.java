package com.soya.trsis.carselling.kafka;

import com.soya.trsis.carselling.db.model.Car;
import com.soya.trsis.carselling.db.dao.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class Consumer {

    @Autowired
    CarRepository carRepository;

    @KafkaListener(topics = "TEST1", groupId = "group0")
    public void consume(ConsumerRecord<String,String> message) throws IOException {
        System.out.print(String.format("#### -> Consumed message -> %s", message));
        log.info(String.format("#### -> Consumed message -> %s", message));
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(message.value(), Car.class);
        carRepository.save(car);
    }

}