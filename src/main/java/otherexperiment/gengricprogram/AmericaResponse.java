package otherexperiment.gengricprogram;

import java.util.List;

/**
 * @author Defu Li
 * @date 2021/2/9 13:13
 */
public class AmericaResponse extends BaseResponse{
    List<String> state;

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }
}
