package com.sb.concurrency.concurrency_in_practice.chapter2;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

// @ThreadSafe
// Cuz no innter stat (no properties, no links to other class properties)
//public class StatelessFactorizer implements Servlet {
//    public void service(ServletRequest req, ServletResponse resp) {
//        BigInteger i = extractFromRequest(req);
//        BigInteger[] factors = factor(i);
//        encodeIntoResponse(resp, factors);
//    }
//}