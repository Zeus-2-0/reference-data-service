package com.brihaspathee.zeus.integration;

import com.brihaspathee.zeus.reference.data.model.XWalkRequest;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.brihaspathee.zeus.test.TestClass;
import com.brihaspathee.zeus.test.TestData;
import com.brihaspathee.zeus.test.TestMethod;
import com.brihaspathee.zeus.web.request.TestInternalRefDataRequest;
import com.brihaspathee.zeus.web.response.ApiException;
import com.brihaspathee.zeus.web.response.ApiExceptionList;
import com.brihaspathee.zeus.web.response.InternalRefDataResponse;
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

    @Value("classpath:com/brihaspathee/zeus/integration/InternalRefDataResourceIT.json")
    Resource resourceFile;

    private TestClass<TestInternalRefDataRequest> internalRefDataResourceTestClass;

    @BeforeEach
    void setUp() throws IOException {
        internalRefDataResourceTestClass = objectMapper.readValue(resourceFile.getFile(), new TypeReference<TestClass<TestInternalRefDataRequest>>() {});
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
        HttpEntity<XWalkRequest> httpEntity = new HttpEntity(testInternalRefDataRequest.getInternalRefDataRequest(), headers);
        InternalRefDataResponse expectedResponse = testInternalRefDataRequest.getExpectedResponse();
        if(!testInternalRefDataRequest.isExceptionExpected()){
            ResponseEntity<ZeusApiResponse> responseEntity = testRestTemplate.postForEntity("/api/v1/internal/refdata", httpEntity, ZeusApiResponse.class);
            ZeusApiResponse actualResponse = responseEntity.getBody();
            InternalRefDataResponse internalRefDataResponse = objectMapper.convertValue(actualResponse.getResponse(), InternalRefDataResponse.class);
            //InternalRefDataResponse internalRefDataResponse = (InternalRefDataResponse) actualResponse.getResponse();
            log.info("Actual Response:{}",actualResponse.getResponse());
            assertEquals(expectedResponse.isValid(), internalRefDataResponse.isValid());
            assertEquals(expectedResponse.getInternalListCode(), internalRefDataResponse.getInternalListCode());
        }else{
            ResponseEntity<ZeusApiResponse> responseEntity = testRestTemplate.postForEntity("/api/v1/internal/refdata", httpEntity, ZeusApiResponse.class);
            assertEquals(testInternalRefDataRequest.getHttpStatusCode(), responseEntity.getStatusCode().toString());
            ZeusApiResponse actualResponse = responseEntity.getBody();
            ApiExceptionList apiExceptionList = objectMapper.convertValue(actualResponse.getResponse(), ApiExceptionList.class);
            ApiException apiException = apiExceptionList.getExceptions().get(0);
            assertEquals(testInternalRefDataRequest.getExceptionCode(),apiException.getExceptionCode());
            assertEquals(testInternalRefDataRequest.getExceptionMessage(),apiException.getExceptionMessage());
        }
    }


    private List<TestInternalRefDataRequest> buildTestData(String methodName){
        log.info("Test Class:{}", internalRefDataResourceTestClass);
        TestMethod<TestInternalRefDataRequest> testMethod =
                internalRefDataResourceTestClass.getTestMethods().stream()
                        .filter(internalRefDataResourceTestMethod -> internalRefDataResourceTestMethod.getTestMethodName().equals(methodName))
                        .findFirst()
                        .get();
        log.info("Test Method:{}", testMethod);
        List<TestData<TestInternalRefDataRequest>> internalRefDataResourceTestData = testMethod.getTestData();
        List<TestInternalRefDataRequest> requests = new ArrayList<>();
        requests.addAll(internalRefDataResourceTestData.stream().map(testData -> testData.getTestData()).collect(Collectors.toList()));
        return requests;
    }
}
