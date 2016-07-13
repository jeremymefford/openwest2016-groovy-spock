package com.example

import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 * @author Jeremy Mefford
 * @since 7/13/16
 */
@ContextConfiguration(loader = SpringApplicationContextLoader, classes = DemoApplication)
@WebIntegrationTest(value = ["server.port=0", "management.port=0"], randomPort = true)
class IntegrationBootstrap extends Specification {
    @Value('${server.contextPath}')
    String contextPath

    @Value('${local.server.port}')
    int port

    def getBaseUrl() {
        "http://127.0.0.1:$port/${StringUtils.removeEnd(contextPath, '/')}"
    }

    RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory())

    def setup() {
        restTemplate.setErrorHandler(new ResponseErrorHandler() {

            @Override
            boolean hasError(ClientHttpResponse response) throws IOException {
                return response.statusCode.is4xxClientError() || response.statusCode.is5xxServerError();
            }

            @Override
            void handleError(ClientHttpResponse response) throws IOException {

            }
        })
    }


}
