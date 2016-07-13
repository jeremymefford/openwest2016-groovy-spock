package com.example.customer

import com.example.IntegrationBootstrap

/**
 * @author Jeremy Mefford
 * @since 7/13/16
 */
class CustomerControllerIT extends IntegrationBootstrap {

    def "simple success test"() {
        when:
        def customer = restTemplate.getForObject("$baseUrl/customer/1", Customer)

        then: "asset that the customer data is what was expected"
        true
    }

    def "it should honor the regex passed"() {
        when: "i call it with a non-digit regex"

        then: "it should throw the expected exception"
    }

}
