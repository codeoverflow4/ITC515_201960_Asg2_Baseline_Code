/* 
Auther: Osanda
Reviewer : Ramitha
Mediator : Rushan
*/
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Main {
	
	private static Scanner scannerIn;//Renamed to give a meaningful name
	private static library library;//Renamed to give a meaningful name
	private static String menu;//Variable renamed to lowercase letters
	private static Calendar calender;//Renamed to give a meaningful name
	private static SimpleDateFormat simpleDateFormat;//renamed to give a meaningful name
	
	
	private static String getMenu() {//Method name changed according to naming conventions
		StringBuilder stringBuilder = new StringBuilder();//Renamed to give a meaningful name
		
		stringBuilder.append("\nLibrary Main Menu\n\n")//Apply naming change
		  .append("  M  : add member\n")
		  .append("  LM : list members\n")
		  .append("\n")
		  .append("  B  : add book\n")
		  .append("  LB : list books\n")
		  .append("  FB : fix books\n")
		  .append("\n")
		  .append("  L  : take out a loan\n")
		  .append("  R  : return a loan\n")
		  .append("  LL : list loans\n")
		  .append("\n")
		  .append("  P  : pay fine\n")
		  .append("\n")
		  .append("  T  : increment date\n")
		  .append("  Q  : quit\n")
		  .append("\n")
		  .append("Choice : ");
		  
		return stringBuilder.toString();//Apply naming change
	}


	public static void main(String[] args) {		
		try {			
			scannerIn = new Scanner(System.in);//Apply naming change
			library = library.INSTANCE();//Apply naming change
			calender = Calendar.INSTANCE();//Apply naming change
			simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");//Apply naming change
	
			for (member member : library.members()) {//Method name change MEMBERS to members 
				output(m);
			}
			output(" ");
			for (book book : library.books()) {//Method name change BOOKS to books 
				output(b);
			}
						
			menu = getMenu();// MENU changed to menu and GET_MENU to getMenu
			
			boolean exception = false;// changed e to exception to give a meaningful name
			
			while (!exception) {
				
				output("\n" + simpleDateFormat.format(calender.Date()));//Apply name changes
				String selection = input(menu);//c change to selection to give a meaningful name
				
				switch (selection.toUpperCase()) {
				
				case "M": 
					addMember();//Apply method naming change
					break;
					
				case "LM": 
					members();//Apply method naming change
					break;
					
				case "B": 
					addBook();//Apply method naming change
					break;
					
				case "LB": 
					books();//Apply method naming change
					break;
					
				case "FB": 
					fixBooks();//Apply method naming change
					break;
					
				case "L": 
					borrowBook();//Apply method naming change
					break;
					
				case "R": 
					returnBook();//Apply method naming change
					break;
					
				case "LL": 
					currentLoans();//Apply method naming change
					break;
					
				case "P": 
					fines();//Apply method naming change
					break;
					
				case "T": 
					incrementDate();//Apply method naming change
					break;
					
				case "Q": 
					exception = true;
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
				library.SAVE();
			}			
		} catch (RuntimeException exception) {
			output(exception);
		}		
		output("\nEnded\n");
	}	

	
	private static void fines() {//Apply method naming conventions
		new PayFineUI(new PayFineControl()).run();// Change RuN to run	
	}


	private static void currentLoans() {//Apply method naming conventions
		output("");
		for (loan loan : library.currentLoans()) {
			output(loan + "\n");
		}		
	}



	private static void books() {//Method Name Changed to lowecase letters
		output("");
		for (book book : library.Books()) {
			output(book + "\n");
		}		
	}



	private static void members() {//Method Name Changed to lowecase letters
		output("");
		for (member member : library.Members()) {
			output(member + "\n");
		}		
	}



	private static void borrowBook() {
		new BorrowBookUI(new BorrowBookControl()).run();		
	}


	private static void returnBook() {
		new ReturnBookUI(new ReturnBookControl()).run();// Change RuN to run	
	}


	private static void fixBooks() {
		new FixBookUI(new FixBookControl()).run();	// Change RuN to run	
	}


	private static void incrementDate() {
		try {
			int days = Integer.valueOf(input("Enter number of days: ")).intValue();
			calender.incrementDate(days);//Apply name change
			library.checkCurrentLoans();//Apply name change
			output(simpleDateFormat.format(calender.Date()));//Apply name change
			
		} catch (NumberFormatException exception) {// e changed to exception
			 output("\nInvalid number of days\n");
		}
	}


	private static void ADD_BOOK() {
		
		String A = input("Enter author: ");
		String T  = input("Enter title: ");
		String C = input("Enter call number: ");
		book B = LIB.Add_book(A, T, C);
		output("\n" + B + "\n");
		
	}

	
	private static void ADD_MEMBER() {
		try {
			String LN = input("Enter last name: ");
			String FN  = input("Enter first name: ");
			String EM = input("Enter email: ");
			int PN = Integer.valueOf(input("Enter phone number: ")).intValue();
			member M = LIB.Add_mem(LN, FN, EM, PN);
			output("\n" + M + "\n");
			
		} catch (NumberFormatException e) {
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String input(String prompt) {
		System.out.print(prompt);
		return IN.nextLine();
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
