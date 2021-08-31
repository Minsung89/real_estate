package com.virtual.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtual.real_estate.entity.TransactionHistory;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, String>{

}
