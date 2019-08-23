/* 
Auther: Osanda
Reviewer : Rushan
Mediator : Ramitha
*/
public class FixBookControl {
	
	private FixBookUI ui;//variable name changed
	private enum ControlState { INITIALISED, READY, FIXING };//Enum chaged to CamelBack
	private ControlState controlState;//variable name changed and removed the underscore separater 
	
	private library library;//variable name changed 
	private book currentBook;//variable name changed


	public FixBookControl() {
		this.library = library.INSTANCE();
		controlState = ControlState.INITIALISED;//
	}
	
	
	public void SetUi(FixBookUI ui) {
		if (!controlState.equals(ControlState.INITIALISED)) {//Fix name issue in StAtE
			throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
		}	
		this.UI = ui;
		ui.setState(FixBookUI.uiState.READY);//Fixed the Set_State into setState
		controlState = ControlState.READY;	//Fix name issue in StAtE	
	}


	public void Book_scanned(int bookId) {
		if (!controlState.equals(ControlState.READY)) {	//Fix name issue in StAtE	
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
		}	
		currentBook = library.Book(bookId);// Changed currentBook and library
		
		if (currentBook == null) {
			UI.display("Invalid bookId");
			return;
		}
		if (!currentBook.isDamaged()) {//fix IS_Damaged into is isDamaged
			UI.display("Book has not been damaged");
			return;
		}
		UI.display(currentBook.toString());// Apply currentBook
		UI.setState(FixBookUI.UI_STATE.FIXING); 
		controlState = ControlState.FIXING;		
	}


	public void fixBook(boolean mustFix) {// Change Fix_Book into fixBook and variable MUSt_Fix into mustFix
		if (!controlState.equals(ControlState.FIXING)) {
			throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
		}	
		if (mustFix) {
			library.repairBOOK(currentBook);// Change Repair_BOOK into fixBook
		}
		currentBook = null;//Apply currentBook
		UI.setState(FixBookUI.UI_STATE.READY);//Apply setState change
		controlState = ControlState.READY;	//Apply controlState change
	}

	
	public void scanningComplete() {//Method name SCannING_COMplete fixed 
		if (!controlState.equals(ControlState.READY)) {//Apply controlState change
			throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
		}	
		UI.setState(FixBookUI.UI_STATE.COMPLETED);	//Apply controlState change	
	}






}
