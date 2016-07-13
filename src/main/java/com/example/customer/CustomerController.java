package com.example.customer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Jeremy Mefford
 * @since 7/12/16
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("/{id:[\\d+]}")
    public Customer getCustomer(@PathVariable("id") long id) {
        return customerService.get(id);
    }
}
