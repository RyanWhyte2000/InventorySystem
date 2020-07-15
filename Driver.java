package projects;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int results;
		/*CREATES OBJECT OF EACH CLASS*/
		Admin A = new Admin();
		User U =new User(); 
		Customer c = new Customer();
		Scanner input = new Scanner(System.in);
		 
		 
		int attempt, id;
		String ad_username, ad_password, cus_username, cus_password, user1, pass1;

		
		ad_username = "admin";
		ad_password = "admin";
		cus_username = "cust1";
		cus_password = "qwerty";

		
			attempt = 3;
			System.out.println( "               Sign in as...?");
			System.out.println( "                 [1]Admin" );
			System.out.println( "                 [2]Customer");
			
			System.out.println( "             Number selection (1 OR 2): ");
			 id = input.nextInt();
			
			 /* CHECK IF USER ENTER A NUMBER GREATER THAN 2 AND LESS THAN 1*/
			while((id != 1) && (id != 2))
			{
				System.out.println( "            Invalid input! Try again: ");
				
				 id = input.nextInt();
			}
 
			/*IF USER ENTERS ONE THEN ADMIN VERIFICATION IS CALLED*/
			if(id == 1)
			{
				  
				System.out.println( "                      Username: ");
				user1 = input.next();
				
				
				
				System.out.println( "                      Password: ");
				pass1 = input.next();
							
				while((!user1.contains(ad_username))|| (!pass1.contains(ad_password)))
				{					
					if (attempt == 1)
					{
						System.out.println("          You have exhausted all attempts!!!!");
						
						System.exit(0);
					}

					attempt= attempt - 1;

					System.out.println( "Invalid credentials! [Attempts: ");
					System.out.println( "                      Username: ");
					
					user1 = input.next();
					System.out.println( "                      Password: ");
					
					pass1 = input.next();
				}
			} 
				
				
				
	
				else
					/*IF USER ENTERS ONE THEN CUSTUMER  VERIFICATION IS CALLED*/

					if (id == 2)
					{
						System.out.println( "                      Username: ");
					String	user2 = input.next();
						
						
						
						System.out.println( "                      Password: ");
					String	pass2 = input.next();
						
					/*THIS SECTION CHECKS IF USERNAME AND PASSWORD FOR CUSTOMER DONT MATCH*/

				while((!user2.contains(cus_username))|| (!pass2.contains(cus_password)))
				{

						
						if (attempt == 1)
						{
							System.out.println("          You have exhausted all attempts!!!!");
							
							System.exit(0);
						}

						attempt= attempt - 1;

						System.out.println( "Invalid credentials! [Attempts: ");
						System.out.println( "                      Username: ");
						
						user2 = input.next();
						System.out.println( "                      Password: ");
						
						pass2 = input.next();
					}
					
					
					
					
					
					}
					
					
				
					
				switch(id) {
				
				case 1:
					A.Menu();//CALLS MENU FROM ADMIN CLASS
					int select2 = input.nextInt();
					while((select2<1) || (select2>4)){
						System.out.println( "Invalid input... try again ");
						select2 = input.nextInt();
					}
					
					do {
					switch(select2) {
					
					/*CALLS METHOD IN ADMIN CLASS BASED ON VALUE SELECTED*/
					case 1:

						A.AddnewItem();						
						break;
						
					case 2:
						A.editmenuitem();
						break;
					case 3:
						A.SearchItem();
						
						break;
					case 4:
						A.deletemenuItem(); 
						
						break;
					case 5:
						System.out.println("Exiting system.......");
						System.exit(0);
						break;
						
					default:
							System.out.println("Invalid input");
							System.exit(0);
							
					}
					A.Menu();
					 select2 = input.nextInt();
					}while(select2!=5); 
						break;
						
					
				case 2:
					c.Menu();//CALLS MENU FROM CUSTOMER CLASS
					int select3 = input.nextInt();
					do {
					switch(select3) {
					
					/*CALLS METHOD IN ADMIN CLASS BASED ON VALUE SELECTED*/
					case 1:
							c.viewAllitems(); 
							
						break;
						
					case 2:
						c.searchItems();
						
						break;
						
					case 3:
						
							c.viewOrders();	
							break;
					case 4:
						System.out.println("Exiting system......."); 
						System.exit(0);
						break;
					
					}
					
					c.Menu();
					 select3 = input.nextInt();
				
				}while(select3!=4);
					
					break;
			
				

			}
			
			
}}
