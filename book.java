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

	public Integer ID() {
		return ID;
	}

	public String TITLE() {
		return TITLE;
	}



	public boolean AVAILABLE() {
		return State == STATE.AVAILABLE;
	}


	public boolean On_loan() {
		return State == STATE.ON_LOAN;
	}


	public boolean IS_Damaged() {
		return State == STATE.DAMAGED;
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
