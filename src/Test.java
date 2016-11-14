
import edu.lstc.dao.SalaryDao;

public class Test {
	public static void main(String args[])	{
		//001	aaa	01	男	经理	在职	1234567890 123456789	123456
	//	Worker w = new Worker("999","zz","01","男","经理","在职","1234","123");
		//Worker w = new Worker("123",'zz','01','男','经理','在职','1234','123');
		//new WorkerDao().SetBean(w);
		
		//new WorkerDao().UpdateName("001","sb");
		
		//new WorkerDao().UpdateDepartment("001","99");
		/*new WorkerDao().UpdatePost("01","001","boss");
		*/
		float f = 10;
		new SalaryDao().UpdateChecking("001", f);
		//System.out.println("OK 6");
		
		String workerno = null;
		workerno = "123";
		System.out.println(!workerno.equals(null));
	}
}
