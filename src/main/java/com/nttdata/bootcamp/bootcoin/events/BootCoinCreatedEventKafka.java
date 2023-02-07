package com.nttdata.bootcamp.bootcoin.events;

import com.nttdata.bootcamp.bootcoin.entity.dto.VirtualCoinKafkaDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BootCoinCreatedEventKafka extends EventKafka<VirtualCoinKafkaDto> {

}
