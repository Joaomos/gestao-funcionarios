module gestaoFuncionarios {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
    requires java.naming; 
	requires java.persistence;
	requires org.hibernate.orm.core;
	requires org.controlsfx.controls;
    
	opens br.com.Joaomos.app;
	opens br.com.Joaomos.controller;
	opens br.com.Joaomos.infra;
	opens br.com.Joaomos.model;
	opens br.com.Joaomos.service;
	opens br.com.Joaomos.view;
}