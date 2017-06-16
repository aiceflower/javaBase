package learn.frame.spring.impl;

import learn.frame.spring.dao.PeopleDaoInterface;
import learn.frame.spring.entity.People;
import learn.frame.spring.service.PeopleServiceInterface;

public class PeopleServiceImpl implements PeopleServiceInterface{
	
	PeopleDaoInterface peopleDao;
	/**
	 * 用于测试setter方式注入spring
	 * @param peopleDao
	 */
	public void setPeopleDao(PeopleDaoInterface peopleDao) {
		this.peopleDao = peopleDao;
	}
	/**
	 *用于测试构造器方式注入spring 
	 * @param peopleDao
	 */
	public PeopleServiceImpl(PeopleDaoInterface peopleDao){
		this.peopleDao = peopleDao;
	}

	/**
	 * 需要有默认构造器，框架是用的反射实现的，反射需要默认构造器
	 */
	public PeopleServiceImpl(){
		
	}
	
	/**
	 * 保存people
	 */
	public void save(People p ){
		peopleDao.save(p);
	}
}
