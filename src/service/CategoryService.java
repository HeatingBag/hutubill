package service;
 
import java.util.Collections;
import java.util.List;
 
import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;
 
public class CategoryService {
 
    CategoryDAO categoryDao = new CategoryDAO();
    RecordDAO recordDao = new RecordDAO();

    /**
     * 查询出所有的Category，然后根据每种分类，再把分类对应的消费记录总数查出来，并且设置在对应分类实例的recordNumer上。
     * 最后再根据recordNumer进行倒排序，让消费频率高的分类放在前面。
     * */
    public List<Category> list() {
        List<Category> cs= categoryDao.list();
        for (Category c : cs) {
            List<Record> rs =recordDao.list(c.id);
            c.recordNumber=rs.size();
        }
        Collections.sort(cs,(c1,c2)->c2.recordNumber-c1.recordNumber);
         
        return cs;
    }
 
    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }
 
    public void update(int id, String name) {
        Category c = new Category();
        c.setName(name);
        c.setId(id);
        categoryDao.update(c);
    }
 
    public void delete(int id) {
        categoryDao.delete(id);
    }
 
}