import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sample.dao.Author;
import com.sample.dao.AuthorDao;
import com.sample.dao.Book;

public class Main {

	public static void main(String[] args) throws Exception {

		String resource = "config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
//		BookDao dao = session.getMapper(BookDao.class);
//
//		Book book = dao.findByPrimarykey(3);
//		Author author = book.getAuthor();
//		System.out.println(author.getName());

		AuthorDao dao = session.getMapper(AuthorDao.class);

		Author author = dao.findByPrimarykey(1);
		// 件数確認
		// System.out.println(author.getBookList().size());

		for (Book book :author.getBookList()) {
			System.out.println(book.getTitle());
		}

		session.commit();

		session.close();
	}

}
