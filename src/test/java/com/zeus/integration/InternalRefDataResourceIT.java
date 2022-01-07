package com.zeus.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeus.web.request.InternalXWalkRequest;
import com.zeus.web.request.TestInternalRefDataRequest;
import com.zeus.web.response.ApiException;
import com.zeus.web.response.ApiExceptionList;
import com.zeus.web.response.InternalRefDataResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 07, January 2022
 * Time: 1:42 PM
 * Project: Zeus
 * Package Name: com.zeus.integration
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InternalRefDataResourceIT {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("classpath:com/zeus/integration/InternalRefDataResourceIT.json")
    Resource resourceFile;

    private InternalRefDataResourceTestClass internalRefDataResourceTestClass;

    @BeforeEach
    void setUp() throws IOException {
        internalRefDataResourceTestClass = objectMapper.readValue(resourceFile.getFile(), InternalRefDataResourceTestClass.class);
    }

    @Test
    void testValidateRefData(){
        List<TestInternalRefDataRequest> requests = buildTestData("testValidateRefData");
        log.info("Requests:{}", requests);
        requests.stream().forEach(testInternalRefDataRequest -> validateRefDataRequest(testInternalRefDataRequest));

    }

    private void validateRefDataRequest(TestInternalRefDataRequest testInternalRefDataRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<InternalXWalkRequest> httpEntity = new HttpEntity(testInternalRefDataRequest.getInternalRefDataRequest(), headers);
        InternalRefDataResponse expectedResponse = testInternalRefDataRequest.getExpectedResponse();
        if(!testInternalRefDataRequest.isExceptionExpected()){
            ResponseEntity<InternalRefDataResponse> responseEntity = testRestTemplate.postForEntity("/api/v1/internal/refdata", httpEntity, InternalRefDataResponse.class);
            InternalRefDataResponse actualResponse = responseEntity.getBody();
            //log.info("Actual Response:{}",actualResponse);
            assertEquals(expectedResponse.isValid(), actualResponse.isValid());
            assertEquals(expectedResponse.getInternalListCode(), actualResponse.getInternalListCode());
        }else{
            ResponseEntity<ApiExceptionList> responseEntity = testRestTemplate.postForEntity("/api/v1/internal/refdata", httpEntity, ApiExceptionList.class);
            assertEquals(testInternalRefDataRequest.getHttpStatusCode(), responseEntity.getStatusCode().toString());
            ApiExceptionList apiExceptionList = responseEntity.getBody();
            ApiException apiException = apiExceptionList.getExceptions().get(0);
            assertEquals(testInternalRefDataRequest.getExceptionCode(),apiException.getExceptionCode());
            assertEquals(testInternalRefDataRequest.getExceptionMessage(),apiException.getExceptionMessage());
        }
    }


    private List<TestInternalRefDataRequest> buildTestData(String methodName){
        InternalRefDataResourceTestMethod testMethod =
                internalRefDataResourceTestClass.getTestMethods().stream()
                        .filter(internalRefDataResourceTestMethod -> internalRefDataResourceTestMethod.getTestMethodName().equals(methodName))
                        .findFirst()
                        .get();
        log.info("Test Method:{}", testMethod);
        List<InternalRefDataResourceTestData> internalRefDataResourceTestData = testMethod.getTestData();
        List<TestInternalRefDataRequest> requests = new ArrayList<>();
        requests.addAll(internalRefDataResourceTestData.stream().map(testData -> testData.getTestInternalRefDataRequest()).collect(Collectors.toList()));
        return requests;
    }
}
