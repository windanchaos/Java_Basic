package com.chaosbom.repository;

import com.chaosbom.entity.Customer;
import com.chaosbom.entity.Student;

public interface CustomerRepository {
    public Customer findCusGoodsByID(int id);
}
