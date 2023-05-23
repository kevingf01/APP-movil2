package models;

import java.util.ArrayList;

public class Medicos {

    //Declaracion de variables
    private int cod_medico;
    private ArrayList<String> medicos = new ArrayList();

    //Constructor
    public Medicos(){

        cod_medico = 1;
        medicos.add("Nicolas Fernandez");
        medicos.add("Sofia Riquelme");
        medicos.add("Sonic the Hedgehog");

    }

    public Medicos(int cod_medico, ArrayList<String> medicos) {
        this.cod_medico = cod_medico;
        this.medicos = medicos;
    }

    public int getCod_medico() {
        return cod_medico;
    }

    public void setCod_medico(int cod_medico) {
        this.cod_medico = cod_medico;
    }

    public ArrayList<String> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<String> medicos) {
        this.medicos = medicos;
    }
}
