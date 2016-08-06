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
    if(minsteOrd==null){
      minsteOrd="xyz";
    }

    while(true){
      while(ob.erTom(id)){
        try{
          this.wait();
        }catch(Exception e){
          System.out.println("Something fked up");
        }
      }
      tmp = ob.hentOrd(id);

      if(tmp==null){
        ob.sendOrd(id, null);
        printFunn();
        notifyAll();
        break;
      }

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
