package controller.withREST;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import domain.SpitterService;
import model.Spittle;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/spittles") // Обрабатывает запросы к URL /spittles
public class SpittleController {

    private SpitterService spitterService;

    @Inject
    public SpittleController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    // CREATE
    @RequestMapping(method=RequestMethod.POST) // Обрабатывает POST-запросы
    @ResponseStatus(HttpStatus.CREATED) // Возвращает ответ HTTP 201 (типо все хорошо)
    public @ResponseBody Spittle createSpittle(@Valid Spittle spittle,
                          BindingResult result, HttpServletResponse response)
            throws BindException {
        if(result.hasErrors()) {
            throw new BindException(result);
        }
        spitterService.saveSpittle(spittle);
        // Указать местоположение ресурса
        response.setHeader("Location", "/spittles/" + spittle.getId()); //возвращает клиенту id созданного ресурса
        return spittle; // Вернуть ресурс
    }

    // READ
    @RequestMapping(value = "/{id}", // Используется переменная-заполнитель
            method = RequestMethod.GET)
    public String getSpittle(@PathVariable("id") long id, //если название локальной переменной соответствует значению из @RequestMapping, тогда значение из @PathVariable можно опустить
                             Model model) {
        model.addAttribute(spitterService.getSpittleById(id));
        return "spittles/view";
    }

    // UPDATE
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putSpittle(@PathVariable("id") long id,
                           @Valid Spittle spittle) {
        spitterService.saveSpittle(spittle);
    }

    // DELETE
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpittle(@PathVariable("id") long id) {
        spitterService.deleteSpittle(id);
    }




}