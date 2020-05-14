package com.us.restconsumer;

import com.us.restconsumer.document.Document;
import com.us.restconsumer.document.DocumentReader;
import com.us.restconsumer.document.DocumentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by adam.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
		stubsMode = StubRunnerProperties.StubsMode.LOCAL,
		ids = "com.us:rest-producer:+:stubs:8080"
)
class DocumentReaderIntTest {

	private DocumentReader documentReader;

	@BeforeEach
	void setup() {
		documentReader = new DocumentReader("http://localhost:8080");
	}

	@Test
	void shouldReadMessageFromDocumentService() {
		// given
		long documentId = 123456789L;

		// when
		Document document = documentReader.readDocument(documentId);

		// then
		assertThat(document.getCreated()).isNull();
		assertThat(document.getDocumentId()).isEqualTo(documentId);
		assertThat(document.getDocumentStatus()).isEqualTo(DocumentStatus.VALID);
	}

}
