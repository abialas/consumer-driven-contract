package com.us.messageproducer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by adam.
 */
public interface DocumentBindings {

	@Output("documentValidation")
	MessageChannel documentValidation();

}
