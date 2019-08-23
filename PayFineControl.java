// author :RamithaSilva mediator :RushanDevanga Reviewer:SandesMagar
public class PayFineControl {
	
	private PayFineUI Ui;
	private enum CONTROL_STATE { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };
	private CONTROL_STATE StAtE;
	
	private library Library; //LiBrArY object renamed as Library
	private member Member;//MeMbEr object renamed as Member

	//Library object name has been changed
	public PayFineControl() {
		this.Library = Library.INSTANCE();
		StAtE = CONTROL_STATE.INITIALISED;
	}
	
	//Class name changed as SetUi
	public void SetUi(PayFineUI ui) {
		if (!StAtE.equals(CONTROL_STATE.INITIALISED)) {
			throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
		}	
		this.Ui = ui;
		ui.Set_State(PayFineUI.UI_STATE.READY);
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
	public void CancelState() {
		Ui.Set_State(PayFineUI.UI_STATE.CANCELLED);
		StAtE = CONTROL_STATE.CANCELLED;
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
