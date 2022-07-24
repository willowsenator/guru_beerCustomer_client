package com.willowsenator.guru_beerCustomer_client.web.client;

import com.willowsenator.guru_beerCustomer_client.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerBeerClientTest {

    @Autowired
    CustomerBeerClient client;

    @Test
    void getCustomerById() {
        var dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        var dto = CustomerDto.builder().name("New customer").build();
        var uri = client.saveNewCustomer(dto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateCustomer() {
        try {
            var dto = CustomerDto.builder().name("New Customer").build();
            client.updateCustomer(UUID.randomUUID(), dto);
        }
        catch(Exception ex){
            fail(ex.getMessage());
        }

    }

    @Test
    void deleteCustomer() {
        try{
            client.deleteCustomer(UUID.randomUUID());
        }
        catch(Exception ex){
            fail(ex.getMessage());
        }
    }
}