CREATE DATABASE IF NOT EXISTS RecipeBookDB;

USE RecipeBookDB;

-- Table for Ingredients
CREATE TABLE Ingredients (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    amount INT NOT NULL,
    PRIMARY KEY (id)
);

-- Table for Categories
CREATE TABLE Categories (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Table for Recipes
CREATE TABLE Recipes (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    image_name VARCHAR(255),
    preparing_duration INT,
    PRIMARY KEY (id)
);

-- Table for Recipe Categories (Many-to-Many relationship)
CREATE TABLE RecipeCategories (
    recipe_id INT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (recipe_id) REFERENCES Recipes(id),
    FOREIGN KEY (category_id) REFERENCES Categories(id),
    PRIMARY KEY (recipe_id, category_id)
);

-- Table for Recipe Ingredients (Many-to-Many relationship)
CREATE TABLE RecipeIngredients (
    recipe_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    FOREIGN KEY (recipe_id) REFERENCES Recipes(id),
    FOREIGN KEY (ingredient_id) REFERENCES Ingredients(id),
    PRIMARY KEY (recipe_id, ingredient_id)
);

-- Table for Recipe Cooking Steps (One-to-One relationship)
CREATE TABLE RecipeCookingSteps (
    id INT NOT NULL AUTO_INCREMENT,
    recipe_id INT NOT NULL,
    cooking_step_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (recipe_id) REFERENCES Recipes(id),
    PRIMARY KEY (id)
);

---------------------------------------------------
--                    INSERTS                    --
---------------------------------------------------

-- Ingredients
INSERT INTO Ingredients (name, amount) VALUES
    ('Tomatoes', 3),
    ('Lettuce', 1),
    ('Slices of bread', 5),
    ('Eggs', 2);

-- Categories
INSERT INTO Categories (name) VALUES
    ('Breakfast'),
    ('Lunch'),
    ('Dinner');

-- Recipes
INSERT INTO Recipes (name, description, image_name, preparing_duration) VALUES
    ('Salad Caesar', 'Salad with Caesar dressing', 'salad.jpg', 20);

-- RecipeCategories (Associating 'Salad Caesar' with 'Lunch' and 'Dinner' category)
INSERT INTO RecipeCategories (recipe_id, category_id) VALUES
    (1, 2),
    (1, 3);

-- RecipeIngredients (Associating ingredients with 'Salad Caesar')
INSERT INTO RecipeIngredients (recipe_id, ingredient_id) VALUES
    (1, 1), -- Tomatoes
    (1, 2), -- Lettuce
    (1, 3), -- Slices of bread
    (1, 4); -- Eggs

-- RecipeCookingSteps (Associating cooking steps with 'Salad Caesar')
INSERT INTO RecipeCookingSteps (recipe_id, cooking_step_name) VALUES
    (1, 'Cook the meat'),
    (1, 'Cook the vegetables'),
    (1, 'Tear the chunks of romaine lettuce'),
    (1, 'Combine and serve');
