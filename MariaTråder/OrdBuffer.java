import java.util.ArrayList;

public class OrdBuffer{

  ArrayList<ArrayList<String>> lister = new ArrayList<>();

  public OrdBuffer(int antallTraader){

    opprettLister(antallTraader);

  }


  public void opprettLister(int antallTraader){
    for(int i=0; i<antallTraader; i++){
      lister.add(i, new ArrayList<String>());
    }
  }


  public synchronized void sendOrd(int id, String ord){
    lister.get(id).add(ord);
  }

  public synchronized String hentOrd(int id){
    return lister.get(id-1).remove(0);
  }

  public synchronized boolean erFull(int id){
    return (lister.get(id).size()<11);
  }

  public synchronized boolean erTom(int id){
    return (lister.get(id-1).isEmpty());
  }


}
