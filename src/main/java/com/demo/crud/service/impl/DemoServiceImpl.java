package com.demo.crud.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crud.model.entity.Document;
import com.demo.crud.model.request.DocumentRequest;
import com.demo.crud.model.response.BaseResponse;
import com.demo.crud.model.response.DocumentResponse;
import com.demo.crud.repository.DocumentRepository;
import com.demo.crud.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public BaseResponse createDocument(DocumentRequest request) {
		Document document = Document.builder().documentName(request.getDocumentName())
				.documentCode(request.getDocumentCode()).createdDate(new Date()).createdBy(request.getCreatedBy())
				.build();
		documentRepository.save(document);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("documentId", document.getId());
		return BaseResponse.createSuccessResponse(response);
	}

	@Override
	public BaseResponse findDocument(String id) {
		Document document = documentRepository.findById(id).orElse(null);
		if (Objects.isNull(document)) {
			return BaseResponse.createFailedResponse(1, "Data Not Found");
		}
		return BaseResponse.createSuccessResponse(generateResponse(document));
	}

	private DocumentResponse generateResponse(Document document) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm");
		return DocumentResponse.builder().id(document.getId()).documentName(document.getDocumentName())
				.documentCode(document.getDocumentCode()).createdBy(document.getCreatedBy())
				.createdDate(Objects.nonNull(document.getCreatedDate()) ? sdf.format(document.getCreatedDate()) : null)
				.modifiedBy(document.getModifiedBy())
				.modifiedDate(
						Objects.nonNull(document.getModifiedDate()) ? sdf.format(document.getModifiedDate()) : null)
				.build();
	}

	@Override
	public BaseResponse findAllDocument() {
		List<Document> listDocument = documentRepository.findAll();
		List<DocumentResponse> response = new ArrayList<DocumentResponse>();
		listDocument.forEach(p -> response.add(generateResponse(p)));
		return BaseResponse.createSuccessResponse(response);
	}

	@Override
	public BaseResponse deleteDoc(String id) {
		try {
			documentRepository.deleteById(id);
		} catch (Exception e) {
			return BaseResponse.createFailedResponse(1, "Data not found");
		}

		return BaseResponse.createSuccessResponse();
	}

	@Override
	public BaseResponse editDocument(DocumentRequest request) {
		Document document = documentRepository.findById(request.getId()).orElse(null);
		if(Objects.isNull(document)) {
			return BaseResponse.createFailedResponse(1, "Data not found");
		}
		document.setDocumentCode(request.getDocumentCode());
		document.setDocumentName(request.getDocumentName());
		document.setModifiedBy(request.getCreatedBy());
		document.setModifiedDate(new Date());
		documentRepository.save(document);
		return BaseResponse.createSuccessResponse();
	}

}
