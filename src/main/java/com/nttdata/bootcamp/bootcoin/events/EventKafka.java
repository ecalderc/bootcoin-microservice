package com.nttdata.bootcamp.bootcoin.events;

import com.nttdata.bootcamp.bootcoin.entity.enums.EventType;
import lombok.Data;

import java.util.Date;

@Data
public abstract class EventKafka<T> {
    private String id;
    private Date date;
    private EventType type;
    private T data;
}
