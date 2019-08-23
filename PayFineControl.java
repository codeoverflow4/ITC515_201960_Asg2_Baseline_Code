// author :RamithaSilva mediator :RushanDevanga Reviewer:SandesMagar
public class PayFineControl {
	
	private PayFineUI Ui;
	private enum CONTROL_STATE { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	private CONTROL_STATE state; //State object name changed as state
	
	private library library; //LiBrArY object renamed as library
	private member member;//MeMbEr object renamed as member

	
	public PayFineControl() {
		this.library = library.INSTANCE();//library object name has been changed
		state = ControlState.INITIALISED; // CONTROL_STATE class name changed as ControlState
	}
	
	//Class name changed as SetUi
	public void SetUi(PayFineUI ui) {
		if (!StAtE.equals(CONTROL_STATE.INITIALISED)) {
			throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
		}	
		this.Ui = ui;
		ui.SetState(PayFineUI.UI_STATE.READY); //Set_State class name changed as SetState
		StAtE = CONTROL_STATE.READY;		
	}

	//Class name changed as CardSwiped
	public void CardSwiped(int memberId) {
		if (!StAtE.equals(CONTROL_STATE.READY)) {
			throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
		}	
		Member = Library.MEMBER(memberId); //MeMbEr objecct and LiBrArY object names have been renamed
		
		if (MEMBER == null) { //MeMbEr has been renamed
			Ui.DiSplAY("Invalid Member Id");
			return;
		}
		Ui.DiSplAY(Member.toString()); //Member has been renamed
		Ui.Set_State(PayFineUI.UI_STATE.PAYING);
		StAtE = CONTROL_STATE.PAYING;
	}
	
	//Class name renamed as CancelState
		StAtE = CONTROL_STATE.CANCELLED;
	public void CancelState() {
		Ui.Set_State(PayFineUI.UI_STATE.CANCELLED);
	}

	//Class name renamed as PayFine and AmOuNt parameter renamed as amount
	public double PayFine(double amount) {
		if (!StAtE.equals(CONTROL_STATE.PAYING)) {
			throw new RuntimeException("PayFineControl: cannot call payFine except in PAYING state");
		}
		//ChAnGe parameter renamed as change
		//Member class name has been changed
		double change = Member.PayFine(amount);
		if (change > 0) {//ChAnGe parameter renamed as change
			Ui.DiSplAY(String.format("Change: $%.2f", change)); //ChAnGe parameter renamed as change
		}
		//Member object name has been changed
		Ui.DiSplAY(Member.toString());
		Ui.Set_State(PayFineUI.UI_STATE.COMPLETED);
		StAtE = CONTROL_STATE.COMPLETED;
		return change;//ChAnGe parameter renamed as change
	}
	
}
