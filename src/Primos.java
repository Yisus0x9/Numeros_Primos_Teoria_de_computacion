

import java.util.ArrayList;
import java.util.HashMap;

public class Primos {

    ArrayList <Integer>nUnos;
    ArchivoServicio flujo;

    public Primos(String nombreAr) {
        this.nUnos =new ArrayList<>();
        flujo=new ArchivoServicio(nombreAr);
        flujo.ArchivoBufferedW("Σ={ε");
    }

    private boolean isPrimo(int i){
        int divisor=0;
        for (int j=1;j<=i/2;j++){
            if(i%j==0) {
                divisor += 2;
            }
            if(divisor>2) {
                break;
            }
        }
        if (divisor==2) {
            //System.out.println(i);
            return true;
        }
        return false;
    }

    public void conjuntoP(int max){
        String cad;
        for (int i = 1; i <= max; i++) {
            if(isPrimo(i)) {
                cad=toBinary(i);
                flujo.ArchivoBufferedW(",").ArchivoBufferedW(cad);
               // numeroUnos(cad);
            }
            if(i%40==0)
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
