package com.codewars.revolut;

/**
 * @author Sergey Golitsyn
 * created on 08.04.2024
 *
 * todo add docs
 */
public interface LoadBalancer {

    void registerAddress(String address);

    String getSupportedType();

    int getSize();

    String get();
}
