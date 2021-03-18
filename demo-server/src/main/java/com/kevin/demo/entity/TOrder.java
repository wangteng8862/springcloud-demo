package com.kevin.demo.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_order")
public class TOrder implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "amount")
	private Integer amount;

}
