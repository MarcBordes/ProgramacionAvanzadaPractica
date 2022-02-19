import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
public class CSV {

    public Table leerTabla(String NombreFichero) throws FileNotFoundException {
        Table tabla = new Table();
        List<String> cabezeraNueva = new LinkedList<>();
        List<ROW> listaFilas = new LinkedList<>();
        File fichero = new File(NombreFichero);
        Scanner leer = new Scanner(fichero);
        String[] separado = leer.next().split(",");
        for(String nombreColumna : separado){
            cabezeraNueva.add(nombreColumna);
        }

        tabla.setCabezera(cabezeraNueva);

        while(leer.hasNextLine()) {
            String[] lista = leer.next().split(",");
            List<Double> filas = new LinkedList<>();
            for (String aux : lista) {
                double str1 = Double.parseDouble(aux);
                filas.add(str1);
            }
            ROW filax = new ROW(filas);
            listaFilas.add(filax);
        }

        tabla.setListaFilas(listaFilas);
        return tabla;
    }

    public TableWithLabels LeerTablaConLabels(String nombreFich) throws FileNotFoundException{
        TableWithLabels tablalabels = new TableWithLabels();
        List<String> cabezeraNueva = new LinkedList<>();
        List<RowWithLabel> listaFilas = new LinkedList<>();
        File fichero = new File(nombreFich);
        Scanner leer = new Scanner(fichero);
        String[] separado = leer.next().split(",");
        for(String nombreColumna : separado){
            cabezeraNueva.add(nombreColumna);
        }

        tablalabels.setCabezera(cabezeraNueva);
        List<String> classes = new LinkedList<>();

        while(leer.hasNextLine()) {
            String[] ejemplar = leer.next().split(",");
            List<Double> filas = new LinkedList<>();
            for (int i = 0; i < ejemplar.length - 1; i++ ) {
                String aux = ejemplar[i];
                double str1 = Double.parseDouble(aux);
                filas.add(str1);
            }
            String label = ejemplar[ejemplar.length - 1];
            classes.add(label);

            RowWithLabel filax = new RowWithLabel(filas);
            listaFilas.add(filax);
            filax.setLabel(label);
        }

        tablalabels.setListaFilasLabels(listaFilas);
        return tablalabels;
    }
}

