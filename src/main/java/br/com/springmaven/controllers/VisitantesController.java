/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.springmaven.controllers;

import br.com.springmaven.daos.VisitanteDao;
import br.com.springmaven.models.Resposta;
import br.com.springmaven.models.Visitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Diego
 */
@Controller
@RequestMapping("/visitantes")
public class VisitantesController {

    @Autowired
    private VisitanteDao vDao;

    // EXEMPLO DE REQUEST MAPPING USANDO PATH VARIABLE
    @RequestMapping(value = "/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Visitante getVisitantePathVariable(@PathVariable int id, Visitante visitante) {
        visitante.setId(id);
        visitante.setNome("visitante bu�a recuperado por PathVariable" + id);

        return visitante;
    }

    // EXEMPLO DE REQUEST MAPPING USANDO REQUEST PARAM
    @RequestMapping(value = "/get", //&sort[webname]
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Visitante getVisitanteRequestParam(@RequestParam("id") int id, @RequestParam("id2") int id2, Visitante visitante) {
        visitante.setId(id);
        visitante.setNome("visitante bu�a recuperado por RequestParam" + id + " - id 2: " + id2);

        return visitante;
    }

    // EXEMPLO DE REQUEST MAPPING LISTANDO UM ARRAY DE ENTIDADES
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public Visitante[] getAllVisitantes() {
        return vDao.getAll();
    }

    // EXEMPLO DE REQUEST MAPPING 
    @RequestMapping(value = "/postMapping", method = RequestMethod.POST)
    public String postMapping(Model model) {
        model.addAttribute("param1", "valuepar1");
        return "saida";
    }

    @GetMapping("/addByGet")
    public void addByGet(@RequestParam("id") int id, @RequestParam("nome") String nome) {
        vDao.insert(new Visitante(id, nome));
    }

    @RequestMapping(value = "/addByPost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resposta addByPost(@RequestParam("id") int id, @RequestParam("nome") String nome, Resposta resp) {
        vDao.insert(new Visitante(id, nome));
        resp.setStatus(1);
        return resp;
    }

    @RequestMapping(value = "/addByJsonPost", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resposta addByJsonPost(@RequestBody Visitante visitante, Resposta resposta) {
        vDao.insert(visitante);
        resposta.setStatus(1);
        System.out.println("");
        return resposta;
    }

    @GetMapping("/delete")
    public void delete(@RequestParam("id") int id) {
        vDao.delete(id);
    }

}
