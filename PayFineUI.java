// author :RamithaSilva mediator :SandesMagar Reviewer:RushanDevanga
import java.util.Scanner;


public class PayFineUI {


	public static enum UI_STATE { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };

	private PayFineControl CoNtRoL; //CoNtRoL object renamed as control
	private Scanner input;		
	private UI_STATE state;		//StAtE object renamed as state

	
	public PayFineUI(PayFineControl control) {
		this.control = control; //CoNtRoL object instance renamed as control
		input = new Scanner(System.in);
		state = UI_STATE.INITIALISED;//StAtE object renamed as state
		control.Set_UI(this);
	}
	
	//Class name changed as SetState
	public void SetState(UI_STATE state) {
		this.state = state;//StAtE object instance renamed as state
	}

	//Class name changed as Run
	public void Run() {
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (state) { //StAtE object renamed as state
			
			case READY:
				String memberString = input("Swipe member card (press <enter> to cancel): ");//String name is changed as memberString
				if (memberString.length() == 0) { //String name is changed
					Control.cancel(); //classes and ojects names has been changed
					break;
				}
				try {
					int Member_ID = Integer.valueOf(memberString).intValue();
					Control.Card_Swiped(Member_ID);//class name has been changed
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double amount = 0; //vaiable name changed as amount
				String amountString = input("Enter amount (<Enter> cancels) : "); //Amt_Str string name changed as amountString
				if (amountString.length() == 0) {
					Control.cancel(); //classes and ojects names has been changed
					break;
				}
				try {
					amount = Double.valueOf(Amt_Str).doubleValue();//vaiable name changed as amount
				}
				catch (NumberFormatException e) {}
				if (amount <= 0) {//parameter name changed as amount
					output("Amount must be positive");
					break;
				}
				CoNtRoL.PaY_FiNe(amount);//parameter name changed as amount
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state);//StAtE changed as state		
			
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
			
	//class name has been changed as Display
	public void Display (Object object) {
		output(object);
	}


}
