/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto1poo;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.io.IOException; // Import the IOException class to handle errors

/**
 *
 * @author Gabriel
 */

public class Projeto1POO {

  class usuario {
    String nome;
    int idade;
    String CPF;
  }

  class login {
    String usuario;
    String login;
  }

  public void conferir() {
    String user = JOptionPane.showInputDialog("Informe o usuario");
    String senha = JOptionPane.showInputDialog("Informe a senha");
    if (user.equals("czar") && senha.equals("3621")) {
      homepage();
    } else {
      JOptionPane.showMessageDialog(null, "Senha incorreta!\nTente novamente");
      conferir();
    }
  }

  public void consultar_horas() {
    File consul = new File("horas.txt");

    if (consul.exists()) {

    } else {
      JOptionPane.showMessageDialog(null, "Esse arquivo não existe!");
    }

  }

  public void criar_arquivo() {
    try {
      File criar = new File("data\\horas.txt");
      if (criar.createNewFile()) {
        System.out.println("Arquivo criado com sucesso");
      } else {
        System.out.println("Arquivo já existe!");
      }

    } catch (IOException e) {
      System.out.println("Ocorreu algum erro");
    }
  }

  public void inserir_na_tabela (JTextField n, JTextField i, JTextField c){
  String nome = n.getText(), idade = i.getText(), cpf = c.getText();
   try {
            FileWriter escritor = new FileWriter("data\\horas.txt", true); // O segundo parâmetro 'true' indica modo de anexação
            escritor.write(nome+";"+idade+";"+cpf+"\n"); // Adiciona uma nova linha ao arquivo
            escritor.close();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
  }

  public Void adicionar_funcionario() {
    JTextField nome = new JTextField();
    JTextField idade = new JTextField();
    JTextField cpf = new JTextField();
    final JComponent[] entrada = new JComponent[] {
      new JLabel("Nome"),
        nome, new JLabel("Idade"), idade, new JLabel("CPF"), cpf
    };

    if((JOptionPane.showConfirmDialog(null, entrada, "Insira os dados", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)){
    System.out.println("Inserida as informações!");
    inserir_na_tabela(nome,idade,cpf);
    homepage();
    }

    else{homepage();}
    return null;

  }


  public void homepage() {

    Object[] opcoes = {
      "Consultar",
      "Adicionar",
    };

    Object selecionarOpcoes = JOptionPane.showInputDialog(null,
      "Escolha uma opção!", "Inserir",
      JOptionPane.INFORMATION_MESSAGE, null,
      opcoes, opcoes[0]);

    switch (selecionarOpcoes.toString()) {
      case "Consultar":
        break;
      case "Adicionar":
        adicionar_funcionario();
        break;
    }
  }

  public static void main(String[] args) {
    Projeto1POO projeto = new Projeto1POO(); //Iniciando o projeto
    projeto.criar_arquivo();
    projeto.homepage();
  }
}