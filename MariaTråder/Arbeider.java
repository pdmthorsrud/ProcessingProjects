public class Arbeider extends Thread{
  protected int id;
  protected String minsteOrd;
  protected OrdBuffer ob;

  public Arbeider(int id, OrdBuffer ob){
    this.id = id;
    this.ob = ob;
  }

  public void run(){}

  public void printFunn(){
    System.out.println("Traad nr. " + id + " fant ordet " + minsteOrd);
  }
}
