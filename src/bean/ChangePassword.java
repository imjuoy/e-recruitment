package bean;

public class ChangePassword {

	String oldpwd ;
	String newpwd;
	String confpwd;
	String id;
	String security_question;
	String answer;
	String newpass;
	String conpass;
	public void setId(String n)
	{
		id=n;
	}
	public void setoldPwd(String o)
	{
		oldpwd=o;
	}
	public void setnewPwd(String n)
	{
		newpwd=n;
		
	}
	public void setconfPwd(String c)
	{
		confpwd=c;
	}
	public void setQues(String q)
	{
		security_question=q;
	}
	public void setAns(String a)
	{
		answer=a;
	}
	public void setNewpass(String n)
	{
		newpass=n;
	}
	public void setConpass(String o)
	{
		conpass=o;
	}

	public String getId()
	{
		//System.out.println("this from bean"+id);
		return id;
		
	}
	
	public String getoldPwd()
	{
		return oldpwd;
	}
	public String getnewPwd()
	{
		return newpwd;
	}
	public String getconfPwd()
	{
		return confpwd;
	}
	public String getQues()
	{
		return security_question;
	}
	public String getAns()
	{
		return answer;
}
	public String getNewpass()
	{
		return newpass;
	}
	public String getConpass()
	{
		return conpass;
	}
}
