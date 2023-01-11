import javax.swing.JOptionPane;
public class Fraction 
{

	int deno;
	int num;
	Fraction()
	{
		num=1;
		deno=1;
	}
	Fraction(int n,int d)
	{
		num=n;
		deno=d;
		
	}
	Fraction(String Frac) throws FractionException,NumberFormatException
	{
		String a[]=Frac.split("/");
		if(a.length!=2)
		{throw new FractionException("Format should be 1/2");}
		this.num=Integer.parseInt(a[0]);
		this.deno=Integer.parseInt(a[1]);
		if(this.deno==0)
		{
			throw new FractionException("Denominator cant be zero");
		}
	}
	void getFraction()
	{ 
		String numerator=JOptionPane.showInputDialog("Enter Numerator: ");	
		String denominator=JOptionPane.showInputDialog("Enter Denominator: ");
		num=Integer.parseInt(numerator);
		deno=Integer.parseInt(denominator);
		
	}
	String reduceFraction(int num,int deno)
	{
	    if(num<0)
	    {
	    	num=-num;
	    	int HCF=1;
		    for(int i = 1; i <= num && i <= deno; ++i) 
		    {   
		        if(num % i == 0 && deno % i == 0) 
		            HCF= i; 
		    } 
		    this.deno=deno/HCF;
		    this.num=-num/HCF; 
		    return num+"/"+deno;
	    }
	    if(deno<0)
	    {
	    	deno=-deno;
	    	int HCF=1;
		    for(int i = 1; i <= num && i <= deno; ++i) 
		    {   
		        if(num % i == 0 && deno % i == 0) 
		            HCF= i; 
		    } 
		    this.deno=deno/HCF;
		    this.num=-num/HCF; 
		    return num+"/"+deno;
	    }
		int HCF=1;
	    for(int i = 1; i <= num && i <= deno; ++i) 
	    {   
	        if(num % i == 0 && deno % i == 0) 
	            HCF= i; 
	    } 
	    this.deno=deno/HCF;
	    this.num=num/HCF; 
	    return num+"/"+deno;
	}
	public String toString()
	{
		return num+"/"+deno;
	}
	Fraction addFraction(Fraction F1)
	{
		
		int n1,d1;
		n1=((num*F1.deno)+(deno*F1.num));
		if(n1==0)
		{
			n1=0;
			d1=0;
			Fraction ans=new Fraction(n1,d1);
			ans.reduceFraction(n1,d1);
			return ans;
		}
		d1=(deno*F1.deno);
		Fraction ans=new Fraction(n1,d1);
		ans.reduceFraction(n1,d1);
		return ans;
	}
	Fraction subFraction(Fraction F1)
	{
		int n1,d1;
		n1=((num*F1.deno)-(deno*F1.num));
		if(n1==0)
		{
			n1=0;
			d1=0;
			Fraction ans=new Fraction(n1,d1);
			ans.reduceFraction(n1,d1);
			return ans;
		}
		d1=(deno*F1.deno);
		Fraction ans=new Fraction(n1,d1);
		ans.reduceFraction(n1,d1);
		return ans;
	}
	Fraction mulFraction(Fraction F1)
	{
		int n1,d1;
		n1=(num*F1.num);
		d1=(deno*F1.deno);
		Fraction ans=new Fraction(n1,d1);
		ans.reduceFraction(n1,d1);
		return ans;
	}
	Fraction divFraction(Fraction F1)
	{
		int n1,d1;
		n1=(F1.deno*num);
		d1=(F1.num*deno);
		Fraction ans=new Fraction(n1,d1);
		ans.reduceFraction(n1,d1);
		return ans;
	}
	
}
