package com.bff.broker.client;

import com.bff.broker.dto.TradeRequest;
import com.bff.broker.dto.TradeResponse;
import com.bff.broker.exception.DownstreamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * Thin HTTP client over the business-broker trading API.
 */
@Component
@Slf4j
public class BusinessBrokerClient {

    private final RestClient restClient;

    public BusinessBrokerClient(RestClient businessBrokerRestClient) {
        this.restClient = businessBrokerRestClient;
    }

    public TradeResponse buy(TradeRequest request) {
        return execute("/api/stocks/buy", request);
    }

    public TradeResponse sell(TradeRequest request) {
        return execute("/api/stocks/sell", request);
    }

    private TradeResponse execute(String path, TradeRequest request) {
        log.info("Calling business-broker {} for {}", path, request.symbol());
        return restClient.post()
                .uri(path)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .exchange((req, res) -> {
                    if (res.getStatusCode().isError()) {
                        ProblemDetail problem = res.bodyTo(ProblemDetail.class);
                        String detail = problem != null && problem.getDetail() != null
                                ? problem.getDetail()
                                : "business-broker returned " + res.getStatusCode();
                        throw new DownstreamException(res.getStatusCode(), detail);
                    }
                    return res.bodyTo(TradeResponse.class);
                });
    }
}
