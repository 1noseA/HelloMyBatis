import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sample.dao.Author;
import com.sample.dao.Book;
import com.sample.dao.BookDao;

public class Main {

	public static void main(String[] args) throws Exception {

		String resource = "config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		BookDao dao = session.getMapper(BookDao.class);

		Book book = dao.findByPrimarykey(3);
		Author author = book.getAuthor();
		System.out.println(author.getName());

		session.commit();

		session.close();
	}

}
