package com.codewars.interviewTasks;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 4/3/2019
 */
public final class ImutableClass {
  private final String name;
  private final List<String> list;

  public ImutableClass(String name, List<String> list) {
    this.name = name;
    this.list = new ArrayList<>(list);
  }

  public String getName() {
    return name;
  }

  public List<String> getList() {
    return new ArrayList<>(list);
  }
}