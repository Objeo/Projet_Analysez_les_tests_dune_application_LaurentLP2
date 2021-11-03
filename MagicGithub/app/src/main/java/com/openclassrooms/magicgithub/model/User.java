package com.openclassrooms.magicgithub.model;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;

import androidx.annotation.Nullable;

import java.util.Objects;
import java.util.Random;

/**
 * Classe qui définit ce qu'est la donnée que l'on appelle un User. (Data class).
 */

public class User {

    private final String id;
    private final String login;
    private final String avatarUrl;

    public User(String id, String login, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    /**
     * Méthode statique qui permet de généer un user aléatoire.
     * Renvoie un element au hasard de l'arraylist FAKE_USER_RANDOM.
     */
    public static User random() {
        return FAKE_USERS_RANDOM.get(new Random().nextInt(FAKE_USERS_RANDOM.size()));
    }

    // --- GETTERS ---
    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        return (((User) obj).avatarUrl.equals(this.avatarUrl) && ((User) obj).login.equals(this.login));
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, avatarUrl);
    }
}