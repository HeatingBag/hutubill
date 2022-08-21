package gui.listener;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
 
import gui.panel.BackupPanel;
import gui.panel.CategoryPanel;
import gui.panel.ConfigPanel;
import gui.panel.SpendPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.RecoverPanel;
import gui.panel.ReportPanel;

/**
 * 设计一个独立的监听器类ToolBarListener ，实现接口ActionListener ，重写actionPerformed方法。
 * 这个监听器是为工具栏上的几个按钮添加的，并且这几个按钮都使用这么一个监听器。
 * 通过ActionEvent.getSource()获取事件是哪个按钮发出来的，根据不同的按钮，发出切换不同的功能面板。
 * 意思即是：如果按钮是bReport，那么就切换到报表面板ReportPanel
 * */
public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.bReport)
            p.workingPanel.show(ReportPanel.instance);
        if (b == p.bCategory)
            p.workingPanel.show(CategoryPanel.instance);
        if (b == p.bSpend)
            p.workingPanel.show(SpendPanel.instance);
        if (b == p.bRecord)
            p.workingPanel.show(RecordPanel.instance);
        if (b == p.bConfig)
            p.workingPanel.show(ConfigPanel.instance);
        if (b == p.bBackup)
            p.workingPanel.show(BackupPanel.instance);
        if (b == p.bRecover)
            p.workingPanel.show(RecoverPanel.instance);
 
    }
}