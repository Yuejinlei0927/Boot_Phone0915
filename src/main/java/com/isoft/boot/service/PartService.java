package com.isoft.boot.service;

import com.isoft.boot.entity.Part;
import com.isoft.boot.entity.Phone;

import java.util.List;

public interface PartService {
    boolean insert(Part part);
    boolean delById(Integer id);
    boolean delByIds(List<Integer> ids);
    Part update(Part part);
    List<Part> getAll();
    Part getById(Integer id);
    List<Part> getParts(String brand);
}
