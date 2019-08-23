// author :RamithaSilva mediator :RushanDevanga Reviewer:OsandaRanawera
public class ReturnBookControl {

	private ReturnBookUI Ui;
	private enum CONTROL_STATE { INITIALISED, READY, INSPECTING };
	private ControlState sTaTe;//CONTROL_STATE class name changed as ControlState //State object name changed as state
	
	private library library; //Object  name changed as library
	private loan currentLoan; //Object  name changed as currentLoan
	

	public ReturnBookControl() {
		this.lIbRaRy = lIbRaRy.INSTANCE(); //Object  name changed as library
		state = CONTROL_STATE.INITIALISED; //State name has changed 
	}
	
	//class name changed as SetUi
	public void SetUi (ReturnBookUI ui) {
		if (!sTaTe.equals(CONTROL_STATE.INITIALISED)) {
			throw new RuntimeException("ReturnBookControl: cannot call setUI except in INITIALISED state");
		}	
		this.Ui = ui;
		ui.Set_State(ReturnBookUI.UI_STATE.READY);
		State = CONTROL_STATE.READY;	//State name has changed	
	}

	//Class name has changed as BookScanned
	public void BookScanned(int Book_ID) {
		if (!state.equals(CONTROL_STATE.READY)) {//State object name changed as state
			throw new RuntimeException("ReturnBookControl: cannot call bookScanned except in READY state");
		}	
		book currentBook = library.Book(Book_ID); //library name changed //CUR_book named as currentBook
		
		if (currentBook == null) {//CUR_book named as currentBook
			Ui.display("Invalid Book Id");
			return;
		}
		if (!currentBook.On_loan()) {//CUR_book named as currentBook
			Ui.display("Book has not been borrowed");
			return;
		}		
		currentLoan = library.LOAN_BY_BOOK_ID(Book_ID);//object names has been changed
		double Over_Due_Fine = 0.0;
		if (currentLoan.Over_Due()) {//object names has been changed as currentLoan
			Over_Due_Fine = lIbRaRy.CalculateOverDueFine(currentLoan);//parameter name has changed
		}
		Ui.display("Inspecting");
		Ui.display(CUR_book.toString());
		Ui.display(currentLoan.toString());
		
		if (currentLoan.Over_Due()) {//object names has been changed as currentLoan and Over_Due
			Ui.display(String.format("\nOverdue fine : $%.2f", Over_Due_Fine));
		}
		Ui.Set_State(ReturnBookUI.UI_STATE.INSPECTING);
		state = CONTROL_STATE.INSPECTING;//object name has changed as state		
	}

	//Class name has changed as ScanningComplete
	public void ScanningComplete() {
		if (!sTaTe.equals(CONTROL_STATE.READY)) {
			throw new RuntimeException("ReturnBookControl: cannot call scanningComplete except in READY state");
		}	
		Ui.Set_State(ReturnBookUI.UI_STATE.COMPLETED);		
	}

	//Class name has changed as DischargeLoan
	public void DischargeLoan(boolean isDamaged) {
		if (!sTaTe.equals(CONTROL_STATE.INSPECTING)) {
			throw new RuntimeException("ReturnBookControl: cannot call dischargeLoan except in INSPECTING state");
		}	
		library.Discharge_loan(currentLoan, isDamaged);//object and parameter names has changed as library and currentloan
		currentLoan = null;
		Ui.Set_State(ReturnBookUI.UI_STATE.READY);
		state = CONTROL_STATE.READY;				
	}


}
