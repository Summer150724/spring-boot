package com.example.springbootdemo.rest.domain.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Test {

  private long id;
  private long columnA;
  private long columnB;
  private Date columnC;

}
