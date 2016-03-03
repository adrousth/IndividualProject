package library.persistence;

import library.entities.Category;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Student on 2/27/2016.
 */
public class CategoryDAOTest {

    @Test
    public void testAddCategories() throws Exception {
        CategoryDAO dao = new CategoryDAO();
        Category cat = new Category();
        cat.setCategory("Fantasy");
        dao.addBookCategory(cat);
        cat.setCategory("Sports");
        dao.addBookCategory(cat);
        cat.setCategory("Non-fiction");
        dao.addBookCategory(cat);

    }
    @Test
    public void testGetCategories() throws Exception {
        CategoryDAO dao = new CategoryDAO();
        List<Category> list = dao.getCategories();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getCategory());
        }
    }
}