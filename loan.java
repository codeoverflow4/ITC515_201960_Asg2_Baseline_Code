/* 
Auther: Osanda
Reviewer : Ramitha
Mediator : Rushan
*/
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class loan implements Serializable {
	
	public static enum LoanState { CURRENT, OVER_DUE, DISCHARGED };// enum name change LOAN_STATE to LoanState
	
	private int loanId;//Change variable name ID into loanId
	private book book;//Change variable name B into book
	private member member;//Change variable name M into member
	private Date dueDate;//Change variable name D into dueDate
	private LoanState loanState; //Change variable name state into loanState

	
	public loan(int loanId, book book, member member, Date dueDate) {
		this.loanId = loanId; //Apply loanId name change 
		this.book = book;//Apply book name change 
		this.member = member;//Apply member name change 
		this.dueDate = dueDate;//Apply dueDate name change 
		this.loanState = LoanState.CURRENT;//Apply loanState name change 
	}

	
	public void checkOverDue() {
		if (loanState == LoanState.CURRENT &&
			Calendar.INSTANCE().Date().after(D)) {//Apply loanState name change 
			this.loanState = LoanState.OVER_DUE;	//Apply loanState name change 		
		}
	}

	
	public boolean OVer_Due() {
		return state == LOAN_STATE.OVER_DUE;
	}

	
	public Integer ID() {
		return ID;
	}


	public Date Get_Due_Date() {
		return D;
	}
	
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		StringBuilder sb = new StringBuilder();
		sb.append("Loan:  ").append(ID).append("\n")
		  .append("  Borrower ").append(M.GeT_ID()).append(" : ")
		  .append(M.Get_LastName()).append(", ").append(M.Get_FirstName()).append("\n")
		  .append("  Book ").append(B.ID()).append(" : " )
		  .append(B.TITLE()).append("\n")
		  .append("  DueDate: ").append(sdf.format(D)).append("\n")
		  .append("  State: ").append(state);		
		return sb.toString();
	}


	public member Member() {
		return M;
	}


	public book Book() {
		return B;
	}


	public void DiScHaRgE() {
		state = LOAN_STATE.DISCHARGED;		
	}

}
