package driverPackage;

import java.util.Scanner;

import polynomialInterfacePackage.PolynomialInterface;

public class ArraySortedPolynomial implements PolynomialInterface {
    int sortedarray[]= new int[1000];
    int sor[][]=new int[20][];
	public ArraySortedPolynomial(String equation1) {
				String[] terms = equation1.split("(?=[+-])");
				int coee=0,exp=0,sign=0,index=0;
				
				for (String x : terms) {
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
					sortedarray[exp]=coee;
			}
	}

	public ArraySortedPolynomial() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PolynomialInterface add(PolynomialInterface other) {
		ArraySortedPolynomial answer = new ArraySortedPolynomial();
		ArraySortedPolynomial parameter = (ArraySortedPolynomial)other;
		int coe=0,exp=0,i,j=1,jj=999,flag=0;
		for(i=this.sortedarray.length-1;i>=0;i--){
			//System.out.println("0   "+i+" "+this.sortedarray[i]);
			if(this.sortedarray[i]!=0 ){
				for(j=jj ;j>=0;j--){
				//System.out.println("33       " +j+" "+parameter.sortedarray[j]);							
					if(parameter.sortedarray[j]!=0){
						coe=0;exp=0;	
						if(i>j){
						exp=i;
						coe=this.sortedarray[i];
						//System.out.println("1 "+i+" "+this.sortedarray[i]+" "+j+" "+parameter.sortedarray[j]);							
						jj=j;
						answer.sortedarray[exp]=coe;
						break;
					}
					else if(i<j){
						exp=j;coe=parameter.sortedarray[j];
						//System.out.println("2 "+i+" "+this.sortedarray[i]+" "+j+" "+parameter.sortedarray[j]);
						jj=j-1;
						answer.sortedarray[exp]=coe;
						}
					else{
						exp=i;
						coe=this.sortedarray[i]+parameter.sortedarray[j];
						//System.out.println("3 "+i+" "+this.sortedarray[i]+" "+j+" "+parameter.sortedarray[j]);
						jj=j-1;
						answer.sortedarray[exp]=coe;
						break;
					}
				}
				if(j==0){
					flag=1;
				}
			}
			if(flag==1){
				break;
			}
		}
		}
		//System.out.println(i+" "+j);
		if(i!=-1){
			for(i=i;i>=0;i--){
				if(this.sortedarray[i]!=0){
					answer.sortedarray[i]=this.sortedarray[i];
					
				}
			}
		}
		if(jj!=-1){
			for(j=jj;j>=0;j--){
				if(parameter.sortedarray[j]!=0){
					answer.sortedarray[j]=parameter.sortedarray[j];
					
				}
			}
		}
		//System.out.println(" "+i+" "+" "+jj+" ");
		return (PolynomialInterface)answer;
}

	@Override
	public String toString() {
		String ss="";
		int pos=0;
		for (int i=0;i<sortedarray.length;i++) {
			if(sortedarray[i]!=0){
				if(i==0){
					ss+=sortedarray[i];
					pos++;
				}
				else{
					if(pos==0){
						if(i==1){
							ss+=sortedarray[i]+"x";
						}
						else{
							ss+=sortedarray[i]+"x^"+i;
						}
					}
					else{
						if(i==1){
							if(sortedarray[i]<0){
								if(sortedarray[i]==-1){
									ss+="-x";
								}
								else
									ss+=sortedarray[i]+"x";
							}
							else{
								if(sortedarray[i]==1){
									ss+="+x";
								}
								else
									ss+="+"+sortedarray[i]+"x";
							}
						}
						else{
							if(sortedarray[i]<0){
								if(sortedarray[i]==-1){
									ss+="-x^"+i;
								}
								else
									ss+=sortedarray[i]+"x^"+i;
							}
							else{
								if(sortedarray[i]==1){
									ss+="+x^"+i;
								}
								else
									ss+="+"+sortedarray[i]+"x^"+i;
							}
						}
					}
					pos++;
				}
			}			
		}
		//System.out.println(ss);	
		return ss;
	}
	@Override
	public PolynomialInterface subtract(PolynomialInterface other) {
				ArraySortedPolynomial answer = new ArraySortedPolynomial();
				ArraySortedPolynomial parameter = (ArraySortedPolynomial)other;
				int coe=0,exp=0,i,j=1,jj=999,flag=0;
				for(i=this.sortedarray.length-1;i>=0;i--){
					//System.out.println("0   "+i+" "+this.sortedarray[i]);
					if(this.sortedarray[i]!=0 ){
					for(j=jj ;j>=0;j--){
						//System.out.println("33       " +j+" "+parameter.sortedarray[j]);							
						if(parameter.sortedarray[j]!=0){
							coe=0;exp=0;
							
							if(i>j){
								exp=i;
								coe=this.sortedarray[i];
								//System.out.println("1 "+i+" "+this.sortedarray[i]+" "+j+" "+parameter.sortedarray[j]);							
								jj=j;
								answer.sortedarray[exp]=coe;
								break;
							}
							else if(i<j){
								exp=j;coe=-parameter.sortedarray[j];
								//System.out.println("2 "+i+" "+this.sortedarray[i]+" "+j+" "+parameter.sortedarray[j]);
								jj=j-1;
								answer.sortedarray[exp]=coe;
								}
							else{
								exp=i;
								coe=this.sortedarray[i]-parameter.sortedarray[j];
								//System.out.println("3 "+i+" "+this.sortedarray[i]+" "+j+" "+parameter.sortedarray[j]);
								jj=j-1;
								answer.sortedarray[exp]=coe;
								break;
							}
							
						}
						if(j==0){
							flag=1;
						}
					}
					if(flag==1){
						break;
					}
				}
					
				}
				//System.out.println(i+" "+j);
				if(i!=-1){
					for(i=i;i>=0;i--){
						if(this.sortedarray[i]!=0){
							answer.sortedarray[i]=this.sortedarray[i];
							
						}
					}
				}
				if(jj!=-1){
					for(j=jj;j>=0;j--){
						if(parameter.sortedarray[j]!=0){
							answer.sortedarray[j]=-parameter.sortedarray[j];
							
						}
					}
				}
				//System.out.println(" "+i+" "+" "+jj+" ");
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
			String equation2 =inputPolynomial();
			if(equation1.charAt(0)=='x'){
				equation1="+"+equation1;
			}
			if(equation2.charAt(0)=='x'){
				equation2="+"+equation2;
			}
			PolynomialInterface sortA1 =  new ArraySortedPolynomial(equation1);
			PolynomialInterface sortA2 = new ArraySortedPolynomial(equation2);
			PolynomialInterface sortA3;
			sortA3 = sortA1.add(sortA2);
			System.out.println("----Implementation Method 2 Sorted Array-----");
			//System.out.println("sortA1 string is " + s1);
			System.out.println("Polynomial 1 after sorting " + sortA1);
			// // System.out.println("sortA2 string is " + s2);
			System.out.println("Polynomial 2 after sorting " + sortA2);
			String sub=sortA3.toString();
			if(sub.length()>0){
			System.out.println("First Polynomial + Second Polynomial = " + sub);
			}
			else{
				System.out.println("First Polynomial + Second Polynomial = 0" );
				
			}
			//System.out.println("First Polynomial + Second Polynomial = " + sortA3);
			
			sortA3 = sortA1.subtract(sortA2);
			String subb=sortA3.toString();
			if(subb.length()>0){
			System.out.println("First Polynomial + Second Polynomial = " + subb);
			}
			else{
				System.out.println("First Polynomial + Second Polynomial = 0" );
				
			}
			//System.out.println("First Polynomial - Second Polynomial = " + sortA3.toString());
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
