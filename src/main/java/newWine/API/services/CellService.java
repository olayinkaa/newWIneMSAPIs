package newWine.API.services;



import newWine.API.dtos.CellDtos;
import newWine.API.models.Cell;
import newWine.API.repositories.CellRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CellService {

    @Autowired
    private CellRepository cellRepository;

    @Autowired
    private ModelMapper modelMapper;

//    Query all cell fellowship
    public Iterable<Cell> findAllCells()
    {
        return cellRepository.findAll();
    }

//    Query Single cell fellowship

    public Optional<Cell> findACell(Long id)
    {
        Optional<Cell> cell = cellRepository.findById(id);

        return cell;

    }

//    Create a cell fellowship

    public CellDtos postCell(CellDtos cell)
    {
        Cell cello = modelMapper.map(cell,Cell.class);
        cellRepository.save(cello);

        CellDtos  cellDtos = modelMapper.map(cello,CellDtos.class);

        return cellDtos;

    }

}
