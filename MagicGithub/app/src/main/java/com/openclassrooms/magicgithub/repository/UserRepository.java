package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.List;

public class UserRepository {

    private final ApiService apiService; // TODO: A utiliser

    /**
     * Si on regarde le constructeur de la classe UserRepository, on voit que ce constructeur défini un
     * paramètre du type de l'Interface ApiService.
     *
     */


    //Lors de l'execution du C il recoit en param une instance de la classe fake userrepository
    //cette instance est sauve dans la variable apiservice, ce grace a quoi on va pouvoir utiliser les méthodes FAS la base de donnée
    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * Il y a donc, à priori, un problème de compatibilité entre le type du paramètre (ApiService) et le type
     * de l'argument (FakeApiService)
     * Cette incompatibilité est levée par le fait que la classe FakeApiService implémente l'interface
     * ApiService.
     * <p>
     * L'interêt pour UserRepository d'avoir un argument du type de l'interface est que cela permet
     * une plus grande souplesse, en effet toute classe qui implémente l'interface ApiService est
     * compatible.
     */
    public List<User> getUsers() {
        // TODO: A modifier
        return apiService.getUsers();
        // return null;
    }

    public void generateRandomUser() {
        // TODO: A modifier
        apiService.generateRandomUser();
    }

    public void deleteUser(User user) {
        // TODO: A modifier
        apiService.deleteUser(user);
    }
}
