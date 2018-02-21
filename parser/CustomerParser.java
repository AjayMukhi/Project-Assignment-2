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

public class CustomerParser {
	
   public void custParse() {
	   
	       String tableName="CUSTOMER";
	        DaoModel dao = new DaoModel();
	 		dao.createCustomerTable(tableName);
	 		
	 		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	 		try {
	 			
	 			DocumentBuilder builder = factory.newDocumentBuilder();
	 			File file = new File("customer.xml");
	 			Document xmlDoc = builder.parse(file);
	 			
	 			xmlDoc.getDocumentElement().normalize();
	 			System.out.println ("Root element of the doc is " + xmlDoc.getDocumentElement().getNodeName());
	 			
	 			NodeList listOfConsumer = xmlDoc.getElementsByTagName("customer");						
	 						
	 			
	 			for (int i = 0 ; i < listOfConsumer.getLength() ; i++) {
	 			    
	 				Node node = listOfConsumer.item(i);
	 			    List<String> values = Arrays.asList(getAttrValue(node, "id"),
	 			    		getTextContent(node, "name"),getTextContent(node, "address1"),
	 			    		getTextContent(node, "address2"),getTextContent(node, "city"),
	 			    		getTextContent(node, "zipcode"),getTextContent(node, "state"),
	 			    		getTextContent(node, "country"),getTextContent(node, "email"),
	 			    		getTextContent(node, "phone-number")  );

	 			    for (int n = 0 ; n < values.size() ; n++) {
	 			    	System.out.println(values.get(n));
	 			    }
	 			    			    
	 			    dao.insertCustomer(values,tableName);			    
	 			  
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
