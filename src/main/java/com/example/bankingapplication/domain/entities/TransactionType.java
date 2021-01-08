package com.example.bankingapplication.domain.entities;

import javax.persistence.Embeddable;

@Embeddable
public enum TransactionType {
  DEPOSIT,
  WITHDRAWAL;
}
