package learn.frame.spring.dao;

import learn.frame.spring.entity.People;

public interface PeopleDaoInterface {

	/**
	 * 保存people到数据库
	 */
	void save(People p);
}
