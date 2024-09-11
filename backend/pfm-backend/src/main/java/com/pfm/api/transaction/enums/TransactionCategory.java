package com.pfm.api.transaction.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public enum TransactionCategory {
	FOOD, 
	TRANSPORT, 
	SALARY, 
	ENTERTAINMENT, 
	HEALTH, 
	OTHER
}
