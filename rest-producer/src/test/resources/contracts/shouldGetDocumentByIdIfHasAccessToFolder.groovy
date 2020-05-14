package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	request {
		method 'GET'
		url '/documents/123456789'
		headers {
			contentType('application/json')
		}
	}
	response {
		status OK()
		body([
			   id  : 123456789,
			   status: "VALID"
		])
		headers {
			contentType('application/json')
		}
	}
}