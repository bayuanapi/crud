package com.demo.crud.model.request;

import lombok.Data;

@Data
public class DocumentRequest {

	private String id;
	private String documentName;
	private String documentCode;
	private String createdBy;
	
}
