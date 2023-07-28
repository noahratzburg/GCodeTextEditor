

public class Line {

	String master;  	// original string input in constructor
	String[] keys;  	// stores seperated text, typically starts with a letter, followed by a value, and any trailing or leading white space.
	Keycode[] keycode;  // coresponding array to store text type, keycode[] will determine the color of the text, indexed with keys[]
	Line(){
	}
	
	Line(String master){
		this.master = master; 				// Store original string for comparison 
		String[] keys = new String[master.length()];
		Keycode[] keycode = new Keycode[master.length()];
		int keyindex = 0;
		boolean done = false;
		for(int i = 1; !master.isEmpty() && !done && i <= master.length(); i++) {
			if(i >= master.length() || (master.charAt(i)>=65 && master.charAt(i)<=90) || (master.charAt(i)>=97 && master.charAt(i)<=122) || master.charAt(i) == '(') {
				if(master.charAt(0) == '(') {  
					keys[keyindex] = master;
					keycode[keyindex] = Keycode.COMMENT;    //assume the rest of the line will be comment after first parenthesis 
					done = true;
				}
				else if (master.isBlank()) {
					keys[keyindex] = master;
					keycode[keyindex] = Keycode.BLANK;
					done = true;
				}
				else if((master.charAt(0)>=65 && master.charAt(0)<=90) || (master.charAt(0)>=97 && master.charAt(0)<=122) || Character.isWhitespace(master.charAt(0))) {
					if(Character.isWhitespace(master.charAt(0)))
						keycode[keyindex] = Keycode.BLANK;
					else if(master.charAt(0) == 'G' || master.charAt(0) == 'g') 
						keycode[keyindex] = Keycode.GCODE;
					else if(master.charAt(0) == 'M' || master.charAt(0) == 'm')
						keycode[keyindex] = Keycode.MCODE;
					else if(master.charAt(0) == 'Z' || master.charAt(0) == 'z')
						keycode[keyindex] = Keycode.ZPOINT;
					else if(master.charAt(0) == 'X' || master.charAt(0) == 'x')
						keycode[keyindex] = Keycode.XPOINT;
					else if(master.charAt(0) == 'Y' || master.charAt(0) == 'y')
						keycode[keyindex] = Keycode.YPOINT;
					else if(master.charAt(0) == 'A' || master.charAt(0) == 'a')
						keycode[keyindex] = Keycode.APOINT;
					else if(master.charAt(0) == 'P' || master.charAt(0) == 'p')
						keycode[keyindex] = Keycode.PCODE;
					else if(master.charAt(0) == 'L' || master.charAt(0) == 'l')
						keycode[keyindex] = Keycode.LCODE;
					else if(master.charAt(0) == 'D' || master.charAt(0) == 'd')
						keycode[keyindex] = Keycode.DCODE;
					else if(master.charAt(0) == 'H' || master.charAt(0) == 'h')
						keycode[keyindex] = Keycode.HCODE;
					else if(master.charAt(0) == 'I' || master.charAt(0) == 'i')
						keycode[keyindex] = Keycode.ICODE;
					else if(master.charAt(0) == 'J' || master.charAt(0) == 'j')
						keycode[keyindex] = Keycode.JCODE;
					else if(master.charAt(0) == 'K' || master.charAt(0) == 'k')
						keycode[keyindex] = Keycode.KCODE;
					else
						keycode[keyindex] = Keycode.UNKNOWN;
					
					keys[keyindex] = master.substring(0, i);
					master = master.substring(i);
					keyindex++;
					i=0;
				}
			}
		}
		
		this.keys = keys;		//TODO clean up null values and correctly size this.keys[] and this.keycode[]
		this.keycode = keycode;
		
		
		
		System.out.println("the next 2 lines should look the same");
		System.out.println(this.master);
		for(int x = 0; x<keys.length; x++) 
		System.out.print(keys[x]);
		System.out.println();
		for(int x = 0; x<keys.length; x++) {
		System.out.print(keys[x]);
		System.out.println(" (" + keycode[x]+ ")");
		
		}
	}
	
	public enum Keycode{
		GCODE, MCODE, ZPOINT, XPOINT, YPOINT, APOINT, PCODE, LCODE, DCODE, HCODE, ICODE, JCODE, KCODE, COMMENT, UNKNOWN, BLANK
	}
}
