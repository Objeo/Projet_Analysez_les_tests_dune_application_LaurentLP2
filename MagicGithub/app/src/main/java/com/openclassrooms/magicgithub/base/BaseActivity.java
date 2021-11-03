package com.openclassrooms.magicgithub.base;

import androidx.appcompat.app.AppCompatActivity;

import com.openclassrooms.magicgithub.MagicGithubApplication;
import com.openclassrooms.magicgithub.repository.UserRepository;

/**
 * BaseActivity#getUserRepository utilise une méthode de la classe MagicGithubApplication,
 * getUserRepository()
 */

public abstract class BaseActivity extends AppCompatActivity {

    public UserRepository getUserRepository() {
        return ((MagicGithubApplication) getApplication()).getUserRepository();
    }
}

/**
 * Quel est l'intérêt de la classe BaseActivity ? Pourquoi la classe ListUserActivity
 * n'utilise pas directement la méthode MagicGithubApplication#getUserRepository ?
 * Via extends la classe BaseActivity sert à factoriser des fonctionnalités réutilisables par plusieurs
 * Activities.
 */
