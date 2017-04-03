package p05_integrationTest.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_integrationTest.CommandManager;
import p05_integrationTest.models.Category;
import p05_integrationTest.models.User;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class CommandManagerTests {
    private static final User[] USERS = new User[] { new User("PESHO"), new User("GOSHO"), new User("STAMAT") };
    private static final Category[] CATEGORIES = new Category[] { new Category("SPORT"), new Category("WORK"), new Category("VIDEO GAMES") };

    private CommandManager commandManager;

    @Before
    public void init() {
        this.commandManager = new CommandManager();
        for (User user : USERS) {
            this.commandManager.add(user);
        }

        for (Category category : CATEGORIES) {
            this.commandManager.add(category);
        }
    }

    @Test
    public void testAddingUsers() {
        Collection<User> addedUsers = this.commandManager.getUserByName().values();

        boolean expected = true;

        User[] clone = USERS.clone();
        for (User addedUser : addedUsers) {
            boolean hasFound = false;
            for (User user : clone) {
                if (user.equals(addedUser)) {
                    hasFound = true;
                    break;
                }
            }

            Assert.assertEquals(expected, hasFound);
            clone = updateArray(clone, addedUser);
        }
    }

    @Test
    public void testAddingCategories() {
        Collection<Category> addedCategories = this.commandManager.getCategoryByName().values();

        boolean expected = true;

        Category[] clone = CATEGORIES.clone();
        for (Category addedCategory : addedCategories) {
            boolean hasFound = false;
            for (Category category : clone) {
                if (category.equals(addedCategory)) {
                    hasFound = true;
                    break;
                }
            }

            Assert.assertEquals(expected, hasFound);
            clone = updateArray(clone, addedCategory);
        }
    }

    @SuppressWarnings(value = "unchecked")
    @Test
    public void testRemovingCategory() throws NoSuchFieldException, IllegalAccessException {
        String categoryNameToBeRemoved = "SPORT";
        Category[] expectedCategories = new Category[] { new Category("WORK"), new Category("VIDEO GAMES") };

        this.commandManager.remove(categoryNameToBeRemoved);
        Field categoryByName = CommandManager.class.getDeclaredField("categoryByName");
        categoryByName.setAccessible(true);
        Map<String, Category> leftCategoriesMap = ((Map<String, Category>) categoryByName.get(this.commandManager));

        Category[] categories = leftCategoriesMap.values().toArray(new Category[expectedCategories.length]);

        Assert.assertArrayEquals(expectedCategories, categories);
    }

    @SuppressWarnings(value = "unchecked")
    @Test
    public void testAssigningUserToCategory() throws NoSuchFieldException, IllegalAccessException {
        this.commandManager.assignUserToCategory("PESHO", "SPORT");

        Field categoryByName = CommandManager.class.getDeclaredField("categoryByName");
        categoryByName.setAccessible(true);

        Field userByName = CommandManager.class.getDeclaredField("userByName");
        userByName.setAccessible(true);

        Category sport = ((Map<String, Category>) categoryByName.get(this.commandManager)).get("SPORT");
        User pesho = ((Map<String, User>) userByName.get(this.commandManager)).get("PESHO");

        boolean expected = true;

        boolean categoryHasPesho = sport.getUsers().containsKey("PESHO");
        boolean peshoHasCategory = pesho.getCategories().containsKey("SPORT");

        Assert.assertEquals(expected, categoryHasPesho);
        Assert.assertEquals(expected, peshoHasCategory);
    }

    @Test
    public void testAssigningChildCategoryToParentCategory() {
        Category football = new Category("FOOTBALL");
        this.commandManager.add(football);

        this.commandManager.assignChildCategoryToCategory("FOOTBALL", "SPORT");

        Map<String, Category> categoryByName = this.commandManager.getCategoryByName();
        Category sportCategory = categoryByName.get("SPORT");
        Map<String, Category> subCategories = sportCategory.getSubCategories();

        boolean expecrted = true;
        boolean hasSubCategory = subCategories.containsKey("FOOTBALL");

        Assert.assertEquals(expecrted, hasSubCategory);
    }

    @Test
    public void testRemovingCategoryAssignUsersToSubCategory() {
        Category football = new Category("FOOTBALL");
        this.commandManager.add(football);

        this.commandManager.assignChildCategoryToCategory("FOOTBALL", "SPORT");
        this.commandManager.assignUserToCategory("PESHO", "SPORT");

        this.commandManager.remove("SPORT");

        User pesho = this.commandManager.getUserByName().get("PESHO");
        Map<String, Category> categoryByName = this.commandManager.getCategoryByName();
        boolean containsSport = categoryByName.containsKey("SPORT");
        Assert.assertEquals(false, containsSport);

        Map<String, Category> categories = pesho.getCategories();
        containsSport = categories.containsKey("SPORT");
        Assert.assertEquals(false, containsSport);

        boolean containsFootball = categories.containsKey("FOOTBALL");
        Assert.assertEquals(true, containsFootball);
    }

    private User[] updateArray(User[] clone, User toBeExcluded) {
        User[] updated = new User[clone.length - 1];

        int index = 0;
        for (User user : clone) {
            if (!user.equals(toBeExcluded)) {
                updated[index++] = user;
            }
        }

        return updated;
    }

    private Category[] updateArray(Category[] clone, Category tobeExcluded) {
        Category[] updated = new Category[clone.length - 1];

        int index = 0;
        for (Category category : clone) {
            if (!category.equals(tobeExcluded)) {
                updated[index++] = category;
            }
        }

        return updated;
    }
}
