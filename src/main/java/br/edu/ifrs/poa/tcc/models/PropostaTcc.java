package br.edu.ifrs.poa.tcc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proposta-tcc")
public class PropostaTcc implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	
	
}
