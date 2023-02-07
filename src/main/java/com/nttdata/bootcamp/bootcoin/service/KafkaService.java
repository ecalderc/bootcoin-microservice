package com.nttdata.bootcamp.bootcoin.service;

import com.nttdata.bootcamp.bootcoin.events.EventKafka;

public interface KafkaService {
    void consumerSave(EventKafka<?> eventKafka);
}
