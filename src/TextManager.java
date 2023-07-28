
public class TextManager {
	
	private Line[] lines;
	private String[] masters;
	private String textPaneString;
	
	public TextManager() {
		this.textPaneString = "";
	}
	
	private void update() {
		
	}
	
	public void setTextPaneContents(String arg) {
		
		this.textPaneString = arg;
		update();
	
	}
	
	public String getTextPaneContents() {
		return this.textPaneString; 
	}
}
