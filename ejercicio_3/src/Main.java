import Impl.cola_dinamica_ciclica;

public class Main {
    public static void main(String[] args) {

        cola_dinamica_ciclica cola = new cola_dinamica_ciclica();

        for (int i = 1; i <= 10; i++) {
            cola.add(i);
        }

        System.out.println("Elementos en la cola:");
        for (int i = 0; i < 10; i++) {
            System.out.print(cola.first()+"\n");
            cola.add(cola.first());
            cola.remove();
        }

        System.out.println("Primero: " + cola.first());

        System.out.println("Eliminando todos los elementos");
        while (!cola.isEmpty()) {
            cola.remove();
        }

        System.out.println("¿Cola vacía?: " + cola.isEmpty());

    }
}