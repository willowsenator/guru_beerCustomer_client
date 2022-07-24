package com.willowsenator.guru_beerCustomer_client.web.client;

import com.willowsenator.guru_beerCustomer_client.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties("com.willowsenator")
public class CustomerBeerClient {
    public final String CUSTOMER_V1_PATH = "/api/v1/customer/";
    private final RestTemplate restTemplate;
    private String apiHost;

    public CustomerBeerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apiHost + CUSTOMER_V1_PATH + uuid.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost + CUSTOMER_V1_PATH, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apiHost + CUSTOMER_V1_PATH + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiHost + CUSTOMER_V1_PATH + uuid.toString());
    }
}
