import com.alibaba.fastjson.JSON;
import com.mindnode.immipal.pojo.Category;
import com.mindnode.immipal.util.date.TimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SQM
 * @version 1.0
 * @date 2018/1/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SomeTest {

    @Test
    public void jsonTest() {
        List<Category> categoryList = new ArrayList<>();
        Category category1 = new Category();
        category1.setCategoryId(1);
        category1.setCategoryTitle("a");

        Category category2 = new Category();
        category2.setCategoryId(2);
        category2.setCategoryTitle("b");

        Category category3 = new Category();
        category3.setCategoryId(3);
        category3.setCategoryTitle("c");
        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);

        String jsonString = JSON.toJSONString(categoryList);
        System.out.println(jsonString);
        System.out.println();

        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("categoryList", categoryList);
        String jsonMapString = JSON.toJSONString(categoryMap);
        System.out.println(jsonMapString);
        System.out.println();

        List categoryListJson = (List) JSON.parse(jsonString);
        System.out.println(categoryListJson);
        System.out.println();

        Map categoryMapJson = (Map) JSON.parse(jsonMapString);
        System.out.println(categoryMapJson);
        System.out.println();
    }

    @Test
    public void dateTest() {
        System.out.println(TimeUtil.toLocalString(System.currentTimeMillis()));
    }

    @Test
    public void listTest() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String string = "abcdefcg";
            strings.add(string);
        }
        System.out.println(strings.toString());
    }
}
