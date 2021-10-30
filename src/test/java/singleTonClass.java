
public class singleTonClass {
	
	private static singleTonClass singleTonClass=null;
	private singleTonClass()
	{
		
	}
	public static singleTonClass getInstance()
	{
		if(singleTonClass==null)
		{
			singleTonClass= new singleTonClass();
		}
		else
			return singleTonClass;
		return singleTonClass;
	}

}
