public class IndreArbeider extends Arbeider{

  boolean ferdig=false;

  public IndreArbeider(int id, OrdBuffer ob){
    super(id, ob);
  }

  public void run(){
    finnMinste();
  }

  public void finnMinste(){
    String tmp;
    //hvis minsteord ikke er satt enda, settes det til xyz
    if(minsteOrd==null){
      minsteOrd="xyz";
    }

    //en uendelig while som kjorer helt til jeg sier break; inne i loopen
    while(true){
      //er ordlista tom saa skal den vente til den ikke er det
      while(ob.erTom(id)){
        try{
          this.wait();
        }catch(Exception e){
          System.out.println("Something fked up");
        }
      }
      //hennter ord
      tmp = ob.hentOrd(id);
      //er ordet som ble hentet lik null, saa betyr dette at traaden er feridg. Den printer funn, notifyer alle sammen, og breaker
      if(tmp==null){
        ob.sendOrd(id, null);
        printFunn();
        notifyAll();
        break;
      }
      //fant nytt minste ord. Er buffer full saa venter den til den ikke er det
      if(minsteOrd.compareTo(tmp)>0){
        while(ob.erFull(id)){
          try{
            this.wait();
          }catch(Exception e){
            System.out.println("Something fked up");
          }
        }
        ob.sendOrd(id, minsteOrd);
        minsteOrd = tmp;
        notifyAll();
      }
    }
  }
}
