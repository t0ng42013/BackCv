package com.portfolio.gastonAlonso.interfazServices;

import com.portfolio.gastonAlonso.model.Skill;

import java.util.List;

public interface ISkillService {
    public List<Skill> verSkill();

    public void crearSkill(Skill skill);

    public void borrarSkill(Long id);

    public Skill buscarSkill(Long id);

    public Skill editaSkill(Skill skill);
}
