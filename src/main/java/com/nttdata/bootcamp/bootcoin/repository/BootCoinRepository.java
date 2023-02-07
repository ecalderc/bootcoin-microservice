package com.nttdata.bootcamp.bootcoin.repository;

import com.nttdata.bootcamp.bootcoin.entity.BootCoin;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BootCoinRepository extends ReactiveCrudRepository<BootCoin, String> {
}
