/**
 * 
 */
package br.com.camel.webhook.entity;

import java.io.Serializable;

/**
 * @author ivan.oliveira
 *
 */
public class People implements Serializable{

	private static final long serialVersionUID = 1L;	
	private String name;
	
	public People() {}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

}
