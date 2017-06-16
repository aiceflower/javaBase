package learn.frame.spring.impl;

import learn.frame.spring.dao.PeopleDaoInterface;
import learn.frame.spring.entity.People;
import learn.frame.spring.service.PeopleServiceInterface;

public class PeopleServiceImpl implements PeopleServiceInterface{
	
	PeopleDaoInterface peopleDao;
	/**
	 * ���ڲ���setter��ʽע��spring
	 * @param peopleDao
	 */
	public void setPeopleDao(PeopleDaoInterface peopleDao) {
		this.peopleDao = peopleDao;
	}
	/**
	 *���ڲ��Թ�������ʽע��spring 
	 * @param peopleDao
	 */
	public PeopleServiceImpl(PeopleDaoInterface peopleDao){
		this.peopleDao = peopleDao;
	}

	/**
	 * ��Ҫ��Ĭ�Ϲ�������������õķ���ʵ�ֵģ�������ҪĬ�Ϲ�����
	 */
	public PeopleServiceImpl(){
		
	}
	
	/**
	 * ����people
	 */
	public void save(People p ){
		peopleDao.save(p);
	}
}
