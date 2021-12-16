package suites;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import services.CalculadoraTest;
import services.CalculoValorLocacaoTest;
import services.LocacaoServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculadoraTest.class,
        CalculoValorLocacaoTest.class,
        LocacaoServiceTest.class
})
public class SuiteExecucao {
    //Aqui não é obrigatório ter essa bosta mais o JAVA obriga.
}



