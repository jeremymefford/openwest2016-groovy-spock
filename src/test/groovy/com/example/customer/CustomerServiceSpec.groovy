package com.example.customer

import spock.lang.Specification

/**
 * @author Jeremy Mefford
 * @since 7/13/16
 */
class CustomerServiceSpec extends Specification {

    def mockRepo = Mock(CustomerRepository)

    def customerService = new CustomerServiceImpl(
            customerRepository: mockRepo
    )

    def "it should return a customer given the correct id"() {
        given:
        def id = 1L

        when:
        def customer = customerService.get(id)

        then:
        1 * mockRepo.findOne(id) >> new Customer(firstName: "John", lastName: "Doe")
        with(customer) {
            firstName == "John"
            lastName == "Doe"
        }
    }

    def "it should throw an IllegalArgumentException when customer id is < 1"() {
        given:
        def id = -1L

        when:
        customerService.get(id)

        then:
        def ex = thrown(IllegalArgumentException)
        ex.message == "Id must be 1 or greater"
    }

    def "it should throw CustomerNotFoundException when customer is not found"() {
        given:
        def id = 1L

        when:
        def customer1 = customerService.get(id)
        def customer2 = customerService.get(id)

        then:
        2 * mockRepo.findOne(id) >>> [new Customer(firstName: "John", lastName: "Doe")]
        with(customer1) {
            firstName == "John"
            lastName == "Doe"
        }
        thrown(CustomerNotFoundException)
    }

}
