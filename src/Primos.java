
import java.util.ArrayList;


public class Primos {

    ArrayList <Integer>nUnos;
    ArchivoServicio flujo,flujo2;

    public Primos(String nombreAr) {
        this.nUnos =new ArrayList<>();
        flujo=new ArchivoServicio(nombreAr);
        flujo.ArchivoBufferedW("Σ={ε");
        flujo2=new ArchivoServicio("Decimal.txt").ArchivoBufferedW("Σ={ε");
    }

    private boolean isPrimo(int i){
        int limit=i/2;
        if(i==2){return true;}
        if(i%2==0){return  false;}
        for (int j=2;j<=limit;j++){
            if(i%j==0) {
                return false;
            }else{
                limit=i/j+2;
            }
        }
        return true;
    }

    public void conjuntoP(int max){
        String cad;
        for (int i = 2; i <= max; i++) {
            if(isPrimo(i)) {
                flujo2.ArchivoBufferedW(",").ArchivoBufferedW(Integer.toString(i));
                cad=toBinary(i);
                numeroUnos(cad);
                flujo.ArchivoBufferedW(",").ArchivoBufferedW(cad);
            }

            if((i%10==0))
                flujo.ArchivoBufferedW("\n");

        }
        flujo.ArchivoBufferedW("}");
    }

    private String toBinary(int j){
        int i=j;
        StringBuffer binario=new StringBuffer();
        int mod=2;
        while(i!=0){
            if(i%mod==0){
                binario.append(0);
                i=i/2;
            }else{
                binario.append(1);
                i=i/2;
            }
        }
        return binario.reverse().toString();
    }

    private void numeroUnos(String cadena){
        int aux=0;
        for (int i = 0; i < cadena.length(); i++) {
            if(cadena.charAt(i)=='1')
                aux++;
        }
        nUnos.add(aux);
    }

    public ArrayList<Integer> getnUnos(){
        return nUnos;
    }

}
