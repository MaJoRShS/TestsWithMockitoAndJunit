package service;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void testeLocacao() {
	//Cenario
	LocacaoService service = new LocacaoService();
	Usuario usuario = new Usuario("Usuario 1");
	Filme filme = new Filme("Filme 1", 2, 5.0);

	//AÃ§Ã£o
	Locacao locacao = service.alugarFilme(usuario, filme);


	//verificaÃ§Ã£o

//	System.out.println(locacao.getValor() == 5.0);
//	System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
//	System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	
//	Assert.assertEquals( 5.0,locacao.getValor(),0.01);
//	Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
//	Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	
	
	//Essa porra foi descontinuada. (assertThat ) só fuincionar para cima da versão 4.5
//	assertThat(locacao.getValor(), is(5.0) );
//	assertThat(locacao.getValor(), is(not(6.0)));
//	assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
//	assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	
	
	//Aqui é para retornar todos os erros ao invés de ir parando de erro por erro.
	error.checkThat(locacao.getValor(), is(6.0) );
	error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
	error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(false));
	}
}
