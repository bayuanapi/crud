package com.demo.crud.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentResponse {

	private String id;
	private String documentName;
	private String documentCode;
	private String createdDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;

}
