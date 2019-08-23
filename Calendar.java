//Author -Rushan Mediator- Sandesh , Reviewer - Ramitha
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	//SeLf change as a self cause All variable names are to start with a lowercase letter and to be in camelBack. 
	private static Calendar SeLf;
	//CaLeNdAr change as a calendar
	private static java.util.Calendar CaLeNdAr;
	
	
	private Calendar() {
		//CaLeNdAr change as a calendar 
		CaLeNdAr = java.util.Calendar.getInstance();
	}
	
	public static Calendar INSTANCE() {
		//SeLf change into self
		if (SeLf == null) {
			//SeLf change into self
			SeLf = new Calendar();
		}
		//SeLf change into self
		return SeLf;
	}
	
	public void incrementDate(int days) {
		//CaLeNdAr change into calendar
		CaLeNdAr.add(java.util.Calendar.DATE, days);		
	}
	//Set_dATE change into setDate
	public synchronized void Set_dATE(Date date) {
		try {
			//CaLeNdAr change into calender
			CaLeNdAr.setTime(date);
			//CaLeNdAr change into calender
	        CaLeNdAr.set(java.util.Calendar.HOUR_OF_DAY, 0);  
			//CaLeNdAr change into calender
	        CaLeNdAr.set(java.util.Calendar.MINUTE, 0);  
			//CaLeNdAr change into calender
	        CaLeNdAr.set(java.util.Calendar.SECOND, 0);  
			//CaLeNdAr change into calender
	        CaLeNdAr.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	//
	public synchronized Date Date() {
		try {
			//all statement updated with calender intead of CaLeNdAr
	        CaLeNdAr.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        CaLeNdAr.set(java.util.Calendar.MINUTE, 0);  
	        CaLeNdAr.set(java.util.Calendar.SECOND, 0);  
	        CaLeNdAr.set(java.util.Calendar.MILLISECOND, 0);
			return CaLeNdAr.getTime();
			//until this place
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
              //Due_Date change into dueDate 
	public synchronized Date Due_Date(int loanPeriod) {
		Date NoW = Date();
		//CaLeNdAr change into calender
		CaLeNdAr.add(java.util.Calendar.DATE, loanPeriod);
		// Due_Date change into dueDate  and CaLeNdAr change into calender
		Date DuEdAtE = CaLeNdAr.getTime();
		//CaLeNdAr change into calender
		CaLeNdAr.setTime(NoW);
		 //DuEdAtE change into dueDate 
		return DuEdAtE;
	}
	
	public synchronized long Get_Days_Difference(Date targetDate) {
		
		long Diff_Millis = Date().getTime() - targetDate.getTime();
	    long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    return Diff_Days;
	}

}
