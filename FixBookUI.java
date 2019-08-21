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

	
	public void RuN() {
		output("Fix Book Use Case UI\n");
		
		while (true) {
			
			switch (StAtE) {
			
			case READY:
				String Book_STR = input("Scan Book (<enter> completes): ");
				if (Book_STR.length() == 0) {
					CoNtRoL.SCannING_COMplete();
				}
				else {
					try {
						int Book_ID = Integer.valueOf(Book_STR).intValue();
						CoNtRoL.Book_scanned(Book_ID);
					}
					catch (NumberFormatException e) {
						output("Invalid bookId");
					}
				}
				break;	
				
			case FIXING:
				String AnS = input("Fix Book? (Y/N) : ");
				boolean FiX = false;
				if (AnS.toUpperCase().equals("Y")) {
					FiX = true;
				}
				CoNtRoL.FIX_Book(FiX);
				break;
								
			case COMPLETED:
				output("Fixing process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + StAtE);			
			
			}		
		}
		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}
	

	public void display(Object object) {
		output(object);
	}
	
	
}
