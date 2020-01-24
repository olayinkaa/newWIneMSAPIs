package newWine.API.services.impl;


import newWine.API.dtos.CellDtos;
import newWine.API.persistence.entity.Cell;
import newWine.API.persistence.repository.CellRepository;
import newWine.API.services.CellService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CellServiceImpl implements CellService {

    @Autowired
    private CellRepository cellRepository;

    @Autowired
    private ModelMapper modelMapper;

    //    Query all cell fellowship
    @Override
    public Iterable<Cell> findAllCells() {
        return cellRepository.findAll();
    }

//    Query Single cell fellowship

    @Override
    public Optional<Cell> findACell(Long id) {
        Optional<Cell> cell = cellRepository.findById(id);

        return cell;

    }

    @Override
    public CellDtos postCell(CellDtos cell) {
        Cell cello = modelMapper.map(cell, Cell.class);
        cellRepository.save(cello);

        CellDtos cellDtos = modelMapper.map(cello, CellDtos.class);

        return cellDtos;

    }

}
