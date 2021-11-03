package com.openclassrooms.magicgithub.di;

import com.openclassrooms.magicgithub.api.FakeApiService;
import com.openclassrooms.magicgithub.repository.UserRepository;

/**
 * La classe Injection fournie la méthode static createUserRepository()
 */

public class Injection {

    /**
     * Cette méthode instancie la classe UserRepository, en lui passant en argument une nouvelle instance
     * de la classe FakeApiService
     */
    public static UserRepository createUserRepository() {
        return new UserRepository(new FakeApiService());
    }
}
