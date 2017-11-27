/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Urna_Eletronica;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @authors Henrique Turazzi - RA 21014343
 *          Vitor Machado - RA 20768705
 *          Jean Mota - RA 20654907
 *          Wesley Porto - RA 21017730
 */
public class Urna  {
    
    static void CadastroCandidato() throws IOException{
        int opcao;
        Object[] opcao1 = {"Prefeito","Vereador"};
        opcao = JOptionPane.showOptionDialog(null,
                                             "Escolha uma opção:", 
                                             "Cadastro Candidato",
                                             JOptionPane.YES_NO_OPTION,
                                             JOptionPane.PLAIN_MESSAGE,
                                             null,
                                             opcao1,
                                             opcao1[1]);
        switch (opcao) {
        case 0:
            
            Candidato prefeito = new Candidato();
            while (prefeito.getNome() == null) {
                try {
                    prefeito.setNome(JOptionPane.showInputDialog(null,
                                                 "Digite o nome:",
                                                 "Cadastro Prefeito",
                                                 JOptionPane.PLAIN_MESSAGE));
                    
                } catch (NullPointerException exc) {
                    Menu_Opcao();
                } catch (IllegalArgumentException exc) {
                    JOptionPane.showMessageDialog(null,
                                                 exc.getMessage(),
                                                 "Cadastro Prefeito",
                                                 JOptionPane.WARNING_MESSAGE);
                }
                    
            }
            while (prefeito.getPartido() == null) {
                try {
                    prefeito.setPartido(JOptionPane.showInputDialog(null,
                                                     "Digite o partido:",
                                                     "Cadastro Prefeito",
                                                     JOptionPane.PLAIN_MESSAGE));
                    prefeito.setTipo("Prefeito");
                    
                } catch (NullPointerException exc) {
                    Menu_Opcao();

                } catch (IllegalArgumentException exc) {
                    JOptionPane.showMessageDialog(null,
                                                 exc.getMessage(),
                                                 "Cadastro Prefeito",
                                                 JOptionPane.WARNING_MESSAGE);
                }
            }
            
            ListaCandidatos.adicionar(prefeito);
            Menu_Opcao();
            break;
        case 1:
            
            Candidato vereador = new Candidato();
            while (vereador.getNome() == null) {
                try {
                    vereador.setNome(JOptionPane.showInputDialog(null,
                                                 "Digite o nome:",
                                                 "Cadastro Vereador",
                                                 JOptionPane.PLAIN_MESSAGE));
                    
                } catch (NullPointerException exc) {
                    Menu_Opcao();
                } catch (IllegalArgumentException exc) {
                    JOptionPane.showMessageDialog(null,
                                                 exc.getMessage(),
                                                 "Cadastro Vereador",
                                                 JOptionPane.WARNING_MESSAGE);
                }
                    
            }
            while (vereador.getPartido() == null) {
                try {
                
                    vereador.setPartido(JOptionPane.showInputDialog(null,
                                                     "Digite o partido:",
                                                     "Cadastro Vereador",
                                                     JOptionPane.PLAIN_MESSAGE));
                    vereador.setTipo("Vereador");
                } catch (NullPointerException exc) {
                    Menu_Opcao();

                } catch (IllegalArgumentException exc) {
                    JOptionPane.showMessageDialog(null,
                                                 exc.getMessage(),
                                                 "Cadastro Vereador",
                                                 JOptionPane.WARNING_MESSAGE);
                }
            }
            
            ListaCandidatos.adicionar(vereador);
            Menu_Opcao();
            break;
        }
    }
    
    static void IniciarEleicao() throws IOException {
        String verificaTipo = "";
        int contador = 0;
        int opcao;
        Object[] opcao1 = {"Prefeito","Vereador"};
        opcao = JOptionPane.showOptionDialog(null,
                                             "Escolha uma opção:", 
                                             "Votar Candidato",
                                             JOptionPane.YES_NO_OPTION,
                                             JOptionPane.PLAIN_MESSAGE,
                                             null,
                                             opcao1,
                                             opcao1[1]);
        switch (opcao) {
            case 0:
                contador = 0;
                if (Candidato.verificaCandidato("Prefeito")) {
                    while(contador == 0) {
                        for (Candidato c : ListaCandidatos.getListaCandidatos("Prefeito")) {
                            
                            Object[] opcoes = {"Votar","Proximo", "Sair"};
                            opcao = JOptionPane.showOptionDialog(null,
                                                         c.imprimirDados(), 
                                                         "Votar Prefeito",
                                                         JOptionPane.YES_NO_OPTION,
                                                         JOptionPane.PLAIN_MESSAGE,
                                                         null,
                                                         opcoes,
                                                         opcoes[1]);

                            switch (opcao) {
                                case 0:
                                    
                                    c.AdicionaVoto();
                                    JOptionPane.showMessageDialog(null,
                                                              "Obrigado por Votar!",
                                                              "Votar Prefeito",
                                                              JOptionPane.PLAIN_MESSAGE);
                                    Menu_Opcao();
                                case 1:
                                    break;
                                case 2:
                                    Menu_Opcao();

                            }


                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(null,
                                                             "Vote em um prefeito!",
                                                             "Votar Prefeito",
                                                             JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                                             "Obrigado por Votar!",
                                                             "Votar Prefeito",
                                                             JOptionPane.PLAIN_MESSAGE);
                            Menu_Opcao();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                                                  "Candidatos Insuficientes!",
                                                  "Votar Prefeito",
                                                  JOptionPane.WARNING_MESSAGE);
                    Menu_Opcao();
                }
                break;
            case 1:
                contador = 0;
                if (Candidato.verificaCandidato("Vereador")) {
                    while(contador == 0) {
                        for (Candidato c : ListaCandidatos.getListaCandidatos("Vereador")) {
                            
                            Object[] opcoes = {"Votar","Proximo", "Sair"};
                            opcao = JOptionPane.showOptionDialog(null,
                                                         c.imprimirDados(), 
                                                         "Votar Vereador",
                                                         JOptionPane.YES_NO_OPTION,
                                                         JOptionPane.PLAIN_MESSAGE,
                                                         null,
                                                         opcoes,
                                                         opcoes[1]);

                            switch (opcao) {
                                case 0:
                                    c.AdicionaVoto();
                                    JOptionPane.showMessageDialog(null,
                                                              "Obrigado por Votar!",
                                                              "Votar Vereador",
                                                              JOptionPane.PLAIN_MESSAGE);
                                    Menu_Opcao();
                                case 1:
                                    break;
                                case 2:
                                    Menu_Opcao();

                            }
                        }
                        if (contador == 0) {
                            JOptionPane.showMessageDialog(null,
                                                             "Vote em um vereador!",
                                                             "Votar Vereador",
                                                             JOptionPane.WARNING_MESSAGE);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                             "Obrigado por Votar!",
                                                             "Votar Vereador",
                                                             JOptionPane.PLAIN_MESSAGE);
                                Menu_Opcao();
                            }  
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                                                  "Candidatos Insuficientes!",
                                                  "Votar Vereador",
                                                  JOptionPane.WARNING_MESSAGE);
                    Menu_Opcao();
                }
                break;
        } 
    }
    
    static void ResultadoEleicao() throws IOException {
        
        if (!Candidato.verificaVotos()) {
            JOptionPane.showMessageDialog(null,
                                          "Votos insuficientes para eleição",
                                          "Resultado Eleição",
                                          JOptionPane.WARNING_MESSAGE);
            Menu_Opcao();
        } else {
            String retorno = "";
            
            retorno = ListaCandidatos.listarCandidatos("Prefeito");
            JOptionPane.showMessageDialog(null,
                                          retorno,
                                          "Resultado Eleição - Prefeito",
                                          JOptionPane.PLAIN_MESSAGE);
            
            
            retorno = Candidato.vencedorPrefeito();
            JOptionPane.showMessageDialog(null,
                                          retorno,
                                          "Vencedor - Prefeito",
                                          JOptionPane.PLAIN_MESSAGE);
            
            retorno = ListaCandidatos.listarCandidatos("Vereador");
            
            JOptionPane.showMessageDialog(null,
                                          retorno,
                                          "Resultado Eleição - Vereador",
                                          JOptionPane.PLAIN_MESSAGE);
            
            retorno = Candidato.vencedorVereador();
            JOptionPane.showMessageDialog(null,
                                          retorno,
                                          "Vencedor - Vereador",
                                          JOptionPane.PLAIN_MESSAGE);
            
            
            JOptionPane.showMessageDialog(null,
                                          "Fim da Eleição!",
                                          "Resultado Eleição",
                                          JOptionPane.WARNING_MESSAGE);
            
            System.exit(0);
            
        }
    }
    
    static void Menu_Opcao() throws IOException {
        int opcao;    
        
        Object[] opcao1 = {"Cadastrar Candidatos","Iniciar Eleição", "Resultado Eleição" ,"Sair"};
        opcao = JOptionPane.showOptionDialog(null,
                                             "Escolha uma opção:", 
                                             "Urna Eletrônica",
                                             JOptionPane.YES_NO_OPTION,
                                             JOptionPane.PLAIN_MESSAGE,
                                             null,
                                             opcao1,
                                             opcao1[1]);
        
            
        switch (opcao) {
        case 0:
            CadastroCandidato();
            break;
        case 1:
            IniciarEleicao();
            break;
        case 2:
            ResultadoEleicao();
            break;
        case 3:
            System.exit(0);
            break;
        }
    }
    public static void main(String[] args) throws IOException {
        Menu_Opcao();
    }
}
