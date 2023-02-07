package com.nttdata.bootcamp.bootcoin.service.impl;

import com.nttdata.bootcamp.bootcoin.entity.BootCoin;
import com.nttdata.bootcamp.bootcoin.repository.BootCoinRepository;
import com.nttdata.bootcamp.bootcoin.service.BootCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//Service implementation
@Service
public class BootCoinServiceImpl implements BootCoinService {

    @Autowired
    private BootCoinRepository bootCoinRepository;

    @Override
    public Flux<BootCoin> findAllBootCoin() {
        Flux<BootCoin> virtualCoinFlux = bootCoinRepository
                .findAll();
        return virtualCoinFlux;
    }
    @Override
    public Mono<BootCoin> findBootCoinByCellNumber(String cellNumber) {
        Mono<BootCoin> virtualCoinFlux = bootCoinRepository
                .findAll()
                .filter(x -> x.getCellNumber().equals(cellNumber) ).next();
        return virtualCoinFlux;
    }

    //then main account is false by default
    @Override
    public Mono<BootCoin> saveBootCoin(BootCoin dataBootCoin) {
        return bootCoinRepository.save(dataBootCoin);
    }


}
