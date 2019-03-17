package com.it.app;

import com.it.dao.*;
import com.it.dao.impl.*;
import com.it.model.*;

import javax.management.relation.Role;
import java.util.List;

public class Main {
  private static final UserDAO userDAO = UserDAOImpl.getInstance();
  private static final ClientDao clientDAO = ClientDAOImpl.getInstance();
  private static final RolesDao rolesDAO = RolesDAOImpl.getInstance();
  private static final SectionDao sectionDAO = SectionDAOImpl.getInstance();
  private static final TrainerDAO trainerDAO = TrainerDAOImpl.getInstance();
  private static final TrainingTypesDAO trainingTypesDAO = TrainingTypesDAOImpl.getInstance();

  public static void main(String[] arguments) {
    
  }

  private static void createClient(User persistUser) {
    Client transientClient = new Client();
    transientClient.setHaveclubcard(true);
    transientClient.setMoney(50);
    transientClient.setUser(persistUser);
    clientDAO.save(transientClient);
  }

  private static void createTrainingType() {
    TrainingTypes trainingTypes = new TrainingTypes();
    trainingTypes.setTrainingName("Running");
    trainingTypesDAO.save(trainingTypes);
  }

  private static void createTrainer(User persistUser, TrainingTypes trainingTypes) {
    Trainer trainer = new Trainer();
    trainer.setUser(persistUser);
    trainer.setTrainingTypes(trainingTypes);
    trainerDAO.save(trainer);
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
