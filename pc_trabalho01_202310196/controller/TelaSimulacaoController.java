/*******************************************************************************************************
* Autor: Maick Vieira Alves
* Matricula: 202310196
* Inicio: 12/03/2025
* Ultima alteracao: 21/03/2025 
* Nome: TelaSimulacaoController
* Descricao: Controller das tela de simulacao. Responsavel por gerencias as funcoes de botoes, sliders e instanciar o objeto Avial
******************************************************************************************************* */

package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Aviao;

public class TelaSimulacaoController {

  @FXML ImageView aviao01;
  @FXML ImageView aviao02;
  @FXML ImageView menuIcone;
  @FXML ImageView imagemRota;

  @FXML Slider sliderAviao02;
  @FXML Slider sliderAviao01;

  @FXML Button botao01;
  @FXML Button botao02;
  @FXML Button botao03;
  @FXML Button botao04;
  @FXML Button botaoReset;
  @FXML Button botaoRota;
  @FXML Button botaoVoltar;

  Aviao av2;
  Aviao av1;
  int posicaoInicial;

  private Scene cena;
  private Stage janela;

   /**************************************************************
   * Metodo: initialize
   * Funcao: metodo que sera executado logo apos carregar o arquivo FXML, responsavel por instanciar os Objetos
   * Aviao e iniciar suas Threads
   * Parametros: nulo
   * Retorno: void
   ***************************************************************/
  @FXML
  public void initialize() {
    // aviao01
    av1 = new Aviao(aviao01, sliderAviao01, posicaoInicial = 2);
    av1.start();

    // aviao02
    av2 = new Aviao(aviao02, sliderAviao02, posicaoInicial = 1);
    av2.start();

  }


  //Botoes para posicionar o aviao:

   /**************************************************************
   * Metodo: Posicao01
   * Funcao: metodo ligado ao botao "botao01", posiciona ambos os avioes embaixo da tela
   * e atribui um valor que sera conferido pela thread para a chamada de seu respectivo metodo
   * Parametros: ActionEvent
   * Retorno: void
   ***************************************************************/
  public void Posicao01(ActionEvent event) throws IOException {

    av1.setPosicaoAviao(2); 
    av2.setPosicaoAviao(1); 

    aviao01.setLayoutX(71);
    aviao01.setLayoutY(681);

    aviao02.setLayoutX(141);
    aviao02.setLayoutY(681);

  }

  /**************************************************************
   * Metodo: Posicao02
   * Funcao: metodo ligado ao botao "botao02", posiciona ambos os avioes enCIM da tela
   * e atribui um valor que sera conferido pela thread para a chamada de seu respectivo metodo
   * Parametros: ActionEvent
   * Retorno: void
   ***************************************************************/
  public void Posicao02(ActionEvent event) throws IOException {

    av1.setPosicaoAviao(4);
    av2.setPosicaoAviao(3);

    aviao01.setLayoutX(71);
    aviao01.setLayoutY(-70);

    aviao02.setLayoutX(141);
    aviao02.setLayoutY(-70);
  }

   /**************************************************************
   * Metodo: Posicao03
   * Funcao: metodo ligado ao botao "botao03", posiciona o aviao01 encima e o aviao 02 embaixo da tela
   * e atribui um valor que sera conferido pela thread para a chamada de seu respectivo metodo
   * Parametros: ActionEvent
   * Retorno: void
   ***************************************************************/
  public void Posicao03(ActionEvent event) throws IOException {

    av1.setPosicaoAviao(4);
    av2.setPosicaoAviao(1);

    aviao01.setLayoutX(71);
    aviao01.setLayoutY(-70);

    aviao02.setLayoutX(141);
    aviao02.setLayoutY(681);

  }

  /**************************************************************
   * Metodo: Posicao04
   * Funcao: metodo ligado ao botao "botao04", posiciona o aviao01 embaixo e o aviao 02 encima da tela
   * e atribui um valor que sera conferido pela thread para a chamada de seu respectivo metodo
   * Parametros: ActionEvent
   * Retorno: void
   ***************************************************************/
  public void Posicao04(ActionEvent event) throws IOException {

    av1.setPosicaoAviao(2);
    av2.setPosicaoAviao(3);

    aviao01.setLayoutX(71);
    aviao01.setLayoutY(681);

    aviao02.setLayoutX(141);
    aviao02.setLayoutY(-70);

  }

  // Fim dos botoes para posicionar o aviao

  

   /**************************************************************
   * Metodo: Resetar
   * Funcao: metodo ligado ao botao "botaoReset", reinicia a tela carregando o FXML novamente
   * Parametros: ActionEvent
   * Retorno: void
   ***************************************************************/
  public void Resetar(ActionEvent event) throws IOException {
    Parent raiz = FXMLLoader.load(getClass().getResource("/view/telaSimulacao.fxml"));
    janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
    cena = new Scene(raiz);
    janela.setScene(cena);
    janela.show();

  }

   /**************************************************************
   * Metodo: Voltar
   * Funcao: metodo ligado ao botao "botaoVoltar", volta para o menu inicial carregando o FXML
   * Parametros: ActionEvent
   * Retorno: void
   ***************************************************************/
  public void Voltar(ActionEvent event) throws IOException {

    Parent raiz = FXMLLoader.load(getClass().getResource("/view/telaInicial.fxml"));
    janela = (Stage) ((Node) event.getSource()).getScene().getWindow();
    cena = new Scene(raiz);
    janela.setScene(cena);
    janela.show();
  }

  /**************************************************************
   * Metodo: ExibirRota
   * Funcao: liga/desliga a imagem do "trilho"
   * Parametros: ActionEvent
   * Retorno: void
   ***************************************************************/

  @FXML
  public void ExibirRota(ActionEvent event) throws IOException {
    if (imagemRota.isVisible()) {
      imagemRota.setVisible(false); // Torna a imagem invisível
    } else {
      imagemRota.setVisible(true); // Torna a imagem visível
    }
  }

}
