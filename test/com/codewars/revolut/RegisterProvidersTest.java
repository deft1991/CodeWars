package com.codewars.revolut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegisterProvidersTest {

    @Test
    void acceptTestOneProvider() {

        // given
        RegisterProviders registerProviders = new RegisterProviders();

        ProviderDto providerDto = new ProviderDto("1");

        // when
        registerProviders.acceptProvider(providerDto);

        // then
        assertTrue(registerProviders.providerAddress.contains("1"));
        assertEquals(registerProviders.providersArray[0].getAddress(), "1");
    }


    @Test
    void acceptTestTen() {

        // given
        RegisterProviders registerProviders = new RegisterProviders();

        for (int i = 0; i < 10; i++) {
            ProviderDto providerDto = new ProviderDto(String.valueOf(i));
            // when
            registerProviders.acceptProvider(providerDto);
        }

        // then
        for (int i = 0; i < 10; i++) {
            assertTrue(registerProviders.providerAddress.contains(String.valueOf(i)));
            assertEquals(registerProviders.providersArray[i].getAddress(), String.valueOf(i));
        }

    }

    @Test
    void acceptTestMoreThenTen() {

        // given
        RegisterProviders registerProviders = new RegisterProviders();

        for (int i = 0; i < 10; i++) {
            ProviderDto providerDto = new ProviderDto(String.valueOf(i));
            // when
            registerProviders.acceptProvider(providerDto);
        }

        // then
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> registerProviders.acceptProvider(new ProviderDto("11")));
        assertEquals(runtimeException.getLocalizedMessage(), RegisterProviders.TOO_MUCH_PROVIDERS);
    }


    @Test
    void acceptTestNotUnic() {

        // given
        RegisterProviders registerProviders = new RegisterProviders();

        ProviderDto providerDto = new ProviderDto("1");
        registerProviders.acceptProvider(providerDto);
        // then
        RuntimeException runtimeException =
                assertThrows(RuntimeException.class, () -> registerProviders.acceptProvider(providerDto));
        assertEquals(runtimeException.getLocalizedMessage(), RegisterProviders.ALREADY_CONTAINS);
    }
}
