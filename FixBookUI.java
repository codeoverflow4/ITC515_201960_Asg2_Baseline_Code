// author :RushanDevanga mediator :OsandaRanawera Reviewer:Sandesh Magar
import java.util.Scanner;

//FixBookUI change as a Fixbookui 
public class FixBookUI { 

	public static enum UI_STATE { INITIALISED, READY, FIXING, COMPLETED };
	//UI_STATE change as a UiState (Underscore seperated class are not acceptable and uppercase letter and to be in camelBack)

	private FixBookControl CoNtRoL;
	//CoNtRoL change as a control All Variable are starting With Lowe Case and To Be CamelBack
	private Scanner input;
	private UI_STATE StAtE;
	//There are two changes here UI_STATE as a UiState and StAtE as a state

	
	////FixBookUI change as a Fixbookui
	public FixBookUI(FixBookControl control) {
		this.CoNtRoL = control;
		//CoNtRoL has to be change control
		
		input = new Scanner(System.in);
		//StAtE change as a state
		StAtE = UI_STATE.INITIALISED;
		
		control.Set_Ui(this);
		
	}

        //Set_State(UI_STATE state) change as a setstate(UiState state)
	public void Set_State(UI_STATE state) {
		//StAtE change as a state
		this.StAtE = state;
	}

	//RuN change as a run 
	public void RuN() {
		//this needs to be updtaed [this.output]
		output("Fix Book Use Case UI\n");
		
		while (true) {
			//StAtE change as a currentState because its meaningful thats why added to the current word here.
			switch (StAtE) {
			
			case READY:
				//Book_STR change as a bookScan	
				String Book_STR = input("Scan Book (<enter> completes): ");
					//Book_STR.length change as bookScan.lenght
				if (Book_STR.length() == 0) {
					//CoNtRoL.SCannING_COMplete  change as a this.control.completeScanning
					CoNtRoL.SCannING_COMplete();
				}
				else {
					try {
						//Book_ID change as a bookId and (Book_STR)change as a bookScan
						int Book_ID = Integer.valueOf(Book_STR).intValue();
						//CoNtRoL.Book_scanned(Book_ID) change as a this.control.scanBook(bookId)
						CoNtRoL.Book_scanned(Book_ID);
					}
					catch (NumberFormatException e) {
						//updated with this.output...
						output("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
					//AnS change as a answer becuase it gives a meanininful
				String AnS = input("Fix Book? (Y/N) : ");
					//FiX change as a fix
				boolean FiX = false;
					//Agian this needs to be change AnS into answer
				if (AnS.toUpperCase().equals("Y")) {
					//FiX has to be change again as a fix
					FiX = true;
				}
					//As we did before This Also Needs to Updated just like control.fixBook(fix)
				CoNtRoL.FIX_Book(FiX);
				break;
								
			case COMPLETED:
					//added this forword to output [this.output] like that way
				output("Fixing process complete");
				return;
			
			default:
					//again updated infront of th output just like  this.output
				output("Unhandled state");
					//StAtE we already updated before as a currentState
				throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
			
			}		
		}
		
	}

	
	private String input(String prompt) {
	
		System.out.print(prompt);
		//added (this) before input it will updated as a this.input....
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}
	

	public void display(Object object) {
		//added (this) before output 
		output(object);
	}
	
	
}
