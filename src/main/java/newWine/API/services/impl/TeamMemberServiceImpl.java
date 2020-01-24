package newWine.API.services.impl;


import newWine.API.core.ModelMapperUtils;
import newWine.API.exceptions.TeamMemberExistException;
import newWine.API.exceptions.TeamMemberNotFoundException;
import newWine.API.models.Request.TeamMemberRequest;
import newWine.API.models.response.TeamMemberResponse;
import newWine.API.persistence.entity.TeamMember;
import newWine.API.persistence.repository.CellRepository;
import newWine.API.persistence.repository.TeamMemberRepository;
import newWine.API.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private CellRepository cellRepository;

    // Query all team members
    @Override
    public Iterable<TeamMember> findAllTeamMembers() {

        return teamMemberRepository.findAll();
    }

    // Create a team member
    @Override
    public TeamMemberResponse saveOrUpdate(TeamMemberRequest request) throws TeamMemberExistException {
        TeamMember existingMember = teamMemberRepository.findByEmail(request.getEmail());
        if (existingMember != null) {
            throw new TeamMemberExistException("Team Member Already Exist");
        }
        TeamMember teamMember = ModelMapperUtils.map(request, TeamMember.class);

        // fetch cell and set value;
        cellRepository.findById(request.getCellId()).ifPresent(teamMember::setCell);
        //
//        Optional<Cell> optionalCell = cellRepository.findById(request.getCellId());
//        if(optionalCell.isPresent()) {
//            Cell cell = optionalCell.get();
//            teamMember.setCell(cell);
//        }
        teamMember = teamMemberRepository.save(teamMember);
        return ModelMapperUtils.map(teamMember, TeamMemberResponse.class);
    }

    //    Query a single team member by id
    @Override
    public Optional<TeamMember> findTeamMember(Long id) throws TeamMemberNotFoundException {

        Optional<TeamMember> member = teamMemberRepository.findById(id);

        if (!member.isPresent()) {
            throw new TeamMemberNotFoundException("No available Member with the id=" + id);
        }

        return member;

    }


// Update a team member Info

    @Override
    public TeamMember updateTeamMember(Long id, TeamMember teamMember) throws TeamMemberNotFoundException {
        Optional<TeamMember> member = teamMemberRepository.findById(id);
        if (!member.isPresent()) {
            throw new TeamMemberNotFoundException("Team Member Not Found");
        }

        teamMember.setId(id);
        return teamMemberRepository.save(teamMember);

    }

    @Override
    public void deleteTeamMember(Long id) {
        if (teamMemberRepository.findById(id).isPresent()) {
            teamMemberRepository.deleteById(id);
        }

        Optional<TeamMember> optionalTeamMember = teamMemberRepository.findById(id);
        if (!optionalTeamMember.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Team Member Not found");
        }
    }
}
