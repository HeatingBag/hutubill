package gui.frame;
 
import javax.swing.JFrame;
 
import gui.panel.MainPanel;
import util.GUIUtil;

/**
 * 主面板，这里最重要的就是 public static MainFrame instance = new MainFrame();
 * 这里是单例的核心，为的是后续的监听器访问这个容器里的组件的 便利性
 * */
public class MainFrame extends JFrame{
    public static MainFrame instance = new MainFrame();
     
    private MainFrame(){
        this.setSize(500,450);
        this.setTitle("一本糊涂账");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    public static void main(String[] args) {
        instance.setVisible(true);
    }
     
}