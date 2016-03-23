package com.eministerios.www.business.entity.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexandre on 09/03/16.
 */

/*@Entity
@SequenceGenerator(name = "nome_seq", sequenceName = "nome_seq_no_banco", allocationSize = 1, initialValue = 1)
@Table(name = "nome_da_tabela")
public class HistoricoAcesso implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) //uso o name que coloquei no @SequenceGenerator
  @Column(name = "id_historico_acesso")
  private int idHistoricoAcesso;
  //mais atributos e os gets/sets
}*/


@Entity
//@SequenceGenerator(name = "id_worker", sequenceName = "worker_id_seq", allocationSize = 1, initialValue = 10)
@Table(name = "worker")
public class Worker implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  //@GeneratedValue(generator = "id_worker")
  /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "lastname", nullable = false)
  private String lastname;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "address")
  private String address;

  @Column(name = "email_1")
  private String email_1;

  @Column(name = "email_2")
  private String email_2;

  @Column(name = "phone_1")
  private String phone_1;

  @Column(name = "phone_2")
  private String phone_2;

  @Column(name = "profession")
  private String profession;

  @Column(name = "description")
  private String description;

  public Worker() {
  }

  public Worker(String name, String lastname, String type, String address, String email_1, String email_2, String phone_1, String phone_2, String profession, String description) {
    this.name = name;
    this.lastname = lastname;
    this.type = type;
    this.address = address;
    this.email_1 = email_1;
    this.email_2 = email_2;
    this.phone_1 = phone_1;
    this.phone_2 = phone_2;
    this.profession = profession;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail1() {
    return email_1;
  }

  public void setEmail1(String email_1) {
    this.email_1 = email_1;
  }

  public String getEmail2() {
    return email_2;
  }

  public void setEmail2(String email_2) {
    this.email_2 = email_2;
  }

  public String getPhone1() {
    return phone_1;
  }

  public void setPhone1(String phone_1) {
    this.phone_1 = phone_1;
  }

  public String getPhone2() {
    return phone_2;
  }

  public void setPhone2(String phone_2) {
    this.phone_2 = phone_2;
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}



