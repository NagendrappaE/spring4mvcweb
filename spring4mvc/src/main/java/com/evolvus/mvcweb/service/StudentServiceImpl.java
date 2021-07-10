package com.evolvus.mvcweb.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.evolvus.mvcweb.bean.Loginbean;
import com.evolvus.mvcweb.dao.StudentDao;
import com.evolvus.mvcweb.model.TaStudent;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

	public Loginbean saveLogin(Loginbean loginBean) {

		logger.debug("isnide the  saveLogin START  ::::::" + loginBean.toString());

//saving to Db by validating business validation

		try {
			TaStudent tastude = new TaStudent();
			tastude.setLastName(loginBean.getLastName());
			tastude.setUsername(loginBean.getFirstName());
			studentDao.save(tastude);
		} catch (DataAccessException | NullPointerException e) {
			logger.error("error {}", e);
		}
		logger.debug("isnide the  saveLogin  ENDS  ::::::" + loginBean.toString());

		loginBean.setMsq("the user details saved ::: the user if " + loginBean.getFirstName());
		return loginBean;
	}

}
