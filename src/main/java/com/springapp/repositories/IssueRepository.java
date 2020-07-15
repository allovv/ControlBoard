package com.springapp.repositories;

import com.springapp.entities.IssueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends CrudRepository<IssueEntity, Long> {

    List<IssueEntity> findAllByFolderIdAndStatus(Long folderId, IssueEntity.IssueStatus status);
    List<IssueEntity> findAllByFolderId(Long folderId);
    List<IssueEntity> findAll();

}
