package com.example.customer

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author Jeremy Mefford
 * @since 7/12/16
 */
class CustomerControllerSpec extends Specification {

    // need to create our mock service here
    def mockService = Mock(CustomerService)

    def customerController = new CustomerController(
            customerService: mockService
    )

//    def setup() {
//
//    }

    def "it should return a customer given the correct id"() {
        given:
        mockService.get(1L) >> new Customer(firstName: "Jane", lastName: "doe")

        when:
        def customer = customerController.getCustomer(1L)

        then:
        customer.firstName == "Jane"
        customer.lastName == "doe"
    }

    @Unroll
    def "it should return a customer given the id"() {
        given:
        mockService.get(_ as Long) >> new Customer(
                firstName: "Jane", lastName: "doe"
        )

        when:
        def customer = customerController.getCustomer(id)

        then:
        customer.firstName == "Jane"
        customer.lastName == "doe"

        where:
        id << [1, 3, 5]
    }

    @Unroll
    def "it should call customer service only 1 time"() {
        when:
        def customer = customerController.getCustomer(1L)

        then:
        1 * mockService.get(_ as Long) >> new Customer(
                firstName: "Jane", lastName: "doe"
        )
        and:
        customer.firstName == "Jane"
        customer.lastName == "doe"
    }


}
