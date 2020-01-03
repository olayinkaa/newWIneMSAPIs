package newWine.API.services;


import newWine.API.exceptions.TeamMemberExistException;
import newWine.API.exceptions.TeamMemberNotFoundException;
import newWine.API.models.TeamMember;
import newWine.API.repositories.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

// Query all team members
    public Iterable<TeamMember> findAllTeamMembers()
    {
        return teamMemberRepository.findAll();
    }

// Create a team member
    public TeamMember saveOrUpdate(TeamMember teamMember) throws TeamMemberExistException
    {
        TeamMember existingMember  =   teamMemberRepository.findByEmail(teamMember.getEmail());
        if(existingMember != null)
        {
            throw new TeamMemberExistException("Team Member Already Exist");
        }
        return teamMemberRepository.save(teamMember);
    }

//    Query a single team member by id
    public Optional<TeamMember> findTeamMember(Long id) throws TeamMemberNotFoundException {

        Optional<TeamMember> member = teamMemberRepository.findById(id);

        if(!member.isPresent())
        {
            throw new TeamMemberNotFoundException("No available Member with the id="+id);
        }

        return member;

    }


// Update a team member Info

    public TeamMember updateTeamMember(Long id, TeamMember teamMember) throws TeamMemberNotFoundException
    {
               Optional<TeamMember> member = teamMemberRepository.findById(id);
               if(!member.isPresent())
               {
                   throw new TeamMemberNotFoundException("Team Member Not Found");
               }

               teamMember.setId(id);
               return teamMemberRepository.save(teamMember);

    }

}
