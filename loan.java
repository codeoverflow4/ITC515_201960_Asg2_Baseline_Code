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

	
	public boolean overDue() {//Change method name OVer_Due into overDue
		return loanState == LoanState.OVER_DUE;
	}

	
	public Integer getId() {//Change method name ID to getId
		return id;
	}


	public Date getDueDate() {//Rename Get_Due_Date into getDueDate
		return dueDate;// Apply dueDate name change
	}

	
	
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");//Rename SDF into simpleDateFormat for meaningful name

		StringBuilder stringBuilder = new StringBuilder();//Rename sb into stringBuilder for meaningful name
		stringBuilder.append("Loan:  ").append(getId()).append("\n")//Apply getId method name
		  .append("  Borrower ").append(member.getId()).append(" : ")//Apply getId method name for member
		  .append(member.getLastName()).append(", ").append(member.getFirstName()).append("\n")//Apply changed getFirstName,getLastName method for member
		  .append("  Book ").append(book.getBookId()).append(" : " )//Apply getBookId method name for book
		  .append(book.getTitle()).append("\n")//Apply getTitle method name for book
		  .append("  DueDate: ").append(simpleDateFormat.format(D)).append("\n")
		  .append("  State: ").append(loanState); // apply loanState name change	
		return stringBuilder.toString();
	}


	public member Member() {
		return member; //variable name changed M to member
	}


	public book Book() {
		return book; //variable name changed B to book
	}


	public void Discharge() {//Method name corrected as Discharge
		loanState = LoanState.DISCHARGED;	// apply loanState name change	
	}

}
