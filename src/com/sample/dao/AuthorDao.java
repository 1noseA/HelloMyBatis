package com.sample.dao;

import org.apache.ibatis.annotations.Insert;

public interface AuthorDao {

	@Insert("insert into author values (#{id}, #{name})")
	public void insert(Author author);

}
