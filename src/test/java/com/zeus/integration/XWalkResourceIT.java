package com.zeus.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeus.web.request.InternalXWalkRequest;
import com.zeus.web.request.TestInternalXWalkRequest;
import com.zeus.web.response.ApiException;
import com.zeus.web.response.ApiExceptionList;
import com.zeus.web.response.XWalkResponse;
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
 * Date: 05, January 2022
 * Time: 3:42 PM
 * Project: Zeus
 * Package Name: com.zeus.integration
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XWalkResourceIT {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("classpath:com/zeus/integration/XWalkResourceIT.json")
    Resource resourceFile;

    private XWalkResourceITTestClass xWalkResourceITTestClass;

    @BeforeEach
    void setUp() throws IOException {
        xWalkResourceITTestClass = objectMapper.readValue(resourceFile.getFile(), XWalkResourceITTestClass.class);
    }

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testGetInternalRefData(){
        List<TestInternalXWalkRequest> requests = buildTestData("testGetInternalRefData");
        //log.info("TestClassDto:{}", testClassDto);
        log.info("Requests:{}", requests);
        requests.stream().forEach(testInternalXWalkRequest -> validateInternalXWalk(testInternalXWalkRequest));

    }

    private void validateInternalXWalk(TestInternalXWalkRequest testInternalXWalkRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<InternalXWalkRequest> httpEntity = new HttpEntity<>(testInternalXWalkRequest.getInternalXWalkRequest(), headers);

        XWalkResponse expectedResponse = testInternalXWalkRequest.getExpectedXWalkResponse();
        if(!testInternalXWalkRequest.isExceptionExpected()){
            ResponseEntity<XWalkResponse> responseEntity = testRestTemplate.postForEntity("/api/v1/xwalk/internal", httpEntity, XWalkResponse.class);
            XWalkResponse xWalkResponse = responseEntity.getBody();
            assertEquals(expectedResponse.getInternalListCode(), xWalkResponse.getInternalListCode());
        }else{
            ResponseEntity<ApiExceptionList> responseEntity = testRestTemplate.postForEntity("/api/v1/xwalk/internal", httpEntity, ApiExceptionList.class);
            assertEquals(testInternalXWalkRequest.getHttpStatusCode(), responseEntity.getStatusCode().toString());
            ApiExceptionList apiExceptionList = responseEntity.getBody();
            ApiException apiException = apiExceptionList.getExceptions().get(0);
            assertEquals(testInternalXWalkRequest.getExceptionCode(),apiException.getExceptionCode());
            assertEquals(testInternalXWalkRequest.getExceptionMessage(),apiException.getExceptionMessage());
        }
    }

    private List<TestInternalXWalkRequest> buildTestData(String methodName){
        XWalkResourceITTestMethod testMethod =
                xWalkResourceITTestClass.getTestMethods().stream()
                        .filter(XWalkResourceITTestMethod -> XWalkResourceITTestMethod.getTestMethodName().equals(methodName))
                        .findFirst()
                        .get();
        List<XWalkResourceITTestData> XWalkResourceITTestData = testMethod.getTestData();
        List<TestInternalXWalkRequest> requests = new ArrayList<>();
        requests.addAll(XWalkResourceITTestData.stream().map(testData -> testData.getTestInternalXWalkRequest()).collect(Collectors.toList()));
        return requests;
    }


}
