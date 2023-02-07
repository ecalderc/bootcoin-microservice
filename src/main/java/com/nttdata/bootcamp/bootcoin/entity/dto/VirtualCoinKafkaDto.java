package com.nttdata.bootcamp.bootcoin.entity.dto;

import lombok.Data;

@Data
public class VirtualCoinKafkaDto {
    private String cellNumberSend;
    private String cellNumberReceive;
    private Number mount;
}
