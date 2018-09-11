package com.hfj.bookmarker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfj.bookmarker.model.Bookmarker;

/**
 * @author HFJ
 *
 */
@Repository
public interface BookmarkerRepository extends JpaRepository<Bookmarker, Long> {

}
