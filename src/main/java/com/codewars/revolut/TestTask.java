package com.codewars.revolut;

/**
 * @author Sergey Golitsyn
 * created on 08.04.2024
 *
 * implement library to simulate load balancer
 * production ready
 *
 * register instance
 * identify by adress
 */

/*
It should be possible to register an instance, identified by an address
Each address should be unique, it should not be possible to register the same address more than once
Load Balancer should accept up to 10 addresses

if register again --> throw error
if register more than 10 addresses --> throw err
---
1. LB lib -->
2. Distributed LB --> distributed storage (Redis)
3. Concurrent collections and locks --> CuncurrentMap or List --> lock by segment --> handle access from different threads

API --> registerAddress(String address, AddressType type) -->


Add method get --> return random instance

1. get with empty --> throw err
2. get with one result return result
3. random thread local --> (0, till size) --> get index --> move to method or service
  map<index, address> --> get element for O(1)

  if I need to remove

  --> Set + List
   --> add fast --> check duplicated elements

  -->


 */
public class TestTask {


}
