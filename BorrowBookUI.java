/*
Author - Sandesh Magar
Mediator- Osanda
Reviewer - Rushan
*/
import java.util.Scanner;


public class BorrowBookUI {

	public static enum UIState { //enum name UI_STATE changed to UIState
		INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };

	private BorrowBookControl borrowBookControl; //object name CONTROL is replaced with borrowBookControl
	private Scanner scanner; //input is replaced with scanner as it is better that object name correspond to Reference name (i.e. Scanner class)
	private UIState uIState;//Refernce name and object name changed


	public BorrowBookUI(BorrowBookControl borrowBookControl) { //control renamed to borrowBookControl, StaTe renamed to uIState and UI_STATE into UIState
		this.borrowBookControl = borrowBookControl;
		scanner = new Scanner(System.in);
		uIState = UIState.INITIALISED;
		borrowBookControl.setUI(this);
	}


	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}


	private void output(Object object) {
		System.out.println(object);
	}


	public void setState(UIState uIState) { //Set_State renamed to setState and StaTe renamed to uIState and UI_STATE into UIState
		this.uIState = uIState;
	}


	public void run() {  //control renamed to borrowBookControl, StaTe renamed to uIState and UI_STATE into UIState and as well as methods from BorrowBookContol class are adjusted
		output("Borrow Book Use Case UI\n");

		while (true) {

			switch (uIStaTe) {

			case CANCELLED:
				output("Borrowing Cancelled");
				return;


			case READY:
				String memberInput = input("Swipe member card (press <enter> to cancel): "); //MEM_STR renamed into memberInput as it is more applicable
				if (memberInput.length() == 0) {
					borrowBookControl.onCancel();
					break;
				}
				try {
					int memberID = Integer.valueOf(memberInput).intValue();
					borrowBookControl.onSwiped(memberID);
				}
				catch (NumberFormatException e) {
					output("Invalid Member Id");
				}
				break;


			case RESTRICTED:
				input("Press <any key> to cancel");
				borrowBookControl.onCancel();
				break;


			case SCANNING:
				String bookInput = input("Scan Book (<enter> completes): ");
				if (bookInput.length() == 0) {
					borrowBookControl.onComplete();
					break;
				}
				try {
					int bID = Integer.valueOf(bookInput).intValue(); //renamed BiD into bId
					borrowBookControl.onScanned(bID);

				} catch (NumberFormatException e) {
					output("Invalid Book Id");
				}
				break;


			case FINALISING:
				String answerInput = input("Commit loans? (Y/N): ");
				if (answerInput.toUpperCase().equals("N")) {
					borrowBookControl.onCancel();

				} else {
					borrowBookControl.onCommitLoans();
					input("Press <any key> to complete ");
				}
				break;


			case COMPLETED:
				output("Borrowing Completed");
				return;


			default:
				output("Unhandled state");
				throw new RuntimeException("BorrowBookUI : unhandled state :" + uIStaTe); // state to UIState
			}
		}
	}


	public void setDisplay(Object object) { //renamed method name Display into setDisplay as it is setting the values passed by its referencer
		output(object);
	}


}
