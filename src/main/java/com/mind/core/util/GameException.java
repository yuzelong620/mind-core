package com.mind.core.util;

/**
 * 游戏异常
 * @author ninglong
 */
public class GameException extends Exception {

	private static final long serialVersionUID = 3452018497153091914L;

	public GameException() {
		super();
	}

	public GameException(String message, Throwable cause) {
		super(message, cause);
	}

	public GameException(String message) {
		super(message);
	}

	public GameException(Throwable cause) {
		super(cause);
	}

}
