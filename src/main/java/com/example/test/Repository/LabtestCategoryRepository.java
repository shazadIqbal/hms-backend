package com.example.test.Repository;

import com.example.test.Model.Labtest;
import com.example.test.Model.Labtestcategory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("labtestCategoryRepository")
public interface LabtestCategoryRepository extends JpaRepository<Labtestcategory, Long> {


    public Labtestcategory findByCategory(String category);
}
