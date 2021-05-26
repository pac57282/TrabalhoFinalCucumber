package stepDefinition;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import util.TrabalhoFinal;


public class TrabalhoFinalStep {

    TrabalhoFinal trabalhoFinal = new TrabalhoFinal();

    @Dado("que o usuário acessou o arquivo Campo de Treinamento")
    public void que_o_usuário_acessou_o_arquivo_Campo_de_Treinamento() {
        trabalhoFinal.inicializa();
    }

    @Quando("o usuário clicar no botão cdNome com algum campo obrigatório em branco")
    public void o_usuário_clicar_no_botão_cdNome_com_algum_campo_obrigatório_em_branco() {
        trabalhoFinal.testeNomeObrigatorio();
    }

    @Quando("o usuário clicar no botão cdSobrenome com algum campo obrigatório em branco")
    public void o_usuário_clicar_no_botão_cdSobrenome_com_algum_campo_obrigatório_em_branco() {
        trabalhoFinal.testeSobrenomeObrigatorio();
    }

    @Quando("o usuário clicar no botão cdSexo com algum campo obrigatório em branco")
    public void o_usuário_clicar_no_botão_cdSexo_com_algum_campo_obrigatório_em_branco() {
        trabalhoFinal.testeSexoObrigatorio();
    }

    @Então("deve aparecer um JOptionPane com a mensagem que nome é obrigatorio")
    public void deve_aparecer_um_JOptionPane_com_a_mensagem_que_nome_é_obrigatorio() {
        trabalhoFinal.validaNomeObrigatorio();
        trabalhoFinal.fecharNavegador();
    }

    @Então("deve aparecer um JOptionPane com a mensagem que sobrenome é obrigatorio")
    public void deve_aparecer_um_JOptionPane_com_a_mensagem_que_sobrenome_é_obrigatorio() {
        trabalhoFinal.validaSobrenomeObrigatorio();
        trabalhoFinal.fecharNavegador();
    }

    @Então("deve aparecer um JOptionPane com a mensagem que sexo é obrigatorio")
    public void deve_aparecer_um_JOptionPane_com_a_mensagem_que_sexo_é_obrigatorio() {
        trabalhoFinal.validaCampoSexoObrigatorio();
        trabalhoFinal.fecharNavegador();
    }

    @Quando("o usuário digitar seu Marcelo no campo textfield, o Nascimento no campo textfield e marcar seu radio button no campo <radio button>")
    public void o_usuário_digitar_seu_Marcelo_no_campo_textfield_o_Nascimento_no_campo_textfield_e_marcar_seu_radio_button_no_campo_radio_button() {
        trabalhoFinal.testeNomeSobrenomeSexo();
    }

    @Então("o resultado no campo textfield de ser Marcelo, no campo textfield deve ser Nascimento e no campo <radio button> deve ser Masculino")
    public void o_resultado_no_campo_textfield_de_ser_Marcelo_no_campo_textfield_deve_ser_Nascimento_e_no_campo_radio_button_deve_ser_Masculino() {
        trabalhoFinal.validaNomeSobrenomeSexo();
        trabalhoFinal.fecharNavegador();
    }

    @Quando("o usuário preencher os campos Marcelo, Nascimento, Masculino, Pizza, {int}o grau completo, O que eh esporte?, Nenhuma Sugestão e clicar no botão Cadastrar")
    public void o_usuário_preencher_os_campos_Marcelo_Nascimento_Masculino_Pizza_o_grau_completo_O_que_eh_esporte_Nenhuma_Sugestão_e_clicar_no_botão_Cadastrar(Integer int1) {
        trabalhoFinal.testePreencherTodosCampos();
    }

    @Então("o resultado deve ser apresentado no campo Cadastro!")
    public void o_resultado_deve_ser_apresentado_no_campo_Cadastro() {
        trabalhoFinal.validaTodosCampos();
        trabalhoFinal.fecharNavegador();
    }

}
