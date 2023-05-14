
package com.portfolio.tm.Controller;

import com.portfolio.tm.Interface.IPersonaService;
import com.portfolio.tm.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
   
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/personas/crear")
  public String crearPersona(@RequestBody Persona persona){
      ipersonaService.guardarPersona(persona);
      return "La persona fue guardada correctamente";
  }
  
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/personas/borrar/{id}")
  public String borrarPersona(@PathVariable Long id){
     ipersonaService.borrarPersona(id);
     return "La persona fue borrada correctamente";
  }
  
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/personas/editar/{id}")
  public Persona editarPersona(@PathVariable Long id,
                               @RequestParam("nombre")String nuevoNombre,
                               @RequestParam("apellido")String nuevoApellido,
                               @RequestParam("img") String nuevoImg){

    Persona persona = ipersonaService.buscarPersona(id);
    
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
    ipersonaService.guardarPersona(persona);
    return persona; 
    }
  @GetMapping("/personas/traer/perfil")
  public Persona buscarPersona(){
      return ipersonaService.buscarPersona((long)1);
  }
}
