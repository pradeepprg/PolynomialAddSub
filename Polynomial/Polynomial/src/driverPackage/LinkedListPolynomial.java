package driverPackage;

import java.util.ArrayList;
import java.util.Scanner;

import polynomialInterfacePackage.PolynomialInterface;

public class LinkedListPolynomial implements PolynomialInterface {
     public ArrayList<Node>  list= new ArrayList<Node>();
	
	public LinkedListPolynomial(String equation1) {
		//System.out.println(equation1);
		String[] terms = equation1.split("(?=[+-])");
		int coee=0,exp=0,sign=0;
		for (String x : terms) {
			//System.out.println(x);
			String[] item=x.split("(?=x)");
			if(item.length==1){
				exp=0;
				String xx=item[0];
				if(xx.length()>1){
					coee=Integer.parseInt(xx);
				}
				else{
					if(xx.charAt(0)=='+'){
						coee=1;
					}
					else if(xx.charAt(0)=='-'){
						coee=-1;
					}
					else{
						coee=Integer.parseInt(xx);
					}
				}
			}
			else{
				String xx=item[0];
				if(xx.length()>1){
					coee=Integer.parseInt(xx);
				}
				else{
					if(xx.charAt(0)=='+'){
						coee=1;
					}
					else if(xx.charAt(0)=='-'){
						coee=-1;
					}
					else{
						coee=Integer.parseInt(xx);
					}
				}
				String xxx=item[1];
				if(xxx.contains("^")){
					exp=Integer.parseInt(xxx.substring(2));
				}else{
					exp=1;
				}			
			}
			//System.out.println(coee+" "+exp);
			Node node=new Node(exp,coee);
			list.add(node);
			//System.out.println(node);
		}
		list.sort((Node s1, Node s2)->s2.getExp()-s1.getExp());
		//System.out.println(list);
	}

	public LinkedListPolynomial() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
			String ss="";
			for(int i=0;i<this.list.size();i++){
				ss+=this.list.get(i).toString();
				if(i==0){
					if(ss.length()>0){
					if(ss.charAt(0)=='+'){
						 ss=ss.substring(1);
					}
					}
					//ss=Integer.toString(0);
				}
			}
			return ss;
	}

	@Override
	public PolynomialInterface add(PolynomialInterface other) {
		System.out.println(this.toString());
		LinkedListPolynomial answer = new LinkedListPolynomial();
		LinkedListPolynomial parameter = (LinkedListPolynomial)other;
		int j=0,jj=0,i=0;
		for(i=0,j=0;i<this.list.size() || j<parameter.list.size();){
			//System.out.println("i "+i+"j  "+j);
			if(j==parameter.list.size() || i==this.list.size()){
				break;
			}
			//for(j=jj;j<parameter.list.size();){
				int coe=0,exp=0;
				//System.out.println(this.list.get(i).toString()+"  "+parameter.list.get(j).toString());
				if(this.list.get(i).getExp()>parameter.list.get(j).getExp()){
					answer.list.add(this.list.get(i));
					i++;
				}
				else if(this.list.get(i).getExp()<parameter.list.get(j).getExp()){
					answer.list.add(parameter.list.get(j));
					j++;	
				}
				else{
					exp=this.list.get(i).getExp();
					coe=this.list.get(i).getCoeff()+parameter.list.get(j).getCoeff();
					j++;i++;
					//System.out.println(i+"hi"+j);
					if(exp==0){
						j=parameter.list.size();}
					Node n=new Node(exp,coe);
					answer.list.add(n);
					
				}
			}
		//}
		//System.out.println(answer.list.toString());
		if(i<this.list.size()){
			for(int ii=i;ii<this.list.size();ii++){
				answer.list.add(this.list.get(ii));
			}
		}
		if(j<parameter.list.size()){
			for(int ii=j;ii<parameter.list.size();ii++){
				answer.list.add(parameter.list.get(ii));
			}
		}

		//System.out.println(answer.list);
		return (PolynomialInterface)answer;
	}

	@Override
	public PolynomialInterface subtract(PolynomialInterface other) {
		//System.out.println(this);
		//System.out.println(other);
		LinkedListPolynomial answer = new LinkedListPolynomial();
		LinkedListPolynomial parameter = (LinkedListPolynomial)other;
		//System.out.println(parameter.list);
		int i=0,j=0,jj=0;
		for(;i<this.list.size() || j<parameter.list.size();){
			//System.out.println("i "+i+"j  "+j+" ");
			if(j==parameter.list.size() || i==this.list.size()){
				break;
			}
			int coe=0,exp=0;
				//System.out.println("j "+j);
				if(this.list.get(i).getExp()>parameter.list.get(j).getExp()){
					answer.list.add(this.list.get(i));
					//System.out.println(i);
					i++;
				}
				else if(this.list.get(i).getExp()<parameter.list.get(j).getExp()){
					Node node=new Node();
					node=parameter.list.get(j);
					node.setCoeff(-(node.getCoeff()));
					answer.list.add(node);
					//System.out.println(j);
					j++;
				}
				else{
					exp=this.list.get(i).getExp();
					coe=this.list.get(i).getCoeff()-parameter.list.get(j).getCoeff();
					j++;i++;
					Node n=new Node(exp,coe);
					//System.out.println(n.toString());
					
					answer.list.add(n);
				}
			}
		//System.out.println(i+" "+j);
		if(i<this.list.size()){
			//System.out.println("hi");
			for(int ii=i;ii<this.list.size();ii++){
				answer.list.add(this.list.get(ii));
			}
		}
		if(j<parameter.list.size()){
			for(int ii=j;ii<parameter.list.size();ii++){
				parameter.list.get(ii).setCoeff(-(parameter.list.get(ii).getCoeff()));
				answer.list.add(parameter.list.get(ii));
			}
		}
		//System.out.println(answer.list);
		return (PolynomialInterface)answer;
	}
	
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)
	{
		String yesOrNo = "";
		
		do
		{
			try{
				
			System.out.println("Enter the first polynomial");
			String equation1 = inputPolynomial();
			System.out.println("Enter the second polynomial");
			String equation2 = inputPolynomial();
			if(equation1.charAt(0)=='x'){
				//System.out.println(equation1);
				equation1="+"+equation1;
			}
			if(equation2.charAt(0)=='x'){
				//System.out.println(equation2);
				equation2="+"+equation2;
			}
			PolynomialInterface exAsIndex1 = new LinkedListPolynomial(equation1);
			PolynomialInterface exAsIndex2 = new LinkedListPolynomial(equation2);
			PolynomialInterface exAsIndex3;
			exAsIndex3 = exAsIndex1.add(exAsIndex2);
			String ss=exAsIndex3.toString();
			

			System.out.println("----Implementation Method 1 Linked List-----");
			System.out.println("First Polynomial Is " + equation1);
			System.out.println("Second Polnomial Is " + equation2);
			if(ss.length()>0){
				System.out.println("First Polynomial + Second Polynomial = " + ss);
				}
				else{
					System.out.println("First Polynomial + Second Polynomial = 0" );
					
				}
			//System.out.println("First Polynomial + Second Polynomial = " + exAsIndex3);
			
			exAsIndex3 = exAsIndex1.subtract(exAsIndex2);
			String sub=exAsIndex3.toString();
			if(sub.length()>0){
			System.out.println("First Polynomial - Second Polynomial = " + exAsIndex3);
			}
			else{
				System.out.println("First Polynomial - Second Polynomial = 0" );
				
			}
			System.out.println();
			}catch (Exception e) {
				System.out.println("ERROR: Polynomial format is not correct");
				System.out.println();
				System.out.println();
			}
				
			System.out.println("Would you like to repeat this program?");
			do
			{
				System.out.println("Please enter \"yes\" or \"no\".");
				yesOrNo = keyboard.nextLine();
			} while (!yesOrNo.equalsIgnoreCase("yes") && !yesOrNo.equalsIgnoreCase("no"));
			
		} while (yesOrNo.equalsIgnoreCase("yes"));
	}
	private static String inputPolynomial()
	{
		String polynomial = "";
			System.out.println("Do not use spaces between terms in the plynomial.");
			System.out.println("Examples: -3x+45x^3-22, 44x^6-3x^10+4x^4, 44-3x^88, etc.");
			
			polynomial = keyboard.next();
			keyboard.nextLine();
		return polynomial;
	}

}
