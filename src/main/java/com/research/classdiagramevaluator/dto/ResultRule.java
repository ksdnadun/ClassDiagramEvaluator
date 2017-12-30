package com.research.classdiagramevaluator.dto;

import org.springframework.stereotype.Component;

@Component
public class ResultRule {
	private String _message;

	public String get_message() {
		return _message;
	}

	public void set_message(String _message) {
		this._message = _message;
	}
}