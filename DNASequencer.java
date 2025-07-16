/*
* Author: Giorgos Fotiou
* Written: 29/09/2023
* Last updated: 09/10/2023
*
* Compilation command: javac DNASequencer.java
* Execution command: java DNASequencer <strand1> <strand2> ...
*
* This program checks if the strands that are taken from the input are correct
* and then finds the longest common sequence between the two of them and then calculates the DNA molecule tha occures from them.
*
*/
package zaza;
public class DNASequencer {
	static String Checkstrand(String elegxos) {
		int a = 0;				//declares counter
		String rightone = null; 	//declares string rightone
		boolean checking = false;	//declares boolean checking =false
		while(checking == false) {																								//checks if there are letters other than a,g,t,c in strings
			a=0;																												//
			for(int i=0; i<elegxos.length(); i++) {																				//		
				if( !(elegxos.charAt(i)== 'a'|| elegxos.charAt(i)== 'c'||elegxos.charAt(i)== 't'||(elegxos.charAt(i)== 'g'))) {	//
					a++;
					break;			//gets out of the loop
				}
   
    			}
    	
		
			if(a>0) {
				rightone = "wrong";			//if a has a value in it other than 0 it returns rightone in the main with value wrong
				return rightone;
			}
			else {
				checking = true;			//gets out of the while loop
			}
			rightone = elegxos;				//rightone becomes the correct string
    	}
			return rightone;				//returns to main
	}
	
	static String Calc(String base, String secondstrand) {
	    int max = 0, maxBase = -1, maxsecond = -1;
	    String Dna = "";												//declares result

	    for (int i = base.length()-1; i >= 0; i--) {
	        int m = i;													//declares m
	        int n = 0;													//declares index n
	        int currentMax = 0;											//declares currentmax

	        	while (m < base.length() && n < secondstrand.length() && base.charAt(m) == secondstrand.charAt(n)) {				//finds the length of the common between the two strings
	        		m++;
	        		n++;
	        		currentMax++;
	        	}

	        	if (currentMax > max) {									//max gets the new length of the common between the two strings
	        		max = currentMax;									//variable max gets the current length of the common
	        		maxBase = i;										//variable maxbase gets value of the index of the common sequence in the string base
	        		maxsecond = n;										//variable maxsecond gets the value of n index of the common sequence in the string secondstrand
	        	}
	    	}

	    
	    if (max < 4)													// If the common sequence is less than 4 characters return base
	        return base;
	 
	    for (int i = 0; i < maxBase; i++) {								// Add the first part of base
	        Dna += base.charAt(i);
	    }

	    for (int i = maxBase; i < maxBase + max; i++) { 				// Add the common between the two strings to the new one
	        Dna += base.charAt(i);
	    }

	    for (int i = maxsecond; i < secondstrand.length(); i++) {		//add the remaining part of secondstrand to the new one
	    	Dna += secondstrand.charAt(i);
	    }

	    return Dna;														//returns the completed new string to the main
	}



	static boolean Contains(String base, String secondstrand) {	//checks if string base contains string secondstrand
		boolean Check3 = false;
		for(int i=0; i<base.length()-secondstrand.length()+1; i++) {
			Check3=true;
			for(int j=0; j<secondstrand.length(); j++) {		//checks the characters of each strand if they match
				if(base.charAt(i+j)!=secondstrand.charAt(j)) {
					Check3 = false;
					break;
				}
			}
				if(Check3)
					return true;								//if is true it means that string base contains string secondstrand
			
		}
		return false;											//if secondstrand is not contained it returns false
	}
	
	
	public static void main(String[] args) {
    	String basestrand,Dnamolecule="";						//declares basestrand and Dnamolecule
    	String strand = null;									//declares strand
    	int i=1;												//declares index
    	if(args.length<1) {										//checks if there isn't any input and prints messages
    		System.out.println("WRONG INPUT!");
    		System.out.println("Expected input: <strand1> <strand2>...");
    		System.exit(0);										//terminates program
    	}
    	
    		basestrand = args[0];
        	basestrand = Checkstrand(basestrand);				//checks basestrand
        	if(args.length==1) {								//if there is only one strand
        		if(basestrand=="wrong") {						//if it has value wrong it means that is a wrong strand
        			System.out.println("WRONG INPUT!");			//prints messages and terminates the program
        			System.out.println("Expected input: <strand1> <strand2>...");
        			System.exit(0);
        	}
        		else System.out.println("DNA molecule : "+basestrand);//elsewhere if it's a right string with only a,g,t,c it prints it
        	}
        	else {											//if there is more than one strand
        	for(i=1; i<args.length; i++) {					//from the second place of the array until the length of the array
        		while(basestrand=="wrong") {					//it checks if basestrand has wrong value
        			basestrand = args[i];					//if it has it gets the value of the next item in the array
        			basestrand = Checkstrand(basestrand);	//checks if the strand has right value
        			i++;									//counter adding 1 so the String strand or basestrand can take the next value in the array
        			if(i==args.length)
        				break;
        		}
        		if(i==args.length)
    				break;
        		strand = args[i];							//take value of array at index
        		strand = Checkstrand(strand);				//checks value of strand
        		if(strand !="wrong") {						//if strand has right value
        		if(Contains(basestrand,strand)==false) {	//checks if the strand is contained in basestrand
        			basestrand=Calc(basestrand,strand);		//calculates the dna molecule
        		}
        		}
        		
        	}
        	}
        	if(basestrand=="wrong") {						//checks if the final product(basestrand)has wrong value
        		System.out.println("Wrong input!");
        	}
        	else {
        	Dnamolecule = basestrand;						//asigns the completed Dna molecule into the variable Dnamolecule
        	System.out.print("DNA molecule : "+Dnamolecule);			//prints Dna molecule
        	}
    }
    	
    	}
