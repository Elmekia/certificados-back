package com.flair.gcf.response;

public class ControllerResponse {

	private boolean hasError = false;
	private String stacktrace;
	private String message;
	private Object response;

	public ControllerResponse() {

	}

	public ControllerResponse(boolean hasError, String message) {
		this.hasError = hasError;
		this.message = message;
	}

	public ControllerResponse(boolean hasError, Object response) {
		this.hasError = hasError;
		this.response = response;
	}

	public ControllerResponse(boolean hasError, String message, String stacktrace) {
		this.hasError = hasError;
		this.message = message;
		this.stacktrace = stacktrace;
	}

	public ControllerResponse(boolean hasError) {
		this.hasError = hasError;
	}

	public ControllerResponse(Object response) {
		this.response = response;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}
}

