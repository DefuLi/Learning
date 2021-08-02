package designmode.structure.facade;

/**
 * 外观模式
 * 每天上班只做三件事：打开浏览器、打开IDE、打开微信
 * 每天下班只做三件事：关闭浏览器、关闭IDE、关闭微信
 * <p>
 * 如果不使用外观模式，需要手动执行6个函数
 * 使用外观模式，上班一个函数，下班一个函数
 *
 * @author Defu Li
 * @date 2021/7/26 23:45
 */
public class Facade {
    Browser browser = new Browser();
    IDE ide = new IDE();
    WeChat weChat = new WeChat();

    public void open() {
        browser.open();
        ide.open();
        weChat.open();
    }

    public void close() {
        browser.close();
        ide.close();
        weChat.close();
    }
}
