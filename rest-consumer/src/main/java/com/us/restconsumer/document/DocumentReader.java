package com.us.restconsumer.document;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

/**
 * Created by adam.
 */
@Service
public class DocumentReader {

	private String documentServiceAddress;

	public DocumentReader(@Value("${documentService.address}") String documentServiceAddress) {
		this.documentServiceAddress = documentServiceAddress;
	}

	public Document readDocument(Long documentId) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Document> requestEntity = new HttpEntity<>(null, httpHeaders);

		return new RestTemplate().exchange(
				this.documentServiceAddress + "/documents/" + documentId,
				HttpMethod.GET,
				requestEntity,
				Document.class
		).getBody();
	}

}
