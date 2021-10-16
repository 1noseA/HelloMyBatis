import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sample.dao.Author;
import com.sample.dao.AuthorDao;

public class Main {

	public static void main(String[] args) throws Exception {

		String resource = "config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 接続しにいく
		SqlSession session = sqlSessionFactory.openSession();

		// Author author = new Author();
		// author.setId(1);
		// author.setName("test");
		// author.setName("hoge");

		AuthorDao dao = session.getMapper(AuthorDao.class);
		// dao.insert(author);
		// dao.update(author);
		// dao.delete(1);

		for (int i = 1; i < 10; i++) {
			Author author = new Author();
			author.setId(i);
			author.setName("test" + i);
			dao.insert(author);
		}

		session.commit();

		session.close();
	}

}
