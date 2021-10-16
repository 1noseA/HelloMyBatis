package com.sample.dao;

import org.apache.ibatis.annotations.Insert;

public interface BookDao {

	@Insert("insert into book values (#{id}, #{title}, #{authorId})")
	public void insert(Book book);
}
