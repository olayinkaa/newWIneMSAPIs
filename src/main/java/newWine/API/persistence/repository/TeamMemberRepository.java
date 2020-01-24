package newWine.API.persistence.repository;


import newWine.API.persistence.entity.TeamMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMember,Long> {

    TeamMember findByEmail(String email);

}
