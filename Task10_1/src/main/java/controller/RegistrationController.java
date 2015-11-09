package controller;

import bean.User;
import entity.UserEntity;

import listener.ServletContext;
import org.apache.commons.collections4.MapUtils;
import org.apache.log4j.Logger;
import service.UserService;

import validator.ValidatorContext;

import static constants.ApplicationConstants.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


/**
 * Created by Tetiana_Matiunina on 06.11.2015.
 */

@WebServlet(urlPatterns = "/reg")
public class RegistrationController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);
    private UserService userService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("registration.jsp");
        view.forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(APP_ATTRIBUTE_NAME);
        User user = new User();
        user.setEmail("dadadada");
        user.setFemale("Male");
        user.setFirstName("KOLA");
        user.setLoginName("vanich");
        user.setLastName("Vanya");
        userService.insert(new UserEntity(user));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUser(req);
        UserEntity userEntity;
        LOGGER.debug(" " + user);
        Map<String, String> errors = validate(user);
        LOGGER.debug("Error " + errors);

        if (MapUtils.isNotEmpty(errors)) {
            req.setAttribute("errors", errors);
            LOGGER.debug("Invalid input params " + errors);
            req.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        } else {

            userEntity = new UserEntity(user);
            if (userService.isLoginRegistered(userEntity.getLoginName())) {
                req.setAttribute("exist", "User with this login has already exist");
                LOGGER.debug("Invalid input params " + errors);
                req.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
            } else {
                userService.insert(userEntity);
                req.setAttribute("userEntity", userEntity);
                getServletContext().getRequestDispatcher("/hello.jsp").forward(req, resp);
            }
        }
    }

    private User getUser(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setLoginName(req.getParameter("login"));
        user.setEmail(req.getParameter("email"));
        LOGGER.debug("Passowrfiald" + (req.getParameter(PASSWORD)));
        user.setPassword(req.getParameter(PASSWORD));
        LOGGER.debug("CPassowrfiald" + (req.getParameter(CONFIRM_PASSWORD)));
        user.setConfirmPassword(req.getParameter(CONFIRM_PASSWORD));
        user.setFemale(req.getParameter("gender"));
        return user;
    }

    private Map<String, String> validate(User user) {

        ValidatorContext validatorContext = new ValidatorContext();

        validatorContext.addPasswordValidator(PASSWORD, user.getPassword())
                .addConfirmPasswordValidator(CONFIRM_PASSWORD, user.getConfirmPassword(), user.getPassword())
                .addNameValidator(FIRST_NAME, user.getFirstName())
                .addNameValidator(LAST_NAME, user.getSecondName())
                .addEmailValidator(EMAIL, user.getEmail())
                .addLoginValidator(LOGIN, user.getLoginName());
        LOGGER.debug(" " + validatorContext);
        return validatorContext.validate();
    }
}
