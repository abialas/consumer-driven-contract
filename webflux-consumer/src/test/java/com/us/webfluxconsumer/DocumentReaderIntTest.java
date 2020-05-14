package com.us.webfluxconsumer;

import com.us.webfluxconsumer.document.DocumentReader;
import com.us.webfluxconsumer.document.DocumentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

/**
 * Created by adam.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.us:webflux-producer:+:stubs:8080")
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

		// expect
		StepVerifier.create(documentReader.readDocument(documentId))
				.expectNextMatches(document ->
						document.getDocumentId().equals(documentId)
								&& document.getDocumentStatus() == DocumentStatus.VALID
								&& document.getCreated() == null)
				.expectComplete();
	}

}
