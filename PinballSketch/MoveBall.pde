class MoveBall{
  boolean down=true;
  boolean left=false;
  public int posBallX;
  public int posBallY;
  int ballSpeedX = 4;
  int ballSpeedY = 4;

  PinballSketch ps = new PinballSketch();

  void moveBall(){
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

  void setMovementBall(){
    if(posBallY==480 && posBallX>ps.posBat && posBallX<=ps.posBat+40) {
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

  void moveBallRightDown(){
    ellipse(posBallX += ballSpeedX, posBallY += ballSpeedY, 15, 15);
  }

  void moveBallRightUp(){
    ellipse(posBallX += ballSpeedX, posBallY -= ballSpeedY, 15, 15);
  }

  void moveBallLeftDown(){
    ellipse(posBallX -= ballSpeedX, posBallY += ballSpeedY, 15, 15);
  }

  void moveBallLeftUp(){
    ellipse(posBallX -= ballSpeedX, posBallY -= ballSpeedY, 15, 15);
  }
}
