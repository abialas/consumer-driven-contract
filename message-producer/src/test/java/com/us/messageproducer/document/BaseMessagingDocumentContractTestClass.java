package com.us.messageproducer.document;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * Created by adam.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
public class BaseMessagingDocumentContractTestClass {

    public static final long DOCUMENT_ID = 123456789L;

    @Autowired
    private DocumentMessageSender documentMessageSender;

    void triggerDocumentValidatedMessage() {
        documentMessageSender.sendValidationResult(DOCUMENT_ID);
    }

    @Configuration
    static class TestConfig {

        @Bean
        @Primary
        DocumentRepository documentRepositoryMock() {
            DocumentRepository documentRepository = mock(DocumentRepository.class);
            Document document = new Document(DOCUMENT_ID, LocalDate.of(2020, 5, 3), Status.VALID);
            doReturn(document).when(documentRepository).findById(document.getId());
            return documentRepository;
        }

    }

}
