import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

class CSVTest {

    CSV fichero = new CSV();

    @Test
    void leerTablaCorrecta() throws FileNotFoundException {
        fichero.leerTabla("miles_dollars.csv");
    }

    @Test
    void leerTablaNombreErroneo() throws FileNotFoundException {
        assertThrows(FileNotFoundException.class, ()->fichero.leerTabla("mal.csv"));
    }
    @Test
    void imprimirColumna() throws FileNotFoundException {
       Table tabla;
       tabla = fichero.leerTabla("miles_dollars.csv");
       List<Double> imprimir = tabla.getColumnAt(0);
       for(Double elem : imprimir)
           System.out.println(elem);
    }

    @Test
    void mostrarFila() throws FileNotFoundException{
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        ROW fila = tabla.getRowAt(1);
        System.out.println(fila.getData());
    }


    @Test
    void imprimirColumnaErronea() throws IndexOutOfBoundsException,FileNotFoundException{
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        assertThrows(IndexOutOfBoundsException.class, ()->tabla.getColumnAt(2));
    }

    @Test
    public void mostrarTablaMiles_Dollars() throws FileNotFoundException{
        Table tabla;
        tabla = fichero.leerTabla("miles_dollars.csv");
        System.out.println(tabla.cabezeras);
        for(ROW elemento : tabla.listaFilas){
            System.out.println(elemento.getData());
        }
    }

    @Test
    public void mostrarTablaIrisSoloNumeros() throws FileNotFoundException {
        Table tablax;
        tablax = fichero.leerTabla("irisSolonumeros.csv");
        System.out.println(tablax.cabezeras);
        for(ROW elemento : tablax.listaFilas) {
            System.out.println(elemento.getData());
        }
    }

    @Test
    public void mostrarFilaConLabel() throws FileNotFoundException{
        TableWithLabels tabla;
        tabla = fichero.LeerTablaConLabels("iris.csv");
        RowWithLabel fila = tabla.getRowAt(1);
        System.out.println(fila.getData() + " " + fila.getLabel());

    }

    @Test
    public void mostrarTablaIris() throws FileNotFoundException {
        TableWithLabels tablax;
        tablax = fichero.LeerTablaConLabels("iris.csv");
        System.out.println(tablax.cabezeras);
        for(RowWithLabel elemento : tablax.listaFilas) {
            System.out.println(elemento.getData() + " " + elemento.getLabel());
        }
    }

}


