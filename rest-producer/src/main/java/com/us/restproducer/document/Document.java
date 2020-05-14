package com.us.restproducer.document;

import java.time.LocalDate;

import lombok.Value;

/**
 * Created by adam.
 */
@Value
class Document {
	private Long id;
	private LocalDate created;
	private Status status;
}
