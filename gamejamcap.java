import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class webcamCap extends PApplet {

//CMYK's Webcam Capture Program for Bacon game jam
//Takes a photo once every minute and saves it to a the folder the program is in
//Good for making crappy videos that you put on youtube
    
Capture cam;
PFont f;

public void setup() {
  size(1280, 720);
  cam = new Capture(this, 1280, 720, 60); //We set it to 1280x720 because 720p is pretty much standard
  cam.start();
  
  f = createFont("Arial", 16, true);
}

public void savePic(){
  save(str(day()) + str(hour()) + str(minute()) + ".png");
}

public void draw() {
  if(cam.available()) {
    cam.read();
  }
  image(cam, 0, 0);
  textFont(f, 16);
  fill(0);
  //text(str(hour()) + ":" + str(minute()) + "  " + str(second()), 20, 20); //You can add this in if you want it.
  if( second() == 0 ){
    savePic();
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "webcamCap" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
