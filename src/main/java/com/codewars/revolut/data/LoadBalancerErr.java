package com.codewars.revolut.data;

/**
 * @author Sergey Golitsyn
 * created on 08.04.2024
 */
public enum LoadBalancerErr {
    DUPLICATED_ADDRESS("Address already registered"),
    SIZE_LIMIT("Load Balancer is full. Try again later");
    private String description;

    LoadBalancerErr(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
