package com.portfolio.gastonAlonso.repository;
import java.util.List;

import com.portfolio.gastonAlonso.interfazServices.ISkillService;
import com.portfolio.gastonAlonso.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    @Autowired
    public SkillRepository skillRepository;

    @Override
    public List<Skill> verSkill() {
        return skillRepository.findAll();
    }

    @Override
    public void crearSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void borrarSkill(Long id) {
    skillRepository.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public Skill editaSkill(Skill skill) {
        Skill skills = skillRepository.findById(skill.getId()).orElse(null);
        skills.setNombre(skill.getNombre());
        skills.setPorcentaje(skill.getPorcentaje());
        return skillRepository.save(skills);
    }
}
