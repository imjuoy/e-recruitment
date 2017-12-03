package util;

public class FormatOutput {

	public String formatText(String TXT, String KEY){
	if(KEY.length()>0)
	{
		String outTXT="";
		String upTXT = TXT.toUpperCase();
		String upKEY = KEY.toUpperCase();
		char c ='\0';
		int i = 0;
		String heythere= "heythere";
		//System.out.println(upKEY.length());
		int pos[] = new int[upKEY.length()];
		
		for(i=0;i<upKEY.length();i++)
		{  
			c = upKEY.charAt(i);
			pos[i]=upTXT.indexOf(c);
		}
		//System.out.println(pos[0]);
		//System.out.println(pos[1]);
		int h=0;
		//System.out.println("h value outside loop="+h);
	
		for(i=0;i<TXT.length();i++)
		{  
			//System.out.println("h value="+h);
		//	System.out.println(pos[h]);
			if(i==pos[h])
			{
				//System.out.println("outTXT value = "+outTXT);
				outTXT = outTXT + "<span style='font-weight:bold;color:#ae0404;'>" + TXT.charAt(i) + "</span>";
				if(h<upKEY.length()-1)
				{
					h++;
				}
				
				
			}
			else
			{
				outTXT = outTXT + TXT.charAt(i);
				//System.out.println("outTXT value = "+outTXT);
			}
		}
		
		return outTXT;
	}
	else return TXT;
}
}
