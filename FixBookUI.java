// author :RushanDevanga mediator :OsandaRanawera Reviewer:Sandesh Magar
import java.util.Scanner;

//FixBookUI change as a Fixbookui 
public class Fixbookui  { 

	public static enum UiState { INITIALISED, READY, FIXING, COMPLETED };
	//UI_STATE change as a UiState (Underscore seperated class are not acceptable and uppercase letter and to be in camelBack)

	private FixBookControl control;
	//CoNtRoL change as a control All Variable are starting With Lowe Case and To Be CamelBack
	private Scanner input;
	private UiState state;
	//There are two changes here UI_STATE as a UiState and StAtE as a state

	
	////FixBookUI change as a Fixbookui
	public Fixbookui(FixBookControl control) {
		this.CoNtRoL = control;
		//CoNtRoL has to be change control
		
		input = new Scanner(System.in);
		//StAtE change as a state
		state = UiState.INITIALISED;
		
		control.SetUi(this);
		
	}

        //Set_State(UI_STATE state) change as a setstate(UiState state)
	public void setstate(UiState state) {
		//StAtE change as a state
		this.state = state;
	}

	//RuN change as a run 
	public void run() {
		//this needs to be updtaed [this.output]
		this.output("Fix Book Use Case UI\n");
		
		while (true) {
			//StAtE change as a currentState because its meaningful thats why added to the current word here.
			switch (currentState) {
			
			case READY:
				//Book_STR change as a bookScan	
				String bookScan = input("Scan Book (<enter> completes): ");
					//Book_STR.length change as bookScan.lenght
				if (bookScan.length() == 0) {
					//CoNtRoL.SCannING_COMplete  change as a this.control.completeScanning
					this.control.completeScanning();
				}
				else {
					try {
						//Book_ID change as a bookId and (Book_STR)change as a bookScan
						int bookId = Integer.valueOf(bookScan).intValue();
						//CoNtRoL.Book_scanned(Book_ID) change as a this.control.scanBook(bookId)
						this.control.scanBook(bookId);
					}
					catch (NumberFormatException e) {
						//updated with this.output...
						this.output("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
					//AnS change as a answer becuase it gives a meanininful
				String answer = input("Fix Book? (Y/N) : ");
					//FiX change as a fix
				boolean fix = false;
					//Agian this needs to be change AnS into answer
				if (answer.toUpperCase().equals("Y")) {
					//FiX has to be change again as a fix
					fix = true;
				}
					//As we did before This Also Needs to Updated just like control.fixBook(fix)
				control.fixBook(FiX);
				break;
								
			case COMPLETED:
					//added this forword to output [this.output] like that way
				this.output("Fixing process complete");
				return;
			
			default:
					//again updated infront of th output just like  this.output
				this.output("Unhandled state");
					//StAtE we already updated before as a currentState
				throw new RuntimeException("FixBookUI : unhandled state :" + state);			
			
			}		
		}
		
	}

	
	private String input(String prompt) {
	
		System.out.print(prompt);
		//added (this) before input it will updated as a this.input....
		this.return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}
	

	public void display(Object object) {
		//added (this) before output 
		this.output(object);
	}
	
	
}
