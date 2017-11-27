/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Urna_Eletronica;

import java.util.ArrayList;

/**
 *
 * @authors Henrique Turazzi - RA 21014343
 *          Vitor Machado - RA 20768705
 *          Jean Mota - RA 20654907
 *          Wesley Porto - RA 21017730
 */
public class Candidato {

    private int votos;
    private String nome;
    private String partido;
    private String tipo;
    
    public Candidato() {
    
    }
    
    public Candidato(String nome, String partido) {
        this.nome = nome;
        this.partido = partido;
    }
    
    public void AdicionaVoto() {
        votos = votos + 1;
    }
    public int RetornarVotos() {
        return votos;
    }
    
    public static boolean verificaVotos() {
        int contPrefeito = 0;
        int contVereador = 0;
        for (Candidato c : ListaCandidatos.getListaCandidatos()) {
            if ((c.RetornarVotos() > 0) &&
                (c.getTipo().equalsIgnoreCase("Prefeito")))
                contPrefeito += c.RetornarVotos() ;
            else if ((c.RetornarVotos() > 0) &&
                (c.getTipo().equalsIgnoreCase("Vereador")))
                contVereador += c.RetornarVotos();            
        }
        
        return contPrefeito == contVereador && contPrefeito > 0 && contVereador > 0;
        
    }
    
    public static boolean verificaCandidato(String tipo) {
        for (Candidato c : ListaCandidatos.getListaCandidatos(tipo)) {
            return true;
        }

        return false;
    }
    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setNome(String nome) {
        if (nome.length() == 0)
            throw new IllegalArgumentException("Preencha o campo");
            
        this.nome = nome;
    }

    public void setPartido(String partido) {
        if (partido.length() == 0)
            throw new IllegalArgumentException("Preencha o campo");
            
        this.partido = partido;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String imprimirDados() {
        return "Nome: " + nome + "\nPartido: " + partido + "\nTipo: " + tipo;
    }
    public String imprimirDadosResultado() {
        return "Nome: " + nome + "\nPartido: " + partido + "\nVotos: " + votos;
    }
    
    public static String vencedorPrefeito() {
        String vencedor = "";
        int votos = 0;
        for (Candidato c : ListaCandidatos.getListaCandidatos("Prefeito")) {
            if (c.RetornarVotos() > votos && c.getTipo().equalsIgnoreCase("Prefeito")) {
                
                votos = c.RetornarVotos();
                vencedor = c.imprimirDadosResultado() + "\n----------\n";
                
            } else if (c.RetornarVotos() == votos && c.getTipo().equalsIgnoreCase("Prefeito")) {
                votos = c.RetornarVotos();
                vencedor += c.imprimirDadosResultado() + "\n----------\n";
            }
            
        }
        
        return vencedor;
    }
    
    public static String vencedorVereador() {
        String vencedor = "";
        int votos = 0;
        for (Candidato c : ListaCandidatos.getListaCandidatos("Vereador")) {
            if (c.RetornarVotos() > votos && c.getTipo().equalsIgnoreCase("Vereador")) {
                
                votos = c.RetornarVotos();
                vencedor = c.imprimirDadosResultado() + "\n----------\n";
                
            } else if (c.RetornarVotos() == votos && c.getTipo().equalsIgnoreCase("Vereador")) {
                votos = c.RetornarVotos();
                vencedor += c.imprimirDadosResultado() + "\n----------\n";
            }
            
        }
        
        return vencedor;
    }
    
}
