package com.example.customer

import spock.lang.Specification

/**
 * @author Jeremy Mefford
 * @since 7/13/16
 */
class CustomerServiceSpec extends Specification {

    // need to setup mock repo

    def customerService = new CustomerServiceImpl()

    def "it should return a customer given the correct id"() {


    }

    def "it should throw an IllegalArgumentException when customer id is < 1"() {

    }

}
