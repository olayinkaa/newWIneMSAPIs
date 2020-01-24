package newWine.API.services;


import newWine.API.core.ModelMapperUtils;
import newWine.API.exceptions.TeamMemberExistException;
import newWine.API.exceptions.TeamMemberNotFoundException;
import newWine.API.models.Request.TeamMemberRequest;
import newWine.API.models.response.TeamMemberResponse;
import newWine.API.persistence.entity.Cell;
import newWine.API.persistence.entity.TeamMember;
import newWine.API.persistence.repository.CellRepository;
import newWine.API.persistence.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


public interface TeamMemberService {

    // Query all team members
    public Iterable<TeamMember> findAllTeamMembers();
    // Create a team member
    public TeamMemberResponse saveOrUpdate(TeamMemberRequest request) throws TeamMemberExistException;

    //    Query a single team member by id
    public Optional<TeamMember> findTeamMember(Long id) throws TeamMemberNotFoundException ;


// Update a team member Info

    public TeamMember updateTeamMember(Long id, TeamMember teamMember) throws TeamMemberNotFoundException;

    public void deleteTeamMember(Long id);
}
