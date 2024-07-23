package com.codewars.revolut.impl;

import com.codewars.revolut.LoadBalancer;
import com.codewars.revolut.data.LoadBalancerErr;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergey Golitsyn
 * created on 08.04.2024
 */
public class AddressLoadBalancer implements LoadBalancer {

    private final int size;
    private final List<String> addressesSet;
    private Random rand;


    public AddressLoadBalancer(int size, Random rand){
        addressesSet = Collections.synchronizedList(new ArrayList<>());
        this.size = size;
        this.rand = rand;
    }

    /**
     * @return false if more than 10 rows and if already contains
     */
    @Override
    public void registerAddress(String address) {
        if (addressesSet.size() > size){
            throw new RuntimeException(LoadBalancerErr.SIZE_LIMIT.getDescription());
        }
        if (addressesSet.contains(address)){
            throw new RuntimeException(LoadBalancerErr.DUPLICATED_ADDRESS.getDescription());
        }
        // todo add address validation
        addressesSet.add(address);
    }

    @Override
    public String getSupportedType() {
        return "Address";
    }

    @Override
    public int getSize() {
        return addressesSet.size();
    }

    @Override
    public String get() {
        int randomIndex = rand.nextInt(addressesSet.size());
        return addressesSet.get(randomIndex);
    }
}
