package com.mkyong.model;
import java.util.List;

public interface Criteria {
    public List<ProxyCar> meetCriteria(List<ProxyCar> cars);
}