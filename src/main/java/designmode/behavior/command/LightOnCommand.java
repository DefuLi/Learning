package designmode.behavior.command;

/**
 * @author Defu Li
 * @since 2021/8/29 23:30
 */
public class LightOnCommand implements ICommand {
    private Light light;

    public void setLight(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }
}
