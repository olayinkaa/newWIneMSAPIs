package newWine.API.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import newWine.API.exceptions.TeamMemberExistException;
import newWine.API.exceptions.TeamMemberNotFoundException;
import newWine.API.models.TeamMember;
import newWine.API.services.MapValidationErrorService;
import newWine.API.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;


@Api(tags="Team Member Management", value="TeamMemberController")
@RestController
@RequestMapping("/api/members")
public class TeamMemberController {


    @Autowired
    TeamMemberService teamMemberService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

//Query all team member request
    @GetMapping
    @ApiOperation(value="List of New Wine Members")
    public ResponseEntity<?> getAllTeamMembers()
    {
        Iterable<TeamMember> teamMembers = teamMemberService.findAllTeamMembers();
        return new ResponseEntity<Iterable<TeamMember>>(teamMembers, HttpStatus.OK);
    }

//Create a team member request
    @PostMapping
    @ApiOperation(value="Create New Team Member")
    public ResponseEntity<?> createTeamMember(@ApiParam("Team Member Create") @Valid @RequestBody TeamMember teamMember, BindingResult result)
    {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        try
        {
            TeamMember teamMember1 = teamMemberService.saveOrUpdate(teamMember);
            return new ResponseEntity<TeamMember>(teamMember1,HttpStatus.OK);
        }
        catch (TeamMemberExistException ex)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }

    }


//Query a  team member request
    @GetMapping("/{id}")
    @ApiOperation(value = "Query a team member")
    public ResponseEntity<Optional<TeamMember>> getTeamMember(@PathVariable("id") Long id)
    {
            try
            {
                Optional<TeamMember> teamMember1 =  teamMemberService.findTeamMember(id);
                return new ResponseEntity<Optional<TeamMember>>(teamMember1,HttpStatus.OK);

            }
            catch (TeamMemberNotFoundException ex)
            {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
            }


    }

//Update a team member Info

    @PutMapping("/{id}")
    @ApiOperation(value="Update a Team Member Info")
    public TeamMember updateTeamMember(@PathVariable("id") Long id, @RequestBody TeamMember teamMember)
    {

        try
        {
            return teamMemberService.updateTeamMember(id, teamMember);
        }
        catch (TeamMemberNotFoundException ex)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }




}
