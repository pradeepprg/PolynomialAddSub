package driverPackage;

public class Node {
	private int exp;
	private int coeff;
	
	public Node(int exp, int coeff) {
		super();
		this.exp = exp;
		this.coeff = coeff;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		if(coeff==0){
			return "";
		}
		String a="",b="x^"+Integer.toString(exp);
		if(exp==1){
			b="x";
		}
		else if(exp==0){
			b="";
			//a=Integer.toString(coeff);
		}
		if(coeff==-1){
			a="-1";
		}
		else if(coeff==1){
			a="+1";
		}
		else{
			a=Integer.toString(coeff);
			if(coeff<0){
				//a="-"+a;
			}
			else{
				a="+"+a;
			}
			
			
		}
		return a+b;
	}

	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getCoeff() {
		return coeff;
	}
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
}
