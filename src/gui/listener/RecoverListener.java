package gui.listener;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
 
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
 
import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;
 
public class RecoverListener implements ActionListener {
 
    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel p  =BackupPanel.instance;
        String mysqlPath= new ConfigService().get(ConfigService.mysqlPath);
        if(0==mysqlPath.length()){
            JOptionPane.showMessageDialog(p, "恢复前请事先配置mysql的路径");
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            ConfigPanel.instance.tfMysqlPath.grabFocus();
            return;
        }
        /**
         *  打开文件选择器，指定要打开的文件
         *  文件名默认设置为hutubill.sql
         *  根据后缀名.sql过滤文件
         * */
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {
             
            @Override
            public String getDescription() {
                return ".sql";
            }
             
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }
        });
 
         int returnVal =  fc.showOpenDialog(p);
         File file = fc.getSelectedFile();
         System.out.println(file);
         if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                MysqlUtil.recover(mysqlPath,file.getAbsolutePath());
//              MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(p, "恢复成功");
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(p, "恢复失败\r\n,错误:\r\n"+e1.getMessage());
            }
              
         }      
    }
 
}