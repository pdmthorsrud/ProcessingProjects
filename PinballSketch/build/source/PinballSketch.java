import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PinballSketch extends PApplet {

public int posBat;
MoveBall mb;

public void setup(){
  
  background(0, 0, 0);
  posBat=0;
  mb = new MoveBall();
}

public void draw(){
  if(mb.posBallY>500){
    gameOver();
  }else{
    background(0, 0, 0);
    fill(255, 255, 255);
    mb.moveBall();
    drawBat();
  }
}

public void drawBat(){
  fill(255, 0, 0);
  if(keyPressed){
    if(keyCode==RIGHT){
      posBat+=5;
    }else if(keyCode==LEFT){
      posBat-=5;
    }
  }
  rect(posBat, 490, 80, 10);
}

public void gameOver(){
  background(255, 0, 0);
  fill(0, 0, 0);
  textSize(50);
  textAlign(CENTER, CENTER);
  text("GAME OVER", 500, 250);
  textSize(25);
  text("New Game (n)", 500, 310);
  if(keyPressed){
    if(key=='n'){
      newGame();
    }
  }
}

public void newGame(){
  background(0, 0, 0);
  mb.posBallX = 0;
  mb.posBallY = 0;
}
class MoveBall{
  boolean down=true;
  boolean left=false;
  public int posBallX;
  public int posBallY;
  int ballSpeed = 4;

  PinballSketch ps = new PinballSketch();

  public void moveBall(){
    setMovementBall();
    if(down==false && left==false){
      moveBallRightUp();
    }else if(down==true && left==false){
      moveBallRightDown();
    }else if(down==false && left==true){
      moveBallLeftUp();
    }else if(down==true && left==true){
      moveBallLeftDown();
    }
  }

  public void setMovementBall(){
    if(posBallY==480 && posBallX>ps.posBat && posBallX<=ps.posBat+80) {
      down=false;
      left=true;
    }else if(posBallY==480 && posBallX>ps.posBat+40 && posBallX<ps.posBat+80){
      down=false;
      left=false;
    }else if(posBallY==0 && posBallX==0){
      down=true;
      left=false;
    }else if(posBallY==1000 && posBallX==1000){
      down=true;
      left=true;
    }else if(posBallY==0){
      down=true;
    }else if(posBallX==0){
      left=false;
    }else if(posBallX==1000){
      left=true;
    }
  }

  public void moveBallRightDown(){
    ellipse(posBallX+=ballSpeed, posBallY+=ballSpeed, 15, 15);
  }

  public void moveBallRightUp(){
    ellipse(posBallX+=ballSpeed, posBallY-=ballSpeed, 15, 15);
  }

  public void moveBallLeftDown(){
    ellipse(posBallX-=ballSpeed, posBallY+=ballSpeed, 15, 15);
  }

  public void moveBallLeftUp(){
    ellipse(posBallX-=ballSpeed, posBallY-=ballSpeed, 15, 15);
  }
}
  public void settings() {  size(1000, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PinballSketch" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
