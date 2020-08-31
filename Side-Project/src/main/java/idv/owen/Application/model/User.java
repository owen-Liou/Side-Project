package idv.owen.Application.model;


import java.io.Serializable;

import java.sql.Timestamp;
import java.util.UUID;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name = "myuser")
public  class User implements Serializable{
    @Id
    @GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
    private UUID user_id;
    private String user_name;
    private String user_pwd;
    private String user_role;
    private Timestamp user_login_date;
    private Boolean isenable;
}