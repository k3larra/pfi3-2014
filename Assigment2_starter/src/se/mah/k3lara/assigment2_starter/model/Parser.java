package se.mah.k3lara.assigment2_starter.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;
import android.util.Xml;

public class Parser {
	    
	public static List<ItemInSafe> getSavedSafeItemsFromLocalStorage(File file){
		List<ItemInSafe> foundItems = new ArrayList<ItemInSafe>();
		String company;
		String loginId;
		String password;
		 XMLParser parser = new XMLParser();
		 String xml = readFile(file);
	     if (xml!=null){
				Document doc = parser.getDomElement(xml); // getting DOM element
				NodeList nl = doc.getElementsByTagName("Item");
				for (int i = 0; i < nl.getLength(); i++) {
					Element e = (Element) nl.item(i);
					company  = parser.getValue(e,"Company");
					loginId = parser.getValue(e,"LoginId");
					password = parser.getValue(e, "Password");
					ItemInSafe itemForSafe = new ItemInSafe(company);
					itemForSafe.setLoginID(loginId);
					itemForSafe.setPassword(password);
					foundItems.add(itemForSafe);
	    	 }
	     }
	     //Log.i("PassSafe","Items read:"+foundItems.size());
		return foundItems;
	}
	
	
	/**
	 * Getting XML from file in localStorage
	 * @param url string
	 * */
	public static String readFile(File file) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try{
			InputStream  inputStream = new FileInputStream(file);
		    int i = inputStream.read();
		    while (i != -1)
		    {
		        byteArrayOutputStream.write(i);
		        i = inputStream.read();
		    }
		    inputStream.close();
		} catch (Exception e) {} 
	    return byteArrayOutputStream.toString();
	}
	
	
	public static String serializeAsXml(List<ItemInSafe> itemsForSafe){
	    XmlSerializer serializer = Xml.newSerializer();
	    StringWriter writer = new StringWriter();
	    try {
	        serializer.setOutput(writer);
	        serializer.startDocument("UTF-8", true);
	        serializer.startTag("", "SafeItem");
	        for (ItemInSafe itemForSafe: itemsForSafe){
	        	serializer.startTag("", "Item");
	            serializer.startTag("", "Company");
	            serializer.text(itemForSafe.getCompany());
	            serializer.endTag("", "Company");
	            serializer.startTag("", "LoginId");
	            serializer.text(itemForSafe.getLoginID());
	            serializer.endTag("", "LoginId");
	            serializer.startTag("", "Password");
	            serializer.text(itemForSafe.getPassword());
	            serializer.endTag("", "Password");
	            serializer.endTag("", "Item");
	        }
	        serializer.endTag("", "SafeItem");
	        serializer.endDocument();
	        return writer.toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    } 
	}
}
