package com.demo.crud.service;

import com.demo.crud.model.request.DocumentRequest;
import com.demo.crud.model.response.BaseResponse;

public interface DemoService {

	BaseResponse createDocument(DocumentRequest request);

	BaseResponse findDocument(String id);

	BaseResponse findAllDocument();

	BaseResponse deleteDoc(String id);

	BaseResponse editDocument(DocumentRequest request);

}
