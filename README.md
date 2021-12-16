# TestsWithMockitoAndJunit

    Seção 1: Apresentação

        1. Visão Geral do Curso

        2. Testes Unitários

    Seção 2: JUnit

        3. Testando sem Ferramenta
            Aqui o amigo passou o tal do principio FIRST, porém aqui os tester foram feitos apenas com a IDE e com coisas da minha cabeça ou seja o teste eu que fiz e boa.

        4. JUnit

            Teste Runner - Quem vai executar os testes e coletar os resultados
            Teste Fixture -Pré condições dos testes
            Suites - são as baterias de testes
            Teste Result Formatter - vão formatar e devolver os dados.
            Assertion - que veirifica o resultado do que está sendo testado.

            Ja começou mostrando o Assert da classe org.junit.Assert; e como precisamos de um resultado de true ou false usamos o assertTrue e ai validamos o resultado.


        5. Organização dos arquivos de teste

            Deixamos o arquivo de teste na pasta de teste referente.


        6. Assertivas

            Aqui tem coisa para caramba que da para fazer com o Assert, basicamente validações basicas de if e else, tem alguma coisinhas mais elaboradas mais é simple no geral.

        7. AssertThat

            Aqui é basicamente uma forma de falar o que você quer receber e sempre validar o que você tem.

        8. Formas de dividir um teste

            Aqui Criamos uma parada para não ficarmos sempre parando na primeira ocorrência de erro durante os testes, mais sim apresentar todos eles de uma única vez.

        9. Tratamento de exceções, parte 1

            Aqui vagabundo mostrou algumas formas de se tratar exceções, claro que em quase todas tem seus pros e contras , mais  para mim a mais fácil e menos b.o é a tal da forma elegante.

        10. Tratamento de exceções, parte 2

            Aqui ele explana ainda mais porque prefere a forma robusta.

        11. Before e After

            @Before
                Ele sempre vai instanciar tudo que você colocar antes da execução de cada teste

            @After
                Ele sempre vai instanciar tudo depois que já aconteceu o seu teste.

            @BeforeClass
                Ele só instância as paradas antes da execução da sua classe, ou seja antes de tudo até mesmo do @Before

            @AfterClass
                Ele só será instanciado ou chamado quando acabar a execução da sua class.

        12. Ordem de execução dos testes
            Aqui ele mostra que tem algumas formas de se fazer o teste e que tem como ordenar a execução, mais se você respeitar o esquema do first você não vai precisar disso.
            Mais se precisar é só mandar a anotação @FixMethodOrder(MethodSorters.NAME_ASCENDING) antes do nome da classe, e deixar os nomes dos seus métodos em ordem alfabética, o que também é um lixo.

        13. Desafio
            Aqui eu caguei e não fiz tudo não estava vendo "coisas" em paralelo e por isso não fiz mais não vi grandes problemas não.

        14. TDD, parte 1
            Basicamente aqui o esquema é sempre fazer os tester primeiro antes de começar a codar, nesse caso você começa a pensar primeiro em como o código deve funcionar e depois você vai implementando a classe que deve ser testada.
            É uma mudança na mente para começar a pensar no que o seu código vai ou deve fazer para depois fazer o código propriamente dito.

            Detalhe: Sempre começar com as menores partes do código e ir adicionando complexidade no decorrer do caminho.
            see

        15. TDD, parte 2
            Aqui ele mostrou ainda mais como fazer o TDD, o esquema é simples, começa pelo Teste, escreve o teste o mais simples possivel, e ai sim cria a classe que vai ser testada, claro que como você previu antes vai criar a classe para passar no teste.
            depois disso cria a classe te ve se passou no teste.
            ai no ultimo passo ve se precisa refatorar o código.

        16. TDD, parte 3
            Aqui o Amigo mostra um problema que existe no TDD, que é o caso de testes conflitantes,por exemplo criamos dois teste que de certa forma acabam por interferir um no outro, segundo ele ainda via tentar mostrar como podemos contornar isso mais ainda assim parece ser uma gambis.

        17. @Ignore e Assumptions
            O @Ignore basicamente não deixa o teste ser executado mais isso é uma bosta porque ai você literalmente não tem esse teste é como se o código estivesse comentado.

            o Esquema real é usarr o Assume

            esse Assume tem quase as mesmas propriedades do Assert, só que ele serve para meio que validar se o recurso que você necessita está disponível para poder iniciar o teste, caso contrario o teste nem inicia.

            ai fica na boa é tipo um @Before porque ele executa essa parada antes do inicio do teste, mais não antes de todos os testes e sim do teste que foi incluído.

        18. Testes parametrizáveis
            basicamente aqui o esquema foi o seguinte,criei uma classe de testes e usando a Anotação @RunWith(Parameterized.class) eu crio uma parametrização dos testes que eu vou fazer,crio os parametros que vou testar anoto eles com @Parameterized.Parameter os parâmetros e se for mais de 1 @Parameterized.Parameter(value = 1) NUMERO_DA_ORDEM_DE_EXECUÇÃO.

            dai cria um teste generico passando as variaveis , ai já era ele roda tranquilo.

        19. Matchers Próprios,
            Aqui é básico ele criou um Matcher dele, que devolve uma parada própria, mais isso é tipo fazer exception personalizada, é a mesma coisa que nada.

            Porém tem suas vantagens de sempre retornar uma mensagem melhor descrita, e no que diz respeito aos testes é bem interessante a parada de criar o seu próprio matcher.

        20. Desafio
            Aqui o desafio dele deve ter algum erro porque simplesmente não roda utilizando o parâmetro que ele passou, pode ser uma atualização da lib ou qualquer coisa do tipo mais do jeito que passou na aula não vai.

            Além do mais tem 4 anos que esse curso foi gravado.

        21. Suíte de testes
