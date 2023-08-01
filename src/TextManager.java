import java.util.LinkedList;

								//TODO setColor methods (set color in Line constructor? )
public class TextManager {		// organize lines into a linked list. Based on changes made to the document string, add, remove, or modify only the effected lines.
	
	private LinkedList<Line> lines = new LinkedList<>();
	private String textPaneString;
	
	public TextManager() {
		setTextPaneContents(new String());
	}
	public TextManager(String arg) {
		setTextPaneContents(arg);
	}
	
	public void setTextPaneContents(String arg) { 
		int lineIndex = 0;
		this.textPaneString = arg;
		for(int i =1; i<= arg.length(); i++) {
			System.out.println("Constructor line index check: " + lineIndex);
			if(lineCount(arg.substring(0, i)) > 0) {
				lines.add(lineIndex, new Line(arg.substring(0, i)));
				arg = arg.substring(i);
				lineIndex++;
				i=0;
			}
			else if(i >= arg.length()) {
				lines.add(lineIndex, new Line(arg.substring(0, i)));
				arg = arg.substring(i);
				lineIndex++;
				i=0;
			}
			else {System.err.println("setTextPaneContents took a steamy dump on the floor");}
		}
		
	}
	
	public void appendTextPaneContents(int offset, String arg) {
		String leading = new String(this.textPaneString.substring(0, offset));
		String trailing = new String(this.textPaneString.substring(offset));
		
		int lineIndex = getLineIndex(offset);
		int lineOffset = (offset - getLineOffset(lineIndex));
		
		System.out.println("leading: " + leading);
		System.out.println("trailing: " + trailing);
		System.out.println("line index check: " + lineIndex);
		
		if(lineCount(arg) < 1) {
			String le = new String(lines.get(lineIndex).master.substring(0, lineOffset));
			String tr = new String(lines.get(lineIndex).master.substring(lineOffset));
			lines.set(lineIndex, new Line(le + arg + tr));
		}
		else {
			for(int i = 0; i <= arg.length(); i++) {
				if(lineCount(arg.substring(i)) > 0) {
					lines.set(lineIndex, (new Line(this.textPaneString.substring(lineOffset, offset) + arg.substring(0, i))));
				}
			}
			
			System.out.println("new line detected");  										// TODO Finish catching append cases
		}

			
		this.textPaneString = leading + arg + trailing;
		System.out.println("line count: " + arg.lines().count());
	}
	
	public void trimTextPaneContents(int offset, int amount) {
		String byebye = new String(this.textPaneString.substring(offset, offset + amount));
		String leading = new String(this.textPaneString.substring(0, offset));
		String trailing = new String(this.textPaneString.substring(offset + amount));
		
		int lineIndex = getLineIndex(offset);
		System.out.println("Trim line Index check: " + lineIndex);
		int lineOffset = (offset - getLineOffset(lineIndex));
		if(lineCount(byebye)<1) {
			String le = new String(lines.get(lineIndex).master.substring(0, lineOffset));
			String tr = new String(lines.get(lineIndex).master.substring(lineOffset + amount));
			lines.set(lineIndex, new Line(le + tr));
		}
		else { 																					//TODO Finish catching trim cases
			System.out.println("(hopefully)removed " + lineCount(byebye) + " lines");
			
		}
		
		this.textPaneString = leading + trailing;
	}
	
	public String getTextPaneContents() {
		return this.textPaneString; 
	}
	
	//////////////////////////////////////////////////helpfull things///////////////////////////////////////////////////////////////////////////////////////////////////////
	private int getLineOffset(int index) {
		int ofs = 0;
			for(int i=0; i<index; i++) {
				ofs += lines.get(i).master.length();
			}
		return ofs;
	}
	private int getLineIndex(int offset) {
		return lineCount(offset);
	}

	private int lineCount(int offset) {
	    StringBuffer sb = new StringBuffer(new String(textPaneString.substring(0, offset)));
	    int counter = 0;
	    for (int i = 0; i < sb.length(); i++) {
	        if (sb.charAt(i) == '\n' || sb.charAt(i) == '\r')
	            counter++;
	    }
	    return counter;
	}
	public static int lineCount(String arg) {
	    StringBuffer sb = new StringBuffer(arg);
	    int counter = 0;
	    for (int i = 0; i < sb.length(); i++) {
	        if (sb.charAt(i) == '\n' || sb.charAt(i) == '\r')
	            counter++;
	    }
	    return counter;
	}
}
