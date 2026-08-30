package com.bff.broker.controller;

import com.bff.broker.client.BusinessBrokerClient;
import com.bff.broker.dto.TradeRequest;
import com.bff.broker.dto.TradeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/broker")
@RequiredArgsConstructor
public class BrokerController {

    private final BusinessBrokerClient businessBrokerClient;

    @PostMapping("/buy")
    public TradeResponse buy(@RequestBody TradeRequest request) {
        return businessBrokerClient.buy(request);
    }

    @PostMapping("/sell")
    public TradeResponse sell(@RequestBody TradeRequest request) {
        return businessBrokerClient.sell(request);
    }
}
