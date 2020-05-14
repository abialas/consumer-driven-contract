package com.us.messageconsumer.document;

import com.us.messageconsumer.DocumentBindings;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by adam.
 */
@Slf4j
@Component
class DocumentValidatedListener {

	@StreamListener(DocumentBindings.DOCUMENT_VALIDATION)
	void receiveValidationResult(Document validatedDocument) {
		log.info("Received validated document: {}", validatedDocument);
	}
}
