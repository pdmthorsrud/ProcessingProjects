public class Main{

  public static void main(String[] args) {
    OrdBuffer ob = new OrdBuffer(10);

    for(int i=0; i<10; i++){
      if(i==0){
        new ForsteArbeider(0, "test.txt", ob).start();
      }else if(i==9){
        new SisteArbeider(9, ob).start();
      }else{
        new IndreArbeider(i, ob).start();
      }
    }
  }

}
