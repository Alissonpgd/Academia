package com.projetoacademia.uplife.controllers;

import com.projetoacademia.uplife.DTO.RequisicaoFormAluno;
import com.projetoacademia.uplife.models.Aluno;
import com.projetoacademia.uplife.models.StatusAluno;
import com.projetoacademia.uplife.repositories.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    //Lista Todos os Alunos//
    @GetMapping("")
    public ModelAndView index(){

        List<Aluno> alunos = this.alunoRepository.findAll();

        ModelAndView mv = new ModelAndView("alunos/index");
        mv.addObject("alunos", alunos);

        return mv;
    }

    //Formulario para criar um novo Aluno//
    @GetMapping("/new")
    public ModelAndView nnew(RequisicaoFormAluno requisicao){
        ModelAndView mv = new ModelAndView("alunos/new");
        mv.addObject("listaStatusAluno", StatusAluno.values());

        return mv;
    }

    //Cria um Novo Aluno//
    @PostMapping("")
    public ModelAndView create(@Valid RequisicaoFormAluno requisicao, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("alunos/new");
            mv.addObject("listaStatusAluno", StatusAluno.values());
            return mv;
        }else{
            Aluno aluno = requisicao.toAluno();
            this.alunoRepository.save(aluno);

            return new ModelAndView("redirect:/alunos");
        }

    }
    //mostra o Aluno pelo ID//
    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Aluno> optional = this.alunoRepository.findById(id);
        if(optional.isPresent()){
            Aluno aluno = optional.get();

            ModelAndView mv = new ModelAndView("alunos/show");
            mv.addObject("aluno", aluno);

            return mv;
        }else{
            return new ModelAndView("redirect:/alunos");
        }
    }

    //CHama o Formulario para Edição do Aluno por ID//
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoFormAluno requisicao){
        Optional<Aluno> optional = this.alunoRepository.findById(id);

        if(optional.isPresent()){
            Aluno aluno = optional.get();
            requisicao.fromAluno(aluno);

            ModelAndView mv = new ModelAndView("alunos/edit");
            mv.addObject("alunoId", aluno.getId());
            mv.addObject("listaStatusAluno", StatusAluno.values());

            return mv;
        }else{
            return new ModelAndView("redirect:/alunos");
        }
    }

    //Salva o Usuario Editado pelo ID//
    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoFormAluno requisicao, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("alunos/edit");
            mv.addObject("alunoId", id);
            mv.addObject("listaStatusAluno", StatusAluno.values());
            return mv;
        }else {
            Optional<Aluno> optional = this.alunoRepository.findById(id);
            if (optional.isPresent()) {
                Aluno aluno = requisicao.toAluno(optional.get());
                this.alunoRepository.save(aluno);

                return new ModelAndView("redirect:/alunos/" + aluno.getId());
            } else {
                return new ModelAndView("redirect:/alunos");
            }
        }
    }

    //Deleta Aluno por ID//
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        try{
            this.alunoRepository.deleteById(id);
            return "redirect:/alunos";
        }
        catch(EmptyResultDataAccessException e){
            return "redirect:/alunos";
        }
    }

}
