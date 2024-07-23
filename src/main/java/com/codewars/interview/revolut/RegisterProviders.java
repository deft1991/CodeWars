package com.codewars.interview.revolut;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 27.12.2021
 */
public class RegisterProviders {

    public final ProviderDto[] providersArray = new ProviderDto[10];
    public final Set<String> providerAddress = new HashSet<>();
    public static final String ALREADY_CONTAINS = "Already contains";
    public static final String TOO_MUCH_PROVIDERS = "Too much providers";

    private int counter = 0;

    /**
     * Register provider
     */
    public void acceptProvider(ProviderDto providerDto) {
        synchronized (providersArray) {
            if (providerAddress.contains(providerDto.getAddress())) {
                throw new RuntimeException(ALREADY_CONTAINS);
            } else {
                if (counter >= 10) {
                    throw new RuntimeException(TOO_MUCH_PROVIDERS);
                }
                providerAddress.add(providerDto.getAddress());
                providersArray[counter++] = providerDto;
            }
        }
    }
}
