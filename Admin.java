package projects;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

import java.io.FileWriter;
import java.io.IOException;

public class Admin extends User {
	int itemId;
	String itemName;
	double itemPrice;
	int itemPreptime;
	int itemQuantity;

	Scanner input = new Scanner(System.in);

	public void Menu() {/*PRINTS A MENU OF THE DIFFERENT METHOD WHEN CALL */

		System.out.println(" Select from menu");
		System.out.println(" 1. Add new item");
		System.out.println(" 2. Edit menu item ");
		System.out.println(" 3. Search menu item ");
		System.out.println(" 4. delete menu item ");
		System.out.println(" 5. Exit menu item "); 

	}

	public void AddnewItem() {/*THIS METHOD IS RESPONSIBLE FOR TAKING DATA FROM USER*/
		try {
			Scanner in = new Scanner(System.in);
			File file = new File("Data.txt"); /*FILE DECLARATION*/
			
			
			
			Random rand = new Random(); /*GENRATE RANDOM NUMBER*/
			file.createNewFile();
			if (file.exists()) {/*CHECK IF FILE EXISTS ON MACHINE*/

				FileWriter writer = new FileWriter(file, true);
				int itemid = rand.nextInt(1000);
				
				
				/*THIS SECTION ASK FOR DATA FROM USER*/
				System.out.println(" item id is: " + itemid);

				System.out.println(" Please enter name of item: ");
				String itemname = input.next();
				System.out.println("Please enter price of item: ");
				float itemprice = input.nextFloat();
				System.out.println("Please enter preparation time of item: ");
				int itempreptime = input.nextInt();
				System.out.println("Please enter quantity of item: ");
				int itemquantity = input.nextInt();

				/* WRITES DATA TO FILE*/
				writer.write(itemid + " " + itemname + " " + itemprice + "  " + itempreptime + " " + itemquantity + "\n");

			 	System.out.println("\n Items added successfully.... ");
				writer.close();

			} else {
 
				System.out.println("File not Found");
				in.close();
			} 
		} catch (IOException e) {

			System.out.println("File Error");
			e.printStackTrace();
		}

	}

	public void SearchItem() {/*THIS METHOD SEARCHES THROUGH THE FILE AND OUTPUT A RECORD*/

		try {
			/*VARIABLE DECLARATION*/
			int itemId = 0;
			String itemName = "";
			float itemPrice = 0;
			int itemPrepTime = 0;
			int itemQuantity = 0;
			int Id = 0; 
			boolean found = false;

			try {
				System.out.println("\n\t\t\tEnter Item Id You Wish To Search for\t:");
				Id = input.nextInt(); 
			} catch (InputMismatchException e) {
				System.err.println("\n\t\twrong input type entered");
			}
			/*CHECK IF FILE EXISTS ON MACHINE*/
			if (new File("Data.txt").exists()) {
 
			Scanner read = new Scanner(new File("Data.txt"));
			/*THIS SECTION GOES THROUGH THE FILE AND PULLS THE ATTRIBUTE THAT ARE STORED IN THE FILE*/
			while (read.hasNext()) {
				itemId = read.nextInt();
				itemName = read.next(); 
				itemPrice = read.nextFloat();
				itemPrepTime = read.nextInt();
				itemQuantity = read.nextInt();
				/* THIS SECTION CHECKS THE ID THAT IS ENTERED AGAINST THE ONES THAT ARE STORED IN THE FILE*/
				if (itemId == Id) {
					found = true;
					break;
				}
			}
			/*THIS SECTION OUTPUTS THE RECORD IF IT IS FOUND IN THE FILE*/

			if (found == true) {
				System.out.println("itemid" + " " + "itemname" + " " + "itemprice" + "  " + "itempreptime" + " " + "itemquantity");

				System.out.println(
						itemId + "\t" + itemName + "\t" + itemPrice + "\t\t" + itemPrepTime + "\t" + itemQuantity + "\n");
			} else {
				System.out.println("\n\t\tItem not found ");
			}

			read.close();
			} else {
				/*THIS SECTION OUTPUTS THIS  IF RECORD IS NOT FOUND IN THE FILE*/

				System.out.println("File not Found");
				
			}

		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		}

	}

	public void editmenuitem() {/*THIS METHOD IS RESPONSIBLE FOR EDITING DATA STORED IN FILE*/
		/*VARIABLE DECLARATION*/
		int itemId = 0;
		String itemName = "";
		float itemPrice = 0;
		int itemPrepTime = 0;
		int itemQuantity = 0;
		int Id = 0;
		boolean checked = true;
		
		try {
			/*FILE REFERENCE*/
			File oldfile = new File("Data.txt");
			File tempfile = new File("temp.txt");
			
			Scanner read = new Scanner(new File("Data.txt"));
			Scanner in = new Scanner(System.in);
			
			FileWriter fw = new FileWriter(tempfile, true);
		
			System.out.println(" enter the id of item you want to edit");
			int Identify = input.nextInt();
			/*THIS SECTION GOES THROUGH THE FILE AND PULLS THE ATTRIBUTE THAT ARE STORED IN THE FILE*/
			while (read.hasNext()) {
				itemId = read.nextInt();
				itemName = read.next();
				itemPrice = read.nextFloat();
				itemPrepTime = read.nextInt();
				itemQuantity = read.nextInt();
				 /* THIS SECTION CHECKS THE ID THAT IS ENTERED AGAINST THE ONES THAT ARE STORED IN THE FILE*/

				if (Identify == itemId ) {
					/*THIS SECTION DISPLAYS AN EDIT MENU IF ID IS FOUND IN FILE*/
					System.out.println(" Select from menu");
					System.out.println(" 1. Edit name");
					System.out.println(" 2. Edit  id ");
					System.out.println(" 3. Edit Price ");
					System.out.println(" 4. Edit Preparation time ");
					System.out.println(" 5. Edit quantity ");
					int select = in.nextInt();
					/*THIS SECTION ALLOWS USER TO CHANGE DATA ALREADY STORED IN FILE*/
					switch (select) {
						case 1: 
							System.out.println(" Please enter new  name of item: ");
							itemName = input.next();
							break;
						case 2:
							System.out.println(" Please enter new  id of item: ");
							itemId = input.nextInt(); 
							break;
						case 3:
							System.out.println("Please enter new price of item: ");
							itemPrice = input.nextFloat();
							break;
						case 4:
							System.out.println(" Please enter new  Preparation time of item: ");
							itemPrepTime = input.nextInt(); 
							break;
						case 5:
							System.out.println(" Please enter new Quantity of item: ");
							itemQuantity = input.nextInt();
							break;
						default:
							System.out.println(" Error input ");
					}
					
					//fw.flush();
					//fw.close();
					
					try {
						/*THIS SECTION WRITES TO A TEMPORARY FILE*/
						fw.write(itemId  + " " + itemName + " " + itemPrice + "  " + itemPrepTime + " " + itemQuantity + "\n");
					}
					catch(FileNotFoundException e) {
						System.err.println("file not found");
					}
				} 
			}
			
			read.close();
			fw.close();
			
			/*THIS SECTION DELETE THE ORIGINAL FILE AND RENAMES THE TEMPORARY FILE TO THE ORIGINAL FILE*/

			if (oldfile.delete()) {
				if (tempfile.renameTo(oldfile)) {
					System.out.println("File Corrected");
				} else {
					System.out.println("Error,, Rename failed");
				}
			}
			else {
				System.err.println("\n\nfile not deleted ");
			}
			
		} catch (IOException e) {
			System.out.println("File Error"); 
			e.printStackTrace();
		}
	}

	public void deletemenuItem() {/*THIS METHOD DELETES A RECORD FROM THE FILE*/
		
		/*VARIABLE DECLARATION*/
		int itemId = 0;
		String itemName = "";
		float itemPrice = 0;
		int itemPrepTime = 0;
		int itemQuantity = 0;
		int Id = 0;

		try {
			/*FILE REFERENCE*/
			File oldfile = new File("Data.txt");
			File tempfile = new File("deletetemp.txt");
			
			if (oldfile.exists()) {/*THIS CHECK IF FILE EXISTS*/
			Scanner read = new Scanner(oldfile);

			Scanner in = new Scanner(System.in);

			FileWriter fw = new FileWriter(tempfile, true);

			System.out.println(" enter the id of item you are looking  for");
			int id = in.nextInt();
			/*THIS SECTION GOES THROUGH THE FILE AND PULLS THE ATTRIBUTE THAT ARE STORED IN THE FILE*/

			while (read.hasNext()) {
				itemId = read.nextInt();
				itemName = read.next();
				itemPrice = read.nextFloat();
				itemPrepTime = read.nextInt();
				itemQuantity = read.nextInt(); 
				/*THIS SECTION CHECKS THE ID THAT IS ENTERED AGAINST THE ONES THAT ARE STORED IN THE FILE*/		
				if (id != itemId) {
					/*WRITES EVERY RECORD TO THE FILE OTHER THAN THE ONE THAT WAS FOUND */
					try {
						fw.write(itemId  + " " + itemName + " " + itemPrice + "  " + itemPrepTime + " " + itemQuantity + "\n");
					}
					catch(FileNotFoundException e) {
						System.err.println("file not found");
			 		}
				}
			}
			read.close();
			//fw.flush();
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
}
