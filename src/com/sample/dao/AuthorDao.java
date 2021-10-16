package com.sample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface AuthorDao {

	@Insert("insert into author values (#{id}, #{name})")
	public void insert(Author author);

	@Update("update author set name = #{name} where id = #{id}")
	public void update(Author author);

}
