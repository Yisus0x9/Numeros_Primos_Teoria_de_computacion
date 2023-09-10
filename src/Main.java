
public class Main {
    public static void main(String[] args) {
       /*
       * Busca entre el 1 y una n los numeros primos, se convierten a binario y se escriben en un archivo txt
       * se grafica los numeros de 1´s respecto al numero de cadena binaria
       * */
        Primos calcular = new Primos("Output.txt");
        calcular.conjuntoP(1000000);
    }
}