package controller;

import bean.User;
import entity.UserEntity;
import org.apache.commons.collections4.MapUtils;
import org.apache.log4j.Logger;
import service.UserService;
import user.UserDao;
import validator.ValidatorContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static constants.ApplicationConstants.*;

/**
 * Created by Администратор on 08.11.2015.
 */
@WebServlet(urlPatterns = "/log")
public class LoginController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
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

        if (MapUtils.isNotEmpty(errors)) {
            req.setAttribute("errors", errors);
            LOGGER.debug("Invalid input params " + errors);
            req.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {

        userEntity = new UserEntity(user);
            if (userService.isUserExist(userEntity.getLoginName(), userEntity.getPassword())) {
                req.setAttribute("exist", "User with this login has already exist");
                LOGGER.debug("Invalid input params " + errors);

                req.setAttribute("userEntity", userService.getUser(userEntity.getLoginName()));
                getServletContext().getRequestDispatcher("/hello.jsp").forward(req, resp);

            } else {
                req.setAttribute("exist", "User with this login has already exist");
                LOGGER.debug("Invalid input params " + errors);
                req.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);

            }
    }
    }


    private User getUser(HttpServletRequest req) {
        User user = new User();
        user.setLoginName(req.getParameter("login"));
        user.setPassword(req.getParameter(PASSWORD));
        return user;
    }


    private Map<String, String> validate(User user) {

        ValidatorContext validatorContext = new ValidatorContext();

        validatorContext.addPasswordValidator(PASSWORD, user.getPassword())
                .addLoginValidator(LOGIN, user.getLoginName());
        LOGGER.debug(" " + validatorContext);
        return validatorContext.validate();
    }

}

