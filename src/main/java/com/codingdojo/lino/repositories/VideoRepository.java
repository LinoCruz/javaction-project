package com.codingdojo.lino.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lino.models.Video;

public interface VideoRepository extends CrudRepository<Video, Long>{

}
