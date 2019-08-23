// author :RamithaSilva mediator :OsandaRanawera Reviewer:RushanDevanga
import java.util.Scanner;


public class ReturnBookUI {

	public static enum UI_STATE { INITIALISED, READY, INSPECTING, COMPLETED };

	private ReturnBookControl control; //object name changed as control
	private Scanner input;
	private UI_STATE state; //object name changed as state

	
	public ReturnBookUI(ReturnBookControl control) {
		this.control = control; //control instance name has changed
		input = new Scanner(System.in);
		state = UI_STATE.INITIALISED;//state object name has changed
		control.Set_UI(this);
	}

	//class name changed as Run
	public void Run() {		
		output("Return Book Use Case UI\n");
		
		while (true) {
			
			switch (state) {//parameter name changed as state
			
			case INITIALISED:
				break;
				
			case READY:
				String Book_STR = input("Scan Book (<enter> completes): ");
				if (Book_STR.length() == 0) {
					CoNtRoL.Scanning_Complete();
				}
				else {
					try {
						int Book_Id = Integer.valueOf(Book_STR).intValue();
						control.Book_scanned(Book_Id);//object name has changed as control
					}
					catch (NumberFormatException e) {
						output("Invalid bookId");
					}					
				}
				break;				
				
			case INSPECTING:
				String ans = input("Is book damaged? (Y/N): ");
				boolean Is_Damaged = false;
				if (ans.toUpperCase().equals("Y")) {					
					Is_Damaged = true;
				}
				CoNtRoL.Discharge_loan(Is_Damaged);
			
			case COMPLETED:
				output("Return processing complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("ReturnBookUI : unhandled state :" + state);	//parameter name changed as state		
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
	
	public void Set_State(UI_STATE state) {
		//object name changed as state	
		this.state = state;	
	}

	
}
