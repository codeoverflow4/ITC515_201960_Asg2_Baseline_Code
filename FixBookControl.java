/* 
Auther: Osanda
Reviewer : Sandesh
Mediator : Rushan
*/
public class FixBookControl {
	
	private FixBookUI fixBookUI; //UI renamed to fixBookUI
	private enum ControlState { INITIALISED, READY, FIXING };// enum CONTROL_STATE renamed to ControlState
	private ControlState controlState;// StAtE renamed to controlState
	
	private library library; //Lib renamed to library for give meaningful name
	private book currentBook;//Cur_Book renamed to currentBook for give meaningful name, removed Underscore


	public FixBookControl() {
		this.library = library.INSTANCE();//Apply variable,enum name changes
		controlState = ControlState.INITIALISED;//Apply variable,enum name changes
	}
	
	
	
	public void SetFixBookUI(FixBookUI fixBookUI) {//Apply name changes,Method name change to SetFixBookUI
		if (!controlState.equals(ControlState.INITIALISED)) {//Apply name changes
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
		}	
		this.UI = ui;
		ui.SetState(FixBookUI.FixBookUISTATE.READY);//removed Underscore from Set_State and renamed UI_STATE to FixBookUISTATE
		controlState = ControlState.READY;//Apply name changes		
	}


	public void BookScanned(int bookId) {//Rename Book_scanned to remove Underscore
		if (!controlState.equals(ControlState.READY)) {
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
		}	
		currentBook = library.Book(bookId);//Apply name changes	
		
		if (currentBook == null) {//Apply name changes	
			UI.display("Invalid bookId");
			return;
		}
		if (!currentBook.isDamaged()) {//Apply name changes, rename IS_Damaged() to isDamaged()
			UI.display("Book has not been damaged");
			return;
		}
		UI.display(currentBook.toString());//Apply name changes
		UI.setState(FixBookUI.UI_STATE.FIXING);// Rename Set_State into setState to remove Underscore
		controlState = ControlState.FIXING;//Apply name changes		
	}


	public void FIX_Book(boolean MUST_fix) {
		if (!StAtE.equals(CONTROL_STATE.FIXING)) {
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
		}	
		if (MUST_fix) {
			LIB.Repair_BOOK(Cur_Book);
		}
		Cur_Book = null;
		UI.Set_State(FixBookUI.UI_STATE.READY);
		StAtE = CONTROL_STATE.READY;		
	}

	
	public void SCannING_COMplete() {
		if (!StAtE.equals(CONTROL_STATE.READY)) {
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
		}	
		UI.Set_State(FixBookUI.UI_STATE.COMPLETED);		
	}






}
