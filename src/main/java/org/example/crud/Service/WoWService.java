package org.example.crud.Service;
import org.example.crud.Entity.Espec;
import org.example.crud.Repository.EspecRepository;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.List;

@Service
public class WoWService {
    private final org.example.crud.Repository.EspecRepository especRepository;
    public WoWService(org.example.crud.Repository.EspecRepository especRepository) { this.especRepository = especRepository; }

    public List<Espec> getEspecsPorRol(String rol) { return especRepository.findByRolEntity_Nombre(rol); }

    public void exportarEspecsACsv(String path, List<Espec> lista) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            pw.println("Clase,Especializacion");
            lista.forEach(e -> pw.println(e.getClase().getName() + "," + e.getName()));
        }
    }
    public void guardarEspec(Espec espec) {
        especRepository.save(espec);
    }
    public List<Espec> getAllEspecs() {
        return especRepository.findAll();
    }
}