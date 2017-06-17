package week3;

import processing.core.PApplet;
import processing.core.PImage;

public class MyApplet extends PApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url = "https://processing.org/img/processing-web.png";
	private PImage webImg;
	private PImage backgroundImg;
	private String laJollaUrl = "http://cseweb.ucsd.edu/~minnes/palmTrees.jpg";
	PImage img;
	/*public void setup(){
		size(600, 400);
		// webImg = loadImage(url, "png");
		backgroundImg = loadImage("../images/barcelona_beach.jpg");
		
	}*/
	
	// previous implementation for samples
	/*public void draw(){
		
		background(0);
		// image(webImg, 0, 0);
		backgroundImg.resize(0, height);
		image(backgroundImg, 0, 0);
		// pintamos el sol
		// cooordinates of center of the ellipe (x,y), and the the with and hwight of the ellipse
		// if the 3rd and 4rth are equal we have a circle
		fill(255, 209, 0);
		ellipse(width/4, height/5, width/7, height/5);
		
		// drawing happy face
		fill(255, 255, 0);
		ellipse(200, 200, 390, 390);
		fill(0, 0, 0);
		ellipse(100, 130, 50, 70);
		ellipse(280, 130, 50, 70);
		
		arc(200, 280, 75, 75, 0, PI);
	}*/
	
	public void setup(){
		
		size(400, 400);
		background(255);
		img = loadImage(laJollaUrl, "jpg");
		img.resize(0, height);
		image(img, 0, 0);
	}
	
	public void draw(){
		
		// add drawing code for MyApplet
		int[] color = sunColorSec(second());	// calculate color code for the sun
		// set sun color
		fill(color[0], color[1], color[2]);
		// draww sun
		ellipse(width/4, height/5, width/4, height/4);	
	}
	
	private int[] sunColorSec(float seconds){
		
		int[] rgb = new int[3];
		// scale the brightness of the yellow based on the seconds, 30 seconds is back, 0 seconds is bright yellow
		float difFrom30 = Math.abs(30-seconds);
		float ratio = difFrom30/30;
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;
		
		System.out.println("R" + rgb[0] + " G" + rgb[1] + " B" + rgb[2]);
		return rgb;
	}
}
