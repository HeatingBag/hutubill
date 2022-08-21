package gui.panel;
 
import static util.GUIUtil.showPanel;
 
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;
 
import javax.swing.ImageIcon;
import javax.swing.JLabel;
 
import entity.Record;
import service.ReportService;
import util.ChartUtil;
 
public class ReportPanel extends WorkingPanel {
    public static ReportPanel instance = new ReportPanel();
 
    JLabel l = new JLabel();

    //在构造其中获取图表，并把图表设置在Label上，然后显示这个Label
    public ReportPanel() {
        this.setLayout(new BorderLayout());
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 400, 300);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
        addListener();
    }
 
    public static void main(String[] args) {
        showPanel(ReportPanel.instance);
    }
 
    @Override
    public void updateData() {
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }
 
    @Override
    public void addListener() {
 
    }
}