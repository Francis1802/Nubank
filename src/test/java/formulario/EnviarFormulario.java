package formulario;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import metodos.Metodos;

public class EnviarFormulario {

	Metodos metodos = new Metodos();

	By digiteSeuCpf = By.name("cpf");
	By continuar = By.xpath("//button[@type='submit']");
	By nomeCompleto = By.name("name");
	By celular = By.name("phone");
	By email = By.name("email");
	By confirmacaoDoEmail = By.name("emailConfirmation");
	By receberComunicacoes = By.xpath("//*[text()='Aceito receber comunicações do Nubank por WhatsApp.']");
	By politicaDePrivacidade = By.id("label-accepted");
	By enviar = By.xpath("//*[@class='sc-pzMyG flNLHe']");
	By texto = By.xpath("//*[@id=\"label-accepted\"]/span[2]/span");

	@Before
	public void setUp() throws Exception {
		metodos.abrirNavegador("https://www.nubank.com.br");
	}

	@After
	public void tearDown() throws Exception {

		metodos.fecharNavegador();

	}

	// @Test
	public void preencherCadastro() throws IOException {
		metodos.escrever(digiteSeuCpf, "432.759.800-33");
		metodos.clicar(continuar);
		metodos.tirarFoto("CT 01 - Print da tela do cpf");
		metodos.escrever(nomeCompleto, "Francis Martins");
		metodos.escrever(celular, "11931234322");
		metodos.escrever(email, "teste@teste.com.br");
		metodos.escrever(confirmacaoDoEmail, "teste@teste.com.br");
		metodos.clicar(receberComunicacoes);
		metodos.clicar(politicaDePrivacidade);
		metodos.tirarFoto("CT 02 - formulario de cadastro");
		metodos.clicar(enviar);
		metodos.tirarFoto("CT 03 - Print após envio do formulario");

	}

	// @Test
	public void cadastroEmBranco() throws IOException {
		metodos.escrever(digiteSeuCpf, "432.759.800-33");
		metodos.clicar(continuar);
		metodos.escrever(nomeCompleto, "");
		metodos.escrever(celular, "");
		metodos.escrever(email, "");
		metodos.escrever(confirmacaoDoEmail, "");
		metodos.clicar(receberComunicacoes);
		metodos.clicar(politicaDePrivacidade);
		metodos.tirarFoto("CT 03 - formulario de cadastro em Branco");

	}

	// @Test
	public void cadastroComCracteres() throws IOException {
		metodos.escrever(digiteSeuCpf, "432.759.800-33");
		metodos.clicar(continuar);
		metodos.escrever(nomeCompleto, "Francis@]ç Martins");
		metodos.escrever(celular, "119+=][/;.,");
		metodos.escrever(email, "teste@/~p´´.,;;;;;");
		metodos.escrever(confirmacaoDoEmail, "teste@/~p´´.,;;;;;");
		metodos.clicar(receberComunicacoes);
		metodos.clicar(politicaDePrivacidade);
		metodos.clicar(enviar);
		metodos.tirarFoto("CT 05 - Print após envio do formulario com caracteres");

	}

	//@Test
	public void cadastroComEmailDiferente() throws IOException {
		metodos.escrever(digiteSeuCpf, "432.759.800-33");
		metodos.clicar(continuar);
		metodos.escrever(nomeCompleto, "Francis Martins");
		metodos.escrever(celular, "11931234322");
		metodos.escrever(email, "teste@teste.com.br");
		metodos.escrever(confirmacaoDoEmail, "teste1@teste1.com.br");
		metodos.clicar(receberComunicacoes);
		metodos.clicar(politicaDePrivacidade);
		metodos.clicar(enviar);
		metodos.tirarFoto("CT 06 - Print após envio do formulario com Email Diferente");
	}
	//@Test
	public void cadastroComPrimeiroNome() throws IOException {
		metodos.escrever(digiteSeuCpf, "432.759.800-33");
		metodos.clicar(continuar);
		metodos.escrever(nomeCompleto, "Francis");
		metodos.escrever(celular, "11931234322");
		metodos.escrever(email, "teste@teste.com.br");
		metodos.escrever(confirmacaoDoEmail, "teste@teste.com.br");
		metodos.clicar(receberComunicacoes);
		metodos.clicar(politicaDePrivacidade);
		metodos.clicar(enviar);
		metodos.tirarFoto("CT 07 - Print após envio do formulario com Primeiro Nome");
	}
	
	@Test
	public void validarTitle() {
		metodos.validarTitle("Eu li, estou ciente das condições de tratamento dos meus dados pessoais e dou meu consentimento, quando aplicável, conforme descrito nesta Política de Privacidade.");
		
		
	}
}
