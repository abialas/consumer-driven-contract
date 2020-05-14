package com.us.webfluxconsumer.document;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 * Created by adam.
 */
@Value
public class Document {
	private Long documentId;
	private LocalDate created;
	private DocumentStatus documentStatus;

	Document(@JsonProperty("id") Long documentId, @JsonProperty("created") LocalDate created, @JsonProperty("status") DocumentStatus documentStatus) {
		this.documentId = documentId;
		this.created = created;
		this.documentStatus = documentStatus;
	}
}
