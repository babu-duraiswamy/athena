package UiComponents;

import org.openqa.selenium.Keys;

public class Textbox extends UiElement {

	public Textbox(String locatorType, String locatorValue) {
		super(locatorType, locatorValue);

	}

	public void setText(String value) {
		if(this.getElement().isEnabled())
		this.getElement().sendKeys(value);
	}

	public void clearText() {
		if(this.getElement().isEnabled())
		this.getElement().clear();
	}

	public void typeEnter() {
		if(this.getElement().isEnabled())
			this.getElement().sendKeys(Keys.RETURN);		
	}
}
