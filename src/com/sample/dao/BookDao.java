package com.sample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface BookDao {

	@Insert("insert into book values (#{id}, #{title}, #{authorId})")
	public void insert(Book book);

	@ResultMap("bookResult")
	@Select("select * from book where id = #{id}")
	public Book findByPrimarykey(int id);

}
