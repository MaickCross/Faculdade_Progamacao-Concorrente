/*******************************************************************************************************
* Autor: Maick Vieira Alves
* Matricula: 202310196
* Inicio: 12/03/2025
* Ultima alteracao: 21/03/2025 
* Nome: Aviao
* Descricao: Essa classe eh a responsavel pela criacao do objeto Aviao, utilizado na tela de
* simulacao do programa, tambem possui seus metodos utilizados no movimento do objeto aviao
******************************************************************************************************* */

package model;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class Aviao extends Thread {

  private ImageView imagemAviao;
  private double velocidadeAviao;
  private int posicaoAviao;
  private Slider sliderAviao;

  /**************************************************************
   * Metodo: Aviao
   * Funcao: construtor da classe Aviao
   * Parametros: ImageView, SLider, int
   * Retorno:
   ***************************************************************/
  public Aviao(ImageView imagemAviao, Slider sliderAviao, int posicaoAviao) {
    this.imagemAviao = imagemAviao;
    this.sliderAviao = sliderAviao;
    this.posicaoAviao = posicaoAviao;

  }

  /**************************************************************
   * Metodo: run
   * Funcao: inicia a thread responsavel por executar em loop, as logicas de
   * movimento do Aviao
   * Parametros: nulo
   * Retorno: void
   ***************************************************************/
  @Override
  public void run() {
    while (true) {
      Platform.runLater(() -> MovimentarAviao(posicaoAviao)); // movimenta o aviao conforme a posicao definida pelo
                                                              // jogador
      try {
        sleep(80); // responsavel pela animacao
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**************************************************************
   * Metodo: MovimentarAviao
   * Funcao: Responsavel pela movimentação do aviao de acordo com as posicoes de
   * inicio, o metodo chama o metodo relacionada a cada posicao de acordo com as escolhas do usuario
   * Parametros: int
   * Retorno: void
   ***************************************************************/
  public void MovimentarAviao(int posicionarAviao) {

    switch (posicionarAviao) {

      case 1:
        // posiciona o aviao 02 na posicao inferior direita
        moverAviao();
        break;

      case 2:
        // posiciona o aviao 01 na posicao inferior esquerda
        moverAviao02();
        break;

      case 3:
        // posiciona o aviao 02 na posicao superior direita
        moverAviao03();

        break;

      case 4:
        // posiciona o aviao 01 na posicao superior esquerda
        moverAviao04();

        break;
    }
  }

  // metodos relacionados ao movimento dos Avioes:

  /**************************************************************
   * Metodo: moverAviao
   * Funcao: responsavel pela animacao do aviao que inicia na posicao inferior
   * direita
   * Parametros: nulo
   * Retorno: void
   ***************************************************************/
  private void moverAviao() {

    ImageView aviao = this.getImagemAviao(); // variavel para o ImageView
    velocidadeAviao = sliderAviao.getValue(); // slider que define a velocidade do Aviao

    if (aviao.getLayoutY() > 530) { // Trilho duplo horizontal 03
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 490) { // Trilho duplo diagonal <- 03
      aviao.setRotate(-45);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 400) { // Trilho simples 02
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 360) { // Trilho duplo Diagonal -> 02
      aviao.setRotate(45);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() + velocidadeAviao);

    } else if (aviao.getLayoutY() > 250) { // Trilho duplo horizontal 02
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 210) { // Trilho duplo diagonal <- 02
      aviao.setRotate(-45);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 110) { // Trilho simples 01
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 70) { // Trilho duplo diagonal -> 01
      aviao.setRotate(45);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() + velocidadeAviao);

    } else if (aviao.getLayoutY() >= -50) { // Trilho duplo horizontal 01
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() <= -50) { // Final do trajeto
      aviao.setRotate(0);
      aviao.setLayoutX(141); // Posiciona o aviao na coordenada X
      aviao.setLayoutY(681); // Posiciona o aviao na coordenada Y
    }
  }

  /**************************************************************
   * Metodo: moverAviao02
   * Funcao: responsavel pela animacao do aviao que inicia na posicao inferior
   * esquerda
   * Parametros: nulo
   * Retorno: void
   ***************************************************************/
  private void moverAviao02() {

    ImageView aviao = this.getImagemAviao(); // variavel para o ImageView
    velocidadeAviao = sliderAviao.getValue(); // slider que controla a velocidade

    if (aviao.getLayoutY() > 530) { // Trilho duplo horizontal 03
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 490) { // Trilho duplo diagonal -> 03
      aviao.setRotate(45);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() + velocidadeAviao);

    } else if (aviao.getLayoutY() > 400) { // Trilho simples 02
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 360) { // Trilho duplo Diagonal <- 02
      aviao.setRotate(-45);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 250) { // Trilho duplo horizontal 02
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 210) { // Trilho duplo diagonal -> 02
      aviao.setRotate(45);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() + velocidadeAviao);

    } else if (aviao.getLayoutY() > 110) { // Trilho simples 01
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() > 70) { // Trilho duplo diagonal <- 01
      aviao.setRotate(-45);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() - velocidadeAviao);

    } else if (aviao.getLayoutY() >= -50) { // Trilho duplo horizontal 01
      aviao.setRotate(0);
      aviao.setLayoutY(aviao.getLayoutY() - velocidadeAviao);

    } else if (aviao.getLayoutY() <= -50) { // Final do Trajeto
      aviao.setRotate(0);
      aviao.setLayoutX(71); // Posiciona o aviao na coordenada X
      aviao.setLayoutY(681); // Posiciona o aviao na coordenada Y
    }
  }

  /**************************************************************
   * Metodo: moverAviao03
   * Funcao: responsavel pela animacao do aviao que inicia na posicao superior
   * direita
   * Parametros: nulo
   * Retorno: void
   ***************************************************************/
  private void moverAviao03() {

    ImageView aviao = this.getImagemAviao(); // variavel para o ImageView
    velocidadeAviao = sliderAviao.getValue(); // slider que controla a velocidade

    if (aviao.getLayoutY() < 80) { // Trilho duplo horizontal 01
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 110) { // Trilho duplo diagonal <- 01
      aviao.setRotate(225);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() - velocidadeAviao);

    } else if (aviao.getLayoutY() < 210) { // Trilho simples 01
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 240) { // Trilho duplo Diagonal -> 02
      aviao.setRotate(135);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 360) { // Trilho duplo horizontal 02
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 390) { // Trilho duplo diagonal <- 02
      aviao.setRotate(225);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() - velocidadeAviao);

    } else if (aviao.getLayoutY() < 500) { // Trilho simples 02
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 530) { // Trilho duplo diagonal -> 03
      aviao.setRotate(135);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() + velocidadeAviao);

    } else if (aviao.getLayoutY() <= 750) { // Trilho duplo horizontal 03
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() >= 750) { // Final do Trajeto
      aviao.setRotate(180);
      aviao.setLayoutX(141); // Posiciona o aviao na coordenada X
      aviao.setLayoutY(-70); // Posiciona o aviao na coordenada Y
    }
  }

  /**************************************************************
   * Metodo: moverAviao04
   * Funcao: responsavel pela animacao do aviao que inicia na posicao superior
   * esquerda
   * Parametros: nulo
   * Retorno: void
   ***************************************************************/
  private void moverAviao04() {

    ImageView aviao = this.getImagemAviao(); // variavel para o ImageView
    velocidadeAviao = sliderAviao.getValue(); // slider que controla a velocidade

    if (aviao.getLayoutY() < 80) { // Trilho duplo horizontal 01
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 110) { // Trilho duplo diagonal -> 01
      aviao.setRotate(135);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 210) { // Trilho simples 01
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 240) { // Trilho duplo Diagonal <- 02
      aviao.setRotate(225);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() - velocidadeAviao);

    } else if (aviao.getLayoutY() < 360) { // Trilho duplo horizontal 02
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 390) { // Trilho duplo diagonal -> 02
      aviao.setRotate(135);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 500) { // Trilho simples 02
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() < 530) { // Trilho duplo diagonal <- 03
      aviao.setRotate(225);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);
      aviao.setLayoutX(aviao.getLayoutX() - velocidadeAviao);

    } else if (aviao.getLayoutY() <= 750) { // Trilho duplo horizontal 03
      aviao.setRotate(180);
      aviao.setLayoutY(aviao.getLayoutY() + velocidadeAviao);

    } else if (aviao.getLayoutY() >= 750) { // Final do Trajeto
      aviao.setRotate(180);
      aviao.setLayoutX(71); // Posiciona o aviao na coordenada X
      aviao.setLayoutY(-70); // Posiciona o aviao na coordenada Y
    }
  }
  // Fim dos metodos relacionados ao movimento dos avioes

  // Getters e Setters:

  /**************************************************************
   * Metodo: getImagemAviao
   * Funcao: metodo get parareceber a imagem do aviao
   * Parametros: nulo
   * Retorno: ImageView
   ***************************************************************/
  public ImageView getImagemAviao() {
    return imagemAviao;
  }


  /**************************************************************
   * Metodo: setPosicaoAviao
   * Funcao: metodo set para definir a posicao do Aviao
   * Parametros: int
   * Retorno: void
   ***************************************************************/
  public void setPosicaoAviao(int posicaoAviao) {
    this.posicaoAviao = posicaoAviao;

  }
  // Fim dos Getters e Setters

}
