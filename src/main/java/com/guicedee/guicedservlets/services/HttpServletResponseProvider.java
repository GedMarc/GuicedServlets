package com.guicedee.guicedservlets.services;

import com.google.inject.Provider;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.services.mocks.MockRequest;
import com.guicedee.guicedservlets.services.mocks.MockResponse;
import com.guicedee.guicedservlets.services.scopes.CallScope;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CallScope
public class HttpServletResponseProvider implements Provider<HttpServletResponse> {

    @Override
    public HttpServletResponse get() {
        try {
            return GuiceContext.get(HttpServletResponse.class);
        } catch (Throwable T) {
            return new MockResponse();
        }
    }
}
