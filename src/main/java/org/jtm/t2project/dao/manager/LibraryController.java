package org.jtm.t2project.dao.manager;

import org.jtm.t2project.dao.entity.Author;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
public class LibraryController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
//                           HttpServletResponse response){
//        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PTeam_JTM");
//        EntityManager eman = emfactory.createEntityManager();
//        eman.getTransaction().begin();
//
//        Author murakami = new Author("Haruki Murakami");
//        eman.persist(murakami);
//
//        eman.getTransaction().commit();
//        eman.close();
//        emfactory.close();
//
//        response.setStatus(HttpServletResponse.SC_OK);
//        return "index";
//
//    }

}
