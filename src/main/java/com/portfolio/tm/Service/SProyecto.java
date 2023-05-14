package com.portfolio.tm.Service;
import com.portfolio.tm.Repository.RProyecto;
import com.portfolio.tm.entity.Proyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
     @Autowired
     RProyecto rProyecto;
     
     public List<Proyecto> list(){
         return rProyecto.findAll();
     }
     
     public Optional<Proyecto> getOne(int id){
         return rProyecto.findById(id);
     }
     
     public Optional<Proyecto> getByNombreP(String nombreP){
         return rProyecto.findByNombreP(nombreP);
     }
     
     public void save(Proyecto proy){
         rProyecto.save(proy);
     }
     
     public void delete(int id){
         rProyecto.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rProyecto.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreP){
         return rProyecto.existsByNombreP(nombreP);
     }
}