package newWine.API.repositories;


import newWine.API.models.TeamMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMember,Long> {

    TeamMember findByEmail(String email);

}
