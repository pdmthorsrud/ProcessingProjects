import java.util.*;
import java.io.*;

public class ForsteArbeider extends Arbeider{

  File fil;

  public void run(){
    lesInnOgFinnMinste();
  }

  public ForsteArbeider(int id, String filnavn, OrdBuffer ob){
    super(id, ob);
    try{
      fil = new File(filnavn);
    }catch(Exception e){
      System.out.println("Filnavnet finnes ikke");
      System.exit(1);
    }
  }

  public void lesInnOgFinnMinste(){
    Scanner les = null;
    try{
      les = new Scanner(fil);
    }catch(Exception e){
      System.out.println("Klarte ikke opprette scanner. Avslutter program");
      System.exit(1);
    }
    String tmp;

    //leser inn hele fila.
    while(les.hasNextLine()){
      tmp = les.next();
      if(minsteOrd.compareTo(tmp)>0){
        //funnet nytt minste ord. Sender gamle til buffer (sammen med sin egen ID), og oppdaterer
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
      }else{
        ob.sendOrd(id, tmp);
        notifyAll();
      }
    }
    //denne traaden er ferdig, printer hva den fant, og sender null til sin buffer
    printFunn();
    ob.sendOrd(id, null);
    notifyAll();
  }
}
