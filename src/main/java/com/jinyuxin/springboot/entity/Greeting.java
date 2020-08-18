package com.jinyuxin.springboot.entity;

/**
 * @auther SamuelKing
 * @date 2020/6/10 15:35
 */
public class Greeting {
  private final long id;
  private final String content;

  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
