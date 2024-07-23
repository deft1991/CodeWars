package com.codewars.revolut.impl;

import com.codewars.revolut.LoadBalancer;
import com.codewars.revolut.data.LoadBalancerErr;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddressLoadBalancerTest {

    @Test
    void register_first_address_success() {
        Random rand = ThreadLocalRandom.current();
        LoadBalancer lb = new AddressLoadBalancer(10, rand);
        lb.registerAddress("address");
        int size = lb.getSize();

        assertEquals(1, size);
    }

    @Test
    void register_non_uniq_address_throws_err() {
        Random rand = ThreadLocalRandom.current();
        LoadBalancer lb = new AddressLoadBalancer(10, rand);

        lb.registerAddress("addres");

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> lb.registerAddress("addres"));
        assertEquals(runtimeException.getLocalizedMessage(), LoadBalancerErr.DUPLICATED_ADDRESS.getDescription());
    }

    @Test
    void register_more_than_n_address_throws_err() {
        Random rand = ThreadLocalRandom.current();
        LoadBalancer lb = new AddressLoadBalancer(2, rand);
        lb.registerAddress("addres_1");
        lb.registerAddress("addres_2");

        lb.registerAddress("addres_3");
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> lb.registerAddress("addres_3"));
        assertEquals(runtimeException.getLocalizedMessage(), LoadBalancerErr.SIZE_LIMIT.getDescription());
    }

    @Test
    void get_random_address_success() {
        Random rand = mock(Random.class);
        when(rand.nextInt(any())).thenReturn(2);

        LoadBalancer lb = new AddressLoadBalancer(10, rand);
        String baseAddress = "address";
        String baseAddress_Two = "address";
        lb.registerAddress(baseAddress);
        lb.registerAddress(baseAddress_Two);
        String address = lb.get();

        assertEquals(baseAddress_Two, address);
    }
}
