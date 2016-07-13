package com.example.customer;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        return customerRepository.findOne(id);
    }
}
