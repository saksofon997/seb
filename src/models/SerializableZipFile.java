package models;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SerializableZipFile implements Serializable {

	  private ZipFile zf;

	  public SerializableZipFile(String filename) throws IOException {
	    this.zf = new ZipFile(filename);
	  }
	  
	  public SerializableZipFile(File file) throws IOException {
	    this.zf = new ZipFile(file);
	  }
	  
	  private void writeObject(ObjectOutputStream out) throws IOException {
	    out.writeObject(zf.getName());
	  }
	  
	  private void readObject(ObjectInputStream in) 
	   throws IOException, ClassNotFoundException {
	  
	    String filename = (String) in.readObject();
	    zf = new ZipFile(filename);
	  }

	  public ZipEntry getEntry(String name) {
	    return zf.getEntry(name);
	  }

	  public InputStream getInputStream(ZipEntry entry) throws IOException {
	    return zf.getInputStream(entry);
	  }
	  
	  public String getName() {
	    return zf.getName();
	  }

	  public Enumeration entries() {
	    return zf.entries();
	  }

	  public int size() {
	    return zf.size();
	  }

	  public void close() throws IOException {
	    zf.close();
	  }
}