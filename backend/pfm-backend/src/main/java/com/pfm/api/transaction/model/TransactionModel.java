package com.pfm.api.transaction.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.pfm.api.transaction.enums.TransactionCategory;
import com.pfm.api.transaction.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionModel {
	private Long id;
	private String description;
	private BigDecimal amount;
	private Date date;
	private TransactionType type;
	private TransactionCategory category;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
