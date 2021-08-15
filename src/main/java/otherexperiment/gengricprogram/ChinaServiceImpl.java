package otherexperiment.gengricprogram;

/**
 * @author Defu Li
 * @since 2021/2/9 13:14
 */
public class ChinaServiceImpl extends BaseService<ChinaResponse> {

    public Result<ChinaResponse> handle(){
        Result result = super.handle();
        return result;
    }
    @Override
    protected ChinaResponse initResponse() {
        ChinaResponse chinaResponse = new ChinaResponse();
        chinaResponse.setName("中国");
        return chinaResponse;
    }
}
