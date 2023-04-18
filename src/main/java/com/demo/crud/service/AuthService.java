package com.demo.crud.service;

import com.demo.crud.model.request.JwtRequest;
import com.demo.crud.model.response.BaseResponse;

public interface AuthService {

	BaseResponse auth(JwtRequest request) throws Exception;

}
