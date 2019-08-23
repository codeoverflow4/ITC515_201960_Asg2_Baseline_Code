//Author -Rushan Mediator- Sandesh , Reviewer - osanda

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")

// library change into Library should be meaningful, all upper case, and underscore separated. 
public class library implements Serializable {
	
	//libraryFile change into LIBRARY_FILE
	private static final String LIBRARY_FILE = "library.obj";
	//libraryFile change into LOAN_LIMIT
	private static final int LOAN_LIMIT = 2;
	//libraryFile change into LOAN_PERIOD
	private static final int LOAN_PERIOD = 2;
	//libraryFile change into FINE_PER_DATE
	private static final double FINE_PER_DATE = 1.0;
	//libraryFile change into MAX_FINES_OWED
	private static final double MAX_FINES_OWED = 1.0;
	//libraryFile change into DAMAGE_FEE
	private static final double DAMAGE_FEE = 2.0;
	
	private static library self;
	//BOOK_ID change into bookId
	private int bookId;
	//MEMBER_ID change into memberId
	private int memberId;
	//LOAN_ID change into loan_Id
	private int loan_Id;
	//LOAN_DATE change loadDate
	private Date loadDate;
	
	private Map<Integer, book> CATALOG;
	private Map<Integer, member> MEMBERS;
	private Map<Integer, loan> LOANS;
	private Map<Integer, loan> CURRENT_LOANS;
	private Map<Integer, book> DAMAGED_BOOKS;
	

	private library() {
 		//CATALOG change into catalog
		catalog = new HashMap<>();
 		//MEMBERS change into members
		members = new HashMap<>();
		//LOANS change into loans
		loans = new HashMap<>();
		//change into currentState
		currentState = new HashMap<>();
		//damagedBooks
		damagedBooks = new HashMap<>();
		//bookId
		bookId = 1;
		//MemberId
		MemberId = 1;	
		//LoadId
		LoadId = 1;		
	}

	
	public static synchronized library INSTANCE() {	
		//SeLf change into self
		if (self == null) {
			
			//PATH change into path
			Path path = path.get(libraryFile);			
			if (Files.exists(PATH)) {	
				try (ObjectInputStream LiF = new ObjectInputStream(new FileInputStream(libraryFile));) {
			    
					//SeLf change into self
					self = (library) LiF.readObject();
					//Calendar change into calendar and Set_dATE change into setDate and LOAN_DATE change into loanDate
					calendar.INSTANCE().setDate(SeLf.loanDate);
					LiF.close();
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			//SeLf change into self
			else self = new library();
		}
		//SeLf change into self
		return self;
	}

	
	public static synchronized void SAVE() {
		//changed SeLf Into self
		if (self != null) {
			// changed SeLf Into self and LOAN_DATE change into loanDate
			SeLf.LOAN_DATE = Calendar.INSTANCE().Date();
			try (ObjectOutputStream LoF = new ObjectOutputStream(new FileOutputStream(libraryFile));) {
				LoF.writeObject(SeLf);
				LoF.flush();
				LoF.close();	
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	//BookID change into bookId
	public int bookId() {
		return BOOK_ID;
	}
	
	
	public int memberId() {
		//MEMBER_ID change into memberId
		return MEMBER_ID;
	}
	
	//NextBID change into nextBid
	private int NextBID() {
	
		return BOOK_ID++;
	}

	//NextMID change into nextMid
	private int nextMid() {
		//MEMBER_ID change into memberId
		return MEMBER_ID++;
	}

	//NextLID change into nextLid
	private int nextLid() {
		
		return LOAN_ID++;
	}

	
	public List<member> MEMBERS() {		
		return new ArrayList<member>(MEMBERS.values()); 
	}


	public List<book> BOOKS() {		
		return new ArrayList<book>(CATALOG.values()); 
	}


	public List<loan> CurrentLoans() {
		return new ArrayList<loan>(CURRENT_LOANS.values());
	}


	public member Add_mem(String lastName, String firstName, String email, int phoneNo) {		
		member member = new member(lastName, firstName, email, phoneNo, NextMID());
		MEMBERS.put(member.GeT_ID(), member);		
		return member;
	}

	//Add_book change ito AddBook
	public book AddBook(String a, String t, String c) {		
		book b = new book(a, t, c, NextBID());
		CATALOG.put(b.ID(), b);		
		return b;
	}

	//MEMBER change ito Member
	public member Member(int memberId) {
		if (MEMBERS.containsKey(memberId)) 
			return MEMBERS.get(memberId);
		return null;
	}

	
	public book Book(int bookId) {
		if (CATALOG.containsKey(bookId)) 
			return CATALOG.get(bookId);		
		return null;
	}

	//LOAN_LIMIT change into LoanLimit
	public int LoanLimit() {
		return loanLimit;
	}

	
	public boolean MEMBER_CAN_BORROW(member member) {		
		if (member.Number_Of_Current_Loans() == loanLimit ) 
			return false;
				
		if (member.Fines_OwEd() >= maxFinesOwed) 
			return false;
				
		for (loan loan : member.GeT_LoAnS()) 
			if (loan.OVer_Due()) 
				return false;
			
		return true;
	}

	
	public int Loans_Remaining_For_Member(member member) {		
		return loanLimit - member.Number_Of_Current_Loans();
	}

	
	public loan ISSUE_LAON(book book, member member) {
		Date dueDate = Calendar.INSTANCE().Due_Date(loanPeriod);
		loan loan = new loan(NextLID(), book, member, dueDate);
		member.Take_Out_Loan(loan);
		book.Borrow();
		LOANS.put(loan.ID(), loan);
		CURRENT_LOANS.put(book.ID(), loan);
		return loan;
	}
	
	
	public loan LOAN_BY_BOOK_ID(int bookId) {
		if (CURRENT_LOANS.containsKey(bookId)) {
			return CURRENT_LOANS.get(bookId);
		}
		return null;
	}

	
	public double CalculateOverDueFine(loan loan) {
		if (loan.OVer_Due()) {
			long daysOverDue = Calendar.INSTANCE().Get_Days_Difference(loan.Get_Due_Date());
			double fine = daysOverDue * finePerDay;
			return fine;
		}
		return 0.0;		
	}


	public void Discharge_loan(loan currentLoan, boolean isDamaged) {
		member member = currentLoan.Member();
		book book  = currentLoan.Book();
		
		double overDueFine = CalculateOverDueFine(currentLoan);
		member.Add_Fine(overDueFine);	
		
		member.dIsChArGeLoAn(currentLoan);
		book.Return(isDamaged);
		if (isDamaged) {
			member.Add_Fine(damageFee);
			DAMAGED_BOOKS.put(book.ID(), book);
		}
		currentLoan.DiScHaRgE();
		CURRENT_LOANS.remove(book.ID());
	}


	public void checkCurrentLoans() {
		for (loan loan : CURRENT_LOANS.values()) {
			loan.checkOverDue();
		}		
	}


	public void Repair_BOOK(book currentBook) {
		if (DAMAGED_BOOKS.containsKey(currentBook.ID())) {
			currentBook.Repair();
			DAMAGED_BOOKS.remove(currentBook.ID());
		}
		else {
			throw new RuntimeException("Library: repairBook: book is not damaged");
		}
		
	}
	
	
}
