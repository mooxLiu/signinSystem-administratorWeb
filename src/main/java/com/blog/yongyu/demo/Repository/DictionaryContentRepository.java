package com.blog.yongyu.demo.Repository;

import com.blog.yongyu.demo.Entity.DictionaryContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryContentRepository extends JpaRepository<DictionaryContent,Long>{

    @Query("select dc from DictionaryContent dc where dc.dictionary.id = ?1")
    List<DictionaryContent> findDicContentByDicId(Long dicId);

    @Query("select dc from DictionaryContent dc where dc.dictionary.id = ?1 and dc.id = ?2")
    DictionaryContent findDicCntByDicIdCntId(Long dicId, Long cntId);

    @Query("select dc from DictionaryContent dc where dc.dictionary.id = ?1 and dc.contentKey = ?2")
    DictionaryContent findDicCntByDicIdCntKey(Long dicId, String key);
}