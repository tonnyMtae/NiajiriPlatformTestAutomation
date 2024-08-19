package factories;

import com.github.javafaker.Faker;
import models.User;
import tz.co.niajiri.qa.base.Base;

public class UserFactory {
    private static final String DEFAULT_PASSWORD = "thesecret";
    private static final Faker faker;

    static {
        faker = new Faker();
    }

    public static User createDefault() {
        var user = new User();
        user.setEmail(Base.buildUniqueTextBySuffix("qatest@mailsurp.com"));
        user.setFullname(faker.name().fullName());
        user.setTelephone(faker.phoneNumber().phoneNumber());
        user.setPassword(DEFAULT_PASSWORD);
        return user;
    }
}