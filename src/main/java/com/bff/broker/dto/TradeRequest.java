package com.bff.broker.dto;

import java.math.BigDecimal;

/**
 * Buy/sell request received from the client and forwarded to business-broker.
 *
 * @param symbol   ticker symbol, e.g. "AAPL"
 * @param quantity number of shares to trade
 * @param price    price per share
 */
public record TradeRequest(String symbol, Long quantity, BigDecimal price) {
}
