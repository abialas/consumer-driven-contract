package com.us.messageconsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by adam.
 */
public interface DocumentBindings {

	String DOCUMENT_VALIDATION = "documentValidation";

	@Input(DOCUMENT_VALIDATION)
	SubscribableChannel documentValidation();

}
