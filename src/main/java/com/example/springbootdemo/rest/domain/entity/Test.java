package com.example.springbootdemo.rest.domain.entity;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class Test {

  private long id;
  private long columnA;
  private long columnB;
  private Date columnC;

  public Test() {
  }

  public Test(long columnA, long columnB, Date columnC) {
    this.columnA = columnA;
    this.columnB = columnB;
    this.columnC = columnC;
  }
}
