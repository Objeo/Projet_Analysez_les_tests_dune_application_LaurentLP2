package com.openclassrooms.magicgithub;

import android.app.Application;

import androidx.annotation.VisibleForTesting;

import com.openclassrooms.magicgithub.di.Injection;
import com.openclassrooms.magicgithub.repository.UserRepository;

/**
 * La classe MagicGithubApplication est un peu "spéciale" :
 * • Elle étend la classe Application
 * • Elle est déclarée dans le manifest
 * • Elle est instanciée automatiquement au lancement de l'application
 * • Sa méthode getUserRepository() est donc accessible à tout moment et en tout point du code
 * On peut dire que c'est un objet de portée globale
 */

public class MagicGithubApplication extends Application {

    private UserRepository userRepository;

    // ---

    /**
     * MagicGithubApplication#getUserRepository() fait appel à la classe Injection et sa méthode static
     * createRepository() pour obtenir une instance de la classe UserRepository.
     * la méthode adopte le Design Pattern Singleton : la classe UserRepository ne peut être instanciée qu'une seule fois.
     * Elle ne peut avoir qu'une unique instance.
     */
    public UserRepository getUserRepository() {
        if (userRepository == null) userRepository = Injection.createUserRepository();
        return userRepository;
    }

    @VisibleForTesting
    public void resetUserRepository() {
        userRepository = null;
    }
}
