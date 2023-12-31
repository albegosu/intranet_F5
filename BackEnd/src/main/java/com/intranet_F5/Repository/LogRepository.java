package com.intranet_F5.Repository;

import com.intranet_F5.Model.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LogRepository extends JpaRepository<LogModel, Long> {
    @Query(value="SELECT * FROM logs WHERE id_request=:id", nativeQuery = true)
    List<LogModel> findAllByRequestId(@Param("id") long id);
}
