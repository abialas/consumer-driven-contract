package com.us.messageconsumer.document;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

/**
 * Created by adam.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.us:message-producer:+:stubs")
class DocumentReaderIntTest {

	@SpyBean
	private DocumentValidatedListener documentValidatedListener;

	@Captor
	private ArgumentCaptor<Document> captorReceivedDocument;

	@Autowired
	private StubTrigger stubTrigger;

	@Test
	void shouldReadMessageFromDocumentService() {
		// when
		stubTrigger.trigger("triggerDocumentSend");

		// then
		verify(documentValidatedListener).receiveValidationResult(captorReceivedDocument.capture());
		Document receivedDocument = captorReceivedDocument.getValue();
		assertThat(receivedDocument.getId()).isEqualTo(123456789L);
		assertThat(receivedDocument.getStatus()).isEqualTo(Status.VALID);
		assertThat(receivedDocument.getCreated()).isNull();
	}

}
