package com.test.testApi.data.model;

import java.util.Arrays;
import java.util.List;

public class UserList {
    public static User IMRANE_ARABAH = new User("Imrane Arabah", "ArabahImrane@gmail.com",
            "0001", "admin");

    public static User RAJAE_BENKHALI = new User("Rajae Benkhali", "Rajaebenkhali@gmail.com",
            "0001", "visiteur");

    public static User MAROUANE_ARABAH = new User("Marouane", "ArabahMarouane@gmail.com",
            "0001", "visiteur");

    public static List<User> ALL = Arrays.asList(IMRANE_ARABAH, RAJAE_BENKHALI, MAROUANE_ARABAH);

}
