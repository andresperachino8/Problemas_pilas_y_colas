import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Practica_Pilas {
    // Problema 1
    // Escribir una función Reemplazar que tenga como argumentos una pila con tipo
    // de elemento enteros y dos valores, nuevo y viejo, de forma que, si el segundo
    // valor aparece en algún lugar de la pila, sea reemplazado por el primero.
    static Stack<Integer> elementos = new Stack<Integer>();

    public static void reemplazar(Stack<Integer> pila, int nuevo, int viejo) {
        // Declara Pila auxiliar para ir almacenando elementos.
        Stack<Integer> pila_aux = new Stack<>();
        // Ejecuta bloque While hasta que la pila ingresada por parámetro esté vacía.
        while (!pila.isEmpty()) {
            // Asigna el último valor de la pila a la variable valor.
            int valor = pila.peek();
            /*
             * compara la variable valor con el parámetro ingresado a reemplazar, si es
             * igual lo almacena en la pila
             * auxiliar y si no almacena el ultimo valor de la pila ingresada
             */
            if (valor == viejo) {
                pila_aux.push(nuevo);
            } else {
                pila_aux.push(valor);
            }
            // Elimina ultimo elemento de la pila pasada por parámetro.
            pila.pop();
        }
        /*
         * El siguiente while hace el procedimiento inverso para volver a llenar la pila
         * original pero esta vez con
         * el valor reemplazado
         */
        while (!pila_aux.isEmpty()) {
            pila.push(pila_aux.peek());
            pila_aux.pop();
        }

        // CASO DE USO EN main
        /*
         * reemplazar(elementos, 37, 12);
         * System.out.println(elementos);
         */
    }

    // PROBLEMA 2
    /*
     * Supongamos que TEST es función Booleana que toma cualquier entero dado y
     * devuelve un valor igual o distinto a cero. Consideremos además el siguiente
     * segmento de código:
     * N=3;
     * pila = Pila(MAX_INT);
     * for (i = 1; i<= N; i++){
     * if (TEST(i))
     * print(i);
     * else
     * pila.push(i);
     * while (!pila.isEmpty){
     * el = pila.pop();
     * print(el);
     * }
     * ¿Cuáles de las siguientes son posibles salidas del código anterior?. a) 1 2 3
     * b) 1 3 2 c) 2 1 3 d) 3 1 2 e) 2 3 1 f) 3 2 1
     */

    // RESPUESTA
    /*
     * No conozco la implementación del método TEST, pero suponiendo que arroja true
     * o false aleatoriamente.
     * Las salidas posibles son las que se muestran en las opciones a (V V V), b (V
     * F F), y f (F F F).
     */

    // PROBLEMA 3
    /*
     * Problema 3: Paréntesis balanceados en expresión aritmética
     * Implementar un programa que determine si los delimitadores (, ), {, }, [, ]
     * en una expresión aritmética (e.j. [(5+x)-(y+z)]) están equilibrados. En caso
     * que la expresión aritmética se encuentre balanceada retornar true, en caso
     * contrario retornar false.
     * Entrada: {([()])} -> Salida: true
     * Entrada: ({[])} -> Salida: false
     */

    public static boolean estaBalanceado(String expresion) {
        // Declaro una pila de tipo Character
        Stack<Character> pila = new Stack<Character>();
        // Bucle para recorrer cada caracter del String ingresado como parámetro
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            // Si el caracter es de apertura, se ingresa a la pila
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
                // Si el caracter es de clausura, y la pila está vacía, devuelve que la
                // expresion no está balanceada, porque significa que no se
                // almacenaron caracteres de apertura en la pila
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    return false;
                }
                // Si el caracter es de clausura, se compara con el ultimo ingresado en la pila
                // y verifica si coinciden, si no coinciden devuelve
                // que la expresion no está balanceada
                char ultimo = pila.pop();
                if ((c == ')' && ultimo != '(') || (c == ']' && ultimo != '[') || (c == '}' && ultimo != '{')) {
                    return false;
                }
            }
        }
        // Devolverá true si la pila está vacía porque significa que se validaron todos
        // los caracteres cargados.
        return pila.isEmpty();
    }
    /*
     * Prueba en Main
     * String expresion1 = "[(5+x)-(y+z)]";
     * String expresion2 = "({[])}";
     * System.out.println(expresion1 + " -> " + estaBalanceado(expresion1));
     * System.out.println(expresion2 + " -> " + estaBalanceado(expresion2));
     */

    // PROBLEMA 4
    /*
     * Ejercicio 4 Se realiza sobre una pila, una secuencia de operaciones de apilar
     * y desapilar. Las operaciones de apilar apilarán, de a uno, los números del 0
     * al 9 en orden (el primer apilar apilará el 0, el segundo apilar el 1, y así
     * hasta que el décimo apilar apile el 9). Cada operación de desapilar, además
     * de desapilar el elemento, lo imprimirá por pantalla. Determinar cuáles de las
     * siguientes opciones no es posible que ocurra. Para cada una de las que sí son
     * posibles, dar una secuencia de llamadas a apilar y desapilar que la cumpla.
     * a. 4 3 2 1 0 9 8 7 6 5
     * b. 4 6 8 7 5 3 2 9 0 1
     * c. 2 5 6 7 4 8 9 3 1 0
     * d. 4 3 2 1 0 5 6 7 8 9
     */
    // RESPUESTA
    /*
     * A: APILAR
     * D: DESAPILAR
     * 
     * a. A A A A A D D D D D A A A A A D D D D D (es posible)
     * b. No es posible porque el 0 no puede mostrarse antes que el 1
     * c. A A A D A A A D A D A D D A D A D D D D (es posible)
     * d. A A A A A D D D D D A D A D A D A D A D (es posible)
     */

    // PROBLEMA 6
    /*
     * Ejercicio 6
     * Escribir un algoritmo que recibe una cola e invierte el orden de sus
     * elementos. Se debe modificar la Cola recibida, no devolver una nueva ni
     * tampoco debe usar estructuras auxiliares.
     */

    public static void invertQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return; // Caso base: la cola está vacía
        }

        // Desencolar el primer elemento y almacenarlo en una variable temporal
        int temp = queue.poll();

        // Llamar recursivamente para invertir el resto de la cola
        invertQueue(queue);

        // En este punto, la cola se ha invertido, y podemos volver a encolar el
        // elemento temporal al final
        queue.offer(temp);
    }
    // BLOQUE EN MAIN
    /*
     * Queue<Integer> queue = new LinkedList<>();
     * 
     * // Agregar elementos a la cola
     * for (int i = 1; i <= 5; i++) {
     * queue.offer(i);
     * }
     * 
     * // Invertir la cola
     * invertQueue(queue);
     * 
     * // Imprimir la cola invertida
     * while (!queue.isEmpty()) {
     * System.out.print(queue.poll() + " ");
     * }
     */

    // PROBLEMA 7
    /*
     * Ejercicio 7
     * Sabiendo que se cuenta con una cola a la que se aplican las operaciones
     * encolar, desencolar, implementar un algoritmo que permita manejar una cola
     * con prioridad. Al desencolar debe priorizar aquellos elementos que fueron
     * encolados con prioridad; es decir, no deben salir elementos comunes de la
     * estructura si no salieron previamente todos los elementos con prioridad.
     */

    public class ColaConPrioridad {
        private Queue<Integer> colaNormal;
        private Queue<Integer> colaPrioridad;

        public ColaConPrioridad() {
            colaNormal = new LinkedList<>();
            // import java.util.PriorityQueue
            colaPrioridad = new PriorityQueue<>();
        }

        // Método para encolar un elemento con prioridad
        public void encolarConPrioridad(int elemento) {
            colaPrioridad.add(elemento);
        }

        // Método para encolar un elemento común
        public void encolar(int elemento) {
            colaNormal.add(elemento);
        }

        // Método para desencolar un elemento, priorizando la cola de prioridad
        public int desencolar() {
            if (!colaPrioridad.isEmpty()) {
                return colaPrioridad.poll();
            } else if (!colaNormal.isEmpty()) {
                return colaNormal.poll();
            } else {
                throw new IllegalStateException("La cola está vacía");
            }
        }

        // Método para verificar si la cola está vacía
        public boolean estaVacia() {
            return colaNormal.isEmpty() && colaPrioridad.isEmpty();
        }

        /*
         * PRUEBA MAIN
         * ColaConPrioridad cola = new ColaConPrioridad();
         * 
         * cola.encolar(1);
         * cola.encolar(2);
         * cola.encolarConPrioridad(3);
         * cola.encolar(4);
         * cola.encolarConPrioridad(5);
         * 
         * while (!cola.estaVacia()) {
         * System.out.println(cola.desencolar());
         * }
         */
    }

    // PROBLEMA 8
    /*
     * Ejercicio 8
     * Implementar un algoritmo para un solitario
     * Se inicia con un mazo de n naipes mezclados.
     * Se debe apilar estos naipes en otro mazo, una arriba de otra. Sólo permite
     * apilar un naipe si es de un número inferior al naipe que está en el tope.
     * Se toma el naipe que está en el tope del primer mazo, si el naipe no cumple
     * con esa condición vuelve al final del primer mazo.
     * Este paso puede realizarse n veces, al finalizar, muestra la cantidad de
     * naipes que se apilaron en el segundo mazo.
     */

    public static int jugarSolitario(int[] mazo) {
        Stack<Integer> pilaOriginal = new Stack<>();
        Queue<Integer> colaSecundaria = new LinkedList<>();

        // Inicializa la cola secundaria con los naipes del mazo
        for (int naipe : mazo) {
            colaSecundaria.add(naipe);
        }

        int contadorApilados = 0;

        while (!colaSecundaria.isEmpty()) {
            int naipeActual = colaSecundaria.poll();

            while (!pilaOriginal.isEmpty() && pilaOriginal.peek() < naipeActual) {
                colaSecundaria.add(pilaOriginal.pop());
            }

            pilaOriginal.push(naipeActual);
            contadorApilados++;
        }

        return contadorApilados;

        // PRUEBA EN MAIN
        /*
         * public static void main(String[] args) {
         * int[] mazoOriginal = {3, 1, 4, 2, 5};
         * 
         * int cantidadApilada = jugarSolitario(mazoOriginal);
         * System.out.println("Cantidad de naipes apilados en el segundo mazo: " +
         * cantidadApilada);
         * }
         */
    }

    // PROBLEMA 9
    /*
     * Ejercicio 9
     * Un profesor dicta n materias y en la primera fecha de final se rinden todas
     * en la misma aula. Para organizar a los alumnos que rinden, nos pide un
     * algoritmo que, dada una cola de Alumnos, devuelva para cada materia una lista
     * con los Alumnos que rinden esa materia, respetando el orden de llegada en la
     * cola de entrada.
     */

    public static Map<String, Queue<Alumno>> organizarAlumnosPorMateria(Queue<Alumno> alumnos) {
        Map<String, Queue<Alumno>> resultado = new HashMap<>();

        while (!alumnos.isEmpty()) {
            Alumno alumno = alumnos.poll();
            String materia = alumno.getMateria();

            // Si la materia no está en el mapa, la agregamos con una nueva cola
            resultado.putIfAbsent(materia, new LinkedList<>());

            // Agregamos al alumno en la cola correspondiente a la materia
            Queue<Alumno> colaMateria = resultado.get(materia);
            colaMateria.offer(alumno);
        }

        return resultado;
    }
    // PRUEBA EN MAIN
    /*
     * // Crear una cola de alumnos
     * Queue<Alumno> colaAlumnos = new LinkedList<>();
     * colaAlumnos.offer(new Alumno("Juan", "Matemática"));
     * colaAlumnos.offer(new Alumno("María", "Historia"));
     * colaAlumnos.offer(new Alumno("Pedro", "Matemática"));
     * colaAlumnos.offer(new Alumno("Laura", "Historia"));
     * colaAlumnos.offer(new Alumno("Carlos", "Matemática"));
     * colaAlumnos.offer(new Alumno("Ana", "Física"));
     * 
     * // Organizar los alumnos por materia
     * Map<String, Queue<Alumno>> resultado =
     * organizarAlumnosPorMateria(colaAlumnos);
     * 
     * // Imprimir los resultados
     * for (Map.Entry<String, Queue<Alumno>> entry : resultado.entrySet()) {
     * String materia = entry.getKey();
     * Queue<Alumno> alumnosPorMateria = entry.getValue();
     * System.out.println("Materia: " + materia);
     * while (!alumnosPorMateria.isEmpty()) {
     * Alumno alumno = alumnosPorMateria.poll();
     * System.out.println(" - " + alumno.getNombre());
     * }
     * }
     */

    // PROBLEMA 10
    /*
     * Ejercicio 10
     * Escribir un algoritmo que modele el trabajo de una torre de control de un
     * aeropuerto con una pista de aterrizaje. Los aviones que están esperando para
     * aterrizar tienen prioridad sobre los que están esperando para despegar. La
     * clase debe funcionar conforme al siguiente ejemplo:
     * Vuelos esperando para aterrizar: AR156, AR32
     * Vuelos esperando para despegar: KLM1267
     * El vuelo AR156 aterrizó con éxito.
     * El vuelo AR32 aterrizó con éxito.
     * El vuelo KLM1267 despegó con éxito.
     * No hay vuelos en espera.
     */
    // PRUEBA EN MAIN
    /*
     * TorreControlAeropuerto torre = new TorreControlAeropuerto();
     * 
     * torre.esperarAterrizar("AR156");
     * torre.esperarAterrizar("AR32");
     * torre.esperarDespegar("KLM1267");
     * 
     * while (torre.hayVuelosEnEspera()) {
     * torre.aterrizar();
     * torre.despegar();
     * }
     */

    // PROBLEMA 11
    /*
     * Ejercicio 11
     * Escribir un algoritmo que permita modelar el funcionamiento de una impresora.
     * Una impresora:
     * • Tiene una capacidad máxima de tinta.
     * • Permite encolar documentos para imprimir (recibiendo el nombre de los
     * documentos).
     * • Permite imprimir los documentos en el orden en que se enviaron a imprimir
     * – Si no hay documentos encolados, se muestra un mensaje informándolo.
     * – Si no hay tinta suficiente, se muestra un mensaje informándolo.
     * – En caso contrario, se muestra el nombre del documento, y se gasta 1 unidad
     * de tinta.
     * - Permite cargar el cartucho de tinta
     */

    // PRUEBA EN MAIN
    /*
     * Impresora impresora = new Impresora(5); // Capacidad máxima de tinta: 5
     * unidades
     * 
     * impresora.encolarDocumento("Documento1");
     * impresora.encolarDocumento("Documento2");
     * impresora.encolarDocumento("Documento3");
     * 
     * impresora.imprimirDocumento();
     * impresora.imprimirDocumento();
     * impresora.imprimirDocumento();
     * impresora.imprimirDocumento(); // No hay documentos encolados
     * impresora.cargarTinta(3); // Cargar tinta
     * impresora.imprimirDocumento();
     */

    // PROBLEMA 12
    /*
     * Ejercicio 12
     * En un banco ingresa una cantidad n de clientes.
     * Cada cliente informa su DNI a la recepcionista al ingresar.
     * Para acelerar la atención se divide a los clientes en 2 grupos ordenados por
     * orden de llegada:
     * Grupo 1: clientes con documento terminado en número par
     * Grupo 2: clientes con documento terminado en número impar
     * Se debe mostrar en una pantalla cada grupo con los DNI ordenados por orden de
     * llegada
     */

}

// PARA PROBLEMA 9
class Alumno {
    String nombre;
    String materia;

    public Alumno(String nombre, String materia) {
        this.nombre = nombre;
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMateria() {
        return materia;
    }
}

// PARA PROBLEMA 10
class TorreControlAeropuerto {
    private Queue<String> vuelosAterrizar;
    private Stack<String> vuelosDespegar;

    public TorreControlAeropuerto() {
        vuelosAterrizar = new LinkedList<>();
        vuelosDespegar = new Stack<>();
    }

    public void esperarAterrizar(String vuelo) {
        vuelosAterrizar.offer(vuelo);
    }

    public void esperarDespegar(String vuelo) {
        vuelosDespegar.push(vuelo);
    }

    public void aterrizar() {
        if (!vuelosAterrizar.isEmpty()) {
            String vuelo = vuelosAterrizar.poll();
            System.out.println("El vuelo " + vuelo + " aterrizó con éxito.");
        } else {
            System.out.println("No hay vuelos esperando para aterrizar.");
        }
    }

    public void despegar() {
        if (!vuelosDespegar.isEmpty()) {
            String vuelo = vuelosDespegar.pop();
            System.out.println("El vuelo " + vuelo + " despegó con éxito.");
        } else {
            System.out.println("No hay vuelos esperando para despegar.");
        }
    }

    public boolean hayVuelosEnEspera() {
        return !vuelosAterrizar.isEmpty() || !vuelosDespegar.isEmpty();
    }
}

// PARA PROBLEMA 11
class Impresora {
    private Queue<String> documentosEncolados;
    private Stack<String> documentosImprimir;
    private int tintaDisponible;

    public Impresora(int capacidadTinta) {
        documentosEncolados = new LinkedList<>();
        documentosImprimir = new Stack<>();
        tintaDisponible = capacidadTinta;
    }

    public void encolarDocumento(String nombreDocumento) {
        documentosEncolados.offer(nombreDocumento);
    }

    public void imprimirDocumento() {
        if (documentosEncolados.isEmpty()) {
            System.out.println("No hay documentos encolados para imprimir.");
        } else if (tintaDisponible <= 0) {
            System.out.println("No hay tinta suficiente para imprimir.");
        } else {
            String documentoAImprimir = documentosEncolados.poll();
            documentosImprimir.push(documentoAImprimir);
            tintaDisponible--;
            System.out.println("Imprimiendo: " + documentoAImprimir);
        }
    }

    public void cargarTinta(int unidades) {
        tintaDisponible += unidades;
        System.out.println("Se cargaron " + unidades + " unidades de tinta. Tinta disponible: " + tintaDisponible);
    }
}

// PARA PROBLEMA 12

class Cliente {
    String dni;

    public Cliente(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }
}

class Banco {
    public static void main(String[] args) {
        int n = 10; // Número de clientes (puedes ajustarlo según necesites)

        Queue<Cliente> grupoPar = new LinkedList<>();
        Queue<Cliente> grupoImpar = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Simulamos la recepción del DNI del cliente (puedes cambiar esta parte según
            // tus necesidades)
            String dni = "DNI" + i; // Aquí debes obtener el DNI de cada cliente

            Cliente cliente = new Cliente(dni);

            // Decidir a qué grupo pertenece el cliente según la paridad del último dígito
            int ultimoDigito = Integer.parseInt(dni.substring(dni.length() - 1));
            if (ultimoDigito % 2 == 0) {
                grupoPar.offer(cliente);
            } else {
                grupoImpar.offer(cliente);
            }
        }

        // Mostrar los DNIs de los clientes en cada grupo
        System.out.println("Grupo 1 (DNI par):");
        while (!grupoPar.isEmpty()) {
            Cliente cliente = grupoPar.poll();
            System.out.println(cliente.getDni());
        }

        System.out.println("\nGrupo 2 (DNI impar):");
        while (!grupoImpar.isEmpty()) {
            Cliente cliente = grupoImpar.poll();
            System.out.println(cliente.getDni());
        }
    }
}