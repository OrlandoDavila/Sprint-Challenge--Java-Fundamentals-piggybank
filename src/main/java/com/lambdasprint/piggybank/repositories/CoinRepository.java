package com.lambdasprint.piggybank.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lambdasprint.piggybank.models.Coin;

public interface CoinRepository extends CrudRepository<Coin, Long> {
}
