import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

       /*
       Todo programa en java comienza por la funcion Main, CUANDO
       SE LE DA AL RUN --> FUNCION PRINCIPAL ES LA MAIN
        */
        //System.out.println(saludoPersonalizadoPara("Lalote","Haag")); Le paso como parametro nombre y apellido

        int numeros [] = {1,5,7,8,10,11};

        //Llamada a la funcion sumatoria -> REALIZA UN PROCEDIMIENTO

        int resultado = sumatoria(numeros); //Le paso por parametro los numeros para que me devuelva la suma de esos mismos

        System.out.println("Resultado sumatoria: " + resultado);

        int promedio = resultado / numeros.length; //Suma total dividido la cantidad de numeros

        System.out.println("Resultado promedio: " + promedio + "\n" + "\n");

        //Archivos

        System.out.println("****ARCHIVOS****");

        String rutaMiArchivo = "C:/Users/Lalo/IdeaProjects/PruebaArchivoNintelij.txt";
        ejemploLecturaArchivo(rutaMiArchivo); //Llamo a la funcion que ya tendra su  propio System.out.println
        ejemploEscrituraArchivo(rutaMiArchivo); //Llamo a la funcion para escribir mi archivo

		//ejemploEscrituraArchivo2(rutaMiArchivo);

        mostrarUltimaModificacionArchivo(rutaMiArchivo);

        System.out.println("\n" + "\n" + "**Entradas de un programa***");
        /*
         *  * Entradas de un programa
         * Cuando yo mando a ejecutar un programa en Java, yo puedo pasarle
         * unos parametros para cuando se ejecute el programa lea esos
         * argumentos
         * Se puede compilar desde cualquier lado, el IDE se encarga del proceso
         * de hacer el run y eso para que no tengamos que hacerlo a mano
         *
         * Todo lo que ingrese el usuario java lo interpeta como string,
         * por lo que si pido un numero tengo que convertirlo a numero con
         * el parseInt
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.println(saludoPersonalizadoPara(nombre,apellido));
        System.out.println("Ingrese todos los numeros que quiera separados por un espacio y cuando no quiera ingresar mas, presione ENTER");

        String numerosString = scanner.nextLine(); //La funcion nextLine se queda clavada esperando el enter, y asigna los numeros a la variable
        //1 2 3 4 5 6 7 8 9

        /*Ahora yo quiero convertir ese String a un Array
         * cada vez que encontremos un espacio... USAMOS SPLIT
         * Cada vez q encuentra un espacio es algo que quiero guardar en mi array*/




        String arrayDeNumeros[] = numerosString.split(" "); //["1","2","3","4"...]

        int resultadoArray = 0; //Para trasnformar lo ingresado a numero:
        for (String unNumero:arrayDeNumeros) {
            resultadoArray += Integer.parseInt(unNumero);

        }
        System.out.println("La suma de los numeros que ingreso es de " + resultadoArray);
    }





    //Archivos...Funcion para la lectura

    private static void ejemploLecturaArchivo(String rutaMiArchivo) throws IOException {
        /*IOException dice que puede largar una excepcion */
        /*Void no devuelve nada por lo que puede ir un System.out.println
         * Recibe por parametro la ruta de mi archivo*/
        for(String unaLinea: Files.readAllLines(Paths.get(rutaMiArchivo))) {

            /*
             * Lo que va a ser esto es iterar mientras existan mas lineas en
             * el archivo, linea por linea y cada linea se va a asignar a
             * unaLinea
             */
            System.out.println(unaLinea);

        }
    }
    //Archivos..Funcion para escritura del archivo

    private static void ejemploEscrituraArchivo(String rutaMiArchivo) throws IOException {
        //Files.writeString(Paths.get(rutaMiArchivo),"Lucas");
        /*Recibe como parametro la ruta, y lo que quiero escribir, Lucas en este caso
         * Pero esto borrara todo lo que esta escrito antes...*/
        //Para que no pise lo que estaba escrito:

        //lineSeparator() indica un salto de linea
        String palabraAEscribir = System.lineSeparator() + "Lucas";
        Files.writeString(Paths.get(rutaMiArchivo),palabraAEscribir, StandardOpenOption.APPEND);
        /*
         * Recibe tres parametros: RutaArchivo,palabra a escribir, y el standard indica
         * que no pise lo que estaba antes, sino que lo AGREGUE
         */
        }
    //ARCHIVOS..Funcion para saber la hora de la ultima modificacion del archivo
    private static void mostrarUltimaModificacionArchivo(String rutaMiArchivo) throws IOException {
        System.out.println(Files.getLastModifiedTime(Paths.get(rutaMiArchivo)));
    }
    /*
     * Ahora yo quiero evitar repetir codigo, por lo que crearemos una funcion
     * Observar que salimos de las llaves de la clase
     */

    private static int sumatoria(int[] numeros) {
        //La funcion recibe un array de numeros enteros(parametro)

        //El int luego de static significa que la funcion va a devolver un entero
        int resultado = 0;

        for(int i=0;i<numeros.length;i++) { //Uso el parametro de numeros normal
            resultado = resultado + numeros[i];
            /*
             * Estoy sumando los elementos del array,
             * en la primer vuelta resultado vale 0 entonces le suma un 1,
             * resultado vale 1..Ahora en la segunda vuelta resultado viene con un 1
             * y se le suma el proximo numero que es 5, y resultado queda
             * valiendo 6 y asi sucesivamente..
             */

        }

        //Las funciones void no llevan return

        return resultado; //Devuelve lo que tenga la variable resultado(int en este caso)


    }
    private static String saludoPersonalizadoPara(String nombre,String apellido) {
        /*
         * Esta funcion devuelve un string y tiene como parametro a nombre y apellido
         */
        return "Hola " + nombre + " " + apellido + "," + "bienvenido!";

        //Le debo pasar un nombre y appelido
    }
}