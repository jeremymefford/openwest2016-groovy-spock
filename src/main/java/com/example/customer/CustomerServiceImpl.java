package com.example.customer;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.NonUniqueResultException;

/**
 * @author Jeremy Mefford
 * @since 7/12/16
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    @Override
    public Customer get(long id) {
        if (id < 1) {
            throw new IllegalArgumentException("Id must be 1 or greater");
        }
        try {
            return customerRepository.findOne(id);
        } catch (NonUniqueResultException e) {
            throw new CustomerNotFoundException();
        }
    }
}
