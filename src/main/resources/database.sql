CREATE DATABASE IF NOT EXISTS RecipeBookDB;

USE RecipeBookDB;

CREATE TABLE recipes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    imageName VARCHAR(255),
    preparingDuration INTEGER,
    cookingDuration INTEGER,
    dateCreated DATE
);

CREATE TABLE ingredients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    amount INTEGER NOT NULL,
    recipe_id BIGINT,
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
);

CREATE TABLE cooking_steps (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    step TEXT,
    recipe_id BIGINT,
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
);

CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE recipe_category (
    recipe_id BIGINT,
    category_id BIGINT,
    FOREIGN KEY (recipe_id) REFERENCES recipes(id),
    FOREIGN KEY (category_id) REFERENCES categories(id),
    PRIMARY KEY (recipe_id, category_id)
);

CREATE TABLE comments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text TEXT,
    user_id BIGINT,
    recipe_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255)
);
