import resources.Graficar;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //System.getProperty("user.dir")+"\\Primos.txt"
        Primos calcular = new Primos("D:\\JavaIntellij\\TeoriadeLaComputacion\\numeros_primos\\src\\Primos.txt");
        int op;
        do {
            System.out.println("Seleccione una opcion:\n1.Calcular Aleatorio\n2.Ingresar 1<n<10,000,000\n3.Salir");
            op=new Scanner(System.in).nextInt();
            if(op==1){
                calcular.conjuntoP((int)(Math.random()*10000000+2));
                new Main().Graf(calcular);
            }

            if(op==2){
                int n=new Scanner(System.in).nextInt();
                calcular.conjuntoP(n);
                new Main().Graf(calcular);
            }

        }while (op!=3);
    }


    public  void Graf(Primos calcular){

        Graficar g1=new Graficar("Numeros Primos",calcular.nUnos);

        JFrame v1=new JFrame("Num Unos");
        JFrame v2=new JFrame("Logaritmo10");
        v1.setVisible(true);
        v1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        v1.setSize(1000,1000);
        v1.setLocationRelativeTo(null);
        v1.add(g1.graficarUnos());

        v1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                v2.setVisible(true);
                v2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                v2.setSize(1000,1000);
                v2.setLocationRelativeTo(null);
                v2.add(g1.graficarLog());
            }
        });
    }

}