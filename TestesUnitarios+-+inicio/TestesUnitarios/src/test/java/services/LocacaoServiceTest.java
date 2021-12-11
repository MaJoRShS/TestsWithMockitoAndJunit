package services;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exception.FilmeSemEstoqueException;
import br.ce.wcaquino.exception.LocadoraException;
import br.ce.wcaquino.servicos.LocacaoService;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;
import java.util.List;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.is;

public class LocacaoServiceTest {

	private LocacaoService service;


	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp(){
		service = new LocacaoService();
		System.out.println("Before");
	}

	@After
	public void tearDown(){
		System.out.println("After");
	}


	@BeforeClass
	public static void setUpClass(){
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownClass(){
		System.out.println("After Class");
	}

	@Test
	public void testeLocacao() throws Exception {
	//Cenario
	Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = List.of(new Filme("Filme 1", 1, 5.0));


		System.out.println("Teste!");

	//Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);

		error.checkThat(locacao.getValor(), is(5.0) );
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));


	}

	@Test(expected = FilmeSemEstoqueException.class)
	public void testLocacao_filmeSemEstoque() throws Exception{
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = List.of(new Filme("Filme 1", 0, 4.0));

		//Ação
		Locacao locacao = service.alugarFilme(usuario, filmes);

	}
	@Test
	public void testeLocacao_usuarioVazio() throws FilmeSemEstoqueException {
		//Cenario
		List<Filme> filmes = List.of(new Filme("Filme 1", 0, 5.0));
		Usuario usuario = new Usuario("Usuario 1");

		//acao
		try {
			service.alugarFilme(null, filmes);
			Assert.fail();
		} catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), is("Usuario vazio"));
		}


	}


	@Test
	public void testLocacao_FilmeVazio() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = new Usuario("Usuario 1");

		expectedException.expect(LocadoraException.class);
		expectedException.expectMessage("Filme vazio");
		//acao
		service.alugarFilme(usuario, null);

	}

}
