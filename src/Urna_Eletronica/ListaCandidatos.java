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
public class ListaCandidatos {
    
    private static ArrayList<Candidato> listaCandidatos = new ArrayList<>();

    public ListaCandidatos() {
    }
    
    //Get da lista de candidatos
    public static ArrayList<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }
    
    public static ArrayList<Candidato> getListaCandidatos(String tipo) {
        ArrayList <Candidato> lista = new ArrayList();
        
        for (Candidato c : ListaCandidatos.getListaCandidatos()) {
            if (c.getTipo().equalsIgnoreCase(tipo))
                lista.add(c);
        }
        
        return lista;
    }
    
    
    //Método para adicionar candidato no fim da lista
    static void adicionar(Candidato c){
        listaCandidatos.add(c);
    }
    
    static String listarCandidatos(String tipo){
        String saida = "";
        saida = "--------   Resultado " + tipo + "   --------\n\n";
        if (tipo.equalsIgnoreCase("Prefeito")) {
            for(Candidato c : listaCandidatos){
                if (c.getTipo().equalsIgnoreCase("Prefeito"))
                    saida += c.imprimirDadosResultado() + "\n----------\n";
            }
        
        } else if (tipo.equalsIgnoreCase("Vereador")) {
            for(Candidato c : listaCandidatos){
                if (c.getTipo().equalsIgnoreCase("Vereador"))
                    saida += c.imprimirDadosResultado() + "\n----------\n";
            }
        } else {
            saida = "Erro ao verificar o tipo de candidato!";
        }
        
        return saida;
    }
}
