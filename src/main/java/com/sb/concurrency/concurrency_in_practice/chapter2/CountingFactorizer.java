package com.sb.concurrency.concurrency_in_practice.chapter2;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

// @ThreadSafe
public class CountingFactorizer implements Servlet {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        excodeIntoResponse(servletResponse, factors);
    }

    private void excodeIntoResponse(ServletResponse servletResponse, BigInteger[] factors) {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    private BigInteger extractFromRequest(final ServletRequest request) {
        return new BigInteger("0");
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{};
    }
}


