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
                } else {
                    this.setAsegurado(false);
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getCause(), "archivo no encontrado", Integer.BYTES);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getCause(), "error desconocido", Integer.BYTES);
        }
        return this.isAsegurado();
    }

    public String VerificarCoberturaProblema() {
        /* El seguro solo cubre colisiones y falta de combustible*/
        if (this.isFallaDesc()&&!this.isColision()&&!this.isFaltaComb()) {//100
            this.setCubierto("el seguro no cubre este daño");
        }else if (this.isFallaDesc()&&this.isColision()&&!this.isFaltaComb()) {//110
            this.setCubierto("el seguro cubre 50% de los daños");
        }else if (this.isFallaDesc()&&!this.isColision()&&this.isFaltaComb()) {//101
            this.setCubierto("el seguro cubre 50% de los daños");
        }else if (this.isFallaDesc()&&this.isColision()&&this.isFaltaComb()) {//111
            this.setCubierto("el seguro cubre 70% de los daños");
        }else if (!this.isFallaDesc()&&!this.isColision()&&this.isFaltaComb()) {//001
            this.setCubierto("el seguro cubre 100% de los daños");
        }else if (!this.isFallaDesc()&&this.isColision()&&!this.isFaltaComb()) {//010
            this.setCubierto("el seguro cubre 100% de los daños");
        }else if (!this.isFallaDesc()&&this.isColision()&&this.isFaltaComb()) {//011
            this.setCubierto("el seguro cubre 66% de los daños");
        }
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

    public boolean isColision() {
        return colision;
    }

    public void setColision(boolean colision) {
        this.colision = colision;
    }

    public boolean isFallaDesc() {
        return fallaDesc;
    }

    public void setFallaDesc(boolean fallaDesc) {
        this.fallaDesc = fallaDesc;
    }

    public boolean isFaltaComb() {
        return faltaComb;
    }

    public void setFaltaComb(boolean faltaComb) {
        this.faltaComb = faltaComb;
    }

}
