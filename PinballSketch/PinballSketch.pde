public int posBat;
MoveBall mb;

void setup(){
  size(1000, 500);
  background(0, 0, 0);
  posBat=0;
  mb = new MoveBall();
}

void draw(){
  if(mb.posBallY>500){
    gameOver();
  }else{
    background(0, 0, 0);
    fill(255, 255, 255);
    mb.moveBall();
    drawBat();
  }
}

void drawBat(){
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

void gameOver(){
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

void newGame(){
  background(0, 0, 0);
  mb.posBallX = 0;
  mb.posBallY = 0;
}
