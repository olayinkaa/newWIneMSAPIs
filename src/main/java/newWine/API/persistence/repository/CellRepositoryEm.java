package newWine.API.persistence.repository;

import newWine.API.persistence.entity.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@Transactional
public class CellRepositoryEm {

    @Autowired
    EntityManager em;

    public Cell findById(Long id)
    {
        return em.find(Cell.class,id);
    }

    public Cell addCell(Cell cell)
    {
        if(cell.getId()==null)
        {
            em.persist(cell);
        } else {

            em.merge(cell);
        }

        return cell;
    }
    public void deleteById(Long id)
    {
        Cell cell = findById(id);
        em.remove(cell);
    }
}
