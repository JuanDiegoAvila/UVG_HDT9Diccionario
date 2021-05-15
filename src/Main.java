import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[]args){

        //se debe elegir la implementacion que se va a utilizar.
        Map<String,String> diccionario;
        System.out.println("-------------------------------");
        System.out.println("Bienvenido al diccionario ingles-español");
        System.out.println("Antes de comenzar debe elegir la implementacion que desea utilizar: ");
        System.out.println("\t[ 1 ] Splay Tree");
        System.out.println("\t[ 2 ] HashMap");
        int opcion = 0;

        while(true){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.print("\nOpcion -> ");
                opcion = scan.nextInt();
                if(opcion>2||opcion<1){
                    System.out.println("Ingrese valores entre 1 y 2");
                }else{
                    Factory Factory = new Factory();
                    diccionario = Factory.factory(opcion);
                    break;
                }
            }catch(Exception e){
                System.out.println("Ingrese valores numericos ! ! !");
            }
        }

        //primero se debe leer el archivo y meterlo en un mapa
        try {
            Scanner input = new Scanner(new File("Spanish.txt"));
            while (input.hasNextLine()) {
                String actual = input.nextLine();

                String[] temp = actual.split("\\s+");
                if(!actual.contains("#")){ //para no incluir la informacion al inicio del documento
                    if(!diccionario.containsKey(temp[0])){
                        diccionario.put(temp[0],temp[1]);
                    }
                }
            }
        }catch (Exception ignored){ }


        try{
            Scanner input = new Scanner(new File("texto.txt"));
            while(input.hasNextLine()){
                String actual = input.nextLine();
                String[] temp = actual.split(" ");
                ArrayList<String> traducido = new ArrayList<>();

                for(String i : temp){
                    //inicia la traduccion.
                    if(diccionario.containsKey(i)){
                        System.out.println(i+" existe");
                        String[] valores = diccionario.get(i).split("[ .,;?!¡¿\'\"\\[\\]]+");
                        traducido.add(valores[0].toString()+" ");
                    }else{
                        traducido.add(" *"+i+"* ");
                    }

                }

                System.out.println("El mensaje original es -> "+actual);

                String nuevo = "";

                for(String x : traducido){
                    nuevo += x;
                }
                System.out.println("El mensaje traducido es -> "+nuevo);
            }
        }catch (Exception ignored){

        }
        //el mapa contiene todas las palabras con ingles como llave y el español como el valor.

        //se debe recibir el texto a traducir y realizar la traduccion.
    }
}
