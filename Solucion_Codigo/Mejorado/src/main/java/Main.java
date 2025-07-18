import Vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando sistema de transporte...");
        
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.mostrarMenu();
        
        System.out.println("Sistema terminado.");
    }
}
