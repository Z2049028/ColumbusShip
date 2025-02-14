package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	final int dimesion = 10;  // Grid is 10x10
	final int scale = 50;     // Each grid cell is 50x50 pixels

	Pane root;                // Main container for the scene
	Image shipImage;          // Image of the ship
	ImageView shipImageView;  // Viewable image of the ship
	Ship ship = new Ship();   // Ship object for location and movement
	Scene scene;              // Scene where everything is drawn

	public static void main(String[] args) {
		launch(args);  // Start the application
	}

	public void loadShipImage() {
		shipImage = new Image("file:ship.png", scale, scale, false, false);  // Load ship image
		shipImageView = new ImageView(shipImage);  // Create ImageView for the ship
		shipImageView.setX(ship.getCurrentLocation().getX() * scale);  // Set X position
		shipImageView.setY(ship.getCurrentLocation().getY() * scale);  // Set Y position		
		root.getChildren().add(shipImageView);  // Add ship to the scene
	}

	public void drawMap() {
		for (int i = 0; i < dimesion; i++) {  // Loop through the grid
			for (int j = 0; j < dimesion; j++) {  
				Rectangle rect = new Rectangle(i * scale, j * scale, scale, scale);  // Create grid cell
				rect.setStroke(Color.BLACK);  // Set border color
				rect.setFill(Color.PALETURQUOISE);  // Set cell fill color
				root.getChildren().add(rect);  // Add the rectangle to the scene
			}
		}
	}

	public void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){  // Listen for key presses
			@Override 
			public void handle(KeyEvent ke) { 
				switch (ke.getCode()) {  // Check key press
					case RIGHT: 
						ship.goEast();  // Move ship right
						break; 
					case LEFT: 
						ship.goWest();  // Move ship left
						break; 
					case UP: 
						ship.goNorth();  // Move ship up
						break; 
					case DOWN: 
						ship.goSouth();  // Move ship down
						break; 
					default: 
						break;  // No action for other keys
				}       
				shipImageView.setX(ship.getCurrentLocation().getX() * scale);  // Update ship X
				shipImageView.setY(ship.getCurrentLocation().getY() * scale);  // Update ship Y
			} 
		});
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		root = new AnchorPane();  // Create a container for the scene
		scene = new Scene(root, 500, 500);  // Create a scene with the root container
		oceanStage.setScene(scene);  // Set the scene for the stage
		oceanStage.setTitle("Ocean Game");  // Set the window title
		oceanStage.show();  // Show the stage (window)
		drawMap();  // Draw the ocean map
		startSailing();  // Start handling key events for movement
		OceanMap oceanMap = new OceanMap();  // Create ocean map (not used here)
		boolean[][] oceanGrid = oceanMap.getOceanCell();  // Get the ocean grid (not used)
		loadShipImage();  // Load and display the ship
	}
}
