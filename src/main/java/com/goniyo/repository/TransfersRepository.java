package com.goniyo.repository;

import org.springframework.data.repository.CrudRepository;

import com.goniyo.model.Stock;
import com.goniyo.model.Transfers;

public interface TransfersRepository extends CrudRepository<Transfers,Integer> {

}
