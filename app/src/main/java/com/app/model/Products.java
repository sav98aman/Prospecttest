package com.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer product_id;
	private String title;
	private String descrp;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Category category;
	
}
