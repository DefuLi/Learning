package designmode.behavior.command;

/**
 * 开门命令
 *
 * @author Defu Li
 * @since 2021/8/29 23:28
 */
public class DoorOpenCommand implements ICommand {
    private Door door;

    public void setDoor(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.openDoor();
    }
}
