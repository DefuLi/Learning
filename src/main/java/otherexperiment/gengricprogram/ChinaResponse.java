package otherexperiment.gengricprogram;

import java.util.List;

/**
 * @author Defu Li
 * @since 2021/2/9 13:10
 */
public class ChinaResponse extends BaseResponse {
    List<String> province;
    public List<String> getProvince(){
        return province;
    }
    public void setProvince(List<String> province){
        this.province = province;
    }
}
