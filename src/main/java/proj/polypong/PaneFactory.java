package proj.polypong;

import javafx.scene.layout.Pane;

public class PaneFactory {
	public Pane getPane(String paneType) {
		if (paneType == null) {
			return null;
		}
		if (paneType.equalsIgnoreCase("GAME")) {
			return new Game();
		} else if (paneType.equalsIgnoreCase("MENU")) {
			return new Menu();
		}
		return null;
	}
}
