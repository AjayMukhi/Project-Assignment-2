package parser;

/** Program to call all parsers and from Main file which run all the xml and load the records into the database
 *  Programmed by Ajay and Karan 
 *  for Project SOA -566
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainParser {
	
	public static void main(String args[]) {
		
		
		//calling the SupplierParse method to parse the Supplier xml and load the data into database
		SupplierParser sparse = new SupplierParser();
		sparse.supplParse();
		
		System.out.println("--------------------------------------------------------------------------");
		
		
		//calling the ConsumerParse method to parse the User xml and load the data into database
		CustomerParser cparse = new CustomerParser();
		cparse.custParse();
		
		System.out.println("--------------------------------------------------------------------------");
		//calling the UserParse method to parse the User xml and load the data into database
		UserParser uparse = new UserParser();
		uparse.UserParse();
		
		System.out.println("--------------------------------------------------------------------------");
		//calling the PartsParse method to parse the Parts xml and load the data into database
		PartsParser pparse = new PartsParser();
		pparse.partsParse();
		
		
		System.out.println("--------------------------------------------------------------------------");
		//calling the Customer Order Parse method to parse the Order xml and load the data into database
		CustomerOrderParser custorderparse = new CustomerOrderParser();
		custorderparse.custOrder();
		
		System.out.println("--------------------------------------------------------------------------");
		//calling the Payment Details Parse method to parse the payment xml and load the data into database
		PaymentDetailsParser paymentparse = new PaymentDetailsParser();
		paymentparse.paymentParse();
		
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Transaction is over...Thank you!");
		String timeStamp= new SimpleDateFormat("yyyy/mm/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("\nCurrent Date=" + timeStamp +"\nProgrammed by Ajay Kumar Mukhi\n");
		
		
		
		
	}

}
