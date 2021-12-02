package service;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;

import br.ce.wcaquino.exception.FilmeSemEstoqueException;
import br.ce.wcaquino.exception.LocadoraException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.rules.ExpectedException;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testeLocacao() throws Exception {
	//Cenario
	LocacaoService service = new LocacaoService();
	Usuario usuario = new Usuario("Usuario 1");
	Filme filme = new Filme("Filme 1", 2, 5.0);

	//A��o
		//Aqui agora lan�a um erro e n�o mais uma falha
		Locacao locacao = service.alugarFilme(usuario, filme);

		error.checkThat(locacao.getValor(), is(5.0) );
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));

//		try {
//			Locacao locacao = service.alugarFilme(usuario, filme);
//			error.checkThat(locacao.getValor(), is(5.0) );
//			error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
//			error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
//		}catch (Exception e){
//			e.printStackTrace();
//			//Aqui eu lan�o uma exce��o for�adamente .
//			Assert.fail("N�o deveria lancar excecao");
//		}




	//verificação

//	System.out.println(locacao.getValor() == 5.0);
//	System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
//	System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	
//	Assert.assertEquals( 5.0,locacao.getValor(),0.01);
//	Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
//	Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	
	
	//Essa porra foi descontinuada. (assertThat ) s� fuincionar para cima da vers�o 4.5
//	assertThat(locacao.getValor(), is(5.0) );
//	assertThat(locacao.getValor(), is(not(6.0)));
//	assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
//	assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	
	
	//Aqui � para retornar todos os erros ao inv�s de ir parando de erro por erro.
//	error.checkThat(locacao.getValor(), is(6.0) );
//	error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
//	error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(false));

	}


	//Aqui o Teste da sucesso porque eu estou informando que ele tem uma exce��o que precisa mesmo ocorrer

	//Segundo a lenda forma elegante
	//Como eu obriguei a forma elgante a lan�ar uma exce�ao personalizada ele agora na teoria est� correto.
	@Test(expected = FilmeSemEstoqueException.class)
	public void testLocacao_filmeSemEstoque() throws Exception{
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);

		//A��o
		Locacao locacao = service.alugarFilme(usuario, filme);

	}
	@Test
	public void testeLocacao_usuarioVazio() throws FilmeSemEstoqueException {
		//Cenario
		LocacaoService service = new LocacaoService();
		Filme filme = new Filme("Filme 1", 2, 5.0);
		Usuario usuario = new Usuario("Usuario 1");

		//acao
		try {
			service.alugarFilme(null, filme);
			Assert.fail();
		} catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), is("Usuario vazio"));
		}


	}


	@Test
	public void testLocacao_FilmeVazio() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");

		expectedException.expect(LocadoraException.class);
		expectedException.expectMessage("Filme vazio");
		//acao
		service.alugarFilme(usuario, null);

	}

//	//Segundo a lenda forma Robusta
//	@Test
//	public void testLocacao_filmeSemEstoque2(){
//		LocacaoService service = new LocacaoService();
//		Usuario usuario = new Usuario("Usuario 1");
//		Filme filme = new Filme("Filme 1", 2, 5.0);
//
//		//A��o
//		try {
//			service.alugarFilme(usuario, filme);
//			Assert.fail("Deveria ter lan�ado uma exce��o");
//		}catch (Exception e){
//			Assert.assertThat(e.getMessage(), CoreMatchers.is("Filme sem Estoque"));
//		}
//
//	}
//
//
//	//Segundo a lenda forma Nova
//	@Test
//	public void testLocacao_filmeSemEstoque3() throws Exception{
//		LocacaoService service = new LocacaoService();
//		Usuario usuario = new Usuario("Usuario 1");
//		Filme filme = new Filme("Filme 1", 0, 5.0);
//		expectedException.expect(Exception.class);
//		expectedException.expectMessage("Filme sem Estoque");
//
//		//A��o
//		service.alugarFilme(usuario, filme);
//
//
//	}
}
