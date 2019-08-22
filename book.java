import java.io.Serializable;

/**
Author: Sandesh Magar
Mediator: Rushan Devanga
Reviewer: Osanda Ranaweera
**/

@SuppressWarnings("serial")
public class Book implements Serializable { //changed book into Book
/** changing variables from UPPERCASE into LOWERCASE**/

	private String title;
	private String author;
	private String callNo;
	private int id;

	private enum State { AVAILABLE, ON_LOAN, DAMAGED, RESERVED }; //modified to State from STATE
	private State state;

//lowercased all the variables
	public Book(String author, String title, String callNo, int id) {
		this.author = author;
		this.title = title;
		this.callNo = callNo;
		this.id = id;
		this.state = State.AVAILABLE;
	}
//lowercasing variable of class toString methods and changed sb variable name to stringBuilder
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Book: ").append(id).append("\n")
		  .append("  Title:  ").append(title).append("\n")
		  .append("  Author: ").append(author).append("\n")
		  .append("  CallNo: ").append(callNo).append("\n")
		  .append("  State:  ").append(state);

		return stringBuilder.toString();
	}

	public int getId() { //Integer into int and getId addded
		return id;
	}

	public String getTitle() { //lowercase and getTitle added
		return title;
	}

	public boolean isAvailable() { // method name changed and return statement adjusted
		return state == State.AVAILABLE;
	}

//method name On_loan() changed to onloan() and return statement adjusted
	public boolean onloan() {
		return state == State.ON_LOAN;
	}

//method name IS_Damanged() changed to isDamanged() and return statement adjusted.
	public boolean isDamaged() {
		return State == State.DAMAGED;
	}


	public void Borrow() {
		if (State.equals(STATE.AVAILABLE)) {
			State = STATE.ON_LOAN;
		}
		else {
			throw new RuntimeException(String.format("Book: cannot borrow while book is in state: %s", State));
		}

	}


	public void Return(boolean DAMAGED) {
		if (State.equals(STATE.ON_LOAN)) {
			if (DAMAGED) {
				State = STATE.DAMAGED;
			}
			else {
				State = STATE.AVAILABLE;
			}
		}
		else {
			throw new RuntimeException(String.format("Book: cannot Return while book is in state: %s", State));
		}
	}


	public void Repair() {
		if (State.equals(STATE.DAMAGED)) {
			State = STATE.AVAILABLE;
		}
		else {
			throw new RuntimeException(String.format("Book: cannot repair while book is in state: %s", State));
		}
	}


}
