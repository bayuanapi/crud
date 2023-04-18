package com.demo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.crud.model.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String>{

}
