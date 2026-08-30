package com.bff.broker.dto;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Trade result returned by business-broker and relayed back to the client.
 */
public record TradeResponse(
        Long tradeId,
        String symbol,
        String type,
        Long quantity,
        BigDecimal price,
        BigDecimal totalAmount,
        Long resultingHoldingQuantity,
        Instant executedAt
) {
}
