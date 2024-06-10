public class Main {
    public static void main(String[] args) {
        pila_dinamica pila=new pila_dinamica(5);


        pila.add(1);

        System.out.println("Se agrego el numero "+pila.first());
        pila.add(2);
        System.out.println("Se agrego el numero "+pila.first());
        pila.add(3);
        System.out.println("Se agrego el numero "+pila.first());
        pila.add(4);
        System.out.println("Se agrego el numero "+pila.first());
        pila.add(5);
        System.out.println("Se agrego el numero "+pila.first());
        pila.add(6);


        for (int i = 0; i < 6; i++) {
            pila.add(i+1);
            System.out.println("Se agrego");
        }
    }
}