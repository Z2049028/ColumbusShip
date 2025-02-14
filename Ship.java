package application;

import javafx.scene.effect.Light.Point;

public class Ship {
	Point currentLocation;  // The current position of the ship

	public Ship() {
		this.currentLocation = new Point();  // Initialize the current position
		currentLocation.setX(4);  // Set initial X position
		currentLocation.setY(7);  // Set initial Y position
	}

	public Point getCurrentLocation() {
		return currentLocation;  // Return the current position
	}

	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;  // Set a new position
	}

	public void goEast() {
		// Move the ship east if it's within bounds
		if (currentLocation.getX() + 1 < 10 && currentLocation.getX() + 1 >= 0)
			currentLocation.setX(currentLocation.getX() + 1);
	}

	public void goWest() {
		// Move the ship west if it's within bounds
		if (currentLocation.getX() - 1 < 10 && currentLocation.getX() - 1 >= 0)
			currentLocation.setX(currentLocation.getX() - 1);
	}

	public void goNorth() {
		// Move the ship north if it's within bounds
		if (currentLocation.getY() - 1 < 10 && currentLocation.getY() - 1 >= 0)
			currentLocation.setY(currentLocation.getY() - 1);
	}

	public void goSouth() {
		// Move the ship south if it's within bounds
		if (currentLocation.getY() + 1 < 10 && currentLocation.getY() + 1 >= 0)
			currentLocation.setY(currentLocation.getY() + 1);
	}
}
