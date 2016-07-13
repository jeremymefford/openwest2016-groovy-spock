package com.example.customer;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Jeremy Mefford
 * @since 7/12/16
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
