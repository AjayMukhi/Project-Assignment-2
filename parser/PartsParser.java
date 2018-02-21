package parser;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import models.DaoModel;

public class PartsParser {
	
	 
	public void partsParse() {
		
		String tableName="PARTS";
		DaoModel dao = new DaoModel();
		dao.createPartsTable(tableName);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File("parts.xml");
			Document xmlDoc = builder.parse(file);
			
			xmlDoc.getDocumentElement().normalize();
			System.out.println ("Root element of the doc is " + xmlDoc.getDocumentElement().getNodeName());
			
			NodeList listOfParts = xmlDoc.getElementsByTagName("part");
						
						
			
			for (int i = 0 ; i < listOfParts.getLength() ; i++) {
			    Node node = listOfParts.item(i);
			    List<String> values = Arrays.asList(getAttrValue(node, "id"),
			    		getTextContent(node, "name"),getTextContent(node, "category"),
			    		getTextContent(node, "model"),getTextContent(node, "price") ,
			    		getTextContent(node, "supplier-id"),getTextContent(node, "supplier-name") 
			    		);

			    for (int n = 0 ; n < values.size() ; n++) {
			    	System.out.println(values.get(n));
			    }				    
			    
			    dao.insertParts(values,tableName);		    
			  
			}
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}

	static private String getAttrValue(Node node,String attrName) {

	    if ( ! node.hasAttributes() ) 
	    	return "";
	    
	    NamedNodeMap nmap = node.getAttributes();
	    if ( nmap == null ) 
	    	return "";
	    
	    Node n = nmap.getNamedItem(attrName);
	    if ( n == null ) 
	    	return "";
	         
	    return n.getNodeValue();

	}

	static private String getTextContent(Node parentNode,String childName) {

	    NodeList nlist = parentNode.getChildNodes();
	    for (int i = 0 ; i < nlist.getLength() ; i++) {
	          Node n = nlist.item(i);
	          String name = n.getNodeName();	          
	          
	          if ( name != null && name.equals(childName) )
	              return n.getTextContent();
	          }

	    return "";

	}
		

	
}
