package com.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AuthorDao {

	@Insert("insert into author values (#{id}, #{name})")
	public void insert(Author author);

	@Update("update author set name = #{name} where id = #{id}")
	public void update(Author author);

	@Delete("delete from author where id = #{id}")
	public void delete(int id);

	@ResultMap("authorResult")
	@Select("select * from author")
	public List<Author> findAll();

//	@ResultMap("authorResult")
//	@Select("select * from author where id = #{id}")
//	public Author findByPrimarykey(int id);

	@ResultMap("authorResultJoinBook")
	@Select("select a.id as authorId, a.name, b.id as bookId, b.title, b.author from author a join book b on a.id = b.author where a.id = #{id}")
	public Author findByPrimarykey(int id);

}
