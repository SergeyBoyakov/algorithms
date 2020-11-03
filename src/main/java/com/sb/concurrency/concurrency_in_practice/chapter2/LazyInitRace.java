package com.sb.concurrency.concurrency_in_practice.chapter2;

/*
BAD PRACTICE
 */
public class LazyInitRace {
 private Object instance = null; // ExpensiveObject

 public Object getInstance() {
  if (instance == null) {
   instance = new Object();
  }

  return instance;
 }
}
