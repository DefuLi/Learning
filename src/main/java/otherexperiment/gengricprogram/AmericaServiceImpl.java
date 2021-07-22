package otherexperiment.gengricprogram;

/**
 * @author Defu Li
 * @date 2021/2/9 13:43
 */
public class AmericaServiceImpl extends BaseService<AmericaResponse> {
    @Override
    protected AmericaResponse initResponse() {
        return new AmericaResponse();
    }
}
