package fr.eni.jpa.jpa13criteriaspringgradle.exception;

import java.util.ArrayList;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException(String msg) {
		super(msg);
	}
}
