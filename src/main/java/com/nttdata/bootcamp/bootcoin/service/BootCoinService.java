package com.nttdata.bootcamp.bootcoin.service;

import com.nttdata.bootcamp.bootcoin.entity.BootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//Interface Service
public interface BootCoinService {
    Flux<BootCoin> findAllBootCoin();
    Mono<BootCoin> findBootCoinByCellNumber(String dni);
    Mono<BootCoin> saveBootCoin(BootCoin dataBootCoin);

}
