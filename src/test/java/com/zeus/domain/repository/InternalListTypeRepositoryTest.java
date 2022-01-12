package com.zeus.domain.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeus.domain.entity.InternalListType;
import com.zeus.domain.entity.TestInternalListType;
import com.zeus.integration.InternalRefDataResourceTestClass;
import com.zeus.integration.InternalRefDataResourceTestData;
import com.zeus.integration.InternalRefDataResourceTestMethod;
import com.zeus.web.request.TestInternalRefDataRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 11, January 2022
 * Time: 9:24 AM
 * Project: Zeus
 * Package Name: com.zeus.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@DataJpaTest
@Slf4j
class InternalListTypeRepositoryTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    InternalListTypeRepository internalListTypeRepository;

    @Value("classpath:com/zeus/domain/repository/InternalListTypeRepositoryTest.json")
    Resource resourceFile;

    private InternalListTypeRepositoryTestClass internalListTypeRepositoryTestClass;

    @BeforeEach
    void setUp() throws IOException {

        internalListTypeRepositoryTestClass = objectMapper.readValue(resourceFile.getFile(), InternalListTypeRepositoryTestClass.class);
    }

    @Test
    void testFindInternalListTypeByInternalListTypeName() {
        List<TestInternalListType> requests = buildTestData("testFindInternalListTypeByInternalListTypeName");
        requests.stream().forEach(testInternalListType -> {
            Optional<InternalListType> optionalInternalListType =
                    internalListTypeRepository.findInternalListTypeByInternalListTypeName(testInternalListType.getInternalListTypeName());
            assertEquals(testInternalListType.isFound(),optionalInternalListType.isPresent());
        });

    }

    private List<TestInternalListType> buildTestData(String methodName){
        InternalListTypeRepositoryTestMethod testMethod =
                internalListTypeRepositoryTestClass.getTestMethods().stream()
                        .filter(internalListTypeRepositoryTestMethod -> internalListTypeRepositoryTestMethod.getTestMethodName().equals(methodName))
                        .findFirst()
                        .get();
        log.info("Test Method:{}", testMethod);
        List<InternalListTypeRepositoryTestData> internalListTypeRepositoryTestData = testMethod.getTestData();
        List<TestInternalListType> requests = new ArrayList<>();
        requests.addAll(internalListTypeRepositoryTestData.stream().map(testData -> testData.getTestInternalListType()).collect(Collectors.toList()));
        return requests;
    }
}