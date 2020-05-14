package com.us.webfluxproducer.document;

import java.time.LocalDate;

import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * Created by adam.
 */
public class BaseRestDocumentContractTestClass {

	@BeforeEach
	void setup() {
		DocumentRepository repositoryMock = mock(DocumentRepository.class);
		Document document = new Document(123456789L, LocalDate.of(2020, 5, 3), Status.VALID);
		doReturn(document).when(repositoryMock).findById(document.getId());
		RestAssuredWebTestClient.standaloneSetup(new DocumentController(repositoryMock));
	}

}

