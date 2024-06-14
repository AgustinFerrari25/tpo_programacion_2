import Impl.cola_dinamica_ciclica;

public class Main {
    public static void main(String[] args) {

        cola_dinamica_ciclica cola = new cola_dinamica_ciclica();

        for (int i = 1; i <= 10; i++) {
            cola.add(i);
        }

        System.out.println("Elementos en la cola y su alrededor:");
        cola.elementoyalrededor();

        System.out.println("Eliminando elementos");
        while (!cola.isEmpty()) {
            cola.remove();
        }

        System.out.println("¿Cola vacía?: " + cola.isEmpty());
    }
}
