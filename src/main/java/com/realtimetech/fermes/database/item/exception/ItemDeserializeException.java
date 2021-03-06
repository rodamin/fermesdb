package com.realtimetech.fermes.database.item.exception;

import com.realtimetech.fermes.exception.FermesException;

public class ItemDeserializeException extends FermesException {
	private static final long serialVersionUID = 7019046866027384876L;

	public ItemDeserializeException(Exception reasonException, String message) {
		super(reasonException, message);
	}

	public ItemDeserializeException(String message) {
		super(message);
	}
}
