package com.spring.mvc.SpringMVCDemo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Response {

	@JsonInclude(Include.NON_NULL)
	private String success;
	@JsonInclude(Include.NON_NULL)
	private String accountIdentifier;
	@JsonInclude(Include.NON_NULL)
	private String errorCode;
	@JsonInclude(Include.NON_NULL)
	private String message;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
