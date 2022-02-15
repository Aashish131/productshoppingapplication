package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

public class DI {

	@Autowired
	private service serv;
	public   void abc()
	{
		serv.om();
	}
}

