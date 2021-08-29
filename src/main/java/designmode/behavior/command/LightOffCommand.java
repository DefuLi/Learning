package designmode.behavior.command;

/**
 * @author Defu Li
 * @since 2021/8/29 23:31
 */
public class LightOffCommand implements ICommand {
    private Light light;

    public void setLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOff();
    }
}
