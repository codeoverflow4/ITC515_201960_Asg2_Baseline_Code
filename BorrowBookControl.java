/*
Author- Sandesh Magar
Mediator - Ramitha
Reviewer - Rushan
*/
import java.util.ArrayList;
import java.util.List;

public class BorrowBookControl { //this is testing 4

	private BorrowBookUI borrowBookUI; //UI renamed to borrowBookUI

	private Library library; //library and LIBRARY renamed but  LIbrary class is missing
	private Member member; // Member class name and member object name adjusted but Member class is missing
	private enum ControlState { //enum name CONTROL_STATE renamed into ControlState
		INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED };
	private ControlState state; //CONTROL_STATE renamed to ControlState and variable State renamed into state

	private List<Book> pending; // book renamed into Book  and PENDING renamed into lowercase
	private List<Loan> completed; //loan renamed into Loan  and COMPLETED renamed into lowercase,
	private Book book;//book is renamed into Book class and variable name BOOK is renamed into book


	public BorrowBookControl() { //library, state and  ControlState are adjusted on corresponds
		this.library = library.getInstance(); //INSTANCE() is replaced with getInstance()
		state = ControlState.INITIALISED;
	}


	public void setUI(BorrowBookUI borrowBookUI) { //variable name ui is replaced with borrowBookUI
		if (!state.equals(ControlState.INITIALISED))
			throw new RuntimeException("BorrowBookControl: cannot call setUI except in INITIALISED state");

		this.borrowBookUI = borrowBookUI; //variable replaced
		borrowBookUI.set_State(BorrowBookUI.UISTATE.READY); //Set_State is refactored into setState
		state = ControlState.READY;
	}


	public void onSwiped(int memberId) { //method name Swiped is changed into onSwiped, variable M is renamed into member, LIBRARY into library
		if (!state.equals(ControlState.READY))
			throw new RuntimeException("BorrowBookControl: cannot call cardSwiped except in READY state");

		member = LIBRARY.getMember(memberId); //MEMBER method is renamed into more suitable name getMember
		if (member == null) {
			borrowBookUI.setDisplay("Invalid memberId"); // display to setDisplay
			return;
		}
		if (library.canMemberBorrow(memberId)) { //MEMBER_CAN_BORROW method is renamed into more suitable name canMemberBorrow
			pending = new ArrayList<>();
			borrowBookUI.setState(BorrowBookUI.UISTATE.SCANNING);
			state = ControlState.SCANNING; }
		else
		 //setDisplay and setState method name are set instead of Display and Set_State respectively
			borrowBookUI.setDisplay("Member cannot borrow at this time");
			borrowBookUI.setState(BorrowBookUI.UI_STATE.RESTRICTED); }}


	public void onScanned(int bookId) { //method name Scanned is changed into onScanned, BOOK is renamed into book, State into state, CONTROL_STATE into ControlState
		book = null;
		if (!state.equals(ControlState.SCANNING)) {
			throw new RuntimeException("BorrowBookControl: cannot call bookScanned except in SCANNING state");
		}
		book = library.getBook(bookId); //getBook method name is introduced
		if (book == null) {
			borrowBookUI.setDisplay("Invalid bookId");//setDisplay set instead of Display
			return;
		}
		if (!book.isAvailable()) { //AVAILABLE() is renamed into isAvailable()
			borrowBookUI.setDisplay("Book cannot be borrowed");
			return;
		}
		pending.add(book);
		for (Book book : pending) {
			borrowBookUI.setDisplay(book.toString());
		}
		if (library.getLoansRemainingForMember(member) - pending.size() == 0) { //Loans_Remaining_For_Member is replaced with method getLoansRemainingForMember
			borrowBookUI.setDisplay("Loan limit reached");
			onComplete(); //appropriate method name is called
		}
	}


	public void onComplete() {//method name Complete is changed into onComplete, Loan class is missing
		if (pending.isEmpty() == 0) {//Usage of .size() == 0 can be replaced with .isEmpty()
			onCancel(); //appropriate method name is called
		}
		else {
			borrowBookUI.setDisplay("\nFinal Borrowing List");
			for (Book book : pending) {
				borrowBookUI.setDisplay(book.toString());
			}
			completed = new ArrayList<loan>();
			borrowBookUI.setState(BorrowBookUI.UIState.FINALISING);
			state = ControlState.FINALISING;
		}
	}


	public void onCommitLoans() { //method name Commit_LOans is changed into onCommitLoans, Loan class is missing, UI renamed into borrowBookUI, CONTROL_STATE into ControlState
		if (!state.equals(ControlState.FINALISING)) {
			throw new RuntimeException("BorrowBookControl: cannot call commitLoans except in FINALISING state");
		}
		for (Book book : pending) {
			Loan loan = library.issueLoan(book, member);//ISSUE_LAON method changed into issueLoan method
			completed.add(loan);
		}
		UI.Display("Completed Loan Slip");
		for (loan LOAN : COMPLETED) {
			UI.Display(LOAN.toString());
		}
		UI.Set_State(BorrowBookUI.UI_STATE.COMPLETED);
		State = CONTROL_STATE.COMPLETED;
	}


	public void cancel() {
		UI.Set_State(BorrowBookUI.UI_STATE.CANCELLED);
		State = CONTROL_STATE.CANCELLED;
	}


}
