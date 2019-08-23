//Author -Rushan Mediator- Sandesh , Reviewer - Ramitha
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	//SeLf change as a self cause All variable names are to start with a lowercase letter and to be in camelBack. 
	private static Calendar self;
	//CaLeNdAr change as a calendar
	private static java.util.Calendar calendar;
	
	
	private calendar() {
		//CaLeNdAr change as a calendar 
		calendar = java.util.Calendar.getInstance();
	}
	
	public static Calendar INSTANCE() {
		//SeLf change into self
		if (self == null) {
			//SeLf change into self
			self = new Calendar();
		}
		//SeLf change into self
		return self;
	}
	
	public void incrementDate(int days) {
		//CaLeNdAr change into calendar
		calendar.add(java.util.Calendar.DATE, days);		
	}
	//Set_dATE change into setDate
	public synchronized void setDate(Date date) {
		try {
			//CaLeNdAr change into calender
			calender.setTime(date);
			//CaLeNdAr change into calender
	        calender.set(java.util.Calendar.HOUR_OF_DAY, 0);  
			//CaLeNdAr change into calender
	        calender.set(java.util.Calendar.MINUTE, 0);  
			//CaLeNdAr change into calender
	        calender.set(java.util.Calendar.SECOND, 0);  
			//CaLeNdAr change into calender
	        calender.set(java.util.Calendar.MILLISECOND, 0);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	//
	public synchronized Date Date() {
		try {
			//all statement updated with calender intead of CaLeNdAr
	        calender.set(java.util.Calendar.HOUR_OF_DAY, 0);  
	        calender.set(java.util.Calendar.MINUTE, 0);  
	        calender.set(java.util.Calendar.SECOND, 0);  
	        calender.set(java.util.Calendar.MILLISECOND, 0);
			return CaLeNdAr.getTime();
			//until this place
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
              //Due_Date change into dueDate 
	public synchronized Date dueDate(int loanPeriod) {
		Date NoW = Date();
		//CaLeNdAr change into calender
		calender.add(java.util.Calendar.DATE, loanPeriod);
		// Due_Date change into dueDate  and CaLeNdAr change into calender
		Date dueDate = CaLeNdAr.getTime();
		//CaLeNdAr change into calender
		calender.setTime(NoW);
		 //DuEdAtE change into dueDate 
		return dueDate;
	}
	
	public synchronized long Get_Days_Difference(Date targetDate) {
		
		long Diff_Millis = Date().getTime() - targetDate.getTime();
	    long Diff_Days = TimeUnit.DAYS.convert(Diff_Millis, TimeUnit.MILLISECONDS);
	    return Diff_Days;
	}

}
