package newWine.API.services;



import newWine.API.dtos.CellDtos;
import newWine.API.persistence.entity.Cell;
import newWine.API.persistence.repository.CellRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CellService {


    public Iterable<Cell> findAllCells();

    public Optional<Cell> findACell(Long id);

    public CellDtos postCell(CellDtos cell);

}
