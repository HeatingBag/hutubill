package startup;
 
import javax.swing.SwingUtilities;
 
import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;
 
public class Bootstrap {

    /**
     * 特别说明一下备份以及恢复的问题：
     * 点击备份和恢复出现BUG：
     * Exception in thread "AWT-EventQueue-0" java.lang.IllegalAccessError: class com.birosoft.liquid.FileChooserBasicUI，，，，，
     * 的原因打开file chooser但是Liquid皮肤里没有涵盖filechooser. 禁用掉Liquid皮肤只需要注释掉GUIUtil里的useLNF的方法体就可以。
     * 实测确实是这样，其余均没问题
     * */
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();
 
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}