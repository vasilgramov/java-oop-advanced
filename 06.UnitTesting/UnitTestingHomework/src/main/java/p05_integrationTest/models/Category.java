package p05_integrationTest.models;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private String name;

    private Map<String, User> users;
    private Map<String, Category> subCategories;

    public Category(String name) {
        this.users = new HashMap<String, User>();
        this.subCategories = new HashMap<String, Category>();

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, User> getUsers() {
        return this.users;
    }

    public Map<String, Category> getSubCategories() {
        return this.subCategories;
    }

    public void addSubCategory(Category category) {
        this.subCategories.put(category.getName(), category);
    }

    public void addUser(User user) {
        this.users.put(user.getName(), user);
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Category category = (Category) obj;
        return this.getName().equals(category.getName());
    }
}
