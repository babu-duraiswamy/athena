package UiComponents;

public class MenuItem extends UiElement {

	public MenuItem(String locatorType, String locatorValue) {
		super(locatorType, locatorValue);
	}

	public void click() {
		if(this.getElement().isEnabled())
		this.getElement().click();
	}
}