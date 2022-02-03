package com.brihaspathee.zeus.domain.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.brihaspathee.zeus.domain.entity.InternalListType;
import com.brihaspathee.zeus.domain.entity.TestInternalListType;
import com.brihaspathee.zeus.test.TestClass;
import com.brihaspathee.zeus.test.TestData;
import com.brihaspathee.zeus.test.TestMethod;
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

    @Value("classpath:com/brihaspathee/zeus/domain/repository/InternalListTypeRepositoryTest.json")
    Resource resourceFile;

    private TestClass<TestInternalListType> internalListTypeRepositoryTestClass;

    @BeforeEach
    void setUp() throws IOException {

        internalListTypeRepositoryTestClass = objectMapper.readValue(resourceFile.getFile(), new TypeReference<TestClass<TestInternalListType>>() {});
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
        TestMethod<TestInternalListType> testMethod =
                internalListTypeRepositoryTestClass.getTestMethods().stream()
                        .filter(internalListTypeRepositoryTestMethod -> internalListTypeRepositoryTestMethod.getTestMethodName().equals(methodName))
                        .findFirst()
                        .get();
        log.info("Test Method:{}", testMethod);
        List<TestData<TestInternalListType>> internalListTypeRepositoryTestData = testMethod.getTestData();
        List<TestInternalListType> requests = new ArrayList<>();
        requests.addAll(internalListTypeRepositoryTestData.stream().map(testData -> testData.getTestData()).collect(Collectors.toList()));
        return requests;
    }
}