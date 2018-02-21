package parser;

/** Program to parse the Customer Order xml  and load the records for 
 *  order placed by customer  into the database
 *  Programmed by Ajay and Karan 
 *  for Project SOA -566
 */

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

public class CustomerOrderParser {
	
   public void  custOrder() {
	   
	   String tableName="CUSTOMERORDER";
	   DaoModel dao = new DaoModel();
	   dao.createCustomerOrderTable(tableName);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File("customerorder.xml");
			Document xmlDoc = builder.parse(file);
			
			xmlDoc.getDocumentElement().normalize();
			System.out.println ("Root element of the doc is " + xmlDoc.getDocumentElement().getNodeName());
			
			NodeList listOfcustOrder = xmlDoc.getElementsByTagName("order");
						
						
			
			for (int i = 0 ; i < listOfcustOrder.getLength() ; i++) {
			    Node node = listOfcustOrder.item(i);
			    List<String> values = Arrays.asList(getAttrValue(node, "id"),
			    		getTextContent(node, "item-name"),getTextContent(node, "item-id"),
			    		getTextContent(node, "quantity"),getTextContent(node, "price"),
			    		getTextContent(node, "customer-id"),getTextContent(node, "customer-name"),
			    		getTextContent(node, "phone"),getTextContent(node, "payment-type"),
			    		getTextContent(node, "payment-id"),getTextContent(node, "order-date"),
			    		getTextContent(node, "address"),getTextContent(node, "city"),
			    		getTextContent(node, "state"),getTextContent(node, "postalcode"),
			    		getTextContent(node, "country")			    		
			    		);

			    for (int n = 0 ; n < values.size() ; n++) {
			    	System.out.println(values.get(n));
			    }
			    
			    
			   dao.insertCustomerOrder(values,tableName);
			    
			  
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


