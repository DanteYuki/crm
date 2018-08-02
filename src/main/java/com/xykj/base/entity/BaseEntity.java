package com.xykj.base.entity;

public class BaseEntity {
	private String keyWord;
	private String token;

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getKeyWord() {
		return this.keyWord;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "BaseEntity [keyWord=" + keyWord + ", token=" + token + "]";
	}
	
	
}
