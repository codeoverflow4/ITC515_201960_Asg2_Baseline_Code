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


	public BorrowBookControl() {
		this.LIBRARY = LIBRARY.INSTANCE();
		State = CONTROL_STATE.INITIALISED;
	}


	public void setUI(BorrowBookUI ui) {
		if (!State.equals(CONTROL_STATE.INITIALISED))
			throw new RuntimeException("BorrowBookControl: cannot call setUI except in INITIALISED state");

		this.UI = ui;
		ui.Set_State(BorrowBookUI.UI_STATE.READY);
		State = CONTROL_STATE.READY;
	}


	public void Swiped(int MEMMER_ID) {
		if (!State.equals(CONTROL_STATE.READY))
			throw new RuntimeException("BorrowBookControl: cannot call cardSwiped except in READY state");

		M = LIBRARY.MEMBER(MEMMER_ID);
		if (M == null) {
			UI.Display("Invalid memberId");
			return;
		}
		if (LIBRARY.MEMBER_CAN_BORROW(M)) {
			PENDING = new ArrayList<>();
			UI.Set_State(BorrowBookUI.UI_STATE.SCANNING);
			State = CONTROL_STATE.SCANNING; }
		else
		{
			UI.Display("Member cannot borrow at this time");
			UI.Set_State(BorrowBookUI.UI_STATE.RESTRICTED); }}


	public void Scanned(int bookId) {
		BOOK = null;
		if (!State.equals(CONTROL_STATE.SCANNING)) {
			throw new RuntimeException("BorrowBookControl: cannot call bookScanned except in SCANNING state");
		}
		BOOK = LIBRARY.Book(bookId);
		if (BOOK == null) {
			UI.Display("Invalid bookId");
			return;
		}
		if (!BOOK.AVAILABLE()) {
			UI.Display("Book cannot be borrowed");
			return;
		}
		PENDING.add(BOOK);
		for (book B : PENDING) {
			UI.Display(B.toString());
		}
		if (LIBRARY.Loans_Remaining_For_Member(M) - PENDING.size() == 0) {
			UI.Display("Loan limit reached");
			Complete();
		}
	}


	public void Complete() {
		if (PENDING.size() == 0) {
			cancel();
		}
		else {
			UI.Display("\nFinal Borrowing List");
			for (book B : PENDING) {
				UI.Display(B.toString());
			}
			COMPLETED = new ArrayList<loan>();
			UI.Set_State(BorrowBookUI.UI_STATE.FINALISING);
			State = CONTROL_STATE.FINALISING;
		}
	}


	public void Commit_LOans() {
		if (!State.equals(CONTROL_STATE.FINALISING)) {
			throw new RuntimeException("BorrowBookControl: cannot call commitLoans except in FINALISING state");
		}
		for (book B : PENDING) {
			loan LOAN = LIBRARY.ISSUE_LAON(B, M);
			COMPLETED.add(LOAN);
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
