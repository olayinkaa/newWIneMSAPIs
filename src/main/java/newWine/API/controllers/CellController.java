package newWine.API.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import newWine.API.dtos.CellDtos;
import newWine.API.persistence.entity.Cell;
import newWine.API.models.Request.CellRequest;
import newWine.API.models.response.CellResponse;
import newWine.API.services.CellService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags="Cell Management", value="CellController")
@RestController
@RequestMapping("/api/v1/cells")
@Validated
public class CellController {

        @Autowired
        private CellService cellService;

        @Autowired
        private ModelMapper modelMapper;

//       Query all cell fellowship request
        @GetMapping
        @ApiOperation(value="List of all available cell fellowship")
        public ResponseEntity<Iterable<Cell>> getAllCells()
        {
                Iterable<Cell> cel = cellService.findAllCells();

                return new ResponseEntity<>(cel, HttpStatus.OK);
        }


//       Create cell fellowship request
        @PostMapping
        @ApiOperation(value="Create a new cell fellowship")
        public ResponseEntity<CellResponse> createCell(@ApiParam("Team Member Create") @Valid @RequestBody CellRequest cell)
        {

                CellDtos cellDtos = modelMapper.map(cell,CellDtos.class);
                CellDtos cel =cellService.postCell(cellDtos);

                CellResponse returnValue = modelMapper.map(cel,CellResponse.class);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(returnValue);

        }




}
