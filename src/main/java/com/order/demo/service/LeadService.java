package com.order.demo.service;

import java.util.List;

import com.order.demo.model.Lead;

public interface LeadService {
List<Lead> getAll();
Lead findByLeadId(Integer id);
}
