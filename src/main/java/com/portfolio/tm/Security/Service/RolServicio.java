
package com.portfolio.tm.Security.Service;

import com.portfolio.tm.Security.Entity.Rol;
import com.portfolio.tm.Security.Enums.RolNombre;
import com.portfolio.tm.Security.Repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolServicio {
    @Autowired
    RolRepository irolRepository;
    
   public Optional<Rol> getByRolNombre(RolNombre rolNombre){
       return irolRepository.findByRolNombre(rolNombre);
   }
   
   public void save(Rol rol){
       irolRepository.save(rol);
   }
}
