package com.example.customer;

/**
 * @author Jeremy Mefford
 * @since 7/12/16
 */
public interface CustomerService {
    /**
     * Returns the customer with the given ID
     *
     * @param id The customer id to look for
     * @return The customer object
     * @throws IllegalArgumentException if id < 1
     * @throws CustomerNotFoundException if customer not found
     */
    Customer get(long id);
}
