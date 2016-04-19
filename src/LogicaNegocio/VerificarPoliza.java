package LogicaNegocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago.sanmartin
 */
public class VerificarPoliza {

    private String placa;
    private File miArchivo;
    private boolean colision;
    private boolean fallaDesc;
    private boolean faltaComb;
    private boolean asegurado;
    private String cubierto;

    public VerificarPoliza(String placa, File miArchivo, boolean colision, boolean fallaDesc, boolean faltaComb) {
        this.placa = placa;
        this.miArchivo = miArchivo;
        this.colision = colision;
        this.fallaDesc = fallaDesc;
        this.faltaComb = faltaComb;
    }

    public boolean VerificarVigenciaSeguro() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(miArchivo));
            String line = placa;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(line)) {
                    this.setAsegurado(true);
                }
                else this.setAsegurado(false);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,e.getCause(),"archivo no encontrado",Integer.BYTES);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e.getCause(),"error desconocido",Integer.BYTES);
        }
        return this.isAsegurado();
    }
    
    public String VerificarCoberturaProblema(){        
        /* El seguro solo cubre colisiones y falta de combustible*/
        if (colision) {
            this.setCubierto("Cubre Colision");
        }if (fallaDesc) {
            this.setCubierto("No Cubre Fallas Desconocidas");
        }if (faltaComb) {
            this.setCubierto("Cubre falta de Combustible");
        }else this.setCubierto("¿?");
        return this.getCubierto();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public File getMiArchivo() {
        return miArchivo;
    }

    public void setMiArchivo(File miArchivo) {
        this.miArchivo = miArchivo;
    }

    public boolean isAsegurado() {
        return asegurado;
    }

    public void setAsegurado(boolean cubierto) {
        this.asegurado = cubierto;
    }

    public String getCubierto() {
        return cubierto;
    }

    public void setCubierto(String cubierto) {
        this.cubierto = cubierto;
    }
    
}