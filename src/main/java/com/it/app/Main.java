package com.it.app;

import com.it.dao.ClientDao;
import com.it.dao.RolesDao;
import com.it.dao.SectionDao;
import com.it.dao.UserDAO;
import com.it.dao.impl.ClientDAOImpl;
import com.it.dao.impl.RolesDAOImpl;
import com.it.dao.impl.SectionDAOImpl;
import com.it.dao.impl.UserDAOImpl;
import com.it.model.Roles;
import com.it.model.User;
import com.it.model.Client;

import javax.management.relation.Role;
import java.util.List;

public class Main {
  private static final UserDAO userDAO = UserDAOImpl.getInstance();
  private static final ClientDao clientDAO = ClientDAOImpl.getInstance();
  private static final RolesDao rolesDAO = RolesDAOImpl.getInstance();
  private static final SectionDao sectionDAO = SectionDAOImpl.getInstance();

  public static void main(String[] arguments) {
    createRole();
    User user1 = userDAO.getOne(42);
    Roles roles = rolesDAO.getOne(1);
    System.out.println(roles.getId());
    createUser("Kiril", "13", "san@g.com", "kiril", roles);
    User user = userDAO.getOne(42);
    System.out.println(user.getId());
    createClient(user);
  }

  private static void createClient(User persistUser) {
    Client transientClient = new Client();
    transientClient.setHaveclubcard(true);
    transientClient.setMoney(50);
    transientClient.setUser(persistUser);
    System.out.println(transientClient.getUser().getId());
    clientDAO.save(transientClient);
  }

  public static void createRole() {
    Roles roles = new Roles();
    roles.setRoleName("trainer");
    rolesDAO.save(roles);
  }

  private static void createUser(
      String login, String password, String email, String name, Roles roles) {
    User transientUser = new User();
    transientUser.setLogin(login);
    transientUser.setPassword(password);
    transientUser.setEmail(email);
    transientUser.setName(name);
    transientUser.setRoles(roles);
    userDAO.save(transientUser);
  }
}
