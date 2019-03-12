package UiComponents;

public class Inputbox extends UiElement{
	
	public Inputbox(String locatorType, String locatorValue) {
		super(locatorType, locatorValue);
		
	}
public void setText(String value) {
	this.getElement().sendKeys(value);
}

public void clearText() {
	this.getElement().clear();
}
}

