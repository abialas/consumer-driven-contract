package com.us.webfluxconsumer.document;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by adam.
 */
@Service
public class DocumentReader {

	private String documentServiceAddress;

	public DocumentReader(@Value("${documentService.address}") String documentServiceAddress) {
		this.documentServiceAddress = documentServiceAddress;
	}

	public Mono<Document> readDocument(Long documentId) {
		return WebClient.builder()
				.baseUrl(documentServiceAddress)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build()
				.get()
				.uri(uriBuilder -> uriBuilder.path("/documents/{id}").build(documentId))
				.retrieve()
				.bodyToMono(Document.class);
	}

}
