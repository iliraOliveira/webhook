/**
 * 
 */
package br.com.camel.webhook.entity;

import java.io.Serializable;

/**
 * @author ivan.oliveira
 *
 */
public class System implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String url;
	
	public System() {}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
