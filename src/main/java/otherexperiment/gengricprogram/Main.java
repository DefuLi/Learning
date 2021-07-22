package otherexperiment.gengricprogram;

/**
 * @author Defu Li
 * @date 2021/2/9 13:18
 */
public class Main {
    public static void main(String[] args) {
        BaseService<ChinaResponse> baseService = new ChinaServiceImpl();
        Result<ChinaResponse> result = baseService.handle();
        ChinaResponse chinaResponse = result.getResponse();
        System.out.println(chinaResponse.toString());

        BaseService<AmericaResponse> americaService = new AmericaServiceImpl();
        Result<AmericaResponse> americaResult = americaService.handle();
        AmericaResponse americaResponse = americaResult.getResponse();
        System.out.println(americaResponse.toString());
    }
}
