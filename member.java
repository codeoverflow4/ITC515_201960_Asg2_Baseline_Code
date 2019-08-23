/* 
Auther: Osanda
Reviewer : Sandesh
Mediator : Rushan
*/
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class member implements Serializable {

	private String lastName;//LN change into lastName for give meaningful name
	private String firstName;//LN change into lastName for give meaningful name
	private String email;//EM change into email for give meaningful name
	private int phoneNo;//PN change into phoneNo for give meaningful name
	private int id;//ID change into id 
	private double fines;//FINES change into lowercase letters
	
	private Map<Integer, loan> loanNumbers;//Change LNS into loanNumbers for give meaning

	
	public member(String lastName, String firstName, String email, int phoneNo, int id) {
		this.lastName = lastName;//Apply name change
		this.firstName = firstName;//Apply name change
		this.email = email;//Apply name change
		this.phoneNo = phoneNo;//Apply name change
		this.id = id;//Apply name change
		
		this.loanNumbers = new HashMap<>();//Apply name change
	}

	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();//Change sb into stringBuilder
		sb.append("Member:  ").append(id).append("\n")// Apply changed name id 
		  .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n")// Apply changed name lastName and firstName
		  .append("  Email: ").append(email).append("\n")// Apply changed name email
		  .append("  Phone: ").append(phoneNo)// Apply changed name phoneNo
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", fines))// Apply changed name fines
		  .append("\n");
		
		for (loan loan : loanNumbers.values()) {//correct the variable name loAn inti loan
			stringBuilder.append(loan).append("\n");//correct the variable name loAn inti loan
		}		  
		return stringBuilder.toString();
	}

	
	public int getId() {//Change method Get_ID into getId
		return id;
	}

	
	public List<loan> getLoans() {//Change method GeT_LoAnS into getLoans
		return new ArrayList<loan>(loanNumbers.values());
	}

	
	public int noOfCurrentLoans() {//Change method Number_Of_Current_Loans into noOfCurrentLoans
		return loanNumbers.size();
	}

	
	public double finesOwned() {//Change method Fines_OwEd into finesOwned
		return fines;
	}

	
	public void takeOutLoan(loan loan) {//Change method Take_Out_Loan into takeOutLoan
		if (!loanNumbers.containsKey(loan.ID())) {
			loan.put(loan.getId(), loan);
		}
		else {
			throw new RuntimeException("Duplicate loan added to member");
		}		
	}

	
	public String getLastName() {//Change method Get_LastName into getLastName
		return lastName;
	}

	
	public String Get_FirstName() {//Change method Get_FirstName into getFirstName
		return firstName;
	}


	public void Add_Fine(double fine) {//Change method Add_Fine into addFine
		fine += fine;
	}
	
	public double Pay_Fine(double amount) {//Change method Pay_Fine into payFine,change variable amount
		if (amount < 0) {
			throw new RuntimeException("Member.payFine: amount must be positive");
		}
		double change = 0;
		if (amount > fines) {//Apply name changes to amount and fines
			change = amount - fines;
			fines = 0;
		}
		else {
			fines -= amount;
		}
		return change;
	}


	public void dischargeLoan(loan loan) {//Change method dIsChArGeLoAn into dischargeLoan
		if (loanNumbers.containsKey(loan.getId())) {
			loanNumbers.remove(loan.getId());
		}
		else {
			throw new RuntimeException("No such loan held by member");
		}		
	}

}
