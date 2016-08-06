public class SisteArbeider extends Arbeider{

  public SisteArbeider(int id, OrdBuffer ob){
    super(id, ob);
  }
  //gjoer alt d samme som indrearbeider fordi jeg var lat og ikke lagde en skikkelig sistearbeider
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
        System.out.println("We are finally done!!");
        printFunn();
        notifyAll();
        break;
      }

      if(minsteOrd.compareTo(tmp)>0){
        while(ob.erFull(id)){
          try{
            this.wait();
            System.out.println("Hheihei");
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
