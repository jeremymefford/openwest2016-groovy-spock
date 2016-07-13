package com.example.customer

import com.example.IntegrationBootstrap
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity

/**
 * @author Jeremy Mefford
 * @since 7/13/16
 */
class CustomerControllerIT extends IntegrationBootstrap {

    def "simple success test"() {
        when:
        def customer = restTemplate.getForObject("$baseUrl/customer/1", Customer)

        then: "asset that the customer data is what was expected"
        with(customer) {
            firstName == "John"
            lastName == "Doe"
        }
    }

    def "it should honor the regex passed"() {
        when: "i call it with a non-digit regex"
        def response = restTemplate.exchange(
                new RequestEntity<Object>(HttpMethod.GET, URI.create("$baseUrl/customer/-1")),
                Customer)

        then: "it should throw the expected exception"
        response.statusCode.is4xxClientError()
    }

}
