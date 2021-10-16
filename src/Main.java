import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sample.dao.Book;
import com.sample.dao.BookDao;

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

		// AuthorDao dao = session.getMapper(AuthorDao.class);
		// dao.insert(author);
		// dao.update(author);
		// dao.delete(1);

//		for (int i = 1; i < 10; i++) {
//			Author author = new Author();
//			author.setId(i);
//			author.setName("test" + i);
//			dao.insert(author);
//		}

		// 全検索
//		List<Author> list = dao.findAll();
//		for (Author author : list) {
//			System.out.println(author.getName());
//		}

		// Author author = new Author();
		// 1件検索
//		Author author = dao.findByPrimarykey(3);
//		System.out.println(author.getName());

		BookDao dao = session.getMapper(BookDao.class);
//		Book book = new Book();
//		book.setId(4);
//		book.setTitle("test title4");
//		book.setAuthorId(3);
//		dao.insert(book);

		Book book = dao.findByPrimarykey(3);
		System.out.println(book.getAuthorId());

		session.commit();

		session.close();
	}

}
