
package bean;

public class Getset {

		String EMP_id;
		String password;
		String desig;
		String ques;
		String ans;
		public String getQues() {
			return ques;
		}
		public void setQues(String ques) {
			this.ques = ques;
			System.out.println(ques);
		}
		public String getAns() {
			return ans;
		}
		public void setAns(String ans) {
			this.ans = ans;
		}
		public void setId(String n)
		{
			EMP_id=n;
		}
		public void setPass(String p)
		{
			password=p;
		}
		public void setDesig(String d)
		{
			desig=d;
		}
		public String getId()
		{
			return EMP_id;
		}
		public String getPass()
		{
			return password;
		}
		public String getDesig()
		{
			return desig;
		}
		

	}

