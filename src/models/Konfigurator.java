package models;

import java.io.Serializable;
import java.util.Properties;
import java.util.zip.ZipFile;

public class Konfigurator implements Serializable{

	private Properties properties;
	private String name;
	private String welcome;
	private String licence;
	private String version;
	
	private SerializableZipFile zipFile;
	
	public Konfigurator(Properties properties, String name, String welcome, String licence, String version, SerializableZipFile zipFile) {
		super();
		this.properties = properties;
		this.name = name;
		this.welcome = welcome;
		this.licence = licence;
		this.version = version;
		this.zipFile = zipFile;
	}
	
	
	public SerializableZipFile getZipFile() {
		return zipFile;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setZipFile(SerializableZipFile zipFile) {
		this.zipFile = zipFile;
	}


	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
