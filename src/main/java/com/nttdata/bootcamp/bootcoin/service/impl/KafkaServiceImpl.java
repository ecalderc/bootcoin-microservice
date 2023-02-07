package com.nttdata.bootcamp.bootcoin.service.impl;

import com.nttdata.bootcamp.bootcoin.entity.BootCoin;
import com.nttdata.bootcamp.bootcoin.entity.dto.VirtualCoinKafkaDto;
import com.nttdata.bootcamp.bootcoin.events.BootCoinCreatedEventKafka;
import com.nttdata.bootcamp.bootcoin.events.EventKafka;
import com.nttdata.bootcamp.bootcoin.repository.BootCoinRepository;
import com.nttdata.bootcamp.bootcoin.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private BootCoinRepository bootCoinRepository;

    @KafkaListener(
            topics = "${topic.bootCoin.name:topic_bootCoin}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumerSave(EventKafka<?> eventKafka) {
        if (eventKafka.getClass().isAssignableFrom(BootCoinCreatedEventKafka.class)) {
            BootCoinCreatedEventKafka createdEvent = (BootCoinCreatedEventKafka) eventKafka;
            log.info("Received Data created event .... with Id={}, data={}",
                    createdEvent.getId(),
                    createdEvent.getData().toString());
            VirtualCoinKafkaDto virtualCoinKafkaDto = ((BootCoinCreatedEventKafka) eventKafka).getData();
            BootCoin bootCoin = new BootCoin();
            bootCoin.setMount(virtualCoinKafkaDto.getMount());
            bootCoin.setCellNumber(virtualCoinKafkaDto.getCellNumberReceive());
            bootCoin.setNumberTransaction(UUID.randomUUID().toString());
            this.bootCoinRepository.save(bootCoin).subscribe();
        }
    }

}
