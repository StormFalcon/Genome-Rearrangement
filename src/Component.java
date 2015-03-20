/**
 * 
 * @author Flyer
 * Component class
 * start
 * end
 * orientation
 */


public class Component {

	String componentStart;
	String componentEnd;
	String content;
	Boolean oriented;
	
	public Component(String componentStart, String componentEnd, Boolean oriented, String content)
	{
		String[] contentHolder = content.split(" ");
		this.content = content;
		this.componentStart = contentHolder[0];
		this.componentEnd = contentHolder[contentHolder.length-1];
		this.oriented = oriented;
	}
	
}
