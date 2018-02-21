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

public class PaymentDetailsParser {
	
public void paymentParse() {
		
		String tableName="PAYMENTDETAILS";
		DaoModel dao = new DaoModel();
		dao.createPaymentDetailTable(tableName);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File("paymentDetails.xml");
			Document xmlDoc = builder.parse(file);
			
			xmlDoc.getDocumentElement().normalize();
			System.out.println ("Root element of the doc is " + xmlDoc.getDocumentElement().getNodeName());
			
			NodeList listOfParts = xmlDoc.getElementsByTagName("payment");
						
						
			
			for (int i = 0 ; i < listOfParts.getLength() ; i++) {
			    Node node = listOfParts.item(i);
			    List<String> values = Arrays.asList(getAttrValue(node, "id"),
			    		getTextContent(node, "payment-type"),getTextContent(node, "card-number"),
			    		getTextContent(node, "card-type"),getTextContent(node, "amount") ,
			    		getTextContent(node, "payment-date"),getTextContent(node, "billing-address"),
			    		getTextContent(node, "city"),getTextContent(node, "state"),
			    		getTextContent(node, "postalcode"),getTextContent(node, "country")
			    		);

			    for (int n = 0 ; n < values.size() ; n++) {
			    	System.out.println(values.get(n));
			    }				    
			    
			    dao.insertPaymentDetails(values,tableName);		    
			  
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
