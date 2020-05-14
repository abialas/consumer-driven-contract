package com.us.messageproducer.document;

import com.us.messageproducer.DocumentBindings;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by adam.
 */
@Component
class DocumentMessageSender {

	private DocumentRepository repository;
	private DocumentBindings documentBindings;

	DocumentMessageSender(DocumentRepository repository, DocumentBindings documentBindings) {
		this.repository = repository;
		this.documentBindings = documentBindings;
	}

	void sendValidationResult(Long documentId) {
		documentBindings.documentValidation().send(
				MessageBuilder.withPayload(repository.findById(documentId))
						.setHeader("Content-Type", "application/json")
						.build()
		);
	}
}
