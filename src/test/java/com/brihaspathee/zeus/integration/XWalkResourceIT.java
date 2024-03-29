package com.brihaspathee.zeus.integration;

import com.brihaspathee.zeus.reference.data.model.XWalkRequest;
import com.brihaspathee.zeus.reference.data.model.XWalkResponse;
import com.brihaspathee.zeus.web.response.ApiException;
import com.brihaspathee.zeus.web.response.ApiExceptionList;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.brihaspathee.zeus.test.TestClass;
import com.brihaspathee.zeus.test.TestData;
import com.brihaspathee.zeus.test.TestMethod;
import com.brihaspathee.zeus.web.request.TestXWalkRequest;
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

    @Value("classpath:com/brihaspathee/zeus/integration/XWalkResourceIT.json")
    Resource resourceFile;

    private TestClass<TestXWalkRequest> xWalkResourceITTestClass;

    @BeforeEach
    void setUp() throws IOException {
        xWalkResourceITTestClass = objectMapper.readValue(resourceFile.getFile(), new TypeReference<TestClass<TestXWalkRequest>>() {});
    }

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testGetInternalRefData(){
        List<TestXWalkRequest> requests = buildTestData("testGetInternalRefData");
        //log.info("TestClassDto:{}", testClassDto);
        log.info("Requests:{}", requests);
        requests.stream().forEach(xWalkRequest -> validateXWalk(xWalkRequest,"/api/v1/xwalk/internal"));

    }

    @Test
    void testGetExternalRefData(){
        List<TestXWalkRequest> requests = buildTestData("testGetExternalRefData");
        //log.info("TestClassDto:{}", testClassDto);
        log.info("Requests:{}", requests);
        requests.stream().forEach(xWalkRequest -> validateXWalk(xWalkRequest,"/api/v1/xwalk/external"));

    }

    private void validateXWalk(TestXWalkRequest testXWalkRequest, String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<XWalkRequest> httpEntity = new HttpEntity(testXWalkRequest.getCrossWalkRequest(), headers);
        log.info("Request:{}", testXWalkRequest.getCrossWalkRequest());
        XWalkResponse expectedResponse = testXWalkRequest.getExpectedXWalkResponse();
        if(!testXWalkRequest.isExceptionExpected()){
            ResponseEntity<ZeusApiResponse> responseEntity = testRestTemplate.postForEntity(url, httpEntity, ZeusApiResponse.class);
            ZeusApiResponse apiResponse = responseEntity.getBody();
            XWalkResponse xWalkResponse = objectMapper.convertValue(apiResponse.getResponse(), XWalkResponse.class);
            log.info("Response:{}", apiResponse);
            assertEquals(expectedResponse.getInternalListCode(), xWalkResponse.getInternalListCode());
        }else{
            ResponseEntity<ZeusApiResponse> responseEntity = testRestTemplate.postForEntity(url, httpEntity, ZeusApiResponse.class);
            ZeusApiResponse apiResponse = responseEntity.getBody();
            ApiExceptionList apiExceptionList = objectMapper.convertValue(apiResponse.getResponse(), ApiExceptionList.class);
            assertEquals(testXWalkRequest.getHttpStatusCode(), responseEntity.getStatusCode().toString());
            ApiException apiException = apiExceptionList.getExceptions().get(0);
            assertEquals(testXWalkRequest.getExceptionCode(),apiException.getExceptionCode());
            assertEquals(testXWalkRequest.getExceptionMessage(),apiException.getExceptionMessage());
        }
    }

    private List<TestXWalkRequest> buildTestData(String methodName){
        TestMethod<TestXWalkRequest> testMethod =
                xWalkResourceITTestClass.getTestMethods().stream()
                        .filter(XWalkResourceITTestMethod -> XWalkResourceITTestMethod.getTestMethodName().equals(methodName))
                        .findFirst()
                        .get();
        List<TestData<TestXWalkRequest>> XWalkResourceITTestData = testMethod.getTestData();
        List<TestXWalkRequest> requests = new ArrayList<>();
        requests.addAll(XWalkResourceITTestData.stream().map(testData -> testData.getTestData()).collect(Collectors.toList()));
        return requests;
    }


}
