package projects;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Customer extends User{
	
	public void Menu()/*PRINTS A MENU OF THE DIFFERENT METHOD WHEN CALL */
	{
		System.out.println(" Select from menu");
 		System.out.println(" 1. View all item");
 		System.out.println(" 2. Search for item ");
 		System.out.println(" 3. view orders ");
 		System.out.println(" 4. Exit ");


	}
	public void viewAllitems() {/*THIS METHOD OUTPUTS A FILE AND ASK USER TO MAKE A SELECTION BASED ON THE OUTPUT*/
		try {
			Random rand = new Random();

			Scanner search = new Scanner(new File("Data.txt"));
	    	Scanner in = new Scanner (System.in);
	    	/*FILE REFERENCE*/
	    	File tempFile = new File("Order.txt");
	    	FileWriter fw = new FileWriter (tempFile, true);
	    	
	    	if (tempFile.exists()) {
	    		/*VARIABLE DECLARATION*/
	    	 int itemId = 0;
				String itemName = "";
				float itemPrice = 0; 
				int itemPrepTime = 0;
				int itemQuantity = 0;
				int Id = 0;
				boolean found = false;
	
				/*THIS SECTION GOES THROUGH THE FILE AND PULLS THE ATTRIBUTE THAT ARE STORED IN THE FILE*/
					while (search.hasNext()) {
					itemId = search.nextInt();
					itemName = search.next();
					itemPrice = search.nextFloat();
					itemPrepTime = search.nextInt();
					itemQuantity = search.nextInt();
					/*THIS SECTION OUTPUTS ALL THE RECORD FOUND IN THE FILE*/

					System.out.println(itemId + "\t" + itemName + "\t" + itemPrice + "\t" + itemPrepTime + "\t" + itemQuantity + "\n");
				}
					search.close();
				Scanner search1 = new Scanner(new File("Data.txt"));

	    	    System.out.println(" Select a meal from list above by entering the id number"	);
	    	    int select = in.nextInt(); 
			
	    	    /*THIS SECTION GOES THROUGH THE FILE AND PULLS THE ATTRIBUTE THAT ARE STORED IN THE FILE*/
		    	    while (search1.hasNext()) {
		    	    	 int id= search1.nextInt();
		    	    	 String name= search1.next();
			    	     float price = search1.nextFloat() ;
			    	     int preptime =search1.nextInt();
			    	     int quantity =search1.nextInt();
			    	     
		                
			    	     /* THIS SECTION CHECKS THE ID THAT IS ENTERED AGAINST THE ONES THAT ARE STORED IN THE FILE*/
		    	    		if (select == id) {
		    	    			/*ATTRIBUTES THAT WERE PULLED ARE BEING TEMPORARILY ASSIGNED*/
		    	    			float tempprice= price;
		    	    			int time =preptime;
		    	    			int quant= quantity;
		    	    			String Name= name;
		    	    			int orderid= rand.nextInt(1000);
		    	    			/*AUTOMATIC ID IS BEING GENERATED*/
		    	    			System.out.println( " Order id is: " + orderid);
		    	    			
		    	        	    System.out.println(" Enter the amount"	);
		    	        	    int   amount = in.nextInt();
		    	        	    /*CHECKS IF AMOUNT ENTERED IS GREATER THAN THE QUANTITY IN STORAGE*/
		    	        	    while(amount>quant) {
		    	        	    	System.out.println(" Not enough in storage"	);
		    	        	    	System.out.println(" Enter a new  amount"	);
			    	        	     amount = in.nextInt(); 
		    	        	    	/* WRITE TO THE ORDER FILE*/
		    	        	    }
		    	        	    /* WRITE TO THE ORDER FILE*/
		    	    			fw.write(select+ " "+Name+ " " +tempprice+ " "+time+ " "+quant+ " "+orderid+ " "+amount+"\n");
		    	        	    System.out.println(" Order has been nade"	);

		    	        	    /*ASK THE USER IF THEY  WANT MAKE ANOTHER ORDER*/
		    	        	    System.out.println(" Do you want to add a new order"	);
		    	        	    System.out.println(" Enter Y/N"	);
		    	        	    char choice = in.next().charAt(0);
		    	        	    if(choice == 'Y') {
		    	        	    	
		    	   
		    	    	    	    orderid= rand.nextInt(1000);
				    	    		System.out.println( " Order id is: " + orderid);
				    	    			
				    	        	  System.out.println(" Enter the amount"	);
				    	              amount = in.nextInt(); 
				    	        	    while(amount>quant) {
				    	        	    	System.out.println(" Not enough in storage"	); 
				    	        	    	System.out.println(" Enter a new  amount"	);
					    	        	     amount = in.nextInt(); 
				    	        	    	
				    	        	    }
				    	        	    /* WRITE TO THE ORDER FILE*/
				    	    			fw.write(select+ " "+Name+ " " +tempprice+ " "+time+ " "+quant+ " "+orderid+ " "+amount+"\n");
				    	        	    System.out.println(" Order has been nade"	);

		    	        	    }

		    	        	    

		    	    		}
		    	    	}
	    	    
					search1.close();	    	    
	    		fw.close();
	    	} else {

				System.out.println("File not Found");
				
			}
		}catch (IOException e) {
			
			System.out.println("File Error");
			e.printStackTrace();
		}
		
}

	
	

	
	public void searchItems() {/*THIS METHOD SEARCHES INVENTORY DIRECTLY AND MAKE AN ORDER*/
		try {
			Random rand = new Random();

			/*FILE REFERENCE*/
			Scanner search = new Scanner(new File("Data.txt"));
	    	Scanner in = new Scanner (System.in);
	    	File tempfile = new File("Order.txt");
	    	FileWriter fw = new FileWriter (tempfile, true);
	    	if (tempfile.exists()) {/*CHECKING IF FILE EXISTS*/
	    	/*VARIABLE DECLARATION AND INITIALISATION*/
	    		int itemId = 0;
				String itemName = "";
				float itemPrice = 0; 
				int itemPrepTime = 0;
				int itemQuantity = 0;
				int Id = 0;
				boolean found = false;
	
	    			System.out.println( " Enter the name of item of item you are looking for");
	    			String name= in.next();
	    			/*THIS SECTION GOES THROUGH THE FILE AND PULLS THE ATTRIBUTE THAT ARE STORED IN THE FILE*/

					while (search.hasNext()) {
					itemId = search.nextInt();
					itemName = search.next();
					itemPrice = search.nextFloat();
					itemPrepTime = search.nextInt();
					itemQuantity = search.nextInt();
					/* THIS SECTION CHECKS THE NAME THAT IS ENTERED AGAINST THE ONES THAT ARE STORED IN THE FILE*/

	    	    		if (name.equals(itemName )) {
	    	    			
	    	    			float tempprice= itemPrice;
	    	    			int time =itemPrepTime;
	    	    			int quant= itemQuantity;
	    	    			int id = itemId;
	    	    			/*GENEARATES ORDER ID*/
	     	    			int orderid=  rand.nextInt(1000);
	     	    			System.out.println( " Order id is: " +orderid);
	     	    			System.out.println(" Enter the amount"	);
	     	        	   int   amount = in.nextInt();
	     	        	  /*CHECKS IF AMOUNT ENTERED IS GREATER THAN THE QUANTITY IN STORAGE*/
	    	        	    while(amount>quant) {
	     	        	  while(amount>quant) {
	    	        	    	System.out.println(" Not enough in storage"	);
	    	        	    	System.out.println(" Enter a new  amount"	);
		    	        	     amount = in.nextInt(); 
	    	        	    	
	    	        	    }
	     	        	 /* WRITE TO THE ORDER FILE*/
	     	    			fw.write(id+ " "+name+ " " +tempprice+ " "+time+ " "+quant+ " "+orderid+ " "+amount+"\n");
	    	        	    System.out.println(" Order received"	);
	    	        	    
	    	    		
	    	    		
	    	    		} 
	    
	    	    	}
	    	    search.close();
	            fw.flush();
	            fw.close();
			  
		} 
	    	}else {

			System.out.println("File not Found");
			
		}
	    	    }catch (IOException e) {
				
				System.out.println("File Error");
				e.printStackTrace();
			}
	}
	
	public void viewOrders() {/*THIS METHOD SHOWS CUSTOMER ORDER BASED ON SELECTION*/
		try { 
		Scanner in = new Scanner (System.in);
		/*VARIABLE DECLARATION*/
		float totalcost=0;
		int totalpreptime;
		int amount=0;
		int itemid=0;
		String itemname="";
		float  itempprice=0;
		int itempreptime=0;
		int orderid=0;
		int itemquantity=0;
		boolean found = false;
		System.out.println(" Enter order id you wish to find"	);
	    int id = in.nextInt(); 
	    Scanner search = new Scanner(new File("Order.txt"));
	    if (new File("Order.txt").exists()) {/*CHECK IF FILE EXISTS*/
			/*THIS SECTION GOES THROUGH THE FILE AND PULLS THE ATTRIBUTE THAT ARE STORED IN THE FILE*/

	    	while (search.hasNext()) { 

   	    		 itemid= search.nextInt();
   	    		 itemname= search.next();
   	    		 itempprice= search.nextFloat() ;
	    	     itempreptime=search.nextInt();
	    	     itemquantity=search.nextInt();
	    	     orderid= search.nextInt(); 
                 amount = search.nextInt(); 
                 	
 				/* THIS SECTION CHECKS THE ID THAT IS ENTERED AGAINST THE ONES THAT ARE STORED IN THE FILE*/

                 if (id==orderid) { 
                	  found = true;
                	  break; 
                 }
   	    }
			/*THIS SECTION OUTPUTS THE RECORD IF IT IS FOUND IN THE FILE*/

     			if (found == true) {
     				/* THIS SECTION CALCULATE THE FINAL COST BASED ON THE ITEM PRICE AND THE AMOUNT AND TOTAL PREPARATION TIME*/
                	totalcost =itempprice *amount; 
                	totalpreptime= itempreptime*amount;
    				System.out.println("itemid" + " " + "itemname" + " " + "itemprice" + "  " + "itempreptime" + " " + "itemquantity"+ "OrderId"+ "total Cost"+ "totalPreptime");

                	System.out.println(itemid+ " \t"+itemname+ "\t " +itempprice+ "     \t " +itempreptime+"\t\t " +itemquantity+"\t "+orderid +"\t "+totalcost+"\t "+totalpreptime);
   	    		
     			}
     			  search.close();

				} else {

					System.out.println("File not Found");
			
				}
	    /* ASK IF USER WANTS TO DELETE ORDER*/
	    System.out.println(" Do you want to delete order"	);
	    System.out.println(" Enter Y/N"	);
	    char choice1 = in.next().charAt(0);
	    if(choice1 == 'Y') {
	    	try {
	    		/*FILE REFERENCE*/
				File oldfile = new File("Order.txt");
				File tempfile = new File("delettemp.txt");
				if (oldfile.exists()) {
				Scanner read = new Scanner(oldfile);


				FileWriter fw = new FileWriter(tempfile, true);

				/*THIS SECTION GOES THROUGH THE FILE AND PULLS THE ATTRIBUTE THAT ARE STORED IN THE FILE*/

				while (read.hasNext()) {
					itemid= read.nextInt();
	   	    		 itemname= read.next();
	   	    		 itempprice= read.nextFloat() ;
		    	     itempreptime= read.nextInt();
		    	     itemquantity= read.nextInt();
		    	     orderid= read.nextInt();  
	                 amount = read.nextInt();  
						/* THIS SECTION CHECKS THE ID THAT IS ENTERED AGAINST THE ONES THAT ARE STORED IN THE FILE*/

					if (id != orderid) {
						try {
							/*WRITES TO A TEMPORARY FILE*/
	     	    			fw.write(itemid+ " "+itemname+ " " +itempprice+ " "+itempreptime+ " "+itemquantity+ " "+orderid+ " "+amount+"\n");

							
						}
						catch(FileNotFoundException e) {
							System.err.println("file not found");
				 		}
					}
				}
				read.close();
				
				fw.close();  
				/*THIS SECTION DELETE THE ORIGINAL FILE AND RENAMES THE TEMPORARY FILE TO THE ORIGINAL FILE*/

				
				if(oldfile.delete()) {
					System.out.println(" successfully deleted ");
					
					if (tempfile.renameTo(oldfile)) {
						System.out.println("File Corrected");
					} else { 
						System.out.println("Error");
					}
				} else {
					System.err.println("file is not delete ");
				}

				} else {

					System.out.println("File not Found");
				}
			} catch (IOException e) {

				System.out.println("File Error"); 
				e.printStackTrace();
			}
	    
	    }
	    
   
				} catch (FileNotFoundException e) {
					System.err.println("file not found");
				}
	  
		}
}

	

