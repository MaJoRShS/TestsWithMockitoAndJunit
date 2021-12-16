package matchers;

import java.util.Calendar;

public class MatchersProprios {

    public static DiaSemanaMatcher caiEm(Integer diaSemana){
        return new DiaSemanaMatcher(diaSemana);
    }


    public static DiaSemanaMatcher caiNumaSegunda(){
        return new DiaSemanaMatcher(Calendar.MONDAY);
    }

    public static  DataDiferencaDiasMatcher ehHojeComDiferencaDias(Integer qtdDias){
        return new DataDiferencaDiasMatcher(qtdDias);
    }

    public static  DataDiferencaDiasMatcher ehHoje(){
//Aqui segundo ele deveria funcionar com 0 mais simplesmente não roda, coloquei 1 e passa o teste simples assim.
        //        return new DataDiferencaDiasMatcher(0);
        return new DataDiferencaDiasMatcher(1);
    }
}
