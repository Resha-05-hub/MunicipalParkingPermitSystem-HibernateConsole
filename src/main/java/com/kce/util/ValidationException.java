package com.kce.util;

public class ValidationException extends Exception {
	@Override
	public String toString() {
		return "Validation Error: Invalid input provided.";
	}
}