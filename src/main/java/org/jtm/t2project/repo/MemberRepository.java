package org.jtm.t2project.repo;

import org.jtm.t2project.dao.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository <Member, Long> {

}
