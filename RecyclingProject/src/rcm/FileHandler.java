package rcm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileHandler {

	private static String fileName = "/Users/Jonathan/recyclingproject/RecyclingProject/src/data/data.txt";
	
	public static void scanAndShow() throws IOException {
		  
		  BufferedReader br = new BufferedReader(new FileReader(fileName));
		  String line;
		  while ((line = br.readLine()) != null) {
			  //
		  }
		  br.close();
		 
	}
	public static void writeToFile(RecyclingMachine rcm) throws IOException{
		java.util.Date date= new java.util.Date();
		long time = date.getTime();
		
		FileWriter f0 = new FileWriter(fileName,true);

		String newLine = System.getProperty("line.separator");


	//	for(i=0;i<10;i++)
	//	{
		    f0.write(rcm.getMachineID()+","+rcm.getLocation()+","+new Timestamp(time)+","+rcm.getLastEmptiedDate()+","+rcm.getQuantity("Aluminum")+","+rcm.getQuantity("Plastic")+","+rcm.getQuantity("Glass")+","+rcm.getTransactionWeight()+","+rcm.getCurrentAmount()+","+rcm.getCurrentTotalForItem("Aluminum")+","+rcm.getCurrentTotalForItem("Plastic")+","+rcm.getCurrentTotalForItem("Glass")+newLine);
	//	}
		f0.close();
	}

}
