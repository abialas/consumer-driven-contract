package contracts

import org.springframework.cloud.contract.spec.Contract

	Contract.make {
		description("should send message with validated document")
		label("triggerDocumentSend")
		input {
			triggeredBy("triggerDocumentValidatedMessage()")
		}
		outputMessage {
			sentTo("documentValidated")
			body([
					id  : 123456789,
					status: "VALID"
			])
			headers {
				contentType(applicationJson())
			}
		}
	}

