package designmode.behavior.command;

/**
 * 关门命令
 *
 * @author Defu Li
 * @since 2021/8/29 23:29
 */
public class DoorCloseCommand implements ICommand {
    private Door door;

    public void setDoor(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.closeDoor();
    }
}
