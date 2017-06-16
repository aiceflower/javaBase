package learn.frame.spring.impl;

import learn.frame.spring.dao.PeopleDaoInterface;
import learn.frame.spring.entity.People;

public class PeopleDaoImpl implements PeopleDaoInterface{

	@Override
	public void save(People p) {
		System.out.println(p);
	}

}
