package org.crossnlp.api.model;

public class TextOwnerRepository {

	private String text;
	private String owner;
	private String repository;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getRepository() {
		return repository;
	}
	
	public void setRepository(String repository) {
		this.repository = repository;
	}
	
}
