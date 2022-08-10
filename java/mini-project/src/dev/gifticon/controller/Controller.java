package dev.gifticon.controller;

import dev.gifticon.scanner.GifticonScanner;
import dev.gifticon.service.Service;
import dev.gifticon.view.View;

public class Controller {

	private final View consoleView = new View();
	private final Service gifticonService = new Service();
	private final GifticonScanner gifticonScanner = new GifticonScanner();
	
	public void viewMain() {
		consoleView.viewMain();
		consoleView.viewMenu(gifticonScanner.getReaction());
	}

	public void getReaction() {
		gifticonScanner.getReaction();
	}

}
