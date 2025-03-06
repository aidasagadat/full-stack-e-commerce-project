package com.aida.service;

import com.aida.model.Order;
import com.aida.model.Seller;
import com.aida.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Order order);
    List<Transaction> getTransactionsBySellerId(Seller seller);
    List<Transaction> getAllTransactions();
}


















