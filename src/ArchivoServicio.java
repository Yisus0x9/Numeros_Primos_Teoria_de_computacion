import java.io.*;
import java.util.Scanner;



public class ArchivoServicio {
    String nombre=" ";
    File archivo;

    public ArchivoServicio(String nombre){
        this.nombre=nombre;
        archivo= new File(nombre);
        if(archivo.exists())
            archivo.delete();
    }
    public  ArchivoServicio ArchivoBufferedW(String cads){
        try(BufferedWriter buffer=new BufferedWriter(new FileWriter(archivo,true))){
            buffer.append(cads);
        }catch(IOException e){
            System.out.println("Error al escribir archivo con BufferWriter");
            e.printStackTrace();
        }
        return this;
    }
}


