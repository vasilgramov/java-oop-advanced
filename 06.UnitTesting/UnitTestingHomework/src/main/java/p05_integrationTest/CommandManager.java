package p05_integrationTest;

import p05_integrationTest.models.Category;
import p05_integrationTest.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Category> categoryByName;
    private Map<String, User> userByName;

    public CommandManager() {
        this.categoryByName = new HashMap<String, Category>();
        this.userByName = new HashMap<String, User>();
    }

    public Map<String, Category> getCategoryByName() {
        return this.categoryByName;
    }

    public Map<String, User> getUserByName() {
        return this.userByName;
    }

    public void add(Category category) {
        this.categoryByName.put(category.getName(), category);
    }

    public void add(User user) {
        this.userByName.put(user.getName(), user);
    }

    public void remove(String categoryName) {
        if (!this.categoryByName.containsKey(categoryName)) {
            throw new IllegalArgumentException("Category does not exists!");
        }

        Category category = this.categoryByName.get(categoryName);
        assignUsersToSubCategory(category);
        updateUsersFromCategory(category);

        this.categoryByName.remove(categoryName);
    }


    public void assignChildCategoryToCategory(String childCategoryName, String parentCategoryName) {
        if (!this.categoryByName.containsKey(childCategoryName) || !this.categoryByName.containsKey(parentCategoryName)) {
            throw new IllegalArgumentException("Both categories should be available!");
        }

        Category childCategory = this.categoryByName.get(childCategoryName);
        Category parentCategory = this.categoryByName.get(parentCategoryName);

        parentCategory.addSubCategory(childCategory);
    }

    public void assignUserToCategory(String username, String categoryName) {
        if (!this.userByName.containsKey(username) || !this.categoryByName.containsKey(categoryName)) {
            throw new IllegalArgumentException("Both username and category name should be available!");
        }

        User user = this.userByName.get(username);
        Category category = this.categoryByName.get(categoryName);

        user.addCategory(category);
        category.addUser(user);
    }

    private void assignUsersToSubCategory(Category category) {
        Collection<Category> subCategories = category.getSubCategories().values();
        if (!subCategories.isEmpty()) {
            Collection<User> users = category.getUsers().values();
            for (User user : users) {
                user.removeCategory(category.getName());

                for (Category subCategory : subCategories) {
                    user.addCategory(subCategory);
                }
            }
        }
    }

    private void updateUsersFromCategory(Category category) {
        Collection<User> users = category.getUsers().values();
        for (User user : users) {
            user.removeCategory(category.getName());
        }
    }

}
